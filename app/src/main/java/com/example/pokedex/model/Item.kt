package com.example.pokedex.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey val id: Int,
    val name: String,
    val category: String,
    val effect: String,
    val imageUrl: String
)
