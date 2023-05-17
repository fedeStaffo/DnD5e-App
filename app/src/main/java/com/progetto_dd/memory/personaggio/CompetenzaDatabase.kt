package com.progetto_dd.memory.personaggio

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.progetto_dd.utils.Converters

@Database(entities = [Competenza::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CompetenzaDatabase: RoomDatabase() {

    abstract val competenzaDao: CompetenzaDao

    companion object{
        @Volatile
        private var INSTANCE: CompetenzaDatabase?=null

        fun getInstance(context: Context): CompetenzaDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CompetenzaDatabase::class.java,
                        "competenza_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}