package com.progetto_dd.memory.personaggio.incantesimo

import androidx.room.*

@Dao
interface IncantesimoDao {

    // Inserisce o sostituisce un incantesimo nel database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(incantesimo: Incantesimo)

    // Elimina un incantesimo dal database
    @Delete
    suspend fun delete(incantesimo: Incantesimo)

    // Inserisce una lista di incantesimi nel database
    @Insert
    suspend fun insertAll(incantesimo: List<Incantesimo>)

    // Ottiene gli incantesimi che corrispondono ai parametri specificati
    @Query("SELECT * FROM tabella_incantesimi WHERE livello = :livello AND tipo = :tipo AND (classi = :classe OR classi LIKE :classeConcatenata)")
    suspend fun getIncantesimiByParams(livello: Int, tipo: String, classe: String, classeConcatenata: String): List<Incantesimo>

    // Ottiene gli incantesimi per un determinato livello e classe
    @Query("SELECT * FROM tabella_incantesimi WHERE livello = :livello AND (classi = :classi OR classi LIKE :classiConcatenata)")
    suspend fun getIncantesimiByLevelAndClass(livello: Int, classi: String, classiConcatenata: String): List<Incantesimo>

    // Ottiene gli incantesimi per un determinato tipo e classe
    @Query("SELECT * FROM tabella_incantesimi WHERE tipo = :tipo AND (classi = :classi OR classi LIKE :classiConcatenata)")
    suspend fun getIncantesimiByTypeAndClass(tipo: String, classi: String, classiConcatenata: String): List<Incantesimo>

    // Ottiene gli incantesimi per una determinata classe
    @Query("SELECT * FROM tabella_incantesimi WHERE (classi = :classi OR classi LIKE :classiConcatenata)")
    suspend fun getIncantesimiByClass(classi: String, classiConcatenata: String): List<Incantesimo>

    // Ottiene un incantesimo in base al suo nome
    @Query("SELECT * FROM tabella_incantesimi WHERE nome = :nomeIncantesimo")
    suspend fun getIncantesimoByNome(nomeIncantesimo: String): Incantesimo?

    @Query("SELECT * FROM tabella_incantesimi WHERE nome LIKE '%' || :keyword || '%'")
    suspend fun searchIncantesimiByKeyword(keyword: String): List<Incantesimo>

}
