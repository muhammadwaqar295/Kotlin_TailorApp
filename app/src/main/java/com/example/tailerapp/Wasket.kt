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

class Wasket : AppCompatActivity() {

    lateinit var slenthWas: EditText
    lateinit var sshoulderWas: EditText
    lateinit var scollorWas: EditText
    lateinit var sregbtnWas: Button
    lateinit var schestWas: EditText
    lateinit var qextrainfoWas: EditText
    lateinit var forbutton: TextView



    lateinit var dbRef: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wasket)



        slenthWas=findViewById(R.id.MlengthWas)
        sshoulderWas=findViewById(R.id.MshoulderWas)
        scollorWas=findViewById(R.id.McllorWas)
        sregbtnWas=findViewById(R.id.MregbtnWas)
        schestWas=findViewById(R.id.MchestWas)
        qextrainfoWas=findViewById(R.id.MextrainfoWas)
        forbutton=findViewById(R.id.ad_reco)


        dbRef= FirebaseDatabase.getInstance().getReference("Male Wasket")

        sregbtnWas.setOnClickListener {
            saveUserData()
        }

        forbutton.setOnClickListener{
            val intent= Intent(this,Wasket_Listed::class.java)
            startActivity(intent)
        }
    }




    private fun saveUserData() {

        //getting values

        val mlength = slenthWas.text.toString()
        val mshoulder = sshoulderWas.text.toString()
        val mcollor = scollorWas.text.toString()
        val mchest = schestWas.text.toString()
        val mextrainfo = qextrainfoWas.text.toString()


        if (!TextUtils.isEmpty(mlength) &&  !TextUtils.isEmpty(mshoulder)
            && !TextUtils.isEmpty(mcollor)
            && !TextUtils.isEmpty(mchest) && !TextUtils.isEmpty(mextrainfo)
        )
        {
            val mid = dbRef.push().key!!


            val userdata = WasketDataModel(mid, mlength,  mshoulder, mcollor,mchest,
                mextrainfo)

            dbRef.child(mid).setValue(userdata)
                .addOnCompleteListener {
                    Toast.makeText(this, "Data is inserted", Toast.LENGTH_SHORT).show()
                    slenthWas.text.clear()
                    sshoulderWas.text.clear()
                    scollorWas.text.clear()
                    schestWas.text.clear()
                    qextrainfoWas.text.clear()

                }

        } else {
            Toast.makeText(this, "Register is Failed", Toast.LENGTH_SHORT).show()
        }


    }
}