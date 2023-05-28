package com.progetto_dd.memory.personaggio.incantesimo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabella_incantesimi")
data class Incantesimo(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "nome")
    var nome: String,

    @ColumnInfo(name = "livello")
    var livello: Int,

    @ColumnInfo(name = "tipo")
    var tipo: String,

    @ColumnInfo(name = "classi")
    var classi: String,

    @ColumnInfo(name = "info")
    var info: String
)
