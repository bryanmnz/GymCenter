package com.example.tothegym.network.api

import com.example.tothegym.network.request.GymGetListRequest
import com.example.tothegym.network.request.LoginRequest
import com.example.tothegym.network.response.GymGetListResponse
import com.example.tothegym.network.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {
    @POST("user/login")
    fun login(@Body data: LoginRequest): Call<LoginResponse>;

    @GET("gym")
    fun listGym(@Query("offset") offset:Number,
                @Query("rows") rows:Number): Call<GymGetListResponse>;
}