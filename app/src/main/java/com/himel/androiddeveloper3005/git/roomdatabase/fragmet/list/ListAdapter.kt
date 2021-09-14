package com.himel.androiddeveloper3005.git.roomdatabase.fragmet.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.himel.androiddeveloper3005.git.roomdatabase.R
import com.himel.androiddeveloper3005.git.roomdatabase.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    var userList = emptyList<User>()

     class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.first_name_txt.text = currentItem.firstName.toString()
        holder.itemView.last_name_txt.text = currentItem.lastName.toString()
        holder.itemView.age_txt.text = currentItem.age.toString()
    }

    fun setData(user : List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int { return userList.size   }

}