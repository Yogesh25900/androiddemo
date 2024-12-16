package com.example.week2

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week2.databinding.ActivityLoginformBinding

class loginform : AppCompatActivity() {

    lateinit var  binding: ActivityLoginformBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginformBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener{
            val username :String = binding.emailInputText.text.toString()
            val password :String = binding.passwordInputText.text.toString()

            if(username.isEmpty()){
                binding.emailInputText.error = "username can't be empty"
            }
            else if(password.isEmpty()){
                binding.passwordInputText.error = "password cant be empty"
            }else {
                val intent = Intent(this@loginform, AnimalActivity::class.java)

                startActivity(intent)
            }


        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}