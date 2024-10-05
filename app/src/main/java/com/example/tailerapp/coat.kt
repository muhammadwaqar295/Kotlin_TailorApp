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

class coat : AppCompatActivity() {

    lateinit var slenthCoat: EditText
    lateinit var sarmCoat: EditText
    lateinit var sshoulderCoat: EditText
    lateinit var scollorCoat: EditText
    lateinit var sregbtnCoat: Button
    lateinit var schestCoat: EditText
    lateinit var qextrainfoCoat: EditText
    lateinit var forbutton: TextView

    lateinit var dbRef: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coat)


        slenthCoat=findViewById(R.id.MlengthCoat)
        sarmCoat=findViewById(R.id.MarmCoat)
        sshoulderCoat=findViewById(R.id.MshoulderCoat)
        scollorCoat=findViewById(R.id.McllorCoat)
        sregbtnCoat=findViewById(R.id.MregbtnCoat)
        schestCoat=findViewById(R.id.MchestCoat)
        qextrainfoCoat=findViewById(R.id.MextrainfoCoat)
        forbutton=findViewById(R.id.ad_reco)

        dbRef= FirebaseDatabase.getInstance().getReference("Male Coat")

        sregbtnCoat.setOnClickListener {
            saveUserData()
        }
        forbutton.setOnClickListener{
            val intent= Intent(this,Coat_listed::class.java)
            startActivity(intent)
        }

    }


    private fun saveUserData() {

        //getting values

        val mlength = slenthCoat.text.toString()
        val marm = sarmCoat.text.toString()
        val mshoulder = sshoulderCoat.text.toString()
        val mcollor = scollorCoat.text.toString()
        val mchest = schestCoat.text.toString()
        val mextrainfo = qextrainfoCoat.text.toString()


        if (!TextUtils.isEmpty(mlength) &&  !TextUtils.isEmpty(marm)&&  !TextUtils.isEmpty(mshoulder)
            && !TextUtils.isEmpty(mcollor) && !TextUtils.isEmpty(mchest) && !TextUtils.isEmpty(mextrainfo)
        )
        {
            val mid = dbRef.push().key!!


            val userdata = CoatdataModel(mid, mlength,marm,  mshoulder, mcollor,mchest,
                mextrainfo)

            dbRef.child(mid).setValue(userdata)
                .addOnCompleteListener {
                    Toast.makeText(this, "Data is inserted", Toast.LENGTH_SHORT).show()
                    slenthCoat.text.clear()
                    sarmCoat.text.clear()
                    sshoulderCoat.text.clear()
                    scollorCoat.text.clear()
                    schestCoat.text.clear()
                    qextrainfoCoat.text.clear()

                }

        } else {
            Toast.makeText(this, "Register is Failed", Toast.LENGTH_SHORT).show()
        }


    }
}