package com.example.week2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week2.adapter.animalAdapter

class AnimalActivity : AppCompatActivity() {
    lateinit var  recyclerView: RecyclerView
    var imageList = ArrayList<Int>()
    var titleList = ArrayList<String>()
//    var descList = ArrayList<String>()
    lateinit var animalAdapter: animalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView =findViewById(R.id.recyclerview)

        imageList.add(R.drawable.squirrel)
        imageList.add(R.drawable.tiger)
        imageList.add(R.drawable.monkey)
        imageList.add(R.drawable.rhino)

        titleList.add("Squirrel")
        titleList.add("Tiger")
        titleList.add("Monkey")
        titleList.add("rhino")

//        descList.add("Squirrels are members of the family Sciuridae, a family that includes small or medium-sized rodents. The squirrel family includes tree squirrels, ground squirrels, and flying squirrels. ")
//        descList.add("The tiger is a large cat and a member of the genus Panthera native to Asia. It has a powerful, muscular body with a large head and paws, a long tail and orange fur with black, mostly vertical stripes.")
//        descList.add("As apes have emerged in the monkey group as sister of the old world monkeys, characteristics that describe monkeys are generally shared by apes as well.")
//        descList.add(("Rhinoceroses are some of the largest remaining megafauna: all weigh at least one tonne in adulthood. They have a herbivorous diet, small brains 400–600 g"))

        animalAdapter = animalAdapter(
            this@AnimalActivity,
            imageList,titleList
        )

        recyclerView.adapter =animalAdapter
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)


    }
}