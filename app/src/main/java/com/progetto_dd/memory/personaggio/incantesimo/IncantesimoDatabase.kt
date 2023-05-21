package com.progetto_dd.memory.personaggio.incantesimo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.progetto_dd.utils.Converters

@Database(entities = [Incantesimo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class IncantesimoDatabase: RoomDatabase() {

    abstract val incantesimoDao: IncantesimoDao

    companion object{
        @Volatile
        private var INSTANCE: IncantesimoDatabase?=null

        fun getInstance(context: Context): IncantesimoDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
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