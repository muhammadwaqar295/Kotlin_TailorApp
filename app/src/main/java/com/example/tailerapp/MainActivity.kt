package com.example.tailerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    lateinit var loginbtn:Button
    lateinit var useremail:EditText
    lateinit var userpass:EditText
    lateinit var logintxt:TextView



    lateinit var auth:FirebaseAuth

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth= FirebaseAuth.getInstance()

        loginbtn=findViewById(R.id.loginbtn)
        useremail=findViewById(R.id.lgemail)
        userpass=findViewById(R.id.lgpassword)
        logintxt=findViewById(R.id.txtlogin)






       logintxt.setOnClickListener {
    val intent=Intent(this,RegisterPage::class.java)
      startActivity(intent)
    }


    loginbtn.setOnClickListener{
        var umail=useremail.text.toString()
        var upass=userpass.text.toString()


        if(!TextUtils.isEmpty(umail)&& !TextUtils.isEmpty(upass)){
            auth.signInWithEmailAndPassword(umail,upass).addOnCompleteListener(this){
        if (it.isSuccessful){
            val intent= Intent(this,Dashboard::class.java)
            startActivity(intent)
        } else
            Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()

            }
        }
        else{
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
        }
    }

    }


}