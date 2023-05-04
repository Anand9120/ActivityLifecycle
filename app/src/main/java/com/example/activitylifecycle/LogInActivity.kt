package com.example.activitylifecycle

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

import android.os.Bundle


import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class LogInActivity : AppCompatActivity()  {
    lateinit var mob: EditText
    lateinit var password: EditText
    lateinit var btn3: Button
    lateinit var txtfp: TextView
    lateinit var txtry: TextView
    val validMobile="0123456789"
     val validPassword= arrayOf("thanos","steve","thor")
    lateinit var sharedPreferences: SharedPreferences


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if(isLoggedIn){
            val  intent= Intent(this@LogInActivity,MainActivity::class.java)
            startActivity(intent)
finish()
        }



        title = "Log In"
        mob = findViewById(R.id.mob)
        password = findViewById(R.id.password)
        btn3 = findViewById(R.id.btn3)
        txtfp = findViewById(R.id.txtfp)
        txtry = findViewById(R.id.txtry)

        btn3.setOnClickListener{
            val MobileNumber=mob.text.toString()
            val Password= password.text.toString()
            var nameOfavenger="Avengers"
            val  intent= Intent(this@LogInActivity,MainActivity::class.java)

            if(MobileNumber==validMobile) {
                if(Password==validPassword[0]) {
                    nameOfavenger = "Ironman"

                    savePreferences(nameOfavenger)
                    startActivity(intent)}

            }
                else if(Password==validPassword[1]){
                    nameOfavenger="Captain America"
                savePreferences(nameOfavenger)

                startActivity(intent)}

        else if (Password==validPassword[2]){
            nameOfavenger="The Hulk"
                savePreferences(nameOfavenger)


                startActivity(intent)}


            else {
                Toast.makeText(this@LogInActivity, "Incorrect credential", Toast.LENGTH_LONG).show()
            }
    }

     }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()

    }

 }










