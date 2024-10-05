package com.example.tailerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserWasketAdapter(val userlist: ArrayList<UserWaskeyDataModelDi>): RecyclerView.Adapter<UserWasketAdapter.MyviewHolder>()
 {

     class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

         val qlength: TextView =itemView.findViewById(R.id.mslengthk)
         val qshoulder: TextView =itemView.findViewById(R.id.msshoulderk)
         val qcollor: TextView =itemView.findViewById(R.id.mscollork)
         val qchest: TextView =itemView.findViewById(R.id.mschestk)
         val qextraifo: TextView =itemView.findViewById(R.id.msextrainfok)


     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
         val itemView= LayoutInflater.from(parent.context).inflate(R.layout.itemlisted_waskek,parent,false)
         return MyviewHolder(itemView)
     }

     override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
         holder.qlength.text=userlist[position].mlength
         holder.qshoulder.text=userlist[position].mshoulder
         holder.qcollor.text=userlist[position].mcollor
         holder.qchest.text=userlist[position].mchest
         holder.qextraifo.text=userlist[position].mextrainfo
     }

     override fun getItemCount(): Int {
         return userlist.size
     }
 }