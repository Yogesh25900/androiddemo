package com.example.week2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week2.R
import org.w3c.dom.Text

class animalAdapter (
    val context : Context,
    val imageList :ArrayList<Int>,
    val titleList :ArrayList<String>,
//    val descList :ArrayList<String>
):RecyclerView.Adapter<animalAdapter.AnimalViewHOlder>() {

    class AnimalViewHOlder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.imageView)
        val title : TextView = itemView.findViewById(R.id.title)
//        val desc : TextView = itemView.findViewById(R.id.desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHOlder {
        val itemView :View= LayoutInflater.from(context).inflate(R.layout.sample_animal,parent,false)
        return AnimalViewHOlder(itemView)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: AnimalViewHOlder, position: Int) {
        holder.title.text =titleList[position]
//        holder.desc.text =descList[position]
        holder.image.setImageResource(imageList[position])

    }

}
