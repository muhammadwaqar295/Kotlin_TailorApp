package com.example.tailerapp
//this is for display data of shalwaar_listed and it also have userShalwardataModeldis and
// UsershalwarAdapter and also have itemlist_shalwarxml
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Shalwar_Listed : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<UserShalwarDataModelDi>
    private lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shalwar_listed)

        recyclerView=findViewById(R.id.recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(this)
        userArrayList= arrayListOf()
        database=FirebaseDatabase.getInstance().getReference("Male Shalwar")
        database.addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val user = dataSnapshot.getValue(UserShalwarDataModelDi::class.java)
                      if (!userArrayList.contains(user)){
                          userArrayList.add(user!!)

                      }
                }
                    recyclerView.adapter=UserShalwarAdapter(userArrayList)

            }
        }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Shalwar_Listed, error.toString(), Toast.LENGTH_SHORT).show()            }
        })
    }
}