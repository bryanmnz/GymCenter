package com.example.tothegym.network.response

import com.example.tothegym.dao.Session
import com.google.gson.annotations.SerializedName

class CreateUserResponse(@SerializedName("body") var body:Session):BasicResponse() {
}