package com.example.pokedex.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonSummary
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.FlowPreview
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokedex.data.TierMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest

@OptIn(FlowPreview::class, kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class PokemonViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PokemonRepository(application)
    
    private val _pokemonList = MutableStateFlow<List<PokemonSummary>>(emptyList())
    val pokemonList: StateFlow<List<PokemonSummary>> = _pokemonList.asStateFlow()

    // State for UI preservation
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedType = MutableStateFlow("All")
    val selectedType = _selectedType.asStateFlow()

    private val _sortType = MutableStateFlow(SortType.ID)
    val sortType = _sortType.asStateFlow()

    private val _sortOrder = MutableStateFlow(SortOrder.ASC)
    val sortOrder = _sortOrder.asStateFlow()

    // Paging 3 Flow
    val pagedPokemonList: Flow<PagingData<PokemonSummary>> = combine(
        _searchQuery.debounce(300),
        _selectedType,
        _sortType,
        _sortOrder
    ) { query, type, sType, sOrder ->
        repository.getPokemonPaging(query, type, sType.name, sOrder.name)
    }.flatMapLatest { it }
     .cachedIn(viewModelScope)

    fun setSearchQuery(query: String) { _searchQuery.value = query }
    fun setSelectedType(type: String) { _selectedType.value = type }
    fun setSortType(type: SortType) { _sortType.value = type }
    fun setSortOrder(order: SortOrder) { _sortOrder.value = order }

    private val _selectedMode = MutableStateFlow(TierMode.PVE)
    val selectedMode = _selectedMode.asStateFlow()

    fun setSelectedMode(mode: TierMode) { _selectedMode.value = mode }

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // Dữ liệu đã được phân loại theo Tier -> Role -> List<PokemonSummary>
    val tieredPokemon: StateFlow<Map<String, Map<String, List<PokemonSummary>>>> = 
        combine(
            _pokemonList, 
            _searchQuery.debounce(300), 
            _selectedType, 
            _selectedMode
        ) { list, query, type, mode ->
            if (list.isEmpty()) return@combine emptyMap()
            withContext(Dispatchers.Default) {
                list.filter { p ->
                    val matchesType = type == "All" || p.types.contains(type.uppercase())
                    val matchesSearch = query.isEmpty() || 
                                     p.name.contains(query, ignoreCase = true) || 
                                     p.formattedId.contains(query) ||
                                     p.tags.any { it.contains(query, ignoreCase = true) }
                    matchesType && matchesSearch
                }.groupBy { p ->
                    when (mode) {
                        TierMode.PVE -> p.pveTier ?: "Unknown"
                        TierMode.PVP_1V1 -> p.pvp1v1Tier ?: "Unknown"
                        TierMode.PVP_2V2 -> p.pvp2v2Tier ?: "Unknown"
                    }
                }.mapValues { entry ->
                    entry.value.groupBy { p ->
                        when (mode) {
                            TierMode.PVE -> p.pveRole ?: "Other"
                            TierMode.PVP_1V1 -> p.pvp1v1Role ?: "Other"
                            TierMode.PVP_2V2 -> p.pvp2v2Role ?: "Other"
                        }
                    }
                }
            }
        }
        .distinctUntilChanged()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyMap())

    private var currentOffset = 0
    private val pageSize = 20
    private var isLastPage = false

    init {
        viewModelScope.launch {
            repository.cleanExtraPokemon()
        }
        observeDatabase()
        loadNextPage()
        startBackgroundSync()
    }

    private fun startBackgroundSync() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(8000) // Tăng delay ban đầu
            while (true) {
                if (!_isLoading.value) {
                    try {
                        repository.startBackgroundSync(limit = 10)
                        delay(20000) // Tăng thời gian nghỉ giữa các lần sync
                    } catch (_: Exception) {
                        delay(40000)
                    }
                } else {
                    delay(10000)
                }
            }
        }
    }

    private fun observeDatabase() {
        viewModelScope.launch {
            repository.getAllPokemonSummaryFromDb()
                .debounce(500) // Tránh cập nhật UI quá dồn dập khi DB thay đổi liên tục
                .collectLatest { list ->
                    _pokemonList.value = list
                }
        }
    }

    fun loadNextPage() {
        if (_isLoading.value || isLastPage) return

        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.fetchAndCachePokemon(pageSize, currentOffset)
                currentOffset += pageSize
                if (currentOffset >= 1025) {
                    isLastPage = true
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadPokemonDetails(pokemonId: String) {
        viewModelScope.launch {
            repository.ensureFullDetails(pokemonId)
        }
    }

    fun getPokemonDetails(pokemonId: String): Flow<Pokemon?> {
        return repository.getPokemonByIdFlow(pokemonId)
    }
}
