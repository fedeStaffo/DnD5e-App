package com.progetto_dd.memory.personaggio.incantesimo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.progetto_dd.utils.Converters

// Definisce il database Room per gli incantesimi
@Database(entities = [Incantesimo::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class IncantesimoDatabase : RoomDatabase() {

    // Dichiarazione astratta del DAO per gli incantesimi
    abstract val incantesimoDao: IncantesimoDao

    companion object {
        @Volatile
        private var INSTANCE: IncantesimoDatabase? = null

        // Restituisce un'istanza del database IncantesimoDatabase
        fun getInstance(context: Context): IncantesimoDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    // Crea un'istanza del database utilizzando il databaseBuilder di Room
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        IncantesimoDatabase::class.java,
                        "incantesimo_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
