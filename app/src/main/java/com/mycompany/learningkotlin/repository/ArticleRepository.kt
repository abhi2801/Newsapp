package com.mycompany.learningkotlin.repository

import com.mycompany.learningkotlin.api.RetrofitInstance
import com.mycompany.learningkotlin.model.Article
import com.mycompany.room.ArticleDatabase

class ArticleRepository (private val db:ArticleDatabase){

    suspend fun getBreakingNews(countryCode:String,pageNumber:Int,apiKey:String){
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber,apiKey)
    }
    suspend fun searchNews(countryCode: String,pageNumber: Int,apiKey: String){
        RetrofitInstance.api.searchForNews(countryCode,pageNumber,apiKey)
    }

    //Room Database

    suspend fun insertNews(article: Article)=db.newsDao().insertNews(article)
    suspend fun deleteNews(article: Article)=db.newsDao().deleteArticle(article)
    fun getSavedNews()=db.newsDao().getAllArticles()


}