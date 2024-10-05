package com.example.tailerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserShalwarAdapter(val userlist: ArrayList<UserShalwarDataModelDi>):RecyclerView.Adapter<UserShalwarAdapter.MyviewHolder>()
{
    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val qlength:TextView=itemView.findViewById(R.id.mslengthku)
        val qaram:TextView=itemView.findViewById(R.id.msarmku)
        val qshoulder:TextView=itemView.findViewById(R.id.msshoulderku)
        val qcollor:TextView=itemView.findViewById(R.id.mscollorku)

        val qchest:TextView=itemView.findViewById(R.id.mschestku)
        val qlap:TextView=itemView.findViewById(R.id.mslapku)
        val qpant:TextView=itemView.findViewById(R.id.mspantku)
        val qpaincha:TextView=itemView.findViewById(R.id.mspainchaku)
        val qcap:TextView=itemView.findViewById(R.id.mscapku)
        val qextraifo:TextView=itemView.findViewById(R.id.msextrainfoku)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserShalwarAdapter.MyviewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.itemlist_shalwar,parent,false)
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

   return userlist.size
    }


}