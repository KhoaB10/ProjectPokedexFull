package com.example.pokedex.data.remote

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 100,
        @Query("offset") offset: Int = 0
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): PokemonDetailResponse

    @GET
    suspend fun getSpecies(@Url url: String): PokemonSpeciesResponse

    @GET
    suspend fun getEvolutionChain(@Url url: String): EvolutionChainResponse

    @GET
    suspend fun getMoveDetails(@Url url: String): MoveDetailResponse

    @GET("item")
    suspend fun getItemList(
        @Query("limit") limit: Int = 100,
        @Query("offset") offset: Int = 0
    ): ItemListResponse

    @GET("item/{name}")
    suspend fun getItemDetails(
        @Path("name") name: String
    ): ItemDetailResponse

    @GET("ability/{name}")
    suspend fun getAbilityDetails(
        @Path("name") name: String
    ): AbilityDetailResponse

    @GET
    suspend fun getMachineDetails(@Url url: String): MachineResponse
}

data class MachineResponse(
    val item: NameUrl,
    @SerializedName("version_group")
    val versionGroup: NameUrl
)

data class AbilityDetailResponse(
    val id: Int,
    val name: String,
    @SerializedName("effect_entries")
    val effectEntries: List<EffectEntry>,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>
)

data class ItemListResponse(
    val results: List<ItemEntry>
)

data class ItemEntry(
    val name: String,
    val url: String
)

data class ItemDetailResponse(
    val id: Int,
    val name: String,
    val category: ItemCategory,
    @SerializedName("effect_entries")
    val effectEntries: List<EffectEntry>,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>,
    val sprites: ItemSprites
)

data class ItemCategory(val name: String)
data class EffectEntry(
    val effect: String,
    val language: Language
)
data class ItemSprites(
    val default: String?
)

data class MoveDetailResponse(
    val name: String,
    val power: Int?,
    val accuracy: Int?,
    val priority: Int,
    @SerializedName("effect_chance")
    val effectChance: Int?,
    val type: TypeName,
    @SerializedName("damage_class")
    val damage_class: DamageClass,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry> = emptyList(),
    @SerializedName("effect_entries")
    val effectEntries: List<MoveEffectEntry> = emptyList(),
    val machines: List<MachineVersionDetail> = emptyList()
)

data class MachineVersionDetail(
    val machine: ApiResource,
    @SerializedName("version_group")
    val versionGroup: NameUrl
)

data class ApiResource(val url: String)

data class MoveEffectEntry(
    val effect: String,
    @SerializedName("short_effect")
    val shortEffect: String? = null,
    val language: Language
)

data class DamageClass(val name: String)

data class PokemonListResponse(
    val results: List<PokemonEntry>
)

data class PokemonEntry(
    val name: String,
    val url: String
)

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val types: List<TypeEntry>,
    val stats: List<StatEntry>,
    val sprites: Sprites,
    val abilities: List<AbilityEntry>,
    val moves: List<MoveEntry>,
    val species: SpeciesEntry,
    val height: Int,
    val weight: Int
)

data class TypeEntry(val type: TypeName)
data class TypeName(val name: String)

data class StatEntry(
    val base_stat: Int,
    val stat: StatName
)
data class StatName(val name: String)

data class AbilityEntry(val ability: AbilityName)
data class AbilityName(val name: String)

data class MoveEntry(
    val move: MoveName,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int,
    @SerializedName("move_learn_method")
    val moveLearnMethod: NameUrl,
    @SerializedName("version_group")
    val versionGroup: NameUrl
)
data class MoveName(
    val name: String,
    val url: String
)

data class SpeciesEntry(
    val name: String,
    val url: String
)

data class Sprites(val other: OtherSprites)
data class OtherSprites(
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)
data class OfficialArtwork(val front_default: String)

data class PokemonSpeciesResponse(
    val name: String,
    @SerializedName("evolution_chain")
    val evolutionChain: EvolutionChainUrl,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>,
    val varieties: List<PokemonVariety>
)

data class PokemonVariety(
    @SerializedName("is_default")
    val isDefault: Boolean,
    val pokemon: PokemonEntry
)
data class FlavorTextEntry(
    @SerializedName("flavor_text")
    val flavorText: String,
    val language: Language
)
data class Language(val name: String)
data class EvolutionChainUrl(val url: String)

data class EvolutionChainResponse(
    val chain: ChainLink
)
data class ChainLink(
    val species: SpeciesName,
    @SerializedName("evolution_details")
    val evolutionDetails: List<EvolutionDetail>,
    @SerializedName("evolves_to")
    val evolvesTo: List<ChainLink>
)
data class EvolutionDetail(
    val trigger: NameUrl,
    val item: NameUrl?,
    @SerializedName("min_level") val minLevel: Int?,
    @SerializedName("min_happiness") val minHappiness: Int?,
    @SerializedName("known_move") val knownMove: NameUrl?,
    @SerializedName("held_item") val heldItem: NameUrl?,
    @SerializedName("time_of_day") val timeOfDay: String?,
    @SerializedName("location") val location: NameUrl?,
    @SerializedName("relative_physical_stats") val relativePhysicalStats: Int?
)
data class NameUrl(val name: String, val url: String)
data class SpeciesName(
    val name: String,
    val url: String
)
