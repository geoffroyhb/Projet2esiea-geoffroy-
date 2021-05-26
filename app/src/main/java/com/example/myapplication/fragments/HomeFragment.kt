package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.PlantAdapter

class HomeFragment :Fragment() {
    override fun
            onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        //recuperer recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_Recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(R.layout.item_horizontable_plant)
        //recuperer le second recycler View
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_Recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(R.layout.item_vertical_plant)

        return view
    }
}