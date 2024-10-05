package com.example.tailerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Shalwar_Kameez : AppCompatActivity() {

    lateinit var slenth:EditText
    lateinit var sarm:EditText
    lateinit var sshoulder:EditText
    lateinit var scollor:EditText
    lateinit var sregbtn:Button

    lateinit var schest:EditText
    lateinit var slap:EditText
    lateinit var spant:EditText
    lateinit var spaincha:EditText
    lateinit var sshalwar:EditText
    lateinit var scap:EditText
    lateinit var qextrainfo:EditText



    lateinit var dbRef:DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shalwar_kameez)

        slenth=findViewById(R.id.Mlength)
        sarm=findViewById(R.id.Marm)
        sshoulder=findViewById(R.id.Mshoulder)
        scollor=findViewById(R.id.Mcllor)
        sregbtn=findViewById(R.id.Mregbtn)

        schest=findViewById(R.id.Mchest)
        slap=findViewById(R.id.Mlap)
        spant=findViewById(R.id.Mpant)
        spaincha=findViewById(R.id.Mpaincha)
        scap=findViewById(R.id.Mcap)
        qextrainfo=findViewById(R.id.Mextrainfo)

        dbRef=FirebaseDatabase.getInstance().getReference("Male Shalwar")

        sregbtn.setOnClickListener {
            saveUserData()
        }






    }

    private fun saveUserData() {

        //getting values

        val mlength = slenth.text.toString()
        val marm = sarm.text.toString()
        val mshoulder = sshoulder.text.toString()
        val mcollor = scollor.text.toString()
        val mchest = schest.text.toString()
        val mlap = slap.text.toString()
        val mpant = spant.text.toString()
        val mpaincha = spaincha.text.toString()
        val mcap = scap.text.toString()
        val mextrainfo = qextrainfo.text.toString()


        if (!TextUtils.isEmpty(mlength) && !TextUtils.isEmpty(marm) && !TextUtils.isEmpty(mshoulder)
            && !TextUtils.isEmpty(mcollor)
            && !TextUtils.isEmpty(mchest)   && !TextUtils.isEmpty(mlap)   && !TextUtils.isEmpty(mpant)
            && !TextUtils.isEmpty(mpaincha)    && !TextUtils.isEmpty(mcap)
            && !TextUtils.isEmpty(mextrainfo)
        )
        {
            val mid = dbRef.push().key!!


            val userdata = mShalwarDataModel(mid, mlength, marm, mshoulder, mcollor,mchest,mlap,mpant,mpaincha,
            mcap,mextrainfo)

            dbRef.child(mid).setValue(userdata)
                .addOnCompleteListener {
                    Toast.makeText(this, "Data is inserted", Toast.LENGTH_SHORT).show()
                    slenth.text.clear()
                    sarm.text.clear()
                    sshoulder.text.clear()
                    scollor.text.clear()

                    schest.text.clear()
                    slap.text.clear()
                    spant.text.clear()
                    spaincha.text.clear()
                    scap.text.clear()
                    qextrainfo.text.clear()

                }

        } else {
            Toast.makeText(this, "Register is Failed", Toast.LENGTH_SHORT).show()
        }


    }

}