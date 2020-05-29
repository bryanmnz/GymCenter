package com.example.tothegym.network.response

import com.example.tothegym.dao.Gym
import com.google.gson.annotations.SerializedName

data class GymGetListResponse(@SerializedName("body") var body: List<Gym>): BasicResponse() {
}