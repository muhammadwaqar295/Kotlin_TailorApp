package com.example.tailerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MaleList : AppCompatActivity() {

    lateinit var shalwar:com.google.android.material.card.MaterialCardView
    lateinit var wasket:com.google.android.material.card.MaterialCardView
    lateinit var kurtaa:com.google.android.material.card.MaterialCardView
    lateinit var coate:com.google.android.material.card.MaterialCardView


            @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_male_list)

           shalwar=findViewById(R.id.shalwar_kameez)
           wasket=findViewById(R.id.wasket)
           kurtaa=findViewById(R.id.male_kurta)
           coate=findViewById(R.id.male_coat)


        shalwar.setOnClickListener{
            val intent= Intent(this,Shalwar_Kameez::class.java)
            startActivity(intent)
        }
              wasket.setOnClickListener{
            val intent= Intent(this,Wasket::class.java)
            startActivity(intent)
        }

                kurtaa.setOnClickListener{
            val intent= Intent(this,Male_Kurta::class.java)
            startActivity(intent)
        }

                coate.setOnClickListener{
            val intent= Intent(this,coat::class.java)
            startActivity(intent)
        }

    }
}

