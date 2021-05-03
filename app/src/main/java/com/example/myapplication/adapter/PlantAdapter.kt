package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


 class PlantAdapter () : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {
     //boite pou ranger tout les composants
     class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val plantImage = view.findViewById<ImageView>(R.id.image_item)
     }


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_horizontable_plant, parent,false)
        return ViewHolder(view)
     }



     override fun getItemCount(): Int {
         return 5
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {

     }


 }