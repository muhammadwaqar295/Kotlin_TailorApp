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
import com.google.android.play.integrity.internal.y
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class RegisterPage : AppCompatActivity() {

     lateinit var UserName:EditText
     lateinit var UserPassword:EditText
     lateinit var UserEmail:EditText
     lateinit var UserContact:EditText
     lateinit var RegisterBtn:Button
     lateinit var have_an_acc:TextView


     private lateinit var auth: FirebaseAuth
     private var firebasestore:FirebaseStorage?=null
     private var storageReference: StorageReference?=null



    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

   auth= FirebaseAuth.getInstance()
        var database=Firebase.database
        var myRef=database.getReference("TailerAAp")

        firebasestore= FirebaseStorage.getInstance()
        storageReference=FirebaseStorage.getInstance().reference

        UserName=findViewById(R.id.user_name)
        UserPassword=findViewById(R.id.user_password)
        UserEmail=findViewById(R.id.user_email)
        UserContact=findViewById(R.id.user_contact)
        RegisterBtn=findViewById(R.id.register_btn)
        have_an_acc=findViewById(R.id.have_an_account)




        RegisterBtn.setOnClickListener{
            var uname=UserName.text.toString()
            var upass=UserPassword.text.toString()
            var umail=UserEmail.text.toString()
            var ucont = UserContact.text.toString()


            if (!TextUtils.isEmpty(uname) &&!TextUtils.isEmpty(upass) && !TextUtils.isEmpty(umail)
                && !TextUtils.isEmpty(ucont) ){



                auth.createUserWithEmailAndPassword(umail,upass).addOnCompleteListener(this){
                    if (it.isSuccessful){
                     var obj1=UserModel(uname,umail,upass, ucont)
                     var uid=auth.currentUser?.uid
                        if (uid !=null){
                            var obj1=UserModel(uname,umail,upass,ucont,auth.currentUser?.uid )
                            myRef.child("Account").push().setValue(obj1)
                        }
                        Toast.makeText(this,"Successfully Register", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Register is Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this, "Register is Failed", Toast.LENGTH_SHORT).show()
            }

        }

        have_an_acc.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }




    }
}