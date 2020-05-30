package com.example.tothegym

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.tothegym.network.api.APIService
import com.example.tothegym.network.api.RetrofitInstance
import com.example.tothegym.network.request.LoginRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View){
        hideKeyBoard();
        var userName = et_user.text.toString();
        var pass = et_pass.text.toString();

        if(userName.isNullOrEmpty() || pass.isNullOrEmpty()){
            Toast.makeText(this, "El usuario y la contraseña son requeridos",
                Toast.LENGTH_SHORT).show();
            return;
        }

        btn_login.isEnabled = false
        pgb_loader.visibility = View.VISIBLE;
        doAsync {
            var retrofitInstance = RetrofitInstance().getInstance()
            var response = retrofitInstance.create(APIService::class.java)
                .login(LoginRequest(userName,pass)).execute()
            uiThread {
                var loginResponse = response.body();
                if (response.isSuccessful){
                    if(loginResponse?.code.equals("0")){
                        var intent = Intent(it, HomeActivity::class.java);
                        startActivity(intent);
                        finish()
                    }else{
                        Toast.makeText(it, loginResponse?.message, Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(it, "La información es incorrecta", Toast.LENGTH_SHORT).show()
                }
                btn_login.isEnabled = true
                pgb_loader.visibility = View.INVISIBLE;
            }
        }

    }

    fun registry(view: View){
        var intent = Intent(this, RegistryActivity::class.java);
        startActivity(intent);
    }

    fun hideKeyBoard(){
        val ins = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        ins.hideSoftInputFromWindow(this.currentFocus?.windowToken,0)
    }
}
