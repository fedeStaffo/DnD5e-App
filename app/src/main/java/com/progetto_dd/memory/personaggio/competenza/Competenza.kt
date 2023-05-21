package com.progetto_dd.memory.personaggio.competenza

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabella_competenze")
data class Competenza(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "nome")
    var nome: String,

    @ColumnInfo(name = "classi_competenza")
    var classi: List<String>
)
