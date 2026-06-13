package com.example.pokedex.model

import androidx.room.ColumnInfo

data class PokemonSummary(
    val id: String,
    val name: String,
    val types: List<String>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val spAtk: Int,
    val spDef: Int,
    val speed: Int,
    val imageUrl: String,
    val pveTier: String? = null,
    val pveRole: String? = null,
    val pvp1v1Tier: String? = null,
    val pvp1v1Role: String? = null,
    val pvp2v2Tier: String? = null,
    val pvp2v2Role: String? = null,
    val tags: List<String> = emptyList(),
    val sortOrder: Double = 0.0,
    val hasFullDetails: Boolean = false
) {
    val total: Int get() = hp + attack + defense + spAtk + spDef + speed

    val baseName: String by lazy {
        name.substringBefore(" Mega").substringBefore(" Alola")
            .substringBefore(" Galar").substringBefore(" Hisui")
            .substringBefore(" Paldea").substringBefore(" Black")
            .substringBefore(" White").substringBefore(" Dusk")
            .substringBefore(" Dawn").substringBefore(" Ultra")
            .substringBefore(" Origin").substringBefore(" Primal")
            .substringBefore(" Crowned").substringBefore(" Ice")
            .substringBefore(" Shadow").substringBefore(" Therian")
            .substringBefore(" Unbound").substringBefore(" Complete")
    }

    val variantName: String by lazy {
        if (name.contains(baseName)) name.substringAfter(baseName).trim() else ""
    }

    val formattedId: String 
        get() {
            val baseId = id.split(".")[0]
            return baseId.padStart(4, '0')
        }
}
