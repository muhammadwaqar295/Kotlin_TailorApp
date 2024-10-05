package com.example.tailerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserKurtaAdapterr(val userlist: ArrayList<UserKurtaDataModelDi>): RecyclerView.Adapter<UserKurtaAdapterr.MyviewHolder>()
 {

     class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
         val qlength: TextView =itemView.findViewById(R.id.mslength)
         val qaram: TextView =itemView.findViewById(R.id.msarm)
         val qshoulder: TextView =itemView.findViewById(R.id.msshoulder)
         val qcollor: TextView =itemView.findViewById(R.id.mscollor)

         val qchest: TextView =itemView.findViewById(R.id.mschest)
         val qlap: TextView =itemView.findViewById(R.id.mslap)
         val qpant: TextView =itemView.findViewById(R.id.mspant)
         val qpaincha: TextView =itemView.findViewById(R.id.mspaincha)
         val qcap: TextView =itemView.findViewById(R.id.mscap)
         val qextraifo: TextView =itemView.findViewById(R.id.msextrainfo)
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
         val itemView=
             LayoutInflater.from(parent.context).inflate(R.layout.itemlist_kurta,parent,false)
         return MyviewHolder(itemView)
     }

     override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
         holder.qlength.text=userlist[position].mlength
         holder.qaram.text=userlist[position].marm
         holder.qshoulder.text=userlist[position].mshoulder
         holder.qcollor.text=userlist[position].mcollor

         holder.qchest.text=userlist[position].mchest
         holder.qlap.text=userlist[position].mlap
         holder.qpant.text=userlist[position].mpant
         holder.qpaincha.text=userlist[position].mpaincha
         holder.qcap.text=userlist[position].mcap
         holder.qextraifo.text=userlist[position].mextrainfo
     }

     override fun getItemCount(): Int {
         return userlist.size     }
 }