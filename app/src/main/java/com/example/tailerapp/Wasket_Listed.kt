package com.example.tailerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Wasket_Listed : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<UserWaskeyDataModelDi>

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wasket_listed)

        recyclerView=findViewById(R.id.recyclerview1    )
        recyclerView.layoutManager= LinearLayoutManager(this)
        userArrayList= arrayListOf()
        database= FirebaseDatabase.getInstance().getReference("Male Wasket")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val user = dataSnapshot.getValue(UserWaskeyDataModelDi::class.java)
                        if (!userArrayList.contains(user)){
                            userArrayList.add(user!!)

                        }
                    }
                    recyclerView.adapter=UserWasketAdapter(userArrayList)

                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Wasket_Listed, error.toString(), Toast.LENGTH_SHORT).show()            }
        })
    }
}