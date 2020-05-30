package com.example.tothegym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isEmpty
import com.example.tothegym.dao.User
import com.example.tothegym.network.api.APIService
import com.example.tothegym.network.api.RetrofitInstance
import kotlinx.android.synthetic.main.activity_registry.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class RegistryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)
    }

    fun createAccount(view: View) {
        if(ti_name.editText?.text.isNullOrEmpty() || ti_lastname.editText?.text.isNullOrEmpty() ||
            ti_age.editText?.text.isNullOrEmpty() || ti_password.editText?.text.isNullOrEmpty()
            || ti_co_password.editText?.text.isNullOrEmpty() || ti_email.editText?.text.isNullOrEmpty()){
            Toast.makeText(this, "Los campos son requeridos, por favor valide.",
                Toast.LENGTH_SHORT).show();
            return;
        }

        if(ti_co_password.toString().equals(ti_password.toString())){
            Toast.makeText(this, "Las contraseñas no coinciden por favor valide",
                Toast.LENGTH_SHORT).show();
            return;
        }

        doAsync {
            //btn_registry.isEnabled = false
            var retrofitInstance = RetrofitInstance().getInstance()
            var user = User("USER_ROLE", true,false,
                ti_name.editText?.text.toString() + " "+ ti_lastname.editText?.text.toString(),
                ti_email.editText?.text.toString(),
                ti_password.editText?.text.toString(),
                0);
            user.age = ti_age.editText?.text.toString().toInt();
            var response = retrofitInstance.create(APIService::class.java)
                .createUser(user).execute()
            uiThread {
                var createUserResponse = response.body();
                if (response.isSuccessful){
                    if(createUserResponse?.code.equals("0")){
                        var intent = Intent(it, HomeActivity::class.java);
                        startActivity(intent);
                        finish()
                    }else{
                        Toast.makeText(it, createUserResponse?.message, Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(it, "La información es incorrecta", Toast.LENGTH_SHORT).show()
                }
                btn_registry.isEnabled = true
                pgb_loader.visibility = View.INVISIBLE;
            }
        }

    }
}
