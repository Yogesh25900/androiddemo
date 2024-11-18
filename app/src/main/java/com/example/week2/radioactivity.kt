package com.example.week2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup

class radioactivity : AppCompatActivity() {
    lateinit var rhino : RadioButton
    lateinit var tiger : RadioButton
    lateinit var monkey : RadioButton
    lateinit var image : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radioactivity)
        monkey = findViewById(R.id.monkey)
        rhino = findViewById(R.id.rhino)
        tiger = findViewById(R.id.tiger)
        image = findViewById(R.id.imageView)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


       val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Set listener for radio button changes
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rhino -> imageView.setImageResource(R.drawable.rhino) // Update to rhino image
                R.id.monkey -> imageView.setImageResource(R.drawable.monkey) // Update to monkey image
                R.id.tiger -> imageView.setImageResource(R.drawable.tiger) // Update to tiger image
            }
        }
    }
}
