package com.gokul.restaurentapp.retrofit

import com.gokul.restaurentapp.pojo.ContentList
import retrofit2.Call
import retrofit2.http.GET


interface ContentApi{
    @GET("home.php")
    fun getRandomMeal(): Call<ContentList>
}