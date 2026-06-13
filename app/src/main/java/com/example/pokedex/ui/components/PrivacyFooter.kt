package com.example.pokedex.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrivacyFooter() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF252530), RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFF32323E), RoundedCornerShape(12.dp))
    ) {
        // Striped Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(
                    Color(0xFF2D3540),
                    RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                )
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val stripeWidth = 2.dp.toPx()
                val gap = 4.dp.toPx()
                val step = stripeWidth + gap

                var x = -size.height
                while (x < size.width + size.height) {
                    drawLine(
                        color = Color(0xFF1E1E26).copy(alpha = 0.4f),
                        start = Offset(x, size.height),
                        end = Offset(x + size.height, 0f),
                        strokeWidth = stripeWidth
                    )
                    x += step
                }
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Privacy Policy",
                color = Color(0xFF00B0FF),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { /* Link */ }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "All content & design © Pokémon Database, 2008-2026.",
                color = Color.Gray,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
            Text(
                text = "Pokémon images & names © 1995-2026 Nintendo/Game Freak.",
                color = Color.Gray,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
        }
    }
}
