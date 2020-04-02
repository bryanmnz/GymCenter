package com.example.tothegym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View){
        var intent = Intent(this, HomeActivity::class.java);
        startActivity(intent);
    }

    fun registry(view: View){
        var intent = Intent(this, RegistryActivity::class.java);
        startActivity(intent);
    }
}
