package com.mycompany.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mycompany.learningkotlin.model.Article
import com.mycompany.learningkotlin.utils.Converters

@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArticleDatabase:RoomDatabase() {
    abstract fun newsDao():NewsDao
    companion object {
        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getDataseClient(context: Context): ArticleDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {
                INSTANCE = Room
                    .databaseBuilder(context, ArticleDatabase::class.java, "LOGIN_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()
                return INSTANCE!!
            }
        }

    }
}