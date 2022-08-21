package com.mycompany.learningkotlin.api

import com.mycompany.learningkotlin.utils.constants.base_url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private val retrofit by lazy {
                 Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        val api by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }

}