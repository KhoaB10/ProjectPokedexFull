package com.example.pokedex.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.request.CachePolicy
import androidx.compose.ui.platform.LocalContext
import com.example.pokedex.model.Item
import com.example.pokedex.ui.components.PrivacyFooter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun ItemScreen(
    navController: NavController,
    viewModel: ItemViewModel = viewModel()
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    
    val itemList by viewModel.itemList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val showBackToTop by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 5
        }
    }

    val categories = listOf(
        "All", "Battle items", "Berries", "General items", 
        "Hold items", "Machines", "Medicine", "Pokeballs"
    )

    val processedList = remember(itemList) {
        itemList.map { item ->
            val cat = item.category.lowercase().replace(" ", "-")
            val mappedCategory = when {
                cat in listOf("stat-boosts", "in-battle", "miracle-shooter", "battle-items") -> "Battle items"
                cat in listOf("healing", "status-cures", "revival", "vitamins", "pp-recovery", "medicine") -> "Medicine"
                cat in listOf("standard-balls", "special-balls", "apricorn-balls", "unused-balls", "pokeballs") -> "Pokeballs"
                cat in listOf("all-machines", "machines") -> "Machines"
                cat == "berries" -> "Berries"
                cat in listOf("mega-stones", "evolution", "type-enhancement", "choice", "effort-training", 
                             "species-specific", "plates", "jewels", "z-crystals", "held-items", 
                             "bad-held-items", "hold-items") -> "Hold items"
                cat == "specials" -> {
                    if (item.name.contains("Capsule") || item.name.contains("Shield")) "Hold items" 
                    else "General items"
                }
                else -> "General items"
            }
            item.copy(category = mappedCategory)
        }
    }

    val filteredList = remember(searchQuery, selectedCategory, processedList) {
        processedList.filter { item ->
            val matchesSearch = item.name.contains(searchQuery, ignoreCase = true)
            val matchesCategory = selectedCategory == "All" || item.category == selectedCategory
            matchesSearch && matchesCategory
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
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    ItemHeaderSection(navController)
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Text(
                        text = "■ ITEMS  Showing ${filteredList.size} items",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    HorizontalDivider(color = Color(0xFF00B0FF), thickness = 2.dp)
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Search items...", color = Color.Gray, fontSize = 14.sp) },
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
                    
                    ItemCategoryFilters(categories, selectedCategory) { selectedCategory = it }
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

            stickyHeader {
                ItemTableHeader()
            }

            items(filteredList, key = { it.id }) { item ->
                val index = filteredList.indexOf(item)
                if (index >= filteredList.size - 5 && !isLoading) {
                    viewModel.loadNextPage()
                }

                ItemRow(item = item)
                HorizontalDivider(color = Color(0xFF32323E), thickness = 0.5.dp)
            }

            if (filteredList.isEmpty() && !isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "No items found in this category yet.",
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = { viewModel.loadNextPage() },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00B0FF)),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text("Load more items", color = Color.White)
                            }
                        }
                    }
                }
            }

            if (isLoading) {
                item {
                    var showLongLoadingMessage by remember { mutableStateOf(false) }

                    LaunchedEffect(Unit) {
                        delay(3000)
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
                        if (showLongLoadingMessage) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Đang tải dữ liệu vật phẩm...\nQuá trình này có thể mất vài giây khi khởi động lần đầu.",
                                color = Color.Gray,
                                fontSize = 13.sp,
                                textAlign = TextAlign.Center,
                                lineHeight = 18.sp
                            )
                        }
                    }
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
fun ItemRow(item: Item) {
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
            Row(
                modifier = Modifier.width(180.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color(0xFF16161D), RoundedCornerShape(4.dp))
                        .border(1.dp, Color(0xFF32323E), RoundedCornerShape(4.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    if (item.imageUrl.isNotEmpty()) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.imageUrl)
                                .crossfade(true)
                                .diskCachePolicy(CachePolicy.ENABLED)
                                .build(),
                            contentDescription = item.name,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    item.name,
                    color = Color(0xFF00B0FF),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Text(
                item.category.replaceFirstChar { it.uppercase() },
                color = Color.LightGray,
                fontSize = 13.sp,
                modifier = Modifier.weight(1f)
            )
        }

        AnimatedVisibility(visible = expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .background(Color(0xFF1A1A22), RoundedCornerShape(4.dp))
                    .border(1.dp, Color(0xFF32323E), RoundedCornerShape(4.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = "EFFECT",
                    color = Color(0xFF00B0FF),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = item.effect,
                    color = Color.White,
                    fontSize = 13.sp,
                    lineHeight = 18.sp
                )
            }
        }
    }
}

@Composable
fun ItemTableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2D2D39))
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Name",
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.width(180.dp)
        )
        Text(
            text = "Category",
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ItemCategoryFilters(categories: List<String>, selected: String, onSelect: (String) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            val isSelected = selected == category
            Box(
                modifier = Modifier
                    .height(36.dp)
                    .background(
                        if (isSelected) Color(0xFF00B0FF) else Color(0xFF252530),
                        RoundedCornerShape(4.dp)
                    )
                    .border(
                        1.dp,
                        if (isSelected) Color.White.copy(alpha = 0.3f) else Color(0xFF32323E),
                        RoundedCornerShape(4.dp)
                    )
                    .clickable { onSelect(category) }
                    .padding(horizontal = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (category == "All") "*" else category.uppercase(),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
fun ItemHeaderSection(navController: NavController) {
    Column {
        // Breadcrumb
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = "Home",
                color = Color(0xFF00B0FF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { navController.navigate("home_route") }
            )
            Text(text = " / ", color = Color.Gray, fontSize = 12.sp)
            Text(text = "Items", color = Color.LightGray, fontSize = 12.sp)
        }

        Text(
            text = "Item List",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Full list of items and their effects in battle and beyond.",
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}
