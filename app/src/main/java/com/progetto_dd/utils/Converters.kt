package com.progetto_dd.utils

import androidx.room.TypeConverter

class Converters {
    /*
     * Converte una stringa separata da virgole in una lista di stringhe.
     * @param value la stringa da convertire
     * @return la lista di stringhe risultante
     */
    @TypeConverter
    fun fromString(value: String?): List<String>? {
        return value?.split(",")?.map { it.trim() }
    }


    /*
     * Converte una lista di stringhe in una singola stringa separata da virgole.
     * @param value la lista di stringhe da convertire
     * @return la stringa risultante
     */
    @TypeConverter
    fun toStringFromList(value: List<String>?): String? {
        return value?.joinToString(", ")
    }
}
