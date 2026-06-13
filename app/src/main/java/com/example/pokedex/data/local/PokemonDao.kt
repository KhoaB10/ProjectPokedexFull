package com.example.pokedex.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pokedex.model.Item
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonSummary
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT id, name, types, hp, attack, defense, spAtk, spDef, speed, imageUrl, pveTier, pveRole, pvp1v1Tier, pvp1v1Role, pvp2v2Tier, pvp2v2Role, tags, sortOrder, hasFullDetails FROM pokemon ORDER BY sortOrder ASC")
    fun getAllPokemonSummary(): Flow<List<PokemonSummary>>

    @Query("SELECT * FROM pokemon ORDER BY sortOrder ASC")
    fun getPagingPokemon(): PagingSource<Int, Pokemon>

    @Query("""
        SELECT id, name, types, hp, attack, defense, spAtk, spDef, speed, imageUrl, pveTier, pveRole, pvp1v1Tier, pvp1v1Role, pvp2v2Tier, pvp2v2Role, tags, sortOrder, hasFullDetails 
        FROM pokemon 
        WHERE (name LIKE '%' || :query || '%' OR id LIKE '%' || :query || '%') 
        AND (:type = 'All' OR types LIKE '%' || :type || '%') 
        ORDER BY 
            CASE WHEN :sortType = 'NAME' AND :sortOrder = 'ASC' THEN name END ASC,
            CASE WHEN :sortType = 'NAME' AND :sortOrder = 'DESC' THEN name END DESC,
            CASE WHEN :sortType = 'ID' AND :sortOrder = 'ASC' THEN sortOrder END ASC,
            CASE WHEN :sortType = 'ID' AND :sortOrder = 'DESC' THEN sortOrder END DESC
    """)
    fun searchPagingPokemonSummary(
        query: String, 
        type: String, 
        sortType: String, 
        sortOrder: String
    ): PagingSource<Int, PokemonSummary>

    @Query("SELECT * FROM pokemon WHERE id = :id")
    suspend fun getPokemonById(id: String): Pokemon?

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getPokemonByIdFlow(id: String): Flow<Pokemon?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonList: List<Pokemon>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon)

    @Query("SELECT COUNT(*) FROM pokemon WHERE id = :baseId OR id LIKE :baseId || '.%'")
    suspend fun getVarietiesCount(baseId: String): Int

    @Update
    suspend fun update(pokemon: Pokemon)

    @Query("DELETE FROM pokemon")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM pokemon")
    suspend fun getCount(): Int

    @Query("SELECT * FROM pokemon WHERE hasFullDetails = 0 ORDER BY sortOrder ASC LIMIT :limit")
    suspend fun getPokemonMissingDetails(limit: Int): List<Pokemon>

    @Query("DELETE FROM pokemon WHERE sortOrder > :limit")
    suspend fun deletePokemonAboveId(limit: Double)
}

@Dao
interface ItemDao {
    @Query("SELECT * FROM items ORDER BY name ASC")
    fun getAllItems(): kotlinx.coroutines.flow.Flow<List<com.example.pokedex.model.Item>>

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<com.example.pokedex.model.Item>)

    @Query("SELECT COUNT(*) FROM items")
    suspend fun getCount(): Int
}
