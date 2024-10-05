package com.example.tailerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Coat_listed : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<UserCoatDataModelDi>

    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coat_listed)

        recyclerView=findViewById(R.id.recyclerview2)
        recyclerView.layoutManager= LinearLayoutManager(this)
        userArrayList= arrayListOf()
        database= FirebaseDatabase.getInstance().getReference("Male Coat")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val user = dataSnapshot.getValue(UserCoatDataModelDi::class.java)
                        if (!userArrayList.contains(user)){
                            userArrayList.add(user!!)

                        }
                    }
                    recyclerView.adapter=UserCoatAdapter(userArrayList)

                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Coat_listed, error.toString(), Toast.LENGTH_SHORT).show()            }
        })
    }
}