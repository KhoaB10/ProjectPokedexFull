package com.example.pokedex.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PokemonRepository(application)
    
    private val _itemList = MutableStateFlow<List<Item>>(emptyList())
    val itemList: StateFlow<List<Item>> = _itemList.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private var currentOffset = 0
    private val pageSize = 200
    private var isLastPage = false

    init {
        observeDatabase()
        loadNextPage()
    }

    private fun observeDatabase() {
        viewModelScope.launch {
            repository.getAllItemsFromDb().collectLatest { list ->
                _itemList.value = list
            }
        }
    }

    fun loadNextPage() {
        if (_isLoading.value || isLastPage) return

        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.fetchAndCacheItems(pageSize, currentOffset)
                currentOffset += pageSize
                // There are around 2100 items in PokeAPI
                if (currentOffset >= 2100) {
                    isLastPage = true
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
