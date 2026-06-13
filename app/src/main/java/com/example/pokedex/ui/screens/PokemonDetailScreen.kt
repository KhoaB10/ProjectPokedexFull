package com.example.pokedex.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.pokedex.model.EvolutionStep
import com.example.pokedex.model.MoveInfo
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonSummary
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.IntrinsicSize.Min

@Composable
fun PokemonDetailScreen(
    pokemonId: String,
    navController: NavController,
    viewModel: PokemonViewModel
) {
    val pagedPokemon = viewModel.pagedPokemonList.collectAsLazyPagingItems()
    
    // We need the full Pokemon object for details
    val pokemonDetails by viewModel.getPokemonDetails(pokemonId).collectAsState(initial = null)
    
    androidx.compose.runtime.LaunchedEffect(pokemonId) {
        viewModel.loadPokemonDetails(pokemonId)
    }

    // Try to find summary in paging data if possible, or wait for pokemonDetails
    val summary = remember(pagedPokemon.itemCount, pokemonId, pokemonDetails) {
        var found: PokemonSummary? = null
        for (i in 0 until pagedPokemon.itemCount) {
            val item = pagedPokemon[i]
            if (item?.id == pokemonId) {
                found = item
                break
            }
        }
        found
    }

    if (summary == null && pokemonDetails == null) {
        Box(modifier = Modifier.fillMaxSize().background(Color(0xFF1E1E26)), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = Color(0xFF00B0FF))
        }
        return
    }

    // Use pokemonDetails if available, otherwise fallback to summary for basic info
    val themeColor = summary?.let { getThemeColor(it.types) } ?: pokemonDetails?.let { getThemeColor(it.types) } ?: Color.Gray
    val secondaryColor = summary?.let { if (it.types.size > 1) getSingleTypeColor(it.types[1]) else themeColor } 
                        ?: pokemonDetails?.let { if (it.types.size > 1) getSingleTypeColor(it.types[1]) else themeColor } 
                        ?: themeColor

    Scaffold(
        containerColor = Color(0xFF1E1E26)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // 1. Breadcrumbs
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Home", color = Color(0xFF00B0FF), fontSize = 12.sp, modifier = Modifier.clickable { navController.navigate("home_route") })
                Text(" / ", color = Color.Gray, fontSize = 12.sp)
                Text("Pokemon", color = Color(0xFF00B0FF), fontSize = 12.sp, modifier = Modifier.clickable {
                    navController.navigate("pokedex_route") {
                        popUpTo("pokedex_route") { inclusive = true }
                    }
                })
                Text(" / ", color = Color.Gray, fontSize = 12.sp)
                Text(summary?.name ?: pokemonDetails?.name ?: "", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }

            // 2. Main Banner
            if (summary != null) {
                MainBannerFromSummary(summary, themeColor, secondaryColor)
            } else if (pokemonDetails != null) {
                MainCharacterBanner(pokemonDetails!!, themeColor, secondaryColor)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 3. Tab Buttons
            DetailTabButtons(themeColor)

            Spacer(modifier = Modifier.height(24.dp))

            // 4. Introduction
            DetailSectionHeader("INTRODUCTION", themeColor)
            val description = pokemonDetails?.description ?: ""
            val name = summary?.name ?: pokemonDetails?.name ?: ""
            val types = summary?.types ?: pokemonDetails?.types ?: emptyList()
            val total = summary?.total ?: pokemonDetails?.total ?: 0
            
            Text(
                text = if (description.isNotEmpty()) description 
                      else "$name is a powerful ${types.joinToString("/")} type Pokémon. " +
                        "With a base total stat of $total, it is a formidable presence in the Pokedex. " +
                        (if (pokemonDetails != null) "Known for abilities like ${pokemonDetails?.abilities?.joinToString(", ") { it.name }}, this Pokémon is a versatile choice for any trainer." else ""),
                color = Color.LightGray,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 5. Pokédex Data
            DetailSectionHeader("POKÉDEX DATA", themeColor)
            if (pokemonDetails != null) {
                PokedexDataTable(pokemonDetails!!)
            } else if (summary != null) {
                PokedexDataPlaceholder(summary)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 6. Base Stats Section
            DetailSectionHeader("BASE STATS", themeColor)
            if (summary != null) {
                BaseStatsSectionFromSummary(summary, themeColor)
            } else if (pokemonDetails != null) {
                BaseStatsSection(pokemonDetails!!, themeColor)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 7. Evolution Chain
            DetailSectionHeader("EVOLUTION CHART", themeColor)
            if (pokemonDetails != null) {
                EvolutionSection(pokemonDetails!!, navController, emptyList())
            } else {
                LoadingPlaceholder(themeColor)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 8. Moves
            DetailSectionHeader("MOVES LEARNED", themeColor)
            if (pokemonDetails?.hasFullDetails == true) {
                MovesTable(pokemonDetails!!)
            } else {
                LoadingPlaceholder(themeColor)
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun MainBannerFromSummary(pokemon: PokemonSummary, color1: Color, color2: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color(0xFF16161D), RoundedCornerShape(8.dp))
            .border(2.dp, Brush.verticalGradient(listOf(color1, color2)), RoundedCornerShape(8.dp))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("POKEMON DATABASE", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(pokemon.name.uppercase(), color = color1, fontSize = 32.sp, fontWeight = FontWeight.Black)
            Text("BEST BUILD, STATS AND EVOLUTIONS", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = coil.request.ImageRequest.Builder(androidx.compose.ui.platform.LocalContext.current)
                    .data(pokemon.imageUrl)
                    .crossfade(true)
                    .diskCachePolicy(coil.request.CachePolicy.ENABLED)
                    .build(),
                contentDescription = pokemon.name,
                modifier = Modifier.size(200.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Fit
            )
        }
    }
}

@Composable
fun PokedexDataPlaceholder(summary: PokemonSummary) {
    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        DataRow("National №", summary.formattedId)
        DataRow("Type", null) {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                summary.types.forEach { TypeBadgeSmall(it) }
            }
        }
        DataRow("Total Stat", summary.total.toString())
    }
}

@Composable
fun BaseStatsSectionFromSummary(pokemon: PokemonSummary, themeColor: Color) {
    val stats = listOf(
        "HP" to pokemon.hp,
        "Attack" to pokemon.attack,
        "Defense" to pokemon.defense,
        "Sp. Atk" to pokemon.spAtk,
        "Sp. Def" to pokemon.spDef,
        "Speed" to pokemon.speed
    )
    Column(modifier = Modifier.padding(16.dp)) {
        stats.forEach { (label, value) -> StatRow(label, value, themeColor) }
        
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
            Text("Total", color = Color.Gray, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.width(100.dp))
            Text(pokemon.total.toString(), color = Color(0xFF00B0FF), fontSize = 14.sp, fontWeight = FontWeight.Black, modifier = Modifier.width(40.dp))
            Box(modifier = Modifier.weight(1f).height(8.dp).background(Color(0xFF252530), RoundedCornerShape(4.dp))) {
                Box(modifier = Modifier.fillMaxWidth(pokemon.total / 720f).fillMaxHeight().background(Color(0xFF00B0FF), RoundedCornerShape(4.dp)))
            }
        }
    }
}

@Composable
fun LoadingPlaceholder(color: Color) {
    Box(modifier = Modifier.fillMaxWidth().padding(32.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(color = color, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text("Loading details...", color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Composable
fun MainCharacterBanner(pokemon: Pokemon, color1: Color, color2: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color(0xFF16161D), RoundedCornerShape(8.dp))
            .border(2.dp, Brush.verticalGradient(listOf(color1, color2)), RoundedCornerShape(8.dp))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("POKEMON DATABASE", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(pokemon.name.uppercase(), color = color1, fontSize = 32.sp, fontWeight = FontWeight.Black)
            Text("BEST BUILD, STATS AND EVOLUTIONS", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = coil.request.ImageRequest.Builder(androidx.compose.ui.platform.LocalContext.current)
                    .data(pokemon.imageUrl)
                    .crossfade(true)
                    .diskCachePolicy(coil.request.CachePolicy.ENABLED)
                    .build(),
                contentDescription = pokemon.name,
                modifier = Modifier.size(200.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Fit
            )
        }
    }
}

@Composable
fun DetailTabButtons(themeColor: Color) {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        TabButton("Profile", Icons.Default.Info, themeColor, true, Modifier.weight(1f))
    }
}

@Composable
fun TabButton(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, color: Color, isSelected: Boolean, modifier: Modifier) {
    Column(
        modifier = modifier.background(Color(0xFF252530), RoundedCornerShape(4.dp)).padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(icon, null, tint = if (isSelected) color else Color.Gray, modifier = Modifier.size(20.dp))
        Text(label, color = if (isSelected) Color.White else Color.Gray, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        if (isSelected) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(modifier = Modifier.height(2.dp).width(40.dp).background(color))
        }
    }
}

@Composable
fun DetailSectionHeader(title: String, color: Color) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(12.dp).background(color))
            Spacer(modifier = Modifier.width(8.dp))
            Text(title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Black)
        }
        Spacer(modifier = Modifier.height(4.dp))
        HorizontalDivider(color = color.copy(alpha = 0.5f), thickness = 1.dp)
    }
}

@Composable
fun PokedexDataTable(pokemon: Pokemon) {
    var selectedAbility by remember { mutableStateOf<com.example.pokedex.model.AbilityInfo?>(null) }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        DataRow("National №", pokemon.formattedId)
        DataRow("Type", null) {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                pokemon.types.forEach { TypeBadgeSmall(it) }
            }
        }
        DataRow("Height", "${pokemon.height / 10.0} m")
        DataRow("Weight", "${pokemon.weight / 10.0} kg")
        DataRow("Abilities", null) {
            Column {
                pokemon.abilities.forEach { ability ->
                    Text(
                        text = ability.name,
                        color = Color(0xFF00B0FF),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clickable { selectedAbility = ability }
                            .padding(vertical = 2.dp)
                    )
                }
            }
        }
        DataRow("Total Stat", pokemon.total.toString())
    }

    selectedAbility?.let { ability ->
        androidx.compose.ui.window.Dialog(onDismissRequest = { selectedAbility = null }) {
            androidx.compose.material3.Card(
                colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = Color(0xFF252530)),
                border = BorderStroke(1.dp, Color(0xFF00B0FF)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(ability.name, color = Color(0xFF00B0FF), fontSize = 18.sp, fontWeight = FontWeight.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(ability.effect, color = Color.White, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    androidx.compose.material3.TextButton(
                        onClick = { selectedAbility = null },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("CLOSE", color = Color(0xFF00B0FF))
                    }
                }
            }
        }
    }
}

@Composable
fun DataRow(label: String, value: String?, content: @Composable (() -> Unit)? = null) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = Color.Gray, fontSize = 14.sp, modifier = Modifier.width(120.dp))
        if (content != null) content()
        else Text(value ?: "", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
    HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
}

@Composable
fun BaseStatsSection(pokemon: Pokemon, themeColor: Color) {
    val stats = listOf(
        "HP" to pokemon.hp,
        "Attack" to pokemon.attack,
        "Defense" to pokemon.defense,
        "Sp. Atk" to pokemon.spAtk,
        "Sp. Def" to pokemon.spDef,
        "Speed" to pokemon.speed
    )
    Column(modifier = Modifier.padding(16.dp)) {
        stats.forEach { (label, value) -> StatRow(label, value, themeColor) }
        
        // Yêu cầu 1: Thêm Total Stat với progress bar
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
            Text("Total", color = Color.Gray, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.width(100.dp))
            Text(pokemon.total.toString(), color = Color(0xFF00B0FF), fontSize = 14.sp, fontWeight = FontWeight.Black, modifier = Modifier.width(40.dp))
            Box(modifier = Modifier.weight(1f).height(8.dp).background(Color(0xFF252530), RoundedCornerShape(4.dp))) {
                Box(modifier = Modifier.fillMaxWidth(pokemon.total / 720f).fillMaxHeight().background(Color(0xFF00B0FF), RoundedCornerShape(4.dp)))
            }
        }
    }
}

@Composable
fun StatRow(label: String, value: Int, color: Color) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = Color.Gray, fontSize = 12.sp, modifier = Modifier.width(100.dp))
        Text(value.toString(), color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.width(40.dp))
        Box(modifier = Modifier.weight(1f).height(8.dp).background(Color(0xFF252530), RoundedCornerShape(4.dp))) {
            Box(modifier = Modifier.fillMaxWidth(value / 255f).fillMaxHeight().background(color, RoundedCornerShape(4.dp)))
        }
    }
}

@Composable
fun EvolutionSection(pokemon: Pokemon, navController: NavController, pokemonList: List<Pokemon>) {
    val evolutionChain = pokemon.evolutionChain
    if (evolutionChain.isEmpty()) return

    // Nhận diện "gốc" của chuỗi (con đầu tiên hoặc con không tiến hóa từ con nào khác trong list)
    val allNames = evolutionChain.map { it.name.lowercase() }
    val allIds = evolutionChain.map { it.id }
    val roots = evolutionChain.filter { step ->
        val from = step.evolvesFrom
        from == null || (!allNames.contains(from.lowercase()) && !allIds.contains(from))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF23232D), RoundedCornerShape(12.dp))
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 32.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        roots.forEachIndexed { index, root ->
            if (index > 0) Spacer(modifier = Modifier.height(40.dp))
            EvolutionTree(root, evolutionChain, pokemon, navController)
        }
    }
}

@Composable
fun EvolutionTree(
    currentStep: EvolutionStep,
    fullChain: List<EvolutionStep>,
    currentPokemon: Pokemon,
    navController: NavController
) {
    // Tìm các con tiến hóa từ pokemon hiện tại
    val children = fullChain.filter { 
        it.evolvesFrom?.equals(currentStep.name, ignoreCase = true) == true ||
        it.evolvesFrom == currentStep.id
    }
    
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(IntrinsicSize.Min)
    ) {
        EvolutionNode(currentStep, currentPokemon, navController)
        
        if (children.isNotEmpty()) {
            Column(
                modifier = Modifier.padding(start = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                children.forEach { child ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 12.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.width(100.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                tint = Color(0xFF00B0FF).copy(alpha = 0.8f),
                                modifier = Modifier.size(24.dp)
                            )
                            if (child.condition.isNotEmpty()) {
                                Text(
                                    text = child.condition,
                                    color = Color(0xFF00B0FF),
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                        EvolutionTree(child, fullChain, currentPokemon, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun EvolutionNode(
    step: EvolutionStep, 
    currentPokemon: Pokemon, 
    navController: NavController
) {
    val displayId = step.id
    val displayName = step.name
    val displayImage = step.imageUrl
    
    val isCurrent = displayId == currentPokemon.id || 
                    (displayId == currentPokemon.id.split(".")[0] && !currentPokemon.id.contains("."))
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            if (displayId != currentPokemon.id && displayId != currentPokemon.id.split(".")[0]) {
                navController.navigate("pokemon_detail/$displayId")
            }
        }
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(Color(0xFF16161D), RoundedCornerShape(16.dp))
                .border(
                    width = if (isCurrent) 2.dp else 1.dp,
                    color = if (isCurrent) Color(0xFF00B0FF) else Color(0xFF32323E),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = displayImage,
                contentDescription = displayName,
                modifier = Modifier.size(75.dp),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = displayName,
            color = if (isCurrent) Color(0xFF00B0FF) else Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MovesTable(pokemon: Pokemon) {
    val levelUpMoves = pokemon.moves.filter { it.learnMethod == "level-up" }.sortedBy { it.level }
    val otherMoves = pokemon.moves.filter { it.learnMethod != "level-up" }

    Column(modifier = Modifier.padding(16.dp)) {
        if (levelUpMoves.isNotEmpty()) {
            Text(
                "LEVEL UP MOVES",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            levelUpMoves.forEach { move ->
                MoveRow(move, showLevel = true)
                HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
            }
        }

        if (otherMoves.isNotEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "OTHER MOVES",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            otherMoves.forEach { move ->
                MoveRow(move, showLevel = false)
                HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
            }
        }
    }
}

@Composable
fun MoveRow(move: MoveInfo, showLevel: Boolean = false) {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val resourceName = "move_${move.name.lowercase().replace(" ", "_").replace("-", "_")}"
    val resourceId = context.resources.getIdentifier(resourceName, "string", context.packageName)
    val displayName = if (resourceId != 0) stringResource(resourceId) else move.name

    Column(modifier = Modifier.fillMaxWidth().clickable { expanded = !expanded }.padding(vertical = 12.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                if (showLevel) {
                    Text(
                        text = "Lv ${move.level}",
                        color = Color.Gray,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(45.dp)
                    )
                } else if (move.learnDetail.isNotEmpty()) {
                    Text(
                        text = move.learnDetail,
                        color = if (move.learnDetail == "Egg") Color(0xFFFF9800) else Color(0xFF4CAF50),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(60.dp)
                    )
                } else if (move.learnMethod != "other") {
                    Text(
                        text = move.learnMethod.replaceFirstChar { it.uppercase() },
                        color = Color.Gray,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(60.dp)
                    )
                }
                Text(displayName, color = Color(0xFF00B0FF), fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
            
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TypeBadgeSmall(move.type)
                Text(move.category.take(3).uppercase(), color = Color.Gray, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
        
        // Yêu cầu 3: Hiển thị nội dung chi tiết khi ấn vào
        AnimatedVisibility(visible = expanded) {
            Column(modifier = Modifier.padding(top = 8.dp).fillMaxWidth().background(Color(0xFF16161D), RoundedCornerShape(4.dp)).padding(8.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    MoveDetailItem("POWER", move.power?.toString() ?: "—")
                    MoveDetailItem("ACCURACY", move.accuracy?.let { "$it%" } ?: "—")
                    MoveDetailItem("PRIORITY", if (move.priority > 0) "+${move.priority}" else if (move.priority < 0) "${move.priority}" else "0")
                    MoveDetailItem("CLASS", move.category)
                }
                
                if (move.description.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("EFFECT", color = Color(0xFF00B0FF), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(move.description, color = Color.White, fontSize = 13.sp, lineHeight = 18.sp)
                }
            }
        }
    }
}

@Composable
fun MoveDetailItem(label: String, value: String) {
    Column {
        Text(label, color = Color.Gray, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        Text(value, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun TypeBadgeSmall(type: String) {
    val color = getSingleTypeColor(type)
    Box(modifier = Modifier.background(color, RoundedCornerShape(4.dp)).padding(horizontal = 8.dp, vertical = 2.dp)) {
        Text(type.uppercase(), color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

fun getThemeColor(types: List<String>): Color = if (types.isEmpty()) Color.Gray else getSingleTypeColor(types[0])

fun getSingleTypeColor(type: String): Color = when (type.uppercase()) {
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
