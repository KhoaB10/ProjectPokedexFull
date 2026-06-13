package com.example.pokedex.data

enum class TierMode(val label: String) {
    PVE("PVE"),
    PVP_1V1("PVP 1v1"),
    PVP_2V2("PVP 2v2")
}

data class ModeData(
    val tier: String,
    val role: String
)

data class CustomPokemonInfo(
    val pve: ModeData? = null,
    val pvp1v1: ModeData? = null,
    val pvp2v2: ModeData? = null,
    val tags: List<String> = emptyList()
)

object PokemonCustomData {
    // Cache the merged map to avoid repeated concatenation overhead using buildMap for efficiency
    val assignments: Map<String, CustomPokemonInfo> by lazy {
        buildMap {
            putAll(getPart1())
            putAll(getPart2())
            putAll(getPart3())
            putAll(getPart4())
            putAll(getPart5())
            putAll(getPart6())
        }
    }

    private fun getPart1() = mapOf(
        "1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Poison", "Catcher", "Staller", "Special Sweeper", "Wall", "Setup Sweeper", "Protect Support", "Weather Setter")
        ),
        "2" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf( "Poison", "Grass", "Catcher", "Setup Sweeper", "Staller", "Special Sweeper", "Wall", "Hazard Cleaner", "Setup Sweeper", "Protect Support", "Speed Debuffer", "Weather Setter")
        ),
        "3" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf( "Grass", "Poison", "Special Sweeper", "Setup Sweeper", "Wallbreaker", "Revenge Killer", "Single-Target Nuke", "Protect Support")
        ),
        "3.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf( "Grass", "Poison", "Setup Sweeper", "Wallbreaker", "Special Sweeper", "Single-Target Nuke", "Spread Attacker")
        ),
        "3.2" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T1.5", "Wall"),
            pvp2v2 = ModeData("T4", "Wall"),
            tags = listOf( "Grass", "Poison", "Wall", "Staller", "Special Sweeper", "Hazard Setter", "Protect Support", "Single-Target Nuke")
        ),
        "4" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf( "Fire", "Special Sweeper", "Setup Sweeper", "Revenge Killer", "Single-Target Nuke", "Protect Support")
        ),
        "5" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf( "Fire", "Special Sweeper", "Setup Sweeper", "Physical Sweeper", "Wallbreaker", "Protect Support", "Spread Attacker")
        ),
        "6" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fire", "Flying", "Special Sweeper", "Setup Sweeper", "Wallbreaker", "Spread Attacker", "Single-Target Nuke", "Protect Support")
        ),
        "6.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf( "Fire", "Dragon", "Physical Sweeper", "Setup Sweeper", "Wallbreaker", "Single-Target Nuke", "Protect Support")
        ),
        "6.2" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Support Sweeper"),
            tags = listOf("Fire", "Flying", "Special Sweeper", "Weather Setter", "Spread Attacker", "Wallbreaker", "Single-Target Nuke", "Protect Support")
        ),
        "6.3" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Fire", "Flying", "Special Sweeper", "Setup Sweeper", "Spread Attacker", "Wallbreaker", "Single-Target Nuke")
        ),
        "7" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Special Sweeper", "Catcher", "Hazard Cleaner", "Setup Sweeper", "Fake Out User", "Protect Support", "Speed Debuffer")
        ),
        "8" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Wall", "Catcher", "Hazard Cleaner", "Fake Out User", "Protect Support", "Speed Debuffer")
        ),
        "9" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Water", "Setup Sweeper", "Special Sweeper", "Hazard Cleaner", "Fake Out User", "Redirector", "Spread Attacker")
        ),
        "9.1" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Water", "Setup Sweeper", "Special Sweeper", "Hazard Cleaner", "Wallbreaker", "Redirector", "Spread Attacker", "Fake Out User", "Single-Target Nuke")
        ),
        "9.2" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Water", "Setup Sweeper", "Special Sweeper", "Wallbreaker", "Spread Attacker", "Single-Target Nuke")
        ),
        "10" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Speed Debuffer")
        ),
        "11" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Wall", "Staller", "Speed Debuffer")
        ),
        "12" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Flying", "Catcher", "Setup Sweeper", "Redirector", "Tailwind Setter", "Protect Support")
        ),
        "12.1" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Bug", "Flying", "Special Sweeper", "Setup Sweeper", "Redirector", "Wallbreaker", "Spread Attacker")
        ),
        "13" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Poison", "Speed Debuffer")
        ),
        "14" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Poison", "Speed Debuffer", "Wall", "Staller")
        ),
        "15" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Poison", "Physical Sweeper", "Setup Sweeper", "Hazard Setter", "Pivot", "Tailwind Setter", "Pivot", "Protect Support")
        ),
        "15.1" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T2", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Poison", "Physical Sweeper", "Setup Sweeper", "Revenge Killer", "Pivot", "Wallbreaker", "Single-Target Nuke", "Protect Support")
        ),
        "16" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Slave", "Physical Sweeper", "Hazard Cleaner", "Pivot", "Tailwind Setter", "Speed Debuffer")
        ),
        "17" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Physical Sweeper", "Slave", "Hazard Cleaner", "Pivot", "Wall", "Tailwind Setter", "Speed Debuffer")
        ),
        "18" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Physical Sweeper", "Slave", "Hazard Cleaner", "Pivot", "Revenge Killer", "Tailwind Setter")
        ),
        "18.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T3", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Normal", "Flying", "Special Sweeper", "Wallbreaker", "Pivot", "Spread Attacker", "Tailwind Setter", "Protect Support")
        ),
        "19" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Physical Sweeper", "Revenge Killer", "Protect Support")
        ),
        "19.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Normal", "Dark", "Physical Sweeper", "Revenge Killer", "Wallbreaker", "Single-Target Nuke", "Protect Support")
        ),
        "20" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Physical Sweeper", "Wallbreaker", "Revenge Killer", "Setup Sweeper", "Single-Target Nuke", "Protect Support")
        ),
        "20.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Dark", "Physical Sweeper", "Setup Sweeper", "Wallbreaker", "Single-Target Nuke", "Protect Support")
        ),
        "21" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Physical Sweeper", "Slave", "Pivot", "Revenge Killer", "Tailwind Setter", "Protect Support")
        ),
        "22" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Physical Sweeper", "Slave", "Pivot", "Tailwind Setter", "Wallbreaker", "Revenge Killer")
        ),
        "23" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Physical Sweeper", "Catcher", "Setup Sweeper", "Hazard Setter", "Attack Debuffer", "Speed Debuffer")
        ),
        "24" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Attack Debuffer", "Setup Sweeper", "Catcher", "Speed Debuffer", "Single-Target Nuke")
        ),
        "25" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Lightning", "SPhysical Sweeper", "Special Sweeper", "Wallbreaker", "Pivot", "Fake Out User", "Speed Debuffer", "Redirector")
        ),
        "26" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Lightning", "Special Sweeper", "Physical Sweeper", "Pivot", "Setup Sweeper", "Fake Out Usee", "Redirector", "Speed Debuffer", "Encore Support")
        ),
        "26.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf("Lightning", "Psychic", "Special Sweeper", "Setup Sweeper", "Revenge Killer", "Fake Out User", "Spread Attacker", "Pivot")
        ),
        "27" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Ground", "Physical Sweeper", "Wall", "Setup Sweeper", "Hazard Cleaner", "Hazard Setter", "Speed Debuffer", "Protect Support")
        ),
        "27.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Steel", "Physical Sweeper", "Setup Sweeper", "Hazard Cleaner", "Protect Support")
        ),
        "28" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Ground", "Physical Sweeper", "Wall", "Setup Sweeper", "Hazard Cleaner", "Hazard Setter", "Spread Attacker")
        ),
        "28.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ice", "Steel", "Physical Sweeper", "Wall", "Setup Sweeper", "Hazard Cleaner", "Protect Support")
        ),
        "29" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Physical Sweeper", "Hazard Setter", "Wallbreaker", "Protect Support")
        ),
        "30" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Wall", "Hazard Setter", "Protect Support", "Attack Debuffer")
        ),
        "31" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Poison", "Ground", "Special Sweeper", "Physical Sweeper", "Wallbreaker", "Hazard Setter", "Staller", "Spread Attacker", "Single-Target Nuke")
        ),
        "32" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Physical Sweeper", "Hazard Setter", "Wallbreaker", "Protect Support")
        ),
        "33" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Poison", "Physical Sweeper", "Wallbreaker", "Hazard Setter", "Protect Support")
        ),
        "34" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Poison", "Ground", "Special Sweeper", "Physical Sweeper", "Wallbreaker", "Stallbreaker", "Single-Target Nuke", "Spread Attacker")
        ),
        "35" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Fairy", "Wall", "Cleric", "Hazard Setter", "Redirector", "Damage Mitigator", "Speed Debuffer", "Helping Hand Support")
        ),
        "36" to CustomPokemonInfo(
            pve = ModeData("T3", "Support Sweeper"),
            pvp1v1 = ModeData("T2", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Setup Sweeper", "Wall", "Hazard Setter", "Cleric", "Redirector")
        ),
        "37" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fire", "Special Sweeper", "Attack Debuffer", "Spread Attacker", "Protect Support")
        ),
        "37.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Special Sweeper", "Speed Debuffer", "Spread Attacker", "Protect Support")
        ),
        "38" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fire", "Special Sweeper", "Setup Sweeper", "Attack Debuffer", "Spread Attacker", "Protect Support")
        ),
        "38.1" to CustomPokemonInfo(
            pve = ModeData("T4", "Support Sweeper"),
            pvp1v1 = ModeData("T2", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Ice", "Fairy", "Special Sweeper", "Damage Mitigator", "Encore Support", "Speed Debuffer", "Spread Attacker", "Protect Support")
        ),
        "39" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Normal", "Catcher", "Special Sweeper", "Wall", "Hazard Setter", "Speed Debuffer", "Damage Mitigator", "Protect Support")
        ),
        "40" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fairy", "Normal", "Special Sweeper", "Hazard Setter", "Wallbreaker", "Spread Attacker", "Speed Debuffer", "Protect Support")
        ),
        "41" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Flying", "Physical Sweeper", "Slave", "Pivot", "Hazard Cleaner", "Wallbreaker", "Tailwind Setter", "Protect Support")
        ),
        "42" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Flying", "Physical Sweeper", "Slave", "Wall", "Pivot", "Hazard Cleaner", "Wallbreaker", "Tailwind Setter", "Protect Support", "Speed Debuffer")
        ),
        "43" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Grass", "Special Sweeper", "Catcher", "Setup Sweeper", "Attack Debuffer", "Speed Debuffer", "Protect Support")
        ),
        "44" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Grass", "Wall", "Catcher", "Attack Debuffer", "Protect Support")
        ),
        "45" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Poison", "Grass", "Special Sweeper", "Setup Sweeper", "Attack Debuffer", "Protect Support")
        ),
        "46" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Grass", "Physical Sweeper", "Catcher", "Staller", "Protect Support", "Redirector")
        ),
        "47" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Grass", "Physical Sweeper", "Catcher", "Staller", "Protect Support", "Redirector")
        ),
        "48" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Poison", "Hazard Setter", "Speed Debuffer", "Catcher", "Staller", "Protect Support", "Redirector")
        ),
        "49" to CustomPokemonInfo(
            pve = ModeData("T3", "Support Sweeper"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Poison", "Setup Sweeper", "Hazard Setter", "Catcher", "Protect Support", "Redirector")
        ),
        "50" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Physical Sweeper", "Hazard Setter", "Pivot", "Protect Support")
        ),
        "50.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Steel", "Physical Sweeper", "Hazard Setter", "Pivot", "Protect Support", "Speed Debuffer")
        ),
        "51" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Ground", "Physical Sweeper", "Hazard Setter", "Pivot", "Protect Support")
        ),
        "51.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Ground", "Steel", "Physical Sweeper", "Hazard Setter", "Pivot", "Protect Support", "Speed Debuffer")
        ),
        "52" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Physical Sweeper", "Slave", "Speed Debuffer", "Pivot", "Protect Support")
        ),
        "52.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Dark", "Special Sweeper", "Slave", "Attack Debuffer", "Pivot", "Protect Support", "Speed Debuffer")
        ),
        "52.3" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Steel", "Physical Sweeper", "Slave", "Pivot", "Wallbreaker", "Protect Support")
        ),
        "52.4" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Physical Sweeper", "Slave", "Protect Support")
        ),
        "53" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Physical Sweeper", "Pivot", "Protect Support", "Speed Debuffer")
        ),
        "53.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Dark", "Physical Sweeper", "Slave", "Pivot", "Attack Debuffer", "Damage Mitigator", "Protect Support", "Speed Debuffer")
        ),
        "54" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Special Sweeper", "Protect Support", "Speed Debuffer", "Damage Mitigator")
        ),
        "55" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Water", "Special Sweeper", "Setup Sweeper", "Protect Support", "Speed Debuffer", "Damage Mitigator")
        ),
        "56" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Pivot", "Protect Support")
        ),
        "57" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Pivot", "Protect Support")
        ),
        "58" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fire", "Physical Sweeper", "Attack Debuffer", "Wall", "Protect Support")
        ),
        "58.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fire", "Rock", "Physical Sweeper", "Wallbreaker", "Protect Support")
        ),
        "59" to CustomPokemonInfo(
            pve = ModeData("T3", "Support Sweeper"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Fire", "Physical Sweeper", "Attack Debuffer", "Pivot", "Protect Support")
        ),
        "59.1" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Fire", "Rock", "Physical Sweeper", "Wallbreaker", "Protect Support", "Attack Debuffer")
        ),
        "60" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Special Sweeper", "Catcher", "Setup Sweeper", "Status Inflicter", "Speed Debuffer", "Protect Support")
        ),
        "61" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Special Sweeper", "Catcher", "Setup Sweeper", "Wall", "Speed Debuffer", "Protect Support")
        ),
        "62" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Fighting", "Physical Sweeper", "Damage Mitigator", "Setup Sweeper", "Protect Support")
        ),
        "63" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Psychic", "Special Sweeper", "Protect Support")
        ),
        "64" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Psychic", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "65" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Psychic", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "65.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Psychic", "Special Sweeper", "Protect Support", "Revenge Killer", "Ability Abuser")
        ),
        "66" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Wallbreaker", "Protect Support")
        ),
        "67" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Wallbreaker", "Wall", "Protect Support")
        ),
        "68" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Single-Target Nuke", "Protect Support")
        ),
        "69" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Poison", "Catcher", "Item Farmer", "Hazard Setter", "Weather Setter", "Protect Support")
        ),
        "70" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Poison", "Physical Sweeper", "Special Sweeper", "Item Farmer", "Setup Sweeper", "Hazard Setter", "Single-Target Nuke", "Protect Support")
        ),
        "71" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Grass", "Poison", "Physical Sweeper", "Special Sweeper", "Wallbreaker", "Setup Sweeper", "Single-Target Nuke", "Protect Support")
        ),
        "72" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Poison", "Wall", "Staller", "Hazard Setter", "Hazard Cleaner", "Speed Debuffer", "Protect Support")
        ),
        "73" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Poison", "Special Sweeper", "Wall", "Staller", "Hazard Setter", "Hazard Cleaner", "Speed Debuffer", "Protect Support")
        ),
        "74" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Ground", "Physical Sweeper", "Wall", "Hazard Setter", "Spread Attacker", "Protect Support")
        ),
        "74.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Electric", "Physical Sweeper", "Wall", "Pivot", "Hazard Setter", "Spread Attacker", "Protect Support")
        ),
        "75" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Ground", "Physical Sweeper", "Wall", "Hazard Setter", "Spread Attacker", "Protect Support")
        ),
        "75.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Electric", "Physical Sweeper", "Wall", "Pivot", "Hazard Setter", "Spread Attacker", "Protect Support")
        ),
        "76" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Ground", "Physical Sweeper", "Wallbreaker", "Wall", "Hazard Setter", "Spread Attacker", "Protect Support")
        ),
        "76.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Electric", "Physical Sweeper", "Wallbreaker", "Wall", "Hazard Setter", "Spread Attacker", "Protect Support")
        ),
        "77" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fire", "Physical Sweeper", "Setup Sweeper", "Revenge Killer", "Single-Target Nuke", "Protect Support")
        ),
        "77.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Physical Sweeper", "Setup Sweeper", "Pivot", "Trick Room Setter", "Protect Support")
        ),
        "78" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Physical Sweeper", "Setup Sweeper", "Revenge Killer", "Single-Target Nuke", "Protect Support")
        ),
        "78.1" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Psychic", "Physical Sweeper", "Setup Sweeper", "Protect Support")
        ),
        "79" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Psychic", "Catcher", "Staller", "Wall", "Pivot", "Trick Room Setter", "Protect Support")
        ),
        "79.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Wall", "Staller", "Pivot", "Trick Room Setter", "Protect Support")
        ),
        "80" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Psychic", "Setup Sweeper", "Wall", "Pivot", "Trick Room Setter", "Protect Support")
        ),
        "80.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Psychic", "Setup Sweeper", "Staller", "Wall", "Trick Room Setter", "Protect Support")
        ),
        "80.2" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Poison", "Wall", "Special Sweeper", "Setup Sweeper", "Wallbreaker", "Trick Room Setter", "Protect Support", "Single-Target Nuke")
        ),
        "81" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Steel", "Special Sweeper", "Wall", "Pivot", "Hazard Setter", "Speed Debuffer", "Protect Support")
        ),
        "82" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Steel", "Special Sweeper", "Wall", "Pivot", "Wallbreaker", "Speed Debuffer", "Protect Support")
        ),
        "83" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Physical Sweeper", "Setup Sweeper", "Tailwind Setter", "Wallbreaker", "Protect Support")
        ),
        "83.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Single-Target Nuke", "Wallbreaker", "Protect Support")
        ),
        "84" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Physical Sweeper", "Speed Debuffer", "Protect Support")
        ),
        "85" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Normal", "Flying", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Protect Support")
        ),
        "86" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Staller", "Speed Debuffer", "Protect Support")
        ),
        "87" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Water", "Ice", "Wall", "Staller", "Weather Setter", "Damage Mitigator", "Protect Support")
        ),
        "88" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Staller", "Hazard Setter", "Protect Support")
        ),
        "88.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Staller", "Hazard Setter", "Protect Support")
        ),
        "89" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Wall", "Staller", "Hazard Setter", "Attack Debuffer", "Protect Support")
        ),
        "89.1" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Wall", "Staller", "Hazard Setter", "Attack Debuffer", "Protect Support")
        ),
        "90" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Wall", "Hazard Setter", "Protect Support")
        ),
        "91" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Water", "Ice", "Physical Sweeper", "Wall", "Setup Sweeper", "Hazard Setter", "Wallbreaker", "Protect Support")
        ),
        "92" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ghost", "Poison", "Special Sweeper", "Speed Debuffer", "Protect Support")
        ),
        "93" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Ghost", "Poison", "Special Sweeper", "Wallbreaker", "Speed Debuffer", "Protect Support")
        ),
        "94" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Ghost", "Poison", "Special Sweeper", "Wallbreaker", "Revenge Killer", "Status Inflicter", "Speed Debuffer", "Protect Support")
        ),
        "94.1" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Support Sweeper"),
            tags = listOf("Ghost", "Poison", "Special Sweeper", "Wallbreaker", "Revenge Killer", "Ability Abuser", "Spread Attacker", "Protect Support")
        ),
        "94.2" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Ghost", "Poison", "Special Sweeper", "Setup Sweeper", "Revenge Killer", "Wallbreaker", "Single-Target Nuke", "Protect Support")
        ),
        "95" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Ground", "Wall", "Hazard Setter", "Speed Debuffer", "Protect Support")
        ),
        "96" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Status Inflicter", "Protect Support")
        ),
        "97" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Wall", "Status Inflicter", "Trick Room Setter", "Protect Support")
        ),
        "98" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Physical Sweeper", "Wallbreaker", "Protect Support")
        ),
        "99" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Water", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Spread Attacker", "Protect Support")
        ),
        "99.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Water", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Speed Debuffer", "Single-Target Nuke", "Protect Support")
        ),
        "100" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Speed Debuffer", "Pivot", "Protect Support")
        ),
        "100.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Grass", "Speed Debuffer", "Pivot", "Protect Support")
        ),
        "101" to CustomPokemonInfo(
            pve = ModeData("T5", "Support Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Special Sweeper", "Speed Debuffer", "Pivot", "Speed Booster", "Protect Support")
        ),
        "101.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Grass", "Speed Debuffer", "Pivot", "Protect Support")
        ),
        "102" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Psychic", "Status Inflicter", "Protect Support")
        ),
        "103" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Psychic", "Special Sweeper", "Wallbreaker", "Trick Room Setter", "Sun Abuser", "Protect Support")
        ),
        "103.1" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Dragon", "Special Sweeper", "Wallbreaker", "Trick Room Setter", "Sun Abuser", "Protect Support")
        ),
        "104" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Physical Sweeper", "Wallbreaker", "Protect Support")
        ),
        "105" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Ground", "Physical Sweeper", "Wallbreaker", "Wall", "Protect Support")
        ),
        "105.1" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fire", "Ghost", "Physical Sweeper", "Wallbreaker", "Wall", "Protect Support")
        ),
        "106" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Wallbreaker", "Revenge Killer", "Speed Booster", "Protect Support")
        ),
        "107" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Wallbreaker", "Priority User", "Fake Out User", "Protect Support")
        ),
        "108" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Wall", "Staller", "Status Inflicter", "Protect Support")
        ),
        "109" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Wall", "Hazard Setter", "Protect Support")
        ),
        "110" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Poison", "Wall", "Staller", "Hazard Setter", "Hazard Cleaner", "Ability Neutralizer", "Protect Support")
        ),
        "110.1" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Poison", "Fairy", "Wall", "Staller", "Hazard Setter", "Hazard Cleaner", "Ability Neutralizer", "Protect Support")
        ),
        "111" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Rock", "Wall", "Physical Sweeper", "Hazard Setter", "Protect Support")
        ),
        "112" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Rock", "Wall", "Physical Sweeper", "Wallbreaker", "Hazard Setter", "Protect Support")
        ),
        "113" to CustomPokemonInfo(
            pve = ModeData("T1", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Normal", "Wall", "Staller", "Cleric", "Status Inflicter", "Damage Mitigator", "Protect Support")
        ),
        "114" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Wall", "Staller", "Status Inflicter", "Protect Support")
        ),
        "115" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Normal", "Physical Sweeper", "Wallbreaker", "Fake Out User", "Protect Support")
        ),
        "115.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Normal", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Fake Out User", "Ability Abuser", "Protect Support")
        ),
        "116" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Special Sweeper", "Protect Support")
        ),
        "117" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "118" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Physical Sweeper", "Protect Support")
        ),
        "119" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Physical Sweeper", "Wallbreaker", "Speed Booster", "Protect Support")
        ),
        "120" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Special Sweeper", "Hazard Cleaner", "Speed Debuffer", "Protect Support")
        ),
        "121" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Water", "Psychic", "Special Sweeper", "Wallbreaker", "Hazard Cleaner", "Revenge Killer", "Speed Debuffer", "Protect Support")
        ),
        "122" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Fairy", "Wall", "Status Inflicter", "Fake Out User", "Protect Support")
        ),
        "122.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Ice", "Wall", "Status Inflicter", "Fake Out User", "Protect Support")
        ),
        "123" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Flying", "Physical Sweeper", "Pivot", "Setup Sweeper", "Protect Support")
        ),
        "124" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Psychic", "Special Sweeper", "Status Inflicter", "Protect Support")
        ),
        "125" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Special Sweeper", "Pivot", "Speed Debuffer", "Protect Support")
        ),
        "126" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fire", "Special Sweeper", "Status Inflicter", "Protect Support")
        ),
        "127" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Bug", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Protect Support")
        ),
        "127.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Bug", "Flying", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Revenge Killer", "Protect Support")
        ),
        "128" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Normal", "Physical Sweeper", "Wallbreaker", "Pivot", "Attack Debuffer", "Protect Support")
        ),
        "128.1" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Wallbreaker", "Pivot", "Attack Debuffer", "Protect Support")
        ),
        "128.2" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fighting", "Fire", "Physical Sweeper", "Wallbreaker", "Pivot", "Attack Debuffer", "Protect Support")
        ),
        "128.3" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fighting", "Water", "Physical Sweeper", "Wallbreaker", "Pivot", "Attack Debuffer", "Protect Support")
        ),
        "129" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Slave")
        ),
        "130" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf("Water", "Flying", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Attack Debuffer", "Pivot", "Single-Target Nuke", "Protect Support")
        ),
        "130.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Water", "Dark", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Attack Debuffer", "Single-Target Nuke", "Protect Support")
        ),
        "131" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Water", "Ice", "Wall", "Staller", "Weather Setter", "Damage Mitigator", "Spread Attacker", "Protect Support")
        ),
        "131.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1", "Support Sweeper"),
            tags = listOf("Water", "Ice", "Wall", "Staller", "Weather Setter", "Damage Mitigator", "Spread Attacker", "Protect Support")
        ),
        "132" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Revenge Killer", "Ability Abuser", "Imposter")
        ),
        "133" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Cleric", "Protect Support")
        ),
        "133.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Cleric", "Protect Support")
        ),
        "134" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Wall", "Staller", "Cleric", "Special Sweeper", "Protect Support")
        ),
        "135" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Electric", "Special Sweeper", "Revenge Killer", "Pivot", "Speed Booster", "Protect Support")
        ),
        "136" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Physical Sweeper", "Wallbreaker", "Protect Support")
        ),
        "137" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Special Sweeper", "Protect Support")
        ),
        "138" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Water", "Wall", "Hazard Setter", "Protect Support")
        ),
        "139" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Rock", "Water", "Special Sweeper", "Wall", "Setup Sweeper", "Hazard Setter", "Sun Abuser", "Protect Support")
        ),
        "140" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Water", "Physical Sweeper", "Hazard Setter", "Protect Support")
        ),
        "141" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Rock", "Water", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Priority User", "Sun Abuser", "Protect Support")
        ),
        "142" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Rock", "Flying", "Physical Sweeper", "Wallbreaker", "Speed Booster", "Protect Support")
        ),
        "142.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Rock", "Flying", "Physical Sweeper", "Wallbreaker", "Speed Booster", "Revenge Killer", "Protect Support")
        ),
        "143" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Normal", "Wall", "Staller", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Stallbreaker", "Protect Support")
        ),
        "143.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Normal", "Wall", "Staller", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Stallbreaker", "Protect Support")
        ),
        "144" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Flying", "Wall", "Staller", "Hazard Cleaner", "Speed Debuffer", "Protect Support")
        ),
        "144.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Flying", "Wall", "Staller", "Hazard Cleaner", "Speed Debuffer", "Protect Support")
        ),
        "145" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Electric", "Flying", "Special Sweeper", "Pivot", "Tailwind Setter", "Wall", "Speed Debuffer", "Protect Support")
        ),
        "145.1" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Electric", "Flying", "Special Sweeper", "Pivot", "Tailwind Setter", "Wall", "Speed Debuffer", "Protect Support")
        ),
        "146" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fire", "Flying", "Special Sweeper", "Wallbreaker", "Pivot", "Weather Setter", "Protect Support")
        ),
        "146.1" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fire", "Flying", "Special Sweeper", "Wallbreaker", "Pivot", "Weather Setter", "Protect Support")
        ),
        "147" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Dragon", "Special Sweeper", "Protect Support")
        ),
        "148" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Dragon", "Special Sweeper", "Setup Sweeper", "Protect Support")
        ),
        "149" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Dragon", "Flying", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Multiscale", "Priority User", "Revenge Killer", "Single-Target Nuke", "Protect Support")
        ),
        "150" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Psychic", "Special Sweeper", "Wallbreaker", "Setup Sweeper", "Revenge Killer", "Spread Attacker", "Single-Target Nuke", "Protect Support")
        ),
        "150.1" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Psychic", "Fighting", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Revenge Killer", "Single-Target Nuke", "Protect Support")
        ),
        "150.2" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Psychic", "Special Sweeper", "Wallbreaker", "Setup Sweeper", "Revenge Killer", "Spread Attacker", "Single-Target Nuke", "Protect Support")
        ),
        "151" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Psychic", "All-Rounder", "Support", "Setup Sweeper", "Status Inflicter", "Hazard Setter", "Hazard Cleaner", "Trick Room Setter", "Protect Support")
        ),
        "152" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Catcher", "Protect Support")
        ),
        "153" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Wall", "Protect Support")
        ),
        "154" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Wall", "Staller", "Cleric", "Dual Screener", "Protect Support")
        ),
        "155" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Special Sweeper", "Protect Support")
        ),
        "156" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Special Sweeper", "Setup Sweeper", "Protect Support")
        ),
        "157" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fire", "Special Sweeper", "Wallbreaker", "Eruption User", "Protect Support")
        ),
        "157.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Fire", "Ghost", "Special Sweeper", "Wallbreaker", "Setup Sweeper", "Single-Target Nuke", "Protect Support")
        ),
        "158" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Physical Sweeper", "Protect Support")
        ),
        "159" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Physical Sweeper", "Setup Sweeper", "Protect Support")
        ),
        "160" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Sheer Force", "Single-Target Nuke", "Protect Support")
        ),
        "161" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Slave", "Speed Debuffer")
        ),
        "162" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Slave", "Pivot", "Speed Debuffer", "Protect Support")
        ),
        "163" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Speed Debuffer")
        ),
        "164" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Normal", "Flying", "Wall", "Status Inflicter", "Tailwind Setter", "Protect Support")
        ),
        "165" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Flying", "Dual Screener")
        ),
        "166" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Bug", "Flying", "Wall", "Dual Screener", "Protect Support")
        ),
        "167" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Poison", "Speed Debuffer")
        ),
        "168" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Bug", "Poison", "Physical Sweeper", "Hazard Setter", "Protect Support")
        ),
        "169" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Poison", "Flying", "Physical Sweeper", "Wallbreaker", "Pivot", "Speed Booster", "Protect Support")
        ),
        "170" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Electric", "Pivot")
        ),
        "171" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Water", "Electric", "Wall", "Pivot", "Heal Bell User", "Status Inflicter", "Protect Support")
        )
    )

    private fun getPart2() = mapOf(
        "172" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Baby")
        ),
        "173" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Baby")
        ),
        "174" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Fairy", "Baby")
        ),
        "175" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Baby")
        ),
        "176" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Fairy", "Flying", "Support", "Protect Support")
        ),
        "177" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Flying", "Pivot")
        ),
        "178" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Psychic", "Flying", "Pivot", "Magic Bounce", "Trick Room Setter", "Protect Support")
        ),
        "179" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Protect Support")
        ),
        "180" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Protect Support")
        ),
        "181" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Electric", "Special Sweeper", "Setup Sweeper", "Protect Support")
        ),
        "181.1" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Electric", "Dragon", "Special Sweeper", "Wallbreaker", "Setup Sweeper", "Single-Target Nuke", "Protect Support")
        ),
        "182" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Sun Abuser", "Protect Support")
        ),
        "183" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Fairy", "Physical Sweeper")
        ),
        "184" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Water", "Fairy", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Huge Power", "Priority User", "Protect Support")
        ),
        "185" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Wall", "Hazard Setter", "Protect Support")
        ),
        "186" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Water", "Weather Setter", "Drizzle", "Helping Hand Support", "Protect Support")
        ),
        "187" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Flying", "Speed Booster")
        ),
        "188" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Flying", "Speed Booster")
        ),
        "189" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Grass", "Flying", "Speed Booster", "Sleep Powder User", "Tailwind Setter", "Protect Support")
        ),
        "190" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Physical Sweeper", "Pivot")
        ),
        "191" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Sun Abuser")
        ),
        "192" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Special Sweeper", "Sun Abuser", "Protect Support")
        ),
        "193" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Flying", "Special Sweeper", "Speed Booster")
        ),
        "194" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Ground", "Wall")
        ),
        "194.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Ground", "Wall")
        ),
        "195" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Water", "Ground", "Wall", "Unaware", "Staller", "Hazard Setter", "Protect Support")
        ),
        "196" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Psychic", "Special Sweeper", "Wallbreaker", "Magic Bounce", "Protect Support")
        ),
        "197" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Dark", "Wall", "Staller", "Status Inflicter", "Wish Support", "Protect Support")
        ),
        "198" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Dark", "Flying", "Prankster", "Tailwind Setter", "Haze User", "Protect Support")
        ),
        "199" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Water", "Psychic", "Wall", "Trick Room Setter", "Protect Support")
        ),
        "199.1" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Poison", "Psychic", "Wall", "Staller", "Trick Room Setter", "Regenerator", "Protect Support")
        ),
        "200" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ghost", "Special Sweeper", "Pivot")
        ),
        "201" to CustomPokemonInfo(
            pve = ModeData("T5", "Slave"),
            pvp1v1 = ModeData("T5", "Slave"),
            pvp2v2 = ModeData("T5", "Slave"),
            tags = listOf("Psychic", "Slave")
        ),
        "202" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Wall", "Staller", "Shadow Tag", "Counter User")
        ),
        "203" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Psychic", "Special Sweeper")
        ),
        "204" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Wall", "Hazard Setter")
        ),
        "205" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Steel", "Wall", "Staller", "Hazard Setter", "Hazard Cleaner", "Protect Support")
        ),
        "206" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Wall", "Serene Grace")
        ),
        "207" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Flying", "Wall", "Pivot")
        ),
        "208" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Steel", "Ground", "Wall", "Hazard Setter", "Protect Support")
        ),
        "208.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Steel", "Ground", "Wall", "Staller", "Wallbreaker", "Hazard Setter", "Protect Support")
        ),
        "209" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Intimidate")
        ),
        "210" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Fairy", "Physical Sweeper", "Wallbreaker", "Intimidate", "Protect Support")
        ),
        "211" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Poison", "Hazard Setter")
        ),
        "211.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Dark", "Poison", "Hazard Setter")
        ),
        "212" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Bug", "Steel", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Technician", "Priority User", "Protect Support")
        ),
        "212.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Bug", "Steel", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Technician", "Priority User", "Protect Support")
        ),
        "213" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Rock", "Wall", "Staller", "Hazard Setter", "Sticky Web User", "Protect Support")
        ),
        "214" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Fighting", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Guts Abuser", "Protect Support")
        ),
        "214.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Fighting", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Skill Link", "Protect Support")
        ),
        "215" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Ice", "Physical Sweeper", "Pivot")
        ),
        "215.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Poison", "Physical Sweeper", "Pivot")
        ),
        "216" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Guts Abuser")
        ),
        "217" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Normal", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Guts Abuser", "Protect Support")
        ),
        "218" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fire", "Wall")
        ),
        "219" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fire", "Rock", "Wall", "Hazard Setter", "Protect Support")
        ),
        "220" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Ground", "Physical Sweeper")
        ),
        "221" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Ground", "Wall", "Staller")
        ),
        "222" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Rock", "Wall")
        ),
        "222.1" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Ghost", "Wall", "Staller", "Eviolite User", "Status Inflicter", "Protect Support")
        ),
        "223" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Special Sweeper")
        ),
        "224" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "225" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Flying", "Slave")
        ),
        "226" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Water", "Flying", "Wall", "Tailwind Setter", "Protect Support")
        ),
        "227" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Steel", "Flying", "Wall", "Staller", "Hazard Setter", "Hazard Cleaner", "Protect Support")
        ),
        "228" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Fire", "Special Sweeper")
        ),
        "229" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Fire", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "229.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Fire", "Special Sweeper", "Wallbreaker", "Setup Sweeper", "Solar Power", "Sun Abuser", "Protect Support")
        ),
        "230" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Dragon", "Special Sweeper", "Swift Swim", "Rain Abuser", "Setup Sweeper", "Protect Support")
        ),
        "231" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Physical Sweeper")
        ),
        "232" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Physical Sweeper", "Wall", "Hazard Setter", "Hazard Cleaner", "Pivot", "Protect Support")
        ),
        "233" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Normal", "Wall", "Staller", "Eviolite User", "Recover User", "Trace", "Protect Support")
        ),
        "234" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Intimidate")
        ),
        "235" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T0.5", "Support"),
            tags = listOf("Normal", "Master of All", "Fake Out User", "Spore User", "Redirector", "Speed Debuffer", "Protect Support")
        ),
        "236" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fighting", "Baby")
        ),
        "237" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Fighting", "Support", "Intimidate", "Fake Out User", "Helping Hand Support", "Protect Support")
        ),
        "238" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Psychic", "Baby")
        ),
        "239" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Baby")
        ),
        "240" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fire", "Baby")
        ),
        "241" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Wall", "Staller", "Heal Bell User", "Protect Support")
        ),
        "242" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Wall", "Staller", "Cleric", "Special Wall", "Status Inflicter", "Protect Support")
        ),
        "243" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Electric", "Special Sweeper", "Legendary", "Wallbreaker", "Calm Mind User", "Protect Support")
        ),
        "244" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Fire", "Physical Sweeper", "Legendary", "Wallbreaker", "Sacred Fire User", "Protect Support")
        ),
        "245" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Water", "Wall", "Legendary", "Staller", "Calm Mind User", "Tailwind Setter", "Protect Support")
        ),
        "246" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Ground", "Physical Sweeper")
        ),
        "247" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Ground", "Wall")
        ),
        "248" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Rock", "Dark", "Physical Sweeper", "Pseudo-Legendary", "Wallbreaker", "Weather Setter", "Sand Stream", "Protect Support")
        ),
        "248.1" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Rock", "Dark", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Weather Setter", "Sand Stream", "Protect Support")
        ),
        "249" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Psychic", "Flying", "Wall", "Legendary", "Staller", "Multiscale", "Setup Sweeper", "Protect Support")
        ),
        "250" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf("Fire", "Flying", "Physical Sweeper", "Legendary", "Wallbreaker", "Regenerator", "Sacred Fire User", "Status Inflicter", "Protect Support")
        ),
        "251" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Grass", "Psychic", "Mythical", "All-Rounder", "Support", "Setup Sweeper", "Status Inflicter", "Protect Support")
        ),
        "252" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Physical Sweeper", "Protect Support")
        ),
        "253" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Eviolite User", "Special Sweeper", "Protect Support")
        ),
        "254" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Grass", "Special Sweeper", "Wallbreaker", "Setup Sweeper", "Protect Support")
        ),
        "254.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Dragon", "Special Sweeper", "Wallbreaker", "Setup Sweeper", "Lightning Rod", "Protect Support")
        ),
        "255" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Special Sweeper", "Protect Support")
        ),
        "256" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Fighting", "Eviolite User", "Physical Sweeper", "Protect Support")
        ),
        "257" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Fighting", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Speed Boost", "Protect Support")
        ),
        "257.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Fire", "Fighting", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Speed Boost", "Protect Support")
        ),
        "258" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Physical Sweeper", "Protect Support")
        ),
        "259" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Ground", "Eviolite User", "Wall", "Protect Support")
        ),
        "260" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Water", "Ground", "Physical Sweeper", "Wallbreaker", "Bulky Sweeper", "Pivot", "Protect Support")
        ),
        "260.1" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Water", "Ground", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Swift Swim", "Rain Abuser", "Protect Support")
        ),
        "261" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Dark", "Intimidate")
        ),
        "262" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Dark", "Intimidate", "Moxie", "Pivot", "Protect Support")
        ),
        "263" to CustomPokemonInfo(
            pve = ModeData("T5", "Slave"),
            pvp1v1 = ModeData("T5", "Slave"),
            pvp2v2 = ModeData("T5", "Slave"),
            tags = listOf("Normal", "Slave", "Pickup")
        ),
        "264" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Belly Drum User", "Extreme Speed User", "Protect Support")
        ),
        "265" to CustomPokemonInfo(
            pve = ModeData("T5", "Slave"),
            pvp1v1 = ModeData("T5", "Slave"),
            pvp2v2 = ModeData("T5", "Slave"),
            tags = listOf("Bug", "Slave")
        ),
        "266" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Bug", "Wall")
        ),
        "267" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Flying", "Quiver Dance User", "Protect Support")
        ),
        "268" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Bug", "Wall")
        ),
        "269" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Poison", "Shield Dust", "Quiver Dance User", "Protect Support")
        ),
        "270" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Grass", "Swift Swim")
        ),
        "271" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Grass", "Swift Swim", "Protect Support")
        ),
        "272" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Water", "Grass", "Special Sweeper", "Swift Swim", "Rain Abuser", "Fake Out User", "Protect Support")
        ),
        "273" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Chlorophyll")
        ),
        "274" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Dark", "Chlorophyll", "Protect Support")
        ),
        "275" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Grass", "Dark", "Mixed Sweeper", "Chlorophyll", "Sun Abuser", "Fake Out User", "Tailwind Setter", "Protect Support")
        ),
        "276" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Guts")
        ),
        "277" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Special Sweeper", "Guts", "Facade User", "Boomburst User", "Protect Support")
        ),
        "278" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Flying", "Drizzle")
        ),
        "279" to CustomPokemonInfo(
            pve = ModeData("T2", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Water", "Flying", "Weather Setter", "Drizzle", "Tailwind Setter", "Pivot", "Protect Support")
        ),
        "280" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Fairy")
        ),
        "281" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Fairy", "Eviolite User", "Protect Support")
        ),
        "282" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Psychic", "Fairy", "Special Sweeper", "Trace", "Wallbreaker", "Protect Support")
        ),
        "282.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Psychic", "Fairy", "Special Sweeper", "Wallbreaker", "Pixilate", "Hyper Voice User", "Protect Support")
        ),
        "283" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Water")
        ),
        "284" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Bug", "Flying", "Intimidate", "Sticky Web User", "Tailwind Setter", "Quiver Dance User", "Protect Support")
        ),
        "285" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Spore User")
        ),
        "286" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Grass", "Fighting", "Physical Sweeper", "Technician", "Poison Heal", "Spore User", "Wallbreaker", "Protect Support")
        ),
        "287" to CustomPokemonInfo(
            pve = ModeData("T5", "Slave"),
            pvp1v1 = ModeData("T5", "Slave"),
            pvp2v2 = ModeData("T5", "Slave"),
            tags = listOf("Normal", "Truant")
        ),
        "288" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Eviolite User", "Vital Spirit", "Setup Sweeper", "Protect Support")
        ),
        "289" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Physical Sweeper", "Wallbreaker", "Truant", "Giga Impact User", "Protect Support")
        ),
        "290" to CustomPokemonInfo(
            pve = ModeData("T5", "Slave"),
            pvp1v1 = ModeData("T5", "Slave"),
            pvp2v2 = ModeData("T5", "Slave"),
            tags = listOf("Bug", "Ground")
        ),
        "291" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Flying", "Speed Boost", "Baton Pass User", "Protect Support")
        ),
        "292" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Bug", "Ghost", "Wonder Guard", "Protect Support")
        ),
        "293" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Soundproof")
        ),
        "294" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Soundproof", "Protect Support")
        ),
        "295" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Special Sweeper", "Scrappy", "Boomburst User", "Protect Support")
        ),
        "296" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Guts")
        ),
        "297" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Fighting", "Physical Sweeper", "Guts", "Thick Fat", "Fake Out User", "Wallbreaker", "Bulky Sweeper", "Protect Support")
        ),
        "298" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Fairy", "Baby", "Huge Power")
        ),
        "299" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Rock", "Eviolite User", "Magnet Pull", "Protect Support")
        ),
        "300" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Normalize")
        ),
        "301" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Normalize", "Protect Support")
        ),
        "302" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Ghost", "Dark", "Prankster", "Staller", "Quash User", "Fake Out User", "Protect Support")
        ),
        "302.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Ghost", "Dark", "Wall", "Magic Bounce", "Recover User", "Staller", "Protect Support")
        ),
        "303" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Steel", "Fairy", "Intimidate", "Protect Support")
        ),
        "303.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Fairy", "Physical Sweeper", "Huge Power", "Wallbreaker", "Setup Sweeper", "Protect Support")
        ),
        "304" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Steel", "Rock", "Eviolite User")
        ),
        "305" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Steel", "Rock", "Eviolite User", "Protect Support")
        ),
        "306" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Steel", "Rock", "Wall", "Rock Head", "Sturdy", "Protect Support")
        ),
        "306.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Wall"),
            pvp1v1 = ModeData("T1", "Wall"),
            pvp2v2 = ModeData("T2", "Wall"),
            tags = listOf("Steel", "Wall", "Filter", "Physical Wall", "Heavy Slam User", "Protect Support")
        ),
        "307" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Psychic", "Pure Power")
        ),
        "308" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Psychic", "Physical Sweeper", "Pure Power", "Fake Out User", "Protect Support")
        ),
        "308.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Fighting", "Psychic", "Physical Sweeper", "Pure Power", "Fake Out User", "Wallbreaker", "Protect Support")
        ),
        "309" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Lightning Rod")
        ),
        "310" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf("Electric", "Special Sweeper", "Lightning Rod", "Intimidate", "Volt Switch User", "Protect Support")
        ),
        "310.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support Sweeper"),
            tags = listOf("Electric", "Special Sweeper", "Intimidate", "Wallbreaker", "Volt Switch User", "Protect Support")
        ),
        "311" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Plus", "Helping Hand Support", "Protect Support")
        ),
        "312" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Minus", "Helping Hand Support", "Protect Support")
        ),
        "313" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Prankster", "Tail Glow User", "Protect Support")
        ),
        "314" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Prankster", "Tail Glow User", "Protect Support")
        ),
        "315" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Poison", "Eviolite User", "Protect Support")
        ),
        "316" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Liquid Ooze")
        ),
        "317" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Poison", "Wall", "Liquid Ooze", "Protect Support")
        ),
        "318" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Dark", "Rough Skin")
        ),
        "319" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Dark", "Physical Sweeper", "Speed Boost", "Wallbreaker", "Protect Support")
        ),
        "319.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Water", "Dark", "Physical Sweeper", "Strong Jaw", "Wallbreaker", "Protect Support")
        ),
        "320" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "HP Tank")
        ),
        "321" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "HP Tank", "Pressure", "Protect Support")
        ),
        "322" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Ground", "Simple")
        ),
        "323" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Fire", "Ground", "Special Sweeper", "Solid Rock", "Simple Beam", "Protect Support")
        ),
        "323.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fire", "Ground", "Special Sweeper", "Sheer Force", "Wallbreaker", "Eruption User", "Protect Support")
        ),
        "324" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Fire", "Drought", "Weather Setter", "White Smoke", "Shell Smash", "Protect Support")
        ),
        "325" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Own Tempo")
        ),
        "326" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Own Tempo", "Protect Support")
        ),
        "327" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Contrary", "Skill Swap User", "Protect Support")
        ),
        "328" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Hyper Cutter")
        ),
        "329" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Dragon", "Levitate", "Protect Support")
        ),
        "330" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Ground", "Dragon", "Special Sweeper", "Levitate", "Boomburst User", "Pivot", "Protect Support")
        ),
        "331" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Water Absorb")
        ),
        "332" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Dark", "Water Absorb", "Sucker Punch User", "Protect Support")
        ),
        "333" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Natural Cure")
        ),
        "334" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Dragon", "Flying", "Wall", "Natural Cure", "Defog User", "Cloud Nine", "Protect Support")
        ),
        "334.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Wall"),
            pvp1v1 = ModeData("T1", "Wall"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Dragon", "Fairy", "Wall", "Pixilate", "Hyper Voice User", "Cotton Guard", "Protect Support")
        ),
        "335" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Toxic Boost", "Facade User", "Protect Support")
        ),
        "336" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Poison", "Infiltrator", "Protect Support")
        ),
        "337" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Psychic", "Levitate", "Trick Room Setter", "Protect Support")
        ),
        "338" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Psychic", "Levitate", "Trick Room Setter", "Protect Support")
        ),
        "339" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Ground", "Oblivious")
        ),
        "340" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Ground", "Dragon Dance User", "Protect Support")
        ),
        "341" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Hyper Cutter")
        ),
        "342" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Dark", "Physical Sweeper", "Adaptability", "Dragon Dance User", "Wallbreaker", "Protect Support")
        )
    )

    private fun getPart3() = mapOf(
        "343" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Psychic", "Levitate")
        ),
        "344" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Ground", "Psychic", "Wall", "Levitate", "Trick Room Setter", "Protect Support")
        ),
        "345" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Grass", "Suction Cups")
        ),
        "346" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Rock", "Grass", "Wall", "Storm Drain", "Suction Cups", "Protect Support")
        ),
        "347" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Bug", "Battle Armor")
        ),
        "348" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Bug", "Swift Swim", "Rain Abuser", "Wallbreaker", "Protect Support")
        ),
        "349" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Swift Swim")
        ),
        "350" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Water", "Wall", "Competitive", "Marvel Scale", "Recover User", "Bulky Sweeper", "Protect Support")
        ),
        "351" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Forecast", "Weather Abuser", "Protect Support")
        ),
        "352" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Normal", "Protean", "Libero", "Trick Room Setter", "Protect Support")
        ),
        "353" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ghost", "Insomnia")
        ),
        "354" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Ghost", "Insomnia", "Cursed Body", "Destiny Bond User", "Protect Support")
        ),
        "354.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Ghost", "Physical Sweeper", "Prankster", "Destiny Bond User", "Wallbreaker", "Protect Support")
        ),
        "355" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Ghost", "Levitate", "Eviolite User")
        ),
        "356" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Ghost", "Eviolite User", "Wall", "Frisk", "Trick Room Setter", "Status Inflicter", "Protect Support")
        ),
        "357" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Flying", "Harvest", "Chlorophyll", "Solar Beam User", "Protect Support")
        ),
        "358" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Levitate", "Heal Bell User", "Protect Support")
        ),
        "359" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Physical Sweeper", "Super Luck", "Critical Hitter", "Sucker Punch User", "Protect Support")
        ),
        "359.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Dark", "Mixed Sweeper", "Magic Bounce", "Wallbreaker", "Sucker Punch User", "Protect Support")
        ),
        "360" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Baby", "Shadow Tag")
        ),
        "361" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Inner Focus")
        ),
        "362" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Inner Focus", "Protect Support")
        ),
        "362.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Ice", "Physical Sweeper", "Refrigerate", "Explosion User", "Wallbreaker", "Protect Support")
        ),
        "363" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Water", "Thick Fat")
        ),
        "364" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ice", "Water", "Eviolite User", "Protect Support")
        ),
        "365" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Ice", "Water", "Wall", "Thick Fat", "Staller", "Protect Support")
        ),
        "366" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Swift Swim")
        ),
        "367" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Swift Swim", "Wallbreaker", "Protect Support")
        ),
        "368" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Swift Swim", "Wallbreaker", "Protect Support")
        ),
        "369" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Water", "Rock", "Rock Head", "Sturdy", "Protect Support")
        ),
        "370" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Swift Swim", "Helping Hand Support", "Protect Support")
        ),
        "371" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Physical Sweeper")
        ),
        "372" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Dragon", "Eviolite User", "Wall", "Protect Support")
        ),
        "373" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Dragon", "Flying", "Physical Sweeper", "Pseudo-Legendary", "Intimidate", "Moxie", "Wallbreaker", "Setup Sweeper", "Protect Support")
        ),
        "373.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Dragon", "Flying", "Mixed Sweeper", "Aerilate", "Wallbreaker", "Setup Sweeper", "Double-Edge User", "Protect Support")
        ),
        "374" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Psychic", "Clear Body")
        ),
        "375" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Steel", "Psychic", "Eviolite User", "Protect Support")
        ),
        "376" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Steel", "Psychic", "Physical Sweeper", "Pseudo-Legendary", "Clear Body", "Wallbreaker", "Protect Support")
        ),
        "376.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Steel", "Psychic", "Physical Sweeper", "Tough Claws", "Wallbreaker", "Speedy Sweeper", "Protect Support")
        ),
        "377" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T3", "Wall"),
            tags = listOf("Rock", "Legendary", "Clear Body", "Wall", "Physical Wall", "Status Inflicter", "Protect Support")
        ),
        "378" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T3", "Wall"),
            tags = listOf("Ice", "Legendary", "Clear Body", "Special Wall", "Staller", "Protect Support")
        ),
        "379" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T3", "Wall"),
            tags = listOf("Steel", "Legendary", "Clear Body", "Wall", "Status Inflicter", "Protect Support")
        ),
        "380" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Dragon", "Psychic", "Legendary", "Levitate", "Tailwind Setter", "Heal Pulse User", "Protect Support")
        ),
        "380.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T2", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Dragon", "Psychic", "Levitate", "Wall", "Staller", "Calm Mind User", "Protect Support")
        ),
        "381" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Psychic", "Legendary", "Levitate", "Special Sweeper", "Wallbreaker", "Pivot", "Protect Support")
        ),
        "381.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Psychic", "Levitate", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "382" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Water", "Legendary", "Drizzle", "Weather Setter", "Special Sweeper", "Wallbreaker", "Water Spout User", "Protect Support")
        ),
        "382.1" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Water", "Primordial Sea", "Weather Setter", "Special Sweeper", "Wallbreaker", "Water Spout User", "Protect Support")
        ),
        "383" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Ground", "Legendary", "Drought", "Weather Setter", "Physical Sweeper", "Wallbreaker", "Precipice Blades User", "Protect Support")
        ),
        "383.1" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Ground", "Fire", "Desolate Land", "Weather Setter", "Physical Sweeper", "Wallbreaker", "Precipice Blades User", "Protect Support")
        ),
        "384" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Dragon", "Flying", "Legendary", "Air Lock", "Mixed Sweeper", "Wallbreaker", "Setup Sweeper", "Protect Support")
        ),
        "384.1" to CustomPokemonInfo(
            pve = ModeData("TEE", "Sweeper"),
            pvp1v1 = ModeData("TEE", "Sweeper"),
            pvp2v2 = ModeData("TEE", "Sweeper"),
            tags = listOf("Dragon", "Flying", "Delta Stream", "Mixed Sweeper", "Wallbreaker", "Setup Sweeper", "Dragon Ascent User", "Protect Support")
        ),
        "385" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Steel", "Psychic", "Mythical", "Serene Grace", "Flinch Hax", "Wish Support", "Trick Room Setter", "Protect Support")
        ),
        "386" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Mythical", "Pressure", "Mixed Sweeper", "Wallbreaker", "Pivot", "Protect Support")
        ),
        "386.1" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Mythical", "Attack Forme", "Pressure", "Mixed Sweeper", "Wallbreaker", "Glass Cannon", "Protect Support")
        ),
        "386.2" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Mythical", "Defense Forme", "Pressure", "Wall", "Staller", "Recover User", "Protect Support")
        ),
        "386.3" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Mythical", "Speed Forme", "Pressure", "Hazard Setter", "Taunt User", "Protect Support")
        ),
        "387" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Baby", "Protect Support")
        ),
        "388" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Eviolite User", "Wall", "Protect Support")
        ),
        "389" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Grass", "Ground", "Physical Sweeper", "Wallbreaker", "Setup Sweeper", "Shell Smash", "Protect Support")
        ),
        "390" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Special Sweeper", "Protect Support")
        ),
        "391" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Fighting", "Eviolite User", "Physical Sweeper", "Protect Support")
        ),
        "392" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf("Fire", "Fighting", "Mixed Sweeper", "Wallbreaker", "Setup Sweeper", "Fake Out User", "Protect Support")
        ),
        "393" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Baby", "Protect Support")
        ),
        "394" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Eviolite User", "Wall", "Protect Support")
        ),
        "395" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Water", "Steel", "Special Sweeper", "Competitive", "Defog User", "Wall", "Protect Support")
        ),
        "396" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Intimidate", "Protect Support")
        ),
        "397" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Eviolite User", "Intimidate", "Protect Support")
        ),
        "398" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf("Normal", "Flying", "Physical Sweeper", "Wallbreaker", "Intimidate", "Reckless", "Brave Bird", "Pivot", "Protect Support")
        ),
        "399" to CustomPokemonInfo(
            pve = ModeData("T5", "Slave"),
            pvp1v1 = ModeData("T5", "Slave"),
            pvp2v2 = ModeData("T5", "Slave"),
            tags = listOf("Normal", "Moody", "Slave")
        ),
        "400" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Water", "Moody Abuser", "Simple", "Simple Beam", "Protect Support")
        ),
        "401" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Baby")
        ),
        "402" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Sticky Web User", "Protect Support")
        ),
        "403" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Baby")
        ),
        "404" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Eviolite User", "Protect Support")
        ),
        "405" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Electric", "Physical Sweeper", "Intimidate", "Guts", "Protect Support")
        ),
        "406" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Poison", "Baby")
        ),
        "407" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Grass", "Poison", "Special Sweeper", "Wallbreaker", "Technician", "Sleep Powder", "Protect Support")
        ),
        "408" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Physical Sweeper", "Wallbreaker")
        ),
        "409" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Physical Sweeper", "Wallbreaker", "Sheer Force", "Head Smash", "Protect Support")
        ),
        "410" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Steel", "Wall")
        ),
        "411" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Steel", "Wall", "Staller", "Metal Burst", "Protect Support")
        ),
        "412" to CustomPokemonInfo(
            pve = ModeData("T5", "Slave"),
            pvp1v1 = ModeData("T5", "Slave"),
            pvp2v2 = ModeData("T5", "Slave"),
            tags = listOf("Bug", "Slave")
        ),
        "413" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Grass", "Steel", "Ground", "Wall", "Protect Support")
        ),
        "414" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Flying", "Tinted Lens", "Special Sweeper", "Protect Support")
        ),
        "415" to CustomPokemonInfo(
            pve = ModeData("T5", "Slave"),
            pvp1v1 = ModeData("T5", "Slave"),
            pvp2v2 = ModeData("T5", "Slave"),
            tags = listOf("Bug", "Flying", "Slave")
        ),
        "416" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Flying", "Pressure", "Heal Order", "Wall", "Protect Support")
        ),
        "417" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Electric", "Follow Me User", "Nuzzle User", "Volt Absorb", "Protect Support")
        ),
        "418" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Physical Sweeper")
        ),
        "419" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Water", "Physical Sweeper", "Swift Swim", "Rain Abuser", "Wave Crash", "Protect Support")
        ),
        "420" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Sun Abuser")
        ),
        "421" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Grass", "Flower Gift", "Sun Abuser", "Helping Hand Support", "Protect Support")
        ),
        "422" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Storm Drain")
        ),
        "423" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Water", "Ground", "Wall", "Storm Drain", "Recover User", "Staller", "Protect Support")
        ),
        "424" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Normal", "Technician", "Fake Out User", "Pivot", "Protect Support")
        ),
        "425" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ghost", "Flying", "Unburden")
        ),
        "426" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Ghost", "Flying", "Unburden", "Tailwind Setter", "Strength Sap", "Protect Support")
        ),
        "427" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Klutz")
        ),
        "428" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Klutz", "Switcheroo", "Fake Out User", "Protect Support")
        ),
        "428.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Normal", "Fighting", "Physical Sweeper", "Scrappy", "Fake Out User", "Wallbreaker", "Protect Support")
        ),
        "429" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ghost", "Special Sweeper", "Levitate", "Nasty Plot User", "Protect Support")
        ),
        "430" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Dark", "Flying", "Physical Sweeper", "Super Luck", "Moxie", "Tailwind Setter", "Protect Support")
        ),
        "431" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Fake Out User")
        ),
        "432" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Support Sweeper"),
            tags = listOf("Normal", "Defiant", "Fake Out User", "Protect Support")
        ),
        "433" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Baby")
        ),
        "434" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Dark", "Aftermath")
        ),
        "435" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Dark", "Aftermath", "Defog User", "Protect Support")
        ),
        "436" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Steel", "Psychic", "Eviolite User", "Levitate", "Heatproof")
        ),
        "437" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Steel", "Psychic", "Trick Room Setter", "Levitate", "Heatproof", "Dual Screener", "Protect Support")
        ),
        "438" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Baby")
        ),
        "439" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Fairy", "Baby")
        ),
        "440" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Baby")
        ),
        "441" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Flying", "Chatter", "Protect Support")
        ),
        "442" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Ghost", "Dark", "Wall", "Pressure", "Infiltrator", "Will-O-Wisp User", "Protect Support")
        ),
        "443" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Ground", "Rough Skin")
        ),
        "444" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Dragon", "Ground", "Eviolite User", "Rough Skin", "Protect Support")
        ),
        "445" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Dragon", "Ground", "Physical Sweeper", "Pseudo-Legendary", "Rough Skin", "Sand Veil", "Wallbreaker", "Protect Support")
        ),
        "445.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Dragon", "Ground", "Physical Sweeper", "Sand Force", "Wallbreaker", "Protect Support")
        ),
        "446" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Baby", "Thick Fat", "Protect Support")
        ),
        "447" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Baby", "Prankster")
        ),
        "448" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Fighting", "Steel", "Mixed Sweeper", "Adaptability", "Inner Focus", "Justified", "Wallbreaker", "Extreme Speed User", "Protect Support")
        ),
        "448.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Fighting", "Steel", "Mixed Sweeper", "Adaptability", "Wallbreaker", "Setup Sweeper", "Protect Support")
        ),
        "449" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ground", "Sand Stream")
        ),
        "450" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Ground", "Weather Setter", "Sand Stream", "Wall", "Physical Wall", "Stealth Rock Setter", "Protect Support")
        ),
        "451" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Bug")
        ),
        "452" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Poison", "Dark", "Physical Sweeper", "Sniper", "Battle Armor", "Protect Support")
        ),
        "453" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Poison", "Fighting", "Dry Skin")
        ),
        "454" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Poison", "Fighting", "Physical Sweeper", "Dry Skin", "Rain Abuser", "Fake Out User", "Protect Support")
        ),
        "455" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Levitate", "Protect Support")
        ),
        "456" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Swift Swim")
        ),
        "457" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Swift Swim", "Storm Drain", "Rain Abuser", "Protect Support")
        ),
        "458" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Flying", "Baby", "Swift Swim")
        ),
        "459" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Ice", "Snow Warning")
        ),
        "460" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf("Grass", "Ice", "Weather Setter", "Snow Warning", "Mixed Sweeper", "Protect Support")
        ),
        "460.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Grass", "Ice", "Physical Sweeper", "Snow Warning", "Wallbreaker", "Protect Support")
        ),
        "461" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Dark", "Ice", "Physical Sweeper", "Wallbreaker", "Pressure", "Pickpocket", "Fake Out User", "Protect Support")
        ),
        "462" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Support Sweeper"),
            tags = listOf("Electric", "Steel", "Special Sweeper", "Magnet Pull", "Sturdy", "Wallbreaker", "Protect Support")
        ),
        "463" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T5", "Wall"),
            tags = listOf("Normal", "Wall", "Regenerator", "Unaware", "Protect Support")
        ),
        "464" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Ground", "Rock", "Physical Sweeper", "Solid Rock", "Wallbreaker", "Trick Room Abuser", "Protect Support")
        ),
        "465" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Grass", "Wall", "Regenerator", "Sleep Powder", "Protect Support")
        ),
        "466" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Electric", "Physical Sweeper", "Motor Drive", "Wallbreaker", "Protect Support")
        ),
        "467" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fire", "Special Sweeper", "Flame Body", "Wallbreaker", "Protect Support")
        ),
        "468" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Fairy", "Flying", "Serene Grace", "Follow Me User", "Tailwind Setter", "Protect Support")
        ),
        "469" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Flying", "Special Sweeper", "Speed Boost", "Tinted Lens", "Protect Support")
        ),
        "470" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Chlorophyll", "Leaf Guard", "Sun Abuser", "Protect Support")
        ),
        "471" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Snow Cloak", "Ice Body", "Special Sweeper", "Protect Support")
        ),
        "472" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Ground", "Flying", "Wall", "Poison Heal", "Staller", "Pivot", "Protect Support")
        ),
        "473" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ice", "Ground", "Physical Sweeper", "Thick Fat", "Wallbreaker", "Protect Support")
        ),
        "474" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Normal", "Special Sweeper", "Adaptability", "Download", "Wallbreaker", "Protect Support")
        ),
        "475" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Support Sweeper"),
            tags = listOf("Psychic", "Fighting", "Physical Sweeper", "Sharpness", "Justified", "Protect Support")
        ),
        "475.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Psychic", "Fighting", "Physical Sweeper", "Inner Focus", "Wallbreaker", "Protect Support")
        ),
        "476" to CustomPokemonInfo(
            pve = ModeData("T5", "Wall"),
            pvp1v1 = ModeData("T5", "Wall"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Steel", "Sturdy", "Protect Support")
        ),
        "477" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Ghost", "Pressure", "Frisk", "Trick Room Setter", "Protect Support")
        ),
        "478" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Ghost", "Cursed Body", "Spikes Setter", "Destiny Bond User", "Protect Support")
        ),
        "479" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Electric", "Ghost", "Levitate", "Protect Support")
        ),
        "479.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Electric", "Water", "Levitate", "Pivot", "Volt Switch User", "Bulky Sweeper", "Protect Support")
        ),
        "479.2" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Electric", "Fire", "Levitate", "Overheat User", "Protect Support")
        ),
        "479.3" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Electric", "Grass", "Levitate", "Leaf Storm User", "Protect Support")
        ),
        "479.4" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Ice", "Levitate", "Blizzard User", "Protect Support")
        ),
        "479.5" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Flying", "Levitate", "Air Slash User", "Protect Support")
        ),
        "480" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Psychic", "Legendary", "Levitate", "Trick Room Setter", "Protect Support")
        ),
        "481" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Psychic", "Legendary", "Levitate", "Helping Hand Support", "Protect Support")
        ),
        "482" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Psychic", "Legendary", "Levitate", "Mixed Sweeper", "Explosion User", "Protect Support")
        ),
        "483" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Steel", "Dragon", "Legendary", "Pressure", "Special Sweeper", "Wallbreaker", "Trick Room Abuser", "Protect Support")
        ),
        "483.1" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Steel", "Dragon", "Pressure", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "484" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Water", "Dragon", "Legendary", "Pressure", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "484.1" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Water", "Dragon", "Pressure", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "485" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fire", "Steel", "Legendary", "Flash Fire", "Special Sweeper", "Wallbreaker", "Eruption User", "Protect Support")
        ),
        "486" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Legendary", "Slow Start", "Physical Sweeper", "Protect Support")
        ),
        "487" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T2", "Wall"),
            tags = listOf("Ghost", "Dragon", "Legendary", "Pressure", "Telepathy", "Wall", "Staller", "Protect Support")
        ),
        "487.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Ghost", "Dragon", "Levitate", "Mixed Sweeper", "Wallbreaker", "Protect Support")
        ),
        "488" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Psychic", "Legendary", "Levitate", "Wall", "Trick Room Setter", "Helping Hand Support", "Protect Support")
        ),
        "489" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Mythical", "Hydration")
        ),
        "490" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Mythical", "Hydration", "Tail Glow User", "Protect Support")
        ),
        "491" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Dark", "Mythical", "Bad Dreams", "Special Sweeper", "Dark Void User", "Protect Support")
        ),
        "492" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Grass", "Mythical", "Natural Cure", "Seed Flare User", "Protect Support")
        ),
        "492.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Grass", "Flying", "Serene Grace", "Special Sweeper", "Wallbreaker", "Protect Support")
        ),
        "493" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Normal", "Mythical", "Multitype", "All-Rounder", "Extreme Speed User", "Protect Support")
        ),
        "494" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Psychic", "Fire", "Victory Star", "V-create", "Wallbreaker", "Special Sweeper")
        ),
        "495" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Contrary", "Setup Sweeper")
        ),
        "496" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Contrary", "Setup Sweeper")
        ),
        "497" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Grass", "Contrary", "Leaf Storm", "Setup Sweeper", "Speedster")
        ),
        "498" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "499" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Fighting", "Blaze")
        ),
        "500" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Fire", "Fighting", "Reckless", "Wallbreaker", "Physical Sweeper")
        ),
        "501" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "502" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "503" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Water", "Torrent", "Shell Armor", "Mixed Sweeper", "Wallbreaker")
        ),
        "504" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Run Away")
        ),
        "505" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Keen Eye", "Analytic", "Baton Pass")
        ),
        "506" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Vital Spirit")
        ),
        "507" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Intimidate")
        ),
        "508" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Normal", "Sand Rush", "Intimidate", "Revenge Killer", "Physical Sweeper")
        ),
        "509" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Dark", "Prankster")
        ),
        "510" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Dark", "Prankster", "Encore", "Thunder Wave", "Support")
        ),
        "511" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Gluttony")
        ),
        "512" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Overgrow", "Special Sweeper")
        ),
        "513" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Gluttony")
        )
    )

    private fun getPart4() = mapOf(
        "514" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze", "Special Sweeper")
        ),
        "515" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Gluttony")
        ),
        "516" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent", "Special Sweeper")
        ),
        "517" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Psychic", "Synchronize")
        ),
        "518" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Psychic", "Synchronize", "Magic Guard", "Trick Room Setter", "Tank")
        ),
        "519" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Big Pecks")
        ),
        "520" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Super Luck")
        ),
        "521" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Super Luck", "Physical Sweeper")
        ),
        "522" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Lightning Rod")
        ),
        "523" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Electric", "Lightning Rod", "Sap Sipper", "Revenge Killer")
        ),
        "524" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Rock", "Sturdy")
        ),
        "525" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Rock", "Sturdy")
        ),
        "526" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Rock", "Sand Stream", "Sturdy", "Stealth Rock", "Tank", "Weather Setter")
        ),
        "527" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Flying", "Unaware")
        ),
        "528" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Psychic", "Flying", "Simple", "Unaware", "Setup Sweeper")
        ),
        "529" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Sand Rush")
        ),
        "530" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Ground", "Steel", "Sand Rush", "Mold Breaker", "Wallbreaker", "Hazard Cleaner", "Physical Sweeper")
        ),
        "531" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Normal", "Regenerator", "Healer", "Wall", "Wish Pass")
        ),
        "531.1" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Normal", "Fairy", "Healer", "Mega", "Wall", "Protect Support")
        ),
        "532" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Guts")
        ),
        "533" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fighting", "Guts", "Eviolite User")
        ),
        "534" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Fighting", "Guts", "Iron Fist", "Wallbreaker", "Priority", "Physical Sweeper")
        ),
        "535" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Water", "Swift Swim")
        ),
        "536" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Water", "Ground", "Swift Swim")
        ),
        "537" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Tank"),
            tags = listOf("Water", "Ground", "Swift Swim", "Water Absorb", "Stealth Rock", "Tank")
        ),
        "538" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Fighting", "Guts", "Tank")
        ),
        "539" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fighting", "Sturdy", "Mold Breaker", "Wallbreaker", "Physical Sweeper")
        ),
        "540" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Grass", "Chlorophyll")
        ),
        "541" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Bug", "Grass", "Leaf Guard")
        ),
        "542" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Bug", "Grass", "Chlorophyll", "Sticky Web", "Setup Sweeper")
        ),
        "543" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Poison", "Speed Boost")
        ),
        "544" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Bug", "Poison", "Speed Boost", "Eviolite User")
        ),
        "545" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Bug", "Poison", "Speed Boost", "Setup Sweeper", "Wallbreaker", "Baton Pass")
        ),
        "546" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Fairy", "Prankster")
        ),
        "547" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T2", "Support"),
            pvp2v2 = ModeData("T0.5", "Support"),
            tags = listOf("Grass", "Fairy", "Prankster", "Tailwind", "Encore", "Support", "Protect Support")
        ),
        "548" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Chlorophyll")
        ),
        "549" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Grass", "Chlorophyll", "Own Tempo", "Quiver Dance", "Setup Sweeper", "Special Sweeper")
        ),
        "550" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Adaptability", "Reckless", "Wallbreaker")
        ),
        "551" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Dark", "Moxie")
        ),
        "552" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Dark", "Moxie")
        ),
        "553" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Ground", "Dark", "Moxie", "Intimidate", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "554" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Hustle")
        ),
        "555" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Fire", "Sheer Force", "Wallbreaker", "Physical Sweeper", "Spread Attacker")
        ),
        "555.1" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Fire", "Psychic", "Zen Mode", "Wallbreaker")
        ),
        "556" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Water Absorb", "Spikes")
        ),
        "557" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Rock", "Sturdy")
        ),
        "558" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Bug", "Rock", "Sturdy", "Shell Smash", "Setup Sweeper", "Wallbreaker")
        ),
        "559" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Fighting", "Moxie")
        ),
        "560" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T1.5", "Support"),
            tags = listOf("Dark", "Fighting", "Intimidate", "Moxie", "Fake Out User", "Wall", "Tank")
        ),
        "561" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Psychic", "Flying", "Magic Guard", "Special Sweeper", "Wallbreaker")
        ),
        "562" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Ghost", "Mummy")
        ),
        "563" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T4", "Wall"),
            tags = listOf("Ghost", "Mummy", "Wall", "Tank", "Hazard Setter")
        ),
        "564" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Rock", "Sturdy")
        ),
        "565" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Rock", "Solid Rock", "Shell Smash", "Setup Sweeper", "Physical Sweeper")
        ),
        "566" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Flying", "Defeatist")
        ),
        "567" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Rock", "Flying", "Defeatist", "Wallbreaker", "Physical Sweeper", "Special Sweeper")
        ),
        "568" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Stench")
        ),
        "569" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Poison", "Aftermath", "Spikes", "Wall")
        ),
        "570" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Illusion")
        ),
        "571" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Dark", "Illusion", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "572" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Technician")
        ),
        "573" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Normal", "Skill Link", "Technician", "Physical Sweeper", "Revenge Killer")
        ),
        "574" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Frisk")
        ),
        "575" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Frisk")
        ),
        "576" to CustomPokemonInfo(
            pve = ModeData("T3", "Tank"),
            pvp1v1 = ModeData("T3", "Tank"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Psychic", "Competitive", "Shadow Tag", "Tank", "Special Sweeper", "Trick Room Setter")
        ),
        "577" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Magic Guard")
        ),
        "578" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Psychic", "Magic Guard", "Eviolite User")
        ),
        "579" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Psychic", "Magic Guard", "Regenerator", "Special Sweeper", "Wallbreaker", "Trick Room Setter")
        ),
        "580" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Flying", "Big Pecks")
        ),
        "581" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Flying", "Hydration", "Setup Sweeper", "Special Sweeper")
        ),
        "582" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Ice Body")
        ),
        "583" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Ice Body")
        ),
        "584" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ice", "Ice Body", "Snow Warning", "Special Sweeper", "Weather Setter")
        ),
        "585" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Grass", "Chlorophyll")
        ),
        "586" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Normal", "Grass", "Sap Sipper", "Chlorophyll", "Setup Sweeper", "Physical Sweeper", "Weather Sweeper")
        ),
        "587" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Electric", "Flying", "Motor Drive", "Nuzzle User", "Volt Switch", "Support")
        ),
        "588" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Swarm")
        ),
        "589" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Bug", "Steel", "No Guard", "Physical Sweeper", "Wallbreaker")
        ),
        "590" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Poison", "Effect Spore")
        ),
        "591" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T2", "Support"),
            pvp2v2 = ModeData("T0", "Support"),
            tags = listOf("Grass", "Poison", "Regenerator", "Spore User", "Rage Powder", "Support", "Tank")
        ),
        "592" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Water", "Ghost", "Cursed Body")
        ),
        "593" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Water", "Ghost", "Water Absorb", "Cursed Body", "Wall", "Tank", "Trick Room Setter")
        ),
        "594" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T4", "Wall"),
            tags = listOf("Water", "Regenerator", "Wall", "Wish Pass", "Tank")
        ),
        "595" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Electric", "Compound Eyes")
        ),
        "596" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Bug", "Electric", "Compound Eyes", "Sticky Web", "Special Sweeper")
        ),
        "597" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Grass", "Steel", "Iron Barbs")
        ),
        "598" to CustomPokemonInfo(
            pve = ModeData("T1", "Tank"),
            pvp1v1 = ModeData("T1", "Tank"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Grass", "Steel", "Iron Barbs", "Stealth Rock", "Leech Seed", "Wall", "Tank")
        ),
        "599" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Plus")
        ),
        "600" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Minus")
        ),
        "601" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Steel", "Shift Gear", "Setup Sweeper", "Physical Sweeper")
        ),
        "602" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Levitate")
        ),
        "603" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Levitate")
        ),
        "604" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Electric", "Levitate", "Mixed Sweeper", "Wallbreaker", "No Weakness")
        ),
        "605" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Synchronize")
        ),
        "606" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Psychic", "Analytic", "Special Sweeper", "Wallbreaker")
        ),
        "607" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ghost", "Fire", "Flash Fire")
        ),
        "608" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ghost", "Fire", "Flash Fire", "Eviolite User")
        ),
        "609" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Ghost", "Fire", "Flash Fire", "Shadow Tag", "Special Sweeper", "Wallbreaker", "Spread Attacker")
        ),
        "610" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Rivalry")
        ),
        "611" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Mold Breaker")
        ),
        "612" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Dragon", "Mold Breaker", "Dragon Dance", "Setup Sweeper", "Physical Sweeper", "Wallbreaker")
        ),
        "613" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Snow Cloak")
        ),
        "614" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Ice", "Slush Rush", "Swift Swim", "Physical Sweeper", "Weather Sweeper")
        ),
        "615" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Ice", "Levitate", "Haze User", "Special Sweeper")
        ),
        "616" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Hydration")
        ),
        "617" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Bug", "Unburden", "Speedster", "Special Sweeper", "Wallbreaker")
        ),
        "618" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Ground", "Electric", "Static", "Wall", "Tank")
        ),
        "619" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Inner Focus")
        ),
        "620" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fighting", "Regenerator", "Reckless", "Fake Out User", "Physical Sweeper", "Wallbreaker")
        ),
        "621" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Dragon", "Rough Skin", "Sheer Force", "Stealth Rock", "Tank")
        ),
        "622" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Ghost", "Iron Fist")
        ),
        "623" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Ground", "Ghost", "No Guard", "Iron Fist", "Wallbreaker", "Physical Sweeper")
        ),
        "624" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Steel", "Defiant")
        ),
        "625" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Dark", "Steel", "Defiant", "Sucker Punch User", "Wallbreaker", "Physical Sweeper")
        ),
        "626" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Normal", "Reckless", "Sap Sipper", "Physical Sweeper")
        ),
        "627" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Keen Eye")
        ),
        "628" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Normal", "Flying", "Defiant", "Sheer Force", "Physical Sweeper", "Wallbreaker")
        ),
        "629" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Flying", "Big Pecks")
        ),
        "630" to CustomPokemonInfo(
            pve = ModeData("T4", "Wall"),
            pvp1v1 = ModeData("T4", "Wall"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Dark", "Flying", "Overcoat", "Wall", "Defog User")
        ),
        "631" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fire", "Flash Fire", "Special Sweeper")
        ),
        "632" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Bug", "Steel", "Hustle", "Wallbreaker")
        ),
        "633" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Dragon", "Hustle")
        ),
        "634" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Dragon", "Hustle", "Eviolite User")
        ),
        "635" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Dark", "Dragon", "Levitate", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "636" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Fire", "Flame Body")
        ),
        "637" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Bug", "Fire", "Quiver Dance", "Setup Sweeper", "Special Sweeper", "Spread Attacker")
        ),
        "638" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Steel", "Fighting", "Justified", "Wallbreaker", "Physical Sweeper")
        ),
        "639" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Rock", "Fighting", "Justified", "Physical Sweeper", "Wallbreaker", "Rock Slide User")
        ),
        "640" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Grass", "Fighting", "Justified", "Wallbreaker", "Physical Sweeper")
        ),
        "641" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Support"),
            pvp1v1 = ModeData("T2", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Flying", "Prankster", "Regenerator", "Tailwind", "Support")
        ),
        "642" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Support"),
            tags = listOf("Electric", "Flying", "Prankster", "Volt Absorb", "Special Sweeper", "Support", "Thunder Wave")
        ),
        "643" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Dragon", "Fire", "Turboblaze", "Wallbreaker", "Special Sweeper")
        ),
        "644" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Dragon", "Electric", "Teravolt", "Wallbreaker", "Physical Sweeper")
        ),
        "645" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Ground", "Flying", "Intimidate", "Sheer Force", "Physical Sweeper", "Special Sweeper", "Wallbreaker")
        ),
        "646" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Dragon", "Ice", "Pressure", "Wallbreaker", "Special Sweeper")
        ),
        "646.1" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Dragon", "Ice", "Teravolt", "Wallbreaker", "Physical Sweeper")
        ),
        "646.2" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Dragon", "Ice", "Turboblaze", "Wallbreaker", "Special Sweeper")
        ),
        "647" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Water", "Fighting", "Justified", "Special Sweeper", "Wallbreaker")
        ),
        "648" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Normal", "Psychic", "Serene Grace", "Special Sweeper")
        ),
        "649" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Bug", "Steel", "Download", "Special Sweeper", "Wallbreaker", "Techno Blast")
        ),
        "650" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Overgrow")
        ),
        "651" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Grass", "Overgrow")
        ),
        "652" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Grass", "Fighting", "Bulletproof", "Spiky Shield", "Tank", "Wall")
        ),
        "653" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "654" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "655" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Fire", "Psychic", "Magician", "Special Sweeper", "Wallbreaker")
        ),
        "656" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "657" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "658" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Water", "Dark", "Protean", "Battle Bond", "Special Sweeper", "Speedster", "Wallbreaker")
        ),
        "659" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Pickup")
        ),
        "660" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Normal", "Ground", "Huge Power", "Physical Sweeper", "Wallbreaker")
        ),
        "661" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Gale Wings")
        ),
        "662" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Flying", "Gale Wings")
        ),
        "663" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Fire", "Flying", "Gale Wings", "Priority", "Physical Sweeper", "Wallbreaker")
        ),
        "664" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Shield Dust")
        ),
        "665" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Bug", "Shed Skin")
        ),
        "666" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Bug", "Flying", "Compound Eyes", "Sleep Powder", "Special Sweeper")
        ),
        "667" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Normal", "Rivalry")
        ),
        "668" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fire", "Normal", "Unnerve", "Special Sweeper", "Wallbreaker")
        ),
        "669" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Flower Veil")
        ),
        "670" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Flower Veil")
        ),
        "671" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T2", "Wall"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Fairy", "Flower Veil", "Wall", "Special Tank", "Support")
        ),
        "672" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Sap Sipper")
        ),
        "673" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Grass", "Sap Sipper", "Physical Sweeper")
        ),
        "674" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Iron Fist")
        ),
        "675" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fighting", "Dark", "Iron Fist", "Wallbreaker", "Physical Sweeper")
        ),
        "676" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Normal", "Fur Coat", "Wall", "Tank")
        ),
        "677" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Keen Eye")
        ),
        "678" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T1.5", "Support"),
            tags = listOf("Psychic", "Prankster", "Competitive", "Support", "Fake Out User")
        ),
        "679" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Ghost", "No Guard")
        ),
        "680" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Steel", "Ghost", "No Guard", "Eviolite User")
        ),
        "681" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Tank"),
            pvp1v1 = ModeData("T0.5", "Tank"),
            pvp2v2 = ModeData("T1.5", "Tank"),
            tags = listOf("Steel", "Ghost", "Stance Change", "King's Shield", "Wallbreaker", "Tank", "Mixed Sweeper")
        ),
        "682" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Healer")
        ),
        "683" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Fairy", "Aroma Veil", "Trick Room Setter", "Support")
        ),
        "684" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fairy", "Sweet Veil")
        )
    )

    private fun getPart5() = mapOf(
        "685" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fairy", "Unburden", "Belly Drum", "Setup Sweeper", "Physical Sweeper")
        ),
        "686" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Psychic", "Contrary")
        ),
        "687" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Dark", "Psychic", "Contrary", "Physical Sweeper", "Wallbreaker")
        ),
        "688" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Water", "Tough Claws")
        ),
        "689" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Rock", "Water", "Tough Claws", "Wallbreaker", "Physical Sweeper")
        ),
        "690" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Poison", "Water", "Poison Point")
        ),
        "691" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Poison", "Dragon", "Adaptability", "Special Sweeper", "Wallbreaker")
        ),
        "692" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Mega Launcher")
        ),
        "693" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Water", "Mega Launcher", "Special Sweeper", "Wallbreaker")
        ),
        "694" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Normal", "Dry Skin")
        ),
        "695" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Electric", "Normal", "Dry Skin", "Solar Power", "Special Sweeper", "Weather Sweeper")
        ),
        "696" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Dragon", "Strong Jaw")
        ),
        "697" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Rock", "Dragon", "Strong Jaw", "Rock Head", "Dragon Dance", "Physical Sweeper", "Wallbreaker")
        ),
        "698" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Ice", "Refrigerate")
        ),
        "699" to CustomPokemonInfo(
            pve = ModeData("T3", "Wall"),
            pvp1v1 = ModeData("T3", "Wall"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Rock", "Ice", "Refrigerate", "Snow Warning", "Wall", "Weather Setter", "Aurora Veil User")
        ),
        "700" to CustomPokemonInfo(
            pve = ModeData("T1", "Wall"),
            pvp1v1 = ModeData("T1", "Wall"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Fairy", "Pixilate", "Hyper Voice", "Wall", "Special Tank", "Special Sweeper")
        ),
        "701" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fighting", "Flying", "Unburden", "Setup Sweeper", "Physical Sweeper")
        ),
        "702" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Electric", "Fairy", "Cheek Pouch", "Nuzzle User")
        ),
        "703" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Rock", "Fairy", "Clear Body", "Sturdy", "Trick Room Setter", "Wall", "Tank")
        ),
        "704" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Dragon", "Sap Sipper")
        ),
        "705" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Dragon", "Sap Sipper", "Eviolite User")
        ),
        "706" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Tank"),
            pvp1v1 = ModeData("T1.5", "Tank"),
            pvp2v2 = ModeData("T2", "Tank"),
            tags = listOf("Dragon", "Sap Sipper", "Gooey", "Special Tank", "Special Sweeper")
        ),
        "707" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Steel", "Fairy", "Prankster", "Support", "Hazard Setter")
        ),
        "708" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Ghost", "Grass", "Natural Cure")
        ),
        "709" to CustomPokemonInfo(
            pve = ModeData("T3", "Tank"),
            pvp1v1 = ModeData("T3", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Ghost", "Grass", "Natural Cure", "Harvest", "Wall", "Tank")
        ),
        "710" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Ghost", "Grass", "Frisk")
        ),
        "711" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Ghost", "Grass", "Frisk", "Harvest", "Trick Room Setter", "Tank")
        ),
        "712" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Ice", "Own Tempo")
        ),
        "713" to CustomPokemonInfo(
            pve = ModeData("T3", "Tank"),
            pvp1v1 = ModeData("T3", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Ice", "Sturdy", "Ice Body", "Physical Wall", "Tank")
        ),
        "714" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Flying", "Dragon", "Infiltrator")
        ),
        "715" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Flying", "Dragon", "Infiltrator", "Special Sweeper", "Speedster")
        ),
        "716" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Fairy", "Fairy Aura", "Geomancy", "Setup Sweeper", "Special Sweeper", "Wallbreaker")
        ),
        "717" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Dark", "Flying", "Dark Aura", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "718" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Dragon", "Ground", "Aura Break", "Power Construct", "Physical Sweeper", "Wallbreaker", "Tank")
        ),
        "719" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Tank"),
            pvp1v1 = ModeData("T1.5", "Tank"),
            pvp2v2 = ModeData("T2", "Tank"),
            tags = listOf("Rock", "Fairy", "Clear Body", "Wall", "Tank", "Special Sweeper")
        ),
        "719.1" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Rock", "Fairy", "Magic Bounce", "Mega", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "720" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Psychic", "Ghost", "Magician", "Special Sweeper", "Wallbreaker")
        ),
        "720.1" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Psychic", "Dark", "Magician", "Special Sweeper", "Wallbreaker", "Physical Sweeper")
        ),
        "721" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Fire", "Water", "Water Absorb", "Special Sweeper", "Wallbreaker", "Spread Attacker")
        ),
        "722" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Flying", "Overgrow")
        ),
        "723" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Flying", "Overgrow")
        ),
        "724" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Grass", "Ghost", "Overgrow", "Long Reach", "Physical Sweeper", "Wallbreaker")
        ),
        "725" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "726" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "727" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T0", "Support"),
            tags = listOf("Fire", "Dark", "Intimidate", "Fake Out User", "Physical Sweeper", "Support", "Tank")
        ),
        "728" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "729" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "730" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Water", "Fairy", "Liquid Voice", "Torrent", "Special Sweeper", "Wallbreaker")
        ),
        "731" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Skill Link")
        ),
        "732" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Skill Link")
        ),
        "733" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Normal", "Flying", "Skill Link", "Physical Sweeper")
        ),
        "734" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Strong Jaw")
        ),
        "735" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Normal", "Strong Jaw", "Adaptability", "Physical Sweeper", "Wallbreaker")
        ),
        "736" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Swarm")
        ),
        "737" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Electric", "Battery", "Eviolite User")
        ),
        "738" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Bug", "Electric", "Levitate", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "739" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Hyper Cutter")
        ),
        "740" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fighting", "Ice", "Iron Fist", "Physical Sweeper", "Wallbreaker")
        ),
        "741" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Electric", "Flying", "Dancer", "Revelation Dance", "Support")
        ),
        "742" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Bug", "Fairy", "Honey Gather")
        ),
        "743" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Bug", "Fairy", "Shield Dust", "Sweet Veil", "Support", "Speedster")
        ),
        "744" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Keen Eye")
        ),
        "745" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Rock", "Sand Rush", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "746" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Schooling", "Special Sweeper", "Wallbreaker")
        ),
        "747" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Poison", "Water", "Merciless")
        ),
        "748" to CustomPokemonInfo(
            pve = ModeData("T2", "Wall"),
            pvp1v1 = ModeData("T1.5", "Wall"),
            pvp2v2 = ModeData("T3", "Wall"),
            tags = listOf("Poison", "Water", "Regenerator", "Wall", "Tank", "Haze User")
        ),
        "749" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Stamina")
        ),
        "750" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Tank"),
            tags = listOf("Ground", "Stamina", "Inner Focus", "Tank", "Physical Sweeper")
        ),
        "751" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Bug", "Water Bubble")
        ),
        "752" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Water", "Bug", "Water Bubble", "Physical Sweeper", "Wallbreaker")
        ),
        "753" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Leaf Guard")
        ),
        "754" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Grass", "Contrary", "Leaf Storm", "Special Sweeper", "Wallbreaker")
        ),
        "755" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Fairy", "Illuminate")
        ),
        "756" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Grass", "Fairy", "Effect Spore", "Support", "Spore User")
        ),
        "757" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Fire", "Corrosion")
        ),
        "758" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Poison", "Fire", "Corrosion", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "759" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Normal", "Fighting", "Fluffy")
        ),
        "760" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T3", "Tank"),
            tags = listOf("Normal", "Fighting", "Fluffy", "Tank", "Physical Sweeper")
        ),
        "761" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Leaf Guard")
        ),
        "762" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Leaf Guard")
        ),
        "763" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Grass", "Queenly Majesty", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "764" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Fairy", "Triage", "Healer", "Support", "Wall")
        ),
        "765" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Normal", "Psychic", "Inner Focus", "Support", "Trick Room Setter")
        ),
        "766" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Fighting", "Receiver", "Physical Sweeper", "Wallbreaker")
        ),
        "767" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Bug", "Water", "Wimp Out")
        ),
        "768" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Tank"),
            tags = listOf("Bug", "Water", "Emergency Exit", "Physical Sweeper", "Wallbreaker", "Tank")
        ),
        "769" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Ghost", "Ground", "Water Compaction")
        ),
        "770" to CustomPokemonInfo(
            pve = ModeData("T3", "Tank"),
            pvp1v1 = ModeData("T3", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Ghost", "Ground", "Water Compaction", "Wall", "Tank")
        ),
        "771" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Water", "Innards Out", "Unaware", "Support", "Wall")
        ),
        "772" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Battle Armor", "Eviolite User")
        ),
        "773" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Normal", "RKS System", "Multi-Type", "Sweeper")
        ),
        "774" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Rock", "Flying", "Shields Down", "Setup Sweeper", "Mixed Sweeper")
        ),
        "775" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Normal", "Comatose", "Wall", "Tank")
        ),
        "776" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Fire", "Dragon", "Shell Armor", "Wall", "Tank")
        ),
        "777" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Electric", "Steel", "Iron Barbs", "Lightning Rod", "Fake Out User", "Nuzzle User", "Support")
        ),
        "778" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Ghost", "Fairy", "Disguise", "Setup Sweeper", "Physical Sweeper")
        ),
        "779" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Psychic", "Dazzling", "Strong Jaw", "Physical Sweeper")
        ),
        "780" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Normal", "Dragon", "Berserk", "Special Sweeper")
        ),
        "781" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ghost", "Grass", "Steelworker", "Physical Sweeper")
        ),
        "782" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Bulletproof")
        ),
        "783" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Fighting", "Soundproof")
        ),
        "784" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Dragon", "Fighting", "Bulletproof", "Clangorous Soul", "Setup Sweeper", "Mixed Sweeper", "Wallbreaker")
        ),
        "785" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T1.5", "Support"),
            pvp2v2 = ModeData("T0.5", "Support"),
            tags = listOf("Electric", "Fairy", "Electric Surge", "Speedster", "Special Sweeper", "Support")
        ),
        "786" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T1.5", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Grass", "Fairy", "Grassy Surge", "Physical Sweeper", "Support", "Wall")
        ),
        "787" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T1", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Fire", "Fairy", "Psychic Surge", "Special Sweeper", "Support")
        ),
        "788" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Support"),
            pvp1v1 = ModeData("T1", "Support"),
            pvp2v2 = ModeData("T0", "Support"),
            tags = listOf("Water", "Fairy", "Misty Surge", "Special Tank", "Support", "Wall")
        ),
        "789" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Unaware")
        ),
        "790" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Sturdy")
        ),
        "791" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Psychic", "Steel", "Full Metal Body", "Physical Sweeper", "Wallbreaker")
        ),
        "792" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Psychic", "Ghost", "Shadow Shield", "Special Sweeper", "Wallbreaker")
        ),
        "793" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Rock", "Poison", "Beast Boost", "Special Sweeper", "Wallbreaker")
        ),
        "794" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Bug", "Fighting", "Beast Boost", "Physical Sweeper", "Wallbreaker")
        ),
        "795" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Bug", "Fighting", "Beast Boost", "Speedster", "Physical Sweeper")
        ),
        "796" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Electric", "Beast Boost", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "797" to CustomPokemonInfo(
            pve = ModeData("T1", "Tank"),
            pvp1v1 = ModeData("T1", "Tank"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Steel", "Flying", "Beast Boost", "Wall", "Tank", "Special Sweeper")
        ),
        "798" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Grass", "Steel", "Beast Boost", "Physical Sweeper", "Wallbreaker")
        ),
        "799" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Dark", "Dragon", "Beast Boost", "Wallbreaker", "Physical Sweeper")
        ),
        "800" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Psychic", "Prism Armor", "Neuroforce", "Special Sweeper", "Wallbreaker", "Tank")
        ),
        "801" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Steel", "Fairy", "Soul-Heart", "Special Sweeper", "Wallbreaker")
        ),
        "802" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Fighting", "Ghost", "Technician", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "803" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Poison", "Beast Boost")
        ),
        "804" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Poison", "Dragon", "Beast Boost", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "805" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Rock", "Steel", "Beast Boost", "Wall", "Tank", "Hazard Setter")
        ),
        "806" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Fire", "Ghost", "Beast Boost", "Special Sweeper", "Wallbreaker")
        ),
        "807" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Electric", "Zeraora", "Volt Absorb", "Speedster", "Physical Sweeper")
        ),
        "808" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Magnet Pull")
        ),
        "809" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Steel", "Iron Fist", "Double Iron Bash", "Physical Sweeper", "Wallbreaker", "Tank")
        ),
        "810" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Overgrow")
        ),
        "811" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Overgrow")
        ),
        "812" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Support"),
            tags = listOf("Grass", "Grassy Surge", "Grassy Glide", "Physical Sweeper", "Support", "Fake Out User")
        ),
        "813" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "814" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "815" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fire", "Libero", "Pyro Ball", "Physical Sweeper", "Speedster", "Wallbreaker")
        ),
        "816" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "817" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "818" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Water", "Sniper", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "819" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Cheek Pouch")
        ),
        "820" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Normal", "Cheek Pouch", "Gluttony", "Wall", "Tank")
        ),
        "821" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Keen Eye")
        ),
        "822" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Flying", "Pluck")
        ),
        "823" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T1.5", "Support"),
            pvp2v2 = ModeData("T1.5", "Support"),
            tags = listOf("Flying", "Steel", "Mirror Armor", "Defog User", "Wall", "Tank", "Support")
        ),
        "824" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Swarm")
        ),
        "825" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Psychic", "Swarm", "Eviolite User")
        ),
        "826" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Bug", "Psychic", "Telepathy", "Special Sweeper")
        ),
        "827" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Unburden")
        ),
        "828" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Dark", "Stakeout", "Physical Sweeper", "Wallbreaker")
        ),
        "829" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Cotton Down")
        ),
        "830" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Grass", "Cotton Down", "Regenerator", "Wall", "Tank", "Support")
        ),
        "831" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Fluffy")
        ),
        "832" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Normal", "Fluffy", "Wall", "Tank")
        ),
        "833" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Strong Jaw")
        ),
        "834" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Water", "Rock", "Swift Swim", "Strong Jaw", "Physical Sweeper", "Wallbreaker")
        ),
        "835" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Ball Fetch")
        ),
        "836" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Electric", "Strong Jaw", "Competitive", "Physical Sweeper", "Speedster")
        ),
        "837" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Steam Engine")
        ),
        "838" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Rock", "Fire", "Steam Engine", "Eviolite User")
        ),
        "839" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Rock", "Fire", "Steam Engine", "Flash Fire", "Physical Sweeper", "Special Sweeper", "Wall", "Tank")
        ),
        "840" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Dragon", "Ripen")
        ),
        "841" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Grass", "Dragon", "Ripen", "Hustle", "Physical Sweeper")
        ),
        "842" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Tank"),
            tags = listOf("Grass", "Dragon", "Ripen", "Thick Fat", "Wall", "Tank")
        ),
        "843" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Sand Spit")
        ),
        "844" to CustomPokemonInfo(
            pve = ModeData("T3", "Tank"),
            pvp1v1 = ModeData("T3", "Tank"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Ground", "Sand Spit", "Shed Skin", "Wall", "Tank", "Weather Setter")
        ),
        "845" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Flying", "Gulp Missile", "Special Sweeper")
        ),
        "846" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Swift Swim")
        ),
        "847" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Water", "Swift Swim", "Physical Sweeper", "Wallbreaker", "Weather Sweeper")
        ),
        "848" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Poison", "Static")
        ),
        "849" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Electric", "Poison", "Punk Rock", "Shift Gear", "Overdrive", "Special Sweeper", "Wallbreaker")
        ),
        "850" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fire", "Flash Fire", "White Smoke", "Physical Sweeper")
        ),
        "851" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Bug", "Flash Fire")
        ),
        "852" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Clueless")
        ),
        "853" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fighting", "Grapploct", "Technician", "Physical Sweeper")
        ),
        "854" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ghost", "Weak Armor")
        ),
        "855" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Ghost", "Weak Armor", "Shell Smash", "Special Sweeper", "Wallbreaker")
        )
    )

    private fun getPart6() = mapOf(
        "856" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Anticipation")
        ),
        "857" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Psychic", "Anticipation")
        ),
        "858" to CustomPokemonInfo(
            pve = ModeData("T3", "Support"),
            pvp1v1 = ModeData("T3", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Psychic", "Fairy", "Magic Bounce", "Support", "Trick Room Setter")
        ),
        "859" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Fairy", "Prankster")
        ),
        "860" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Fairy", "Prankster", "Eviolite User")
        ),
        "861" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T1.5", "Support"),
            pvp2v2 = ModeData("T0.5", "Support"),
            tags = listOf("Dark", "Fairy", "Prankster", "Fake Out User", "Thunder Wave", "Support", "Screens Setter")
        ),
        "862" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Dark", "Normal", "Guts", "Physical Sweeper", "Wallbreaker")
        ),
        "863" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Steel", "Steely Spirit", "Physical Sweeper", "Support")
        ),
        "864" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ghost", "Cursed Body", "Special Sweeper")
        ),
        "865" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fighting", "Scrappy", "Physical Sweeper", "Wallbreaker")
        ),
        "866" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Ice", "Psychic", "Screen Cleaner", "Support", "Rapid Spin User")
        ),
        "867" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Ghost", "Ground", "Wandering Spirit", "Wall", "Tank")
        ),
        "868" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Fairy", "Sweet Veil")
        ),
        "869" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Fairy", "Aroma Veil", "Support", "Healer")
        ),
        "870" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fighting", "Limber", "Physical Sweeper")
        ),
        "871" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Electric", "Lightning Rod", "Wall", "Tank")
        ),
        "872" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Bug", "Ice Scales")
        ),
        "873" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Ice", "Bug", "Ice Scales", "Quiver Dance", "Special Sweeper", "Wallbreaker")
        ),
        "874" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Rock", "Power Spot", "Support", "Tank")
        ),
        "875" to CustomPokemonInfo(
            pve = ModeData("T4", "Tank"),
            pvp1v1 = ModeData("T4", "Tank"),
            pvp2v2 = ModeData("T4", "Tank"),
            tags = listOf("Ice", "Ice Face", "Physical Wall", "Tank")
        ),
        "876" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Psychic", "Psychic Surge", "Follow Me User", "Support")
        ),
        "877" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Dark", "Electric", "Hunger Switch", "Physical Sweeper")
        ),
        "878" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Steel", "Sturdy")
        ),
        "879" to CustomPokemonInfo(
            pve = ModeData("T3", "Tank"),
            pvp1v1 = ModeData("T3", "Tank"),
            pvp2v2 = ModeData("T3", "Tank"),
            tags = listOf("Steel", "Sturdy", "Heavy Metal", "Wall", "Tank")
        ),
        "880" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Electric", "Dragon", "Strong Jaw", "Fishious Rend", "Physical Sweeper", "Wallbreaker")
        ),
        "881" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Electric", "Ice", "Slush Rush", "Physical Sweeper", "Wallbreaker")
        ),
        "882" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Water", "Dragon", "Strong Jaw", "Fishious Rend", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "883" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Water", "Ice", "Slush Rush", "Physical Sweeper", "Wallbreaker")
        ),
        "884" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Steel", "Dragon", "Sturdy", "Special Sweeper")
        ),
        "885" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Ghost", "Infiltrator")
        ),
        "886" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dragon", "Ghost", "Infiltrator")
        ),
        "887" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Dragon", "Ghost", "Infiltrator", "Dragon Dance", "Special Sweeper", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "888" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Steel", "Fighting", "Dauntless Shield", "Physical Sweeper", "Wallbreaker", "Tank")
        ),
        "889" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Steel", "Fighting", "Intrepid Sword", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "890" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Poison", "Dragon", "Pressure", "Special Sweeper", "Wallbreaker", "Tank")
        ),
        "891" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Inner Focus")
        ),
        "892" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Fighting", "Dark", "Unseen Fist", "Physical Sweeper", "Wallbreaker")
        ),
        "893" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Grass", "Dark", "Leaf Guard", "Physical Sweeper", "Wallbreaker")
        ),
        "894" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Electric", "Transistor", "Special Sweeper", "Speedster")
        ),
        "895" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Dragon", "Dragon's Maw", "Special Sweeper", "Wallbreaker")
        ),
        "896" to CustomPokemonInfo(
            pve = ModeData("T1", "Tank"),
            pvp1v1 = ModeData("T1", "Tank"),
            pvp2v2 = ModeData("T1.5", "Tank"),
            tags = listOf("Ice", "As One", "Physical Sweeper", "Tank")
        ),
        "897" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Ghost", "As One", "Special Sweeper", "Speedster")
        ),
        "898" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Psychic", "Ice", "Ghost", "As One", "Special Sweeper", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "899" to CustomPokemonInfo(
            pve = ModeData("T5", "Tank"),
            pvp1v1 = ModeData("T5", "Tank"),
            pvp2v2 = ModeData("T5", "Tank"),
            tags = listOf("Normal", "Stamina")
        ),
        "900" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Normal", "Psychic", "Intimidate", "Physical Sweeper", "Support")
        ),
        "901" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Water", "Ghost", "Swift Swim", "Special Sweeper", "Wallbreaker")
        ),
        "902" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Water", "Ghost", "Swift Swim", "Physical Sweeper", "Wallbreaker")
        ),
        "903" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Fighting", "Poison", "Poison Touch", "Speedster", "Physical Sweeper")
        ),
        "904" to CustomPokemonInfo(
            pve = ModeData("T1.5", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Poison", "Dark", "Poison Touch", "Wallbreaker", "Special Sweeper")
        ),
        "905" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Fairy", "Flying", "Contrary", "Special Sweeper", "Wallbreaker")
        ),
        "906" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Overgrow")
        ),
        "907" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Grass", "Overgrow")
        ),
        "908" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Grass", "Dark", "Protean", "Flower Trick", "Physical Sweeper", "Speedster")
        ),
        "909" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "910" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Blaze")
        ),
        "911" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fire", "Ghost", "Unaware", "Torch Song", "Special Sweeper", "Tank")
        ),
        "912" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "913" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Torrent")
        ),
        "914" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Water", "Fighting", "Moxie", "Aqua Step", "Physical Sweeper", "Speedster")
        ),
        "915" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Run Away")
        ),
        "916" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Normal", "Dark", "Stakeout", "Physical Sweeper")
        ),
        "917" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Guts")
        ),
        "918" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Normal", "Guts")
        ),
        "919" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Swarm")
        ),
        "920" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Bug", "First Impression User", "Physical Sweeper")
        ),
        "921" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Static")
        ),
        "922" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Fighting", "Static")
        ),
        "923" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Electric", "Fighting", "Iron Fist", "Speedster", "Physical Sweeper")
        ),
        "924" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Normal", "Friend Guard")
        ),
        "925" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Normal", "Technician", "Population Bomb", "Physical Sweeper", "Speedster")
        ),
        "926" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fairy", "Own Tempo")
        ),
        "927" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fairy", "Steel", "Gigaton Hammer", "Physical Sweeper")
        ),
        "928" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Rock", "Sturdy")
        ),
        "929" to CustomPokemonInfo(
            pve = ModeData("T1", "Support"),
            pvp1v1 = ModeData("T2", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Rock", "Purifying Salt", "Salt Cure", "Wall", "Tank", "Support")
        ),
        "930" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Fire", "Grass", "Chlorophyll", "Special Sweeper")
        ),
        "931" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Bug", "Compound Eyes")
        ),
        "932" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Bug", "Rock", "Compound Eyes", "Sticky Web User")
        ),
        "933" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Swift Swim")
        ),
        "934" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Swift Swim", "Physical Sweeper")
        ),
        "935" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fire", "Flash Fire")
        ),
        "936" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fire", "Psychic", "Flash Fire", "Special Sweeper", "Wallbreaker")
        ),
        "937" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fire", "Ghost", "Flash Fire", "Physical Sweeper", "Wallbreaker")
        ),
        "938" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Electric", "Electromorphosis")
        ),
        "939" to CustomPokemonInfo(
            pve = ModeData("T2", "Tank"),
            pvp1v1 = ModeData("T2", "Tank"),
            pvp2v2 = ModeData("T2", "Support"),
            tags = listOf("Electric", "Electromorphosis", "Special Sweeper", "Wall", "Tank")
        ),
        "940" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Electric", "Flying", "Wind Power", "Special Sweeper")
        ),
        "941" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Normal", "Volt Absorb")
        ),
        "942" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Ghost", "Cursed Body")
        ),
        "943" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Ghost", "Cursed Body")
        ),
        "944" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Poison", "Normal", "Prankster")
        ),
        "945" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Poison", "Normal", "Prankster", "Support", "Toxic User")
        ),
        "946" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Dark Aura")
        ),
        "947" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Dark", "Dark Aura")
        ),
        "948" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Dark", "Grass", "Dark Aura", "Physical Sweeper")
        ),
        "949" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ground", "Fighting")
        ),
        "950" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ground", "Fighting", "Physical Sweeper", "Wallbreaker")
        ),
        "951" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Inner Focus")
        ),
        "952" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Fighting", "Inner Focus")
        ),
        "953" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Steel", "Fighting", "Sharpness", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "954" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fairy", "Psychic", "Sharpness", "Special Sweeper", "Wallbreaker")
        ),
        "955" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ghost", "Infiltrator")
        ),
        "956" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ghost", "Infiltrator", "Special Sweeper")
        ),
        "957" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Levitate")
        ),
        "958" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Flying", "Levitate")
        ),
        "959" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Psychic", "Flying", "Levitate", "Special Sweeper", "Wallbreaker")
        ),
        "960" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Ground", "Swift Swim")
        ),
        "961" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Ground", "Swift Swim", "Physical Sweeper")
        ),
        "962" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Water", "Rattled")
        ),
        "963" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Water", "Dragon", "Physical Sweeper", "Wallbreaker")
        ),
        "964" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Water", "Palafin", "Zero to Hero", "Physical Sweeper", "Wallbreaker")
        ),
        "965" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Steel", "Sturdy")
        ),
        "966" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Steel", "Poison", "Physical Sweeper", "Wallbreaker")
        ),
        "967" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Psychic", "Technician")
        ),
        "968" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Psychic", "Technician", "Physical Sweeper")
        ),
        "969" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Rock", "Poison", "Corrosion")
        ),
        "970" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Rock", "Poison", "Corrosion", "Special Sweeper")
        ),
        "971" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ghost", "Pickup")
        ),
        "972" to CustomPokemonInfo(
            pve = ModeData("T3", "Sweeper"),
            pvp1v1 = ModeData("T3", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ghost", "Sand Rush", "Physical Sweeper", "Wallbreaker")
        ),
        "973" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Electric", "Normal", "Competitive")
        ),
        "974" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ice", "Thick Fat")
        ),
        "975" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T3", "Sweeper"),
            tags = listOf("Ice", "Slush Rush", "Physical Sweeper", "Wallbreaker")
        ),
        "976" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Water", "Psychic", "Regenerator", "Physical Sweeper")
        ),
        "977" to CustomPokemonInfo(
            pve = ModeData("T1", "Tank"),
            pvp1v1 = ModeData("T1", "Tank"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Water", "Unaware", "Physical Wall", "Tank", "Support")
        ),
        "978" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T4", "Support"),
            tags = listOf("Water", "Normal", "Support")
        ),
        "979" to CustomPokemonInfo(
            pve = ModeData("T4", "Sweeper"),
            pvp1v1 = ModeData("T4", "Sweeper"),
            pvp2v2 = ModeData("T4", "Sweeper"),
            tags = listOf("Ghost", "Annoyance", "Special Sweeper")
        ),
        "980" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Guts")
        ),
        "981" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Fighting", "Stamina")
        ),
        "982" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1.5", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Fighting", "Guts", "Physical Sweeper", "Wallbreaker")
        ),
        "983" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Steel", "Ghost", "Good as Gold", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "984" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Ground", "Fighting", "Protosynthesis", "Physical Sweeper", "Wallbreaker")
        ),
        "985" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Fairy", "Psychic", "Protosynthesis", "Special Sweeper", "Wallbreaker")
        ),
        "986" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Grass", "Dragon", "Protosynthesis", "Special Sweeper", "Wallbreaker")
        ),
        "987" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Ghost", "Fairy", "Protosynthesis", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "988" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Poison", "Fire", "Protosynthesis", "Special Sweeper", "Wallbreaker")
        ),
        "989" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Ground", "Rock", "Protosynthesis", "Physical Sweeper", "Wallbreaker")
        ),
        "990" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Dragon", "Dark", "Protosynthesis", "Physical Sweeper", "Wallbreaker")
        ),
        "991" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Water", "Fighting", "Quark Drive", "Physical Sweeper", "Wallbreaker")
        ),
        "992" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Electric", "Ice", "Quark Drive", "Special Sweeper", "Wallbreaker")
        ),
        "993" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Fire", "Ground", "Quark Drive", "Special Sweeper", "Wallbreaker")
        ),
        "994" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Poison", "Electric", "Quark Drive", "Special Sweeper", "Wallbreaker")
        ),
        "995" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Water", "Ice", "Quark Drive", "Special Sweeper", "Wallbreaker")
        ),
        "996" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Rock", "Electric", "Quark Drive", "Physical Sweeper", "Wallbreaker")
        ),
        "997" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Dark", "Dragon", "Quark Drive", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "998" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Dragon", "Ice", "Thermal Exchange", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "999" to CustomPokemonInfo(
            pve = ModeData("T5", "Sweeper"),
            pvp1v1 = ModeData("T5", "Sweeper"),
            pvp2v2 = ModeData("T5", "Sweeper"),
            tags = listOf("Ghost", "Honey Gather")
        ),
        "1000" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Steel", "Ghost", "Good as Gold", "Make It Rain", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "1001" to CustomPokemonInfo(
            pve = ModeData("T1", "Tank"),
            pvp1v1 = ModeData("T1", "Tank"),
            pvp2v2 = ModeData("T1.5", "Tank"),
            tags = listOf("Dark", "Grass", "Tablets of Ruin", "Wall", "Tank")
        ),
        "1002" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Dark", "Ice", "Sword of Ruin", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "1003" to CustomPokemonInfo(
            pve = ModeData("T1", "Tank"),
            pvp1v1 = ModeData("T1", "Tank"),
            pvp2v2 = ModeData("T1", "Tank"),
            tags = listOf("Dark", "Ground", "Vessel of Ruin", "Wall", "Tank", "Hazard Setter")
        ),
        "1004" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Dark", "Fire", "Beads of Ruin", "Special Sweeper", "Wallbreaker", "Speedster")
        ),
        "1005" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Dragon", "Dark", "Protosynthesis", "Dragon Dance", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "1006" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fairy", "Fighting", "Quark Drive", "Special Sweeper", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "1007" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Fighting", "Dragon", "Orichalcum Pulse", "Physical Sweeper", "Wallbreaker", "Weather Setter")
        ),
        "1008" to CustomPokemonInfo(
            pve = ModeData("T0", "Sweeper"),
            pvp1v1 = ModeData("T0", "Sweeper"),
            pvp2v2 = ModeData("T0", "Sweeper"),
            tags = listOf("Electric", "Dragon", "Hadron Engine", "Special Sweeper", "Wallbreaker", "Weather Setter")
        ),
        "1009" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Water", "Dragon", "Protosynthesis", "Special Sweeper", "Wallbreaker")
        ),
        "1010" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Grass", "Psychic", "Quark Drive", "Physical Sweeper", "Wallbreaker")
        ),
        "1011" to CustomPokemonInfo(
            pve = ModeData("T4", "Support"),
            pvp1v1 = ModeData("T4", "Support"),
            pvp2v2 = ModeData("T3", "Support"),
            tags = listOf("Grass", "Dragon", "Supersweet Syrup", "Support")
        ),
        "1012" to CustomPokemonInfo(
            pve = ModeData("T5", "Support"),
            pvp1v1 = ModeData("T5", "Support"),
            pvp2v2 = ModeData("T5", "Support"),
            tags = listOf("Grass", "Ghost", "Hospitality")
        ),
        "1013" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Support"),
            tags = listOf("Grass", "Ghost", "Hospitality", "Special Sweeper", "Wallbreaker", "Support")
        ),
        "1014" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Poison", "Fighting", "Toxic Chain", "Guard Dog", "Physical Sweeper", "Wallbreaker")
        ),
        "1015" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Poison", "Psychic", "Toxic Chain", "Frisk", "Special Sweeper", "Wallbreaker")
        ),
        "1016" to CustomPokemonInfo(
            pve = ModeData("T2", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Support"),
            tags = listOf("Poison", "Fairy", "Toxic Chain", "Competitive", "Special Sweeper", "Support")
        ),
        "1017" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Grass", "Fire", "Water", "Rock", "Embody Aspect", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "1018" to CustomPokemonInfo(
            pve = ModeData("T1", "Tank"),
            pvp1v1 = ModeData("T1", "Tank"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Steel", "Dragon", "Stamina", "Electro Shot", "Wall", "Tank", "Special Sweeper")
        ),
        "1019" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T2", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Grass", "Dragon", "Regenerator", "Special Sweeper", "Wallbreaker", "Tank")
        ),
        "1020" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Fire", "Dragon", "Protosynthesis", "Physical Sweeper", "Wallbreaker", "Tank")
        ),
        "1021" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1", "Sweeper"),
            tags = listOf("Electric", "Dragon", "Protosynthesis", "Special Sweeper", "Wallbreaker", "Tank")
        ),
        "1022" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T2", "Sweeper"),
            tags = listOf("Rock", "Psychic", "Quark Drive", "Physical Sweeper", "Wallbreaker", "Speedster")
        ),
        "1023" to CustomPokemonInfo(
            pve = ModeData("T1", "Sweeper"),
            pvp1v1 = ModeData("T1", "Sweeper"),
            pvp2v2 = ModeData("T1.5", "Sweeper"),
            tags = listOf("Steel", "Psychic", "Quark Drive", "Special Sweeper", "Wallbreaker")
        ),
        "1024" to CustomPokemonInfo(
            pve = ModeData("T0.5", "Sweeper"),
            pvp1v1 = ModeData("T0.5", "Sweeper"),
            pvp2v2 = ModeData("T0.5", "Sweeper"),
            tags = listOf("Normal", "Tera Shift", "Tera Shell", "Teraform Zero", "Special Sweeper", "Tank")
        ),
        "1025" to CustomPokemonInfo(
            pve = ModeData("T2", "Support"),
            pvp1v1 = ModeData("T2", "Support"),
            pvp2v2 = ModeData("T1", "Support"),
            tags = listOf("Poison", "Ghost", "Poison Puppeteer", "Support", "Wall")
        ),
    )
}
