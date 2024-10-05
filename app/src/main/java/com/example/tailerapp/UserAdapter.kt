package com.example.tailerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class UserAdapter (var context: Context, var mylist:ArrayList<UserModel>): BaseAdapter() {
    override fun getCount(): Int {
        return mylist.size
    }

    override fun getItem(p0: Int): Any {
        return mylist.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view= LayoutInflater.from(context).inflate(R.layout.nav_header,p2,false)

        var txtusername: TextView =view.findViewById(R.id.username)
        var txtusermail: TextView =view.findViewById(R.id.usermail)
        var txtusercontact: TextView =view.findViewById(R.id.usercontact)

        var username=mylist.get(p0).uname
        var usermail=mylist.get(p0).umail
        var usercontact=mylist.get(p0).ucont


        txtusername.text=username
        txtusermail.text=usermail
        txtusercontact.text=usercontact


        return view
    }
}