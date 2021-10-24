package com.satyam.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsService {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.Baseurl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val newsInstance:NewsInterface= retrofit.create(NewsInterface::class.java)
}