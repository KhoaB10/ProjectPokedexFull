package com.example.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrivacyPolicySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(Color(0xFF25252D))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(Color(0xFF32323E))
                .drawBehind {
                    val stripeWidth = 12.dp.toPx()
                    val stripeColor = Color(0xFF00B0FF).copy(alpha = 0.15f)
                    var x = -size.height
                    while (x < size.width + size.height) {
                        drawLine(
                            color = stripeColor,
                            start = Offset(x, size.height),
                            end = Offset(x + size.height, 0f),
                            strokeWidth = 3.dp.toPx()
                        )
                        x += stripeWidth
                    }
                }
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Privacy Policy",
                color = Color(0xFF00B0FF),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "All content & design © Pokémon Database, 2008-2026.\n" +
                        "Pokémon images & names © 1995-2026 Nintendo/Game Freak.",
                color = Color(0xFFB0B0B0),
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
        }
    }
}
