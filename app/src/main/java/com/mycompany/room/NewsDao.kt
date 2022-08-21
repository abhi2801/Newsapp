package com.mycompany.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mycompany.learningkotlin.model.Article

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertNews(article: Article):Long
    @Query("select * from News_Table")
    fun getAllArticles():LiveData<List<Article>>
    @Delete
    fun deleteArticle(article: Article)
}