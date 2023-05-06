package com.gokul.restaurentapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gokul.restaurentapp.R
import com.gokul.restaurentapp.pojo.ContentList
import com.gokul.restaurentapp.pojo.Table
import com.gokul.restaurentapp.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RetrofitInstance.api.getRandomMeal().enqueue(object : Callback<ContentList>{
            override fun onResponse(call: Call<ContentList>, response: Response<ContentList>) {
                if(response.body() !=null){
                    val table: Table = response.body()!!.table[0]
                    Log.v("Api responce","is "+table)

                }else{

                }
            }

            override fun onFailure(call: Call<ContentList>, t: Throwable) {
                    Log.v("error message","from api call")
            }
        })
    }
}