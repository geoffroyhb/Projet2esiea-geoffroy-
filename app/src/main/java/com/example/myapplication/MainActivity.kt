package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //charger notre Plantrepository
        val repo =PlantRepository()

        //mettre à jour

        repo.updateData{
            //injecter le fragment dans notre boite (fragment_container )
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()

        }



    }
}