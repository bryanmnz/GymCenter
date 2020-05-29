package com.example.tothegym.dao

import com.google.gson.annotations.SerializedName

data class Gym (
    @SerializedName("role") var role:String,
    @SerializedName("state") var state:Boolean,
    @SerializedName("rate") var rate: Number,
    @SerializedName("areas") var areas: List<String>,
    @SerializedName("_id") var _id: String,
    @SerializedName("name") var name: String,
    @SerializedName("email") var email: String,
    @SerializedName("image") var image: String,
    @SerializedName("city") var city: String,
    @SerializedName("locality") var locality: String,
    @SerializedName("address") var address: String,
    @SerializedName("location") var location: String
    ) {
}