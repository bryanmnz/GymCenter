package com.example.tothegym.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    fun getInstance(): Retrofit{
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build();
        return Retrofit.Builder()
            .baseUrl("https://app-corex-gym.herokuapp.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build();
    }
}