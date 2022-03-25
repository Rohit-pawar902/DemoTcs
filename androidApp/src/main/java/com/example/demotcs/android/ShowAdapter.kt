package com.example.demotcs.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demotcs.entity.Person


class ShowAdapter(var item:List<Person>):RecyclerView.Adapter<ShowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val xml=LayoutInflater.from(parent.context).inflate(
            R.layout.registration_row,parent,false
        )
        return ShowViewHolder(xml)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        var d1=item[position]
        holder.name.text =  "Name  : "+d1.name
        holder.email.text = "Email  : "+d1.email
        holder.mobile.text ="Mobile : "+d1.mobile
        holder.pass.text ="Password : "+d1.password
        holder.address.text ="Address : "+d1.gender

//        holder.img1.setImageResource(d1.uImage)
    }

    override fun getItemCount(): Int {
        return item.size
    }

}

class ShowViewHolder(var items:View ):RecyclerView.ViewHolder(items){
    var name= items.findViewById<TextView>(R.id.tvname)
    var email = items.findViewById<TextView>(R.id.tvemail)
    var mobile = items.findViewById<TextView>(R.id.tvmobile)
    var pass = items.findViewById<TextView>(R.id.tvpass)
    var address = items.findViewById<TextView>(R.id.tvaddress)

//    var img1=items.findViewById<ImageView>(R.id.imageView2)

}