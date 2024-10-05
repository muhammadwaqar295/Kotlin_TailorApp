package com.example.tailerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserCoatAdapter(val userlist: ArrayList<UserCoatDataModelDi>): RecyclerView.Adapter<UserCoatAdapter.MyviewHolder>() {

    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val qlength: TextView =itemView.findViewById(R.id.mslengthwas)
        val qaram: TextView =itemView.findViewById(R.id.msarmwas)
        val qshoulder: TextView =itemView.findViewById(R.id.msshoulderwas)
        val qchest: TextView =itemView.findViewById(R.id.mschestwas)
        val qcollor: TextView =itemView.findViewById(R.id.mscollorwas)
        val qextraifo: TextView =itemView.findViewById(R.id.msextrainfowas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.itemlist_coat,parent,false)
        return MyviewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.qlength.text=userlist[position].mlength
        holder.qaram.text=userlist[position].marm
        holder.qshoulder.text=userlist[position].mshoulder
        holder.qchest.text=userlist[position].mchest
        holder.qcollor.text=userlist[position].mcollor
        holder.qextraifo.text=userlist[position].mextrainfo    }

    override fun getItemCount(): Int {

        return userlist.size    }


}