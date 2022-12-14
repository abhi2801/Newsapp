package com.mycompany.learningkotlin.utils

import androidx.room.TypeConverter
import com.mycompany.learningkotlin.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source:Source):String{
        return source.name
    }
    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }
}