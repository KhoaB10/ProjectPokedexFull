package com.example.pokedex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokedex.R
import com.example.pokedex.ui.components.PrivacyFooter
import com.example.pokedex.ui.components.ShortcutCard
import com.example.pokedex.ui.components.ShortcutItem
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun HomeScreen(navController: NavController) {
    HomeScreenContent(
        onShortcutClick = { route ->
            navController.navigate(route)
        }
    )
}

@Composable
fun HomeScreenContent(onShortcutClick: (String) -> Unit) {
    val shortcuts = listOf(
        ShortcutItem("Giới thiệu về game", R.drawable.images, "guide_route"),
        ShortcutItem("Bảng xếp hạng", R.drawable.tier, "tier_route"),
        ShortcutItem("Pokémon", R.drawable.pokemon, "pokedex_route"),
        ShortcutItem("Vật phẩm", R.drawable.items, "item_route"),
        ShortcutItem("Xây dựng đội hình", R.drawable.build1, "build_route")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E26))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        HomeHeaderSection()
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Chào mừng đến với bách khoa Pokemon! Chúng tôi tin rằng mình sẽ cung cấp thông tin về Pokemon chính xác và đơn giản nhất có thể\n" +
                        "\n" +
                        "Ở trang chủ bạn có thể truy cập vào các cửa sổ khác. Để tìm hiểu sâu hơn bạn có thể dùng cửa sổ menu hoặc thông qua các Shortcuts ở bên dưới để tìm chi tiết về toàn bộ Pokédex, chỉ số cơ bản, hệ thống tiến hóa và các vật phẩm trong game. Và rất nhiều thứ khác nữa!",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                modifier = Modifier
                    .background(Color(0xFF32323E), shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 24.dp, vertical = 8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp, top = 24.dp)
        ) {
            Box(modifier = Modifier.size(14.dp).background(Color(0xFF00B0FF)))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "SHORTCUTS",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp
            )
        }

        HorizontalDivider(
            color = Color(0xFF00B0FF),
            thickness = 2.dp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            shortcuts.forEach { shortcut ->
                ShortcutCard(
                    item = shortcut,
                    onClick = {
                        onShortcutClick(shortcut.route)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        PrivacyFooter()

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun HomeHeaderSection() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color(0xFF32323E), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Home, contentDescription = null, tint = Color(0xFF00B0FF))
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = "Pokedex Database",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = "Chào mừng bạn trở lại!",
                color = Color.Gray,
                fontSize = 13.sp
            )
        }
    }
}
