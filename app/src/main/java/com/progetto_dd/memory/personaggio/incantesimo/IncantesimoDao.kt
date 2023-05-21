package com.progetto_dd.memory.personaggio.incantesimo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface IncantesimoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(incantesimo: Incantesimo)

    @Insert
    suspend fun insertAll(incantesimo: List<Incantesimo>)
}