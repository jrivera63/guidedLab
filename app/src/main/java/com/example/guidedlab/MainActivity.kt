package com.example.guidedlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intValue: Int){
        login(1),
        password(2),
        success(0)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.idLoginInput)
        val txtPassword = findViewById<TextView>(R.id.idPasswordInput)
        val btnLogin = findViewById<Button>(R.id.idLoginBtn)

        btnLogin.setOnClickListener{
            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())){
                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.loginErrorMessage), Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }

                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.passwordErrorMessage), Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }

                else -> Toast.makeText(applicationContext, "Success!", Toast.LENGTH_LONG).show()
            }
        }

    }
}

fun CheckLogin(txtLogin: String, txtPassword: String): MainActivity.LoginSuccess {
    val holdLogin = "Josiah"
    val holdPassword = "password"

    if(holdLogin != txtLogin){
        return MainActivity.LoginSuccess.login
    }
    return if(holdPassword != txtPassword){
        MainActivity.LoginSuccess.password
    } else {
        MainActivity.LoginSuccess.success}
}