package com.mycompany.learningkotlin.api

import com.mycompany.learningkotlin.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/top-headlines")
    suspend fun getBreakingNews(@Query("country") country:String="us",
                                @Query("page") pageNo:Int=1,
                        @Query("apikey")apikey:String
                        ):Response<NewsResponse>
    @GET("everything")
    suspend fun searchForNews(@Query("q") searchQuery:String,
                                @Query("page") pageNo:Int=1,
                                @Query("apikey")apikey:String
    ):Response<NewsResponse>
}