package com.satyam.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("v2/top-headlines")
    fun fetchHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apikey: String
    ): Call<News>
//https://newsapi.org/v2/top-headlines?country=in&apiKey=622cad3f2e51402da4cf2f4175d77110


}