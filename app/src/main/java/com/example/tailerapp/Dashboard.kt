package com.example.tailerapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


import kotlin.system.exitProcess

class Dashboard : AppCompatActivity() {



    lateinit var malelist:com.google.android.material.card.MaterialCardView

    lateinit var toggle:ActionBarDrawerToggle
    lateinit var listedbtn:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

     val drawerLayout :DrawerLayout=findViewById(R.id.drawerLayout)
        val navview :NavigationView=findViewById(R.id.nav_view)
        toggle=ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_adman-> Toast.makeText(applicationContext,"Click on adman",Toast.LENGTH_SHORT).show()
                R.id.nav_setting-> Toast.makeText(applicationContext,"Click on setting",Toast.LENGTH_SHORT).show()
                R.id.nav_share-> Toast.makeText(applicationContext,"Click on share",Toast.LENGTH_SHORT).show()
                R.id.nav_about-> Toast.makeText(applicationContext,"Click on about",Toast.LENGTH_SHORT).show()
                R.id.nav_logout-> exitProcess(1)
            }
            true
        }

  listedbtn=findViewById(R.id.btnmm)
        malelist=findViewById(R.id.male_list)
        malelist.setOnClickListener{
            val intent= Intent(this,MaleList::class.java)
            startActivity(intent)
        }



        listedbtn.setOnClickListener{
            val intent= Intent(this,Shalwar_Listed::class.java)
            startActivity(intent)
        }










    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      if (toggle.onOptionsItemSelected(item)){
          return true
      }
        return super.onOptionsItemSelected(item)
    }
}