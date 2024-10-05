package com.example.tailerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class kurta_Listed : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<UserKurtaDataModelDi>

    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kurta_listed)

        recyclerView=findViewById(R.id.recyclerview5)
        recyclerView.layoutManager= LinearLayoutManager(this)
        userArrayList= arrayListOf()
        database= FirebaseDatabase.getInstance().getReference("Male Kurta")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val user = dataSnapshot.getValue(UserKurtaDataModelDi::class.java)
                        if (!userArrayList.contains(user)){
                            userArrayList.add(user!!)

                        }
                    }
                    recyclerView.adapter=UserKurtaAdapterr(userArrayList)

                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@kurta_Listed, error.toString(), Toast.LENGTH_SHORT).show()            }
        })
    }
}