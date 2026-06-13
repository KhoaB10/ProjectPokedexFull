package com.example.pokedex.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.pokedex.model.PokemonSummary
import com.example.pokedex.ui.components.PrivacyFooter
import com.example.pokedex.ui.theme.PokedexTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class SortType { ID, NAME }
enum class SortOrder { ASC, DESC }

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonScreen(
    navController: NavController,
    viewModel: PokemonViewModel = viewModel()
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedType by viewModel.selectedType.collectAsState()
    val sortType by viewModel.sortType.collectAsState()
    val sortOrder by viewModel.sortOrder.collectAsState()

    val pagedPokemon = viewModel.pagedPokemonList.collectAsLazyPagingItems()
    val isLoading by viewModel.isLoading.collectAsState()

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    
    val showBackToTop by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 5
        }
    }

    Scaffold(
        containerColor = Color(0xFF1E1E26),
        floatingActionButton = {
            AnimatedVisibility(
                visible = showBackToTop,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            listState.animateScrollToItem(0)
                        }
                    },
                    containerColor = Color(0xFF00B0FF),
                    contentColor = Color.White,
                    shape = CircleShape,
                    modifier = Modifier.size(56.dp)
                ) {
                    Icon(Icons.Default.ArrowUpward, contentDescription = "Back to top")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    PokemonHeaderSection(navController)
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Text(
                        text = "■ POKEMON  Showing ${pagedPokemon.itemCount} pokemon",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    HorizontalDivider(color = Color(0xFF00B0FF), thickness = 2.dp)
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { viewModel.setSearchQuery(it) },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Tìm kiếm tên hoặc ID...", color = Color.Gray, fontSize = 14.sp) },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF00B0FF),
                            unfocusedBorderColor = Color(0xFF32323E),
                            focusedContainerColor = Color(0xFF16161D),
                            unfocusedContainerColor = Color(0xFF16161D),
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        ),
                        shape = RoundedCornerShape(4.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    DummyFilters(selectedType) { viewModel.setSelectedType(it) }
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

            // Thanh tiêu đề có chức năng nhấn để sắp xếp
            stickyHeader {
                PokemonTableHeader(
                    currentSortType = sortType,
                    currentSortOrder = sortOrder,
                    onSortClick = { type ->
                        if (sortType == type) {
                            viewModel.setSortOrder(if (sortOrder == SortOrder.ASC) SortOrder.DESC else SortOrder.ASC)
                        } else {
                            viewModel.setSortType(type)
                            viewModel.setSortOrder(SortOrder.ASC)
                        }
                    }
                )
            }

            items(
                count = pagedPokemon.itemCount,
                key = pagedPokemon.itemKey { it.id }
            ) { index ->
                val pokemon = pagedPokemon[index]
                
                // Tự động load thêm từ network khi cuộn gần đến cuối (vì Paging 3 ở đây chỉ load từ DB)
                if (index >= pagedPokemon.itemCount - 5 && !isLoading) {
                    LaunchedEffect(Unit) {
                        viewModel.loadNextPage()
                    }
                }

                if (pokemon != null) {
                    PokemonRow(
                        pokemon = pokemon,
                        onNameClick = { id ->
                            navController.navigate("pokemon_detail/$id")
                        }
                    )
                    HorizontalDivider(color = Color(0xFF32323E), thickness = 0.5.dp)
                }
            }

            // Hiển thị trạng thái load của Paging (Dữ liệu từ Database)
            when (val state = pagedPokemon.loadState.refresh) {
                is LoadState.Loading -> {
                    item {
                        LoadingIndicator(message = "Đang chuẩn bị danh sách...")
                    }
                }
                is LoadState.Error -> {
                    // Có thể thêm item báo lỗi ở đây
                }
                else -> {}
            }

            // Hiển thị trạng thái load từ Network (Manual Pagination)
            if (isLoading) {
                item {
                    LoadingIndicator(message = "Đang tải dữ liệu từ máy chủ...\nVui lòng đợi trong giây lát!")
                }
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
                PrivacyFooter()
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun LoadingIndicator(message: String? = null) {
    var showLongLoadingMessage by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        delay(2000)
        showLongLoadingMessage = true
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = Color(0xFF00B0FF),
            modifier = Modifier.size(32.dp)
        )
        if (showLongLoadingMessage && message != null) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = message,
                color = Color.Gray,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
fun PokemonRow(pokemon: PokemonSummary, onNameClick: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .background(if (expanded) Color(0xFF252530) else Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Cột Icon và ID
            Row(
                modifier = Modifier.width(90.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .aspectRatio(1f)
                        .background(Color(0xFF16161D), RoundedCornerShape(4.dp))
                        .border(1.dp, Color(0xFF32323E), RoundedCornerShape(4.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = coil.request.ImageRequest.Builder(androidx.compose.ui.platform.LocalContext.current)
                            .data(pokemon.imageUrl)
                            .crossfade(true)
                            .diskCachePolicy(coil.request.CachePolicy.ENABLED)
                            .build(),
                        contentDescription = pokemon.name,
                        modifier = Modifier.fillMaxSize().padding(2.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(pokemon.formattedId, color = Color.Gray, fontSize = 12.sp)
            }

            // Cột Tên (Xử lý hiển thị Biến thể)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onNameClick(pokemon.id) }
                    .padding(vertical = 4.dp)
            ) {
                if (pokemon.id.contains(".")) {
                    Text(pokemon.baseName, color = Color(0xFF00B0FF), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text(pokemon.variantName, color = Color.Gray, fontSize = 11.sp, fontWeight = FontWeight.Medium)
                } else {
                    Text(pokemon.name, color = Color(0xFF00B0FF), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }

            // Cột Hệ
            Column(modifier = Modifier.width(90.dp)) {
                pokemon.types.forEach { type ->
                    TypeBadge(type)
                }
            }

            // Cột Chỉ số (Total)
            Row(
                modifier = Modifier.width(50.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = pokemon.total.toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    modifier = Modifier.width(40.dp),
                    textAlign = TextAlign.End
                )
            }
        }

        AnimatedVisibility(visible = expanded) {
            PokemonOnlyStats(pokemon)
        }
    }
}

@Composable
fun PokemonOnlyStats(pokemon: PokemonSummary) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .background(Color(0xFF1A1A22), RoundedCornerShape(4.dp))
            .border(1.dp, Color(0xFF32323E), RoundedCornerShape(4.dp))
            .padding(12.dp)
    ) {
        SectionTitle("BASE STATS")
        BaseStatsGrid(pokemon)
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        color = Color(0xFF00B0FF),
        fontSize = 11.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.padding(bottom = 6.dp)
    )
}

@Composable
fun BaseStatsGrid(pokemon: PokemonSummary) {
    val stats = listOf(
        "HP" to pokemon.hp,
        "ATK" to pokemon.attack,
        "DEF" to pokemon.defense,
        "SPA" to pokemon.spAtk,
        "SPD" to pokemon.spDef,
        "SPE" to pokemon.speed,
        "TOTAL" to pokemon.total
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        stats.forEach { (label, value) ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(label, color = Color.Gray, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                Text(
                    value.toString(),
                    color = if (label == "TOTAL") Color(0xFF00B0FF) else Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun DummyFilters(selectedType: String, onTypeSelected: (String) -> Unit) {
    val types = listOf(
        "All" to Color(0xFF00B0FF),
        "Normal" to Color(0xFFA8A77A),
        "Fire" to Color(0xFFEE8130),
        "Water" to Color(0xFF6390F0),
        "Grass" to Color(0xFF7AC74C),
        "Electric" to Color(0xFFF7D02C),
        "Ice" to Color(0xFF96D9D6),
        "Fighting" to Color(0xFFC22E28),
        "Poison" to Color(0xFFA33EA1),
        "Ground" to Color(0xFFE2BF65),
        "Flying" to Color(0xFFA98FF3),
        "Psychic" to Color(0xFFF95587),
        "Bug" to Color(0xFFA6B91A),
        "Rock" to Color(0xFFB6A136),
        "Ghost" to Color(0xFF735797),
        "Dragon" to Color(0xFF6F35FC),
        "Steel" to Color(0xFFB7B7CE),
        "Dark" to Color(0xFF705746),
        "Fairy" to Color(0xFFD685AD)
    )
    
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = types) { (name, color) ->
            val isSelected = selectedType == name
            Box(
                modifier = Modifier
                    .height(36.dp)
                    .background(
                        if (isSelected) (if (name == "All") Color(0xFF00B0FF) else Color(0xFF252530)) else Color(0xFF252530),
                        RoundedCornerShape(4.dp)
                    )
                    .border(
                        1.dp,
                        if (isSelected) (if (name == "All") Color.White.copy(alpha = 0.3f) else Color(0xFF00B0FF)) else Color(0xFF32323E),
                        RoundedCornerShape(4.dp)
                    )
                    .clickable { onTypeSelected(name) }
                    .padding(horizontal = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (name == "All") "*" else name.uppercase(),
                    color = if (isSelected) (if (name == "All") Color.White else Color(0xFF00B0FF)) else color,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
fun PokemonHeaderSection(navController: NavController) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Home",
                color = Color(0xFF00B0FF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { navController.navigate("home_route") }
            )
            Text(text = " / ", color = Color.Gray, fontSize = 12.sp)
            Text(text = "Pokemon List", color = Color.LightGray, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Pokemon List",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Full database with Base Stats, Abilities, and Evolutions.",
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}

@Composable
fun PokemonTableHeader(
    currentSortType: SortType,
    currentSortOrder: SortOrder,
    onSortClick: (SortType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2D2D39))
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Cột ID (#)
        HeaderCell(
            text = "#",
            isActive = currentSortType == SortType.ID,
            sortOrder = currentSortOrder,
            modifier = Modifier.width(90.dp),
            onClick = { onSortClick(SortType.ID) }
        )

        // Cột Name
        HeaderCell(
            text = "Name",
            isActive = currentSortType == SortType.NAME,
            sortOrder = currentSortOrder,
            modifier = Modifier.weight(1f),
            onClick = { onSortClick(SortType.NAME) }
        )

        // Cột Type (không sắp xếp)
        Text(
            text = "Type",
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.width(90.dp)
        )

        // Cột Stats
        Row(modifier = Modifier.width(50.dp), horizontalArrangement = Arrangement.End) {
            Text("BST", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 12.sp, modifier = Modifier.width(40.dp), textAlign = TextAlign.End)
        }
    }
}

@Composable
fun HeaderCell(
    text: String,
    isActive: Boolean,
    sortOrder: SortOrder,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = if (isActive) Color(0xFF00B0FF) else Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        if (isActive) {
            Icon(
                imageVector = if (sortOrder == SortOrder.ASC) Icons.Default.ArrowUpward else Icons.Default.ArrowDownward,
                contentDescription = null,
                tint = Color(0xFF00B0FF),
                modifier = Modifier.size(14.dp).padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun TypeBadge(type: String) {
    val color = when (type.uppercase()) {
        "GRASS" -> Color(0xFF7AC74C)
        "POISON" -> Color(0xFFA33EA1)
        "FIRE" -> Color(0xFFEE8130)
        "WATER" -> Color(0xFF6390F0)
        "FLYING" -> Color(0xFFA98FF3)
        "ELECTRIC" -> Color(0xFFF7D02C)
        "ICE" -> Color(0xFF96D9D6)
        "FIGHTING" -> Color(0xFFC22E28)
        "GROUND" -> Color(0xFFE2BF65)
        "PSYCHIC" -> Color(0xFFF95587)
        "BUG" -> Color(0xFFA6B91A)
        "ROCK" -> Color(0xFFB6A136)
        "GHOST" -> Color(0xFF735797)
        "DRAGON" -> Color(0xFF6F35FC)
        "STEEL" -> Color(0xFFB7B7CE)
        "DARK" -> Color(0xFF705746)
        "FAIRY" -> Color(0xFFD685AD)
        "NORMAL" -> Color(0xFFA8A77A)
        else -> Color.Gray
    }
    Box(
        modifier = Modifier
            .padding(vertical = 2.dp)
            .width(70.dp)
            .height(20.dp)
            .background(color, RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(type, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonScreenPreview() {
    PokedexTheme {
        PokemonScreen(rememberNavController())
    }
}
