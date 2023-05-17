package com.progetto_dd.utils

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromString(value: String?): List<String>? {
        return value?.split(",")?.map { it.trim() }
    }

    @TypeConverter
    fun toString(value: List<String>?): String? {
        return value?.joinToString(", ")
    }
}
