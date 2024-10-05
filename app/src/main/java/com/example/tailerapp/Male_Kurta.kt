package com.example.tailerapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Male_Kurta : AppCompatActivity() {

    lateinit var slenthKurta: EditText
    lateinit var sarmKurta: EditText
    lateinit var sshoulderKurta: EditText
    lateinit var scollorKurta: EditText
    lateinit var sregbtnKurta: Button

    lateinit var schestKurta: EditText
    lateinit var slapKurta: EditText
    lateinit var spantKurta: EditText
    lateinit var spainchaKurta: EditText
    lateinit var sshalwarKurta: EditText
    lateinit var scapKurta: EditText
    lateinit var qextrainfoKurta: EditText
    lateinit var likebtn: TextView


    lateinit var dbRef: DatabaseReference



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.male_kurta)

        slenthKurta=findViewById(R.id.MlengthKurta)
        sarmKurta=findViewById(R.id.MarmKurta)
        sshoulderKurta=findViewById(R.id.MshoulderKurta)
        scollorKurta=findViewById(R.id.McllorKurta)
        sregbtnKurta=findViewById(R.id.MregbtnKurta)

        schestKurta=findViewById(R.id.MchestKurta)
        slapKurta=findViewById(R.id.MlapKurta)
        spantKurta=findViewById(R.id.MpantKurta)
        spainchaKurta=findViewById(R.id.MpainchaKurta)
        scapKurta=findViewById(R.id.McapKurta)
        qextrainfoKurta=findViewById(R.id.MextrainfoKurta)
        likebtn=findViewById(R.id.ad_rec11)


        dbRef= FirebaseDatabase.getInstance().getReference("Male Kurta")

        sregbtnKurta.setOnClickListener {
            saveUserData()
        }


        likebtn.setOnClickListener{
            val intent= Intent(this,kurta_Listed::class.java)
            startActivity(intent)
        }
    }


    private fun saveUserData() {

        //getting values

        val mlength = slenthKurta.text.toString()
        val marm = sarmKurta.text.toString()
        val mshoulder = sshoulderKurta.text.toString()
        val mcollor = scollorKurta.text.toString()
        val mchest = schestKurta.text.toString()
        val mlap = slapKurta.text.toString()
        val mpant = spantKurta.text.toString()
        val mpaincha = spainchaKurta.text.toString()
        val mcap = scapKurta.text.toString()
        val mextrainfo = qextrainfoKurta.text.toString()


        if (!TextUtils.isEmpty(mlength) && !TextUtils.isEmpty(marm) && !TextUtils.isEmpty(mshoulder)
            && !TextUtils.isEmpty(mcollor)
            && !TextUtils.isEmpty(mchest)   && !TextUtils.isEmpty(mlap)   && !TextUtils.isEmpty(mpant)
            && !TextUtils.isEmpty(mpaincha)    && !TextUtils.isEmpty(mcap)
            && !TextUtils.isEmpty(mextrainfo)
        )
        {
            val mid = dbRef.push().key!!


            val userdata = mKurtaDtaModel(mid, mlength, marm, mshoulder, mcollor,mchest,mlap,mpant,mpaincha,
                mcap,mextrainfo)

            dbRef.child(mid).setValue(userdata)
                .addOnCompleteListener {
                    Toast.makeText(this, "Data is inserted", Toast.LENGTH_SHORT).show()
                    slenthKurta.text.clear()
                    sarmKurta.text.clear()
                    sshoulderKurta.text.clear()
                    scollorKurta.text.clear()

                    schestKurta.text.clear()
                    slapKurta.text.clear()
                    spantKurta.text.clear()
                    spainchaKurta.text.clear()
                    scapKurta.text.clear()
                    qextrainfoKurta.text.clear()

                }

        } else {
            Toast.makeText(this, "Register is Failed", Toast.LENGTH_SHORT).show()
        }


    }
}