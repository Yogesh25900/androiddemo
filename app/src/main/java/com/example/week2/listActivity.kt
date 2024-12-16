package com.example.week2

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listActivity : AppCompatActivity() {

    lateinit var  listview :ListView

    var contacts = arrayOf(
        "Deepika" ,"Sumina","Sumitra", "Manasi " +
                "", "Samy", "Sandhya", "Prishma", "Nishma",
        "Nilima", "Janaki", "Deepti", "Angela",
        "Suman","Radha", "Samita","Sunadari", "Santoshi","Swagata","Shruti","Eliza",
        "Sneha","Pratiksha","Ashma","Ayushma","Aradhya"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        listview = findViewById(R.id.listView)

        val adapter = ArrayAdapter(
            this@listActivity,
            android.R.layout.simple_list_item_1,
            contacts
        )

        listview.adapter= adapter


        listview.setOnItemClickListener { parent, view, position, id ->
            if(parent!=null){
                Toast.makeText(
                    this,
                    "You have selected " +parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}