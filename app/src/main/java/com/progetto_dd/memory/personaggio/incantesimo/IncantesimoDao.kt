package com.progetto_dd.memory.personaggio.incantesimo

import androidx.room.*

@Dao
interface IncantesimoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(incantesimo: Incantesimo)

    @Delete
    suspend fun delete(incantesimo: Incantesimo)

    @Insert
    suspend fun insertAll(incantesimo: List<Incantesimo>)

    @Query("SELECT * FROM tabella_incantesimi WHERE livello = :livello AND tipo = :tipo AND (classi = :classe OR classi LIKE :classeConcatenata)")
    suspend fun getIncantesimiByParams(livello: Int, tipo: String, classe: String, classeConcatenata: String): List<Incantesimo>

    @Query("SELECT * FROM tabella_incantesimi WHERE livello = :livello AND (classi = :classi OR classi LIKE :classiConcatenata)")
    suspend fun getIncantesimiByLevelAndClass(livello: Int, classi: String, classiConcatenata: String): List<Incantesimo>

    @Query("SELECT * FROM tabella_incantesimi WHERE tipo = :tipo AND (classi = :classi OR classi LIKE :classiConcatenata)")
    suspend fun getIncantesimiByTypeAndClass(tipo: String, classi: String, classiConcatenata: String): List<Incantesimo>

    @Query("SELECT * FROM tabella_incantesimi WHERE (classi = :classi OR classi LIKE :classiConcatenata)")
    suspend fun getIncantesimiByClass(classi: String, classiConcatenata: String): List<Incantesimo>

    @Query("SELECT * FROM tabella_incantesimi WHERE nome = :nomeIncantesimo")
    suspend fun getIncantesimoByNome(nomeIncantesimo: String): Incantesimo?
}