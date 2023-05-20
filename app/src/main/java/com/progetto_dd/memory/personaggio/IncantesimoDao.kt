package com.progetto_dd.memory.personaggio

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IncantesimoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(incantesimo: Incantesimo)

    @Insert
    suspend fun insertAll(incantesimo: List<Incantesimo>)
}