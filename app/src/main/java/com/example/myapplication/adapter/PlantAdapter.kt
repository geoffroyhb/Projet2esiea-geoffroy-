package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.MainActivity
import com.example.myapplication.PlantRepository
import com.example.myapplication.Plantmodel
import com.example.myapplication.R
import org.w3c.dom.Text


class PlantAdapter (
     private val context :MainActivity,
     private val plantList:List<Plantmodel>,
     private val layoutId:Int
 ) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {
     //boite pou ranger tout les composants
     class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val plantImage = view.findViewById<ImageView>(R.id.image_item)
         val plantName:TextView? = view.findViewById(R.id.name_item)
         val plantDescription:TextView? = view.findViewById(R.id.textView2)
         val likeIcon =view.findViewById<ImageView>(R.id.like_icon)
     }


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(layoutId, parent,false)
        return ViewHolder(view)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         // recuperer les infos
         val currentPlant = plantList[position]

         val repo =PlantRepository()

            //utiliser glide pour recuperer l'image de son lien
            Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

         //mettre a jour le nom plante

         holder.plantName?.text= currentPlant.name

         //mettre à jour la descrption

         holder.plantDescription?.text =currentPlant.description

         //verifier plante liker

         if(currentPlant.liked){
             holder.likeIcon.setImageResource(R.drawable.ic_like)
         }
         else {
             holder.likeIcon.setImageResource(R.drawable.ic_unlike)
         }
         holder.likeIcon.setOnClickListener{

             //inversement du bouton like ou unlike
             currentPlant.liked = !currentPlant.liked
             //mettre à jour
            repo.updatePlant(currentPlant)
         }
     }

     override fun getItemCount(): Int= plantList.size




 }