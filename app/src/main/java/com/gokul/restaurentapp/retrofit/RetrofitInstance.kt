package com.gokul.restaurentapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ContentApi by lazy{
        Retrofit.Builder()
            .baseUrl("http://127.0.0.1/App/contents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContentApi::class.java)
    }
}