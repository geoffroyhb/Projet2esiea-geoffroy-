package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Plantmodel
import com.example.myapplication.R
import com.example.myapplication.adapter.PlantAdapter
import com.example.myapplication.adapter.PlantItemDecoration

class HomeFragment :Fragment() {
    override fun
            onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)


        // créer une liste qui va stoker les plantes
        val plantList = arrayListOf<Plantmodel>()

        // enregistrer une premiere plante (rose)
        plantList.add(
            Plantmodel(
            name = "Rose",
                description = "Rose clair",
            imageUrl = "https://media.istockphoto.com/photos/flowers-red-rose-isolated-on-white-background-picture-id1191892713?s=612x612",
                liked = false
        ))

        // enregistrer une seconde  plante (lavande)
        plantList.add(
            Plantmodel(
                name = "lavande",
                description = "violet écarlate ",
                imageUrl = "https://media.istockphoto.com/photos/garden-with-the-flourishing-lavender-picture-id1140984793?s=612x612",
                liked = false
            ))


        // enregistrer une troisième plante (pissenlit)
        plantList.add(
            Plantmodel(
                name = "pissenlit",
                description = "petit pissenlit",
                imageUrl = "https://media.istockphoto.com/photos/two-dandelions-with-leaves-picture-id1142487263?s=612x612",
                liked = false
            ))


        // enregistrer une quatrième plante (nénuphar )
        plantList.add(
            Plantmodel(
                name = "nénuphar",
                description = "small nénuphar",
                imageUrl = "https://media.istockphoto.com/photos/waterlilies-picture-id115015104?s=612x612",
                liked = false
            ))






        //recuperer recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_Recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(plantList,R.layout.item_horizontable_plant)
        //recuperer le second recycler View
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_Recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(plantList,R.layout.item_vertical_plant)

        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }
}