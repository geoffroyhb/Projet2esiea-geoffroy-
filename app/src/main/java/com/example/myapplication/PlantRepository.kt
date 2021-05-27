package com.example.myapplication

import com.example.myapplication.PlantRepository.Singleton.databaseRef
import com.example.myapplication.PlantRepository.Singleton.plantList
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PlantRepository {

    object Singleton{
        // se connecter à la réference du firebase "plants"
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")
        //créer une lsite qui va contenir nos plantes
        val plantList= arrayListOf<Plantmodel>()

    }

   fun updateData(callback:() ->Unit){
       databaseRef.addValueEventListener(object :ValueEventListener{




           override fun onDataChange(p0: DataSnapshot) {

               //retirer les ancieens

               plantList.clear()
               //recolter liste

               for (ds in p0.children ) {

                   val plant = ds.getValue(Plantmodel::class.java)

                   if (plant!=null){
                       plantList.add(plant)
                   }

               }
               //actionner le callbakc

               callback()
           }
           override fun onCancelled(p0: DatabaseError) {

           }





       })
   }

    fun updatePlant(plant:Plantmodel)= databaseRef.child(plant.id).setValue(plant)

}