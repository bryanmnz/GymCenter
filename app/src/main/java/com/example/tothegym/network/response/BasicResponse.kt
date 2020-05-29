package com.example.tothegym.network.response

import com.google.gson.annotations.SerializedName

open class BasicResponse(){
    @SerializedName("code") var code: String = "";
    @SerializedName("message") var message: String = "";
}