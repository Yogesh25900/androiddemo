package com.example.week2

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteractionActivity : AppCompatActivity() {
    lateinit var buttonAlert : Button
    lateinit var  buttonSnack : Button
    lateinit var  buttonToast : Button
    lateinit var  main :ConstraintLayout

    override fun onCreate
                (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)
        buttonAlert =findViewById<Button>(R.id.buttonAlert)
        buttonSnack =findViewById<Button>(R.id.buttonSnack)
        buttonToast =findViewById<Button>(R.id.buttonToast)
        main = findViewById(R.id.main)

        buttonToast.setOnClickListener{

            Toast.makeText(
                this@UserInteractionActivity,
                "Invalid login Details",

                Toast.LENGTH_LONG
            ).show()
        }
        buttonSnack.setOnClickListener{
            Snackbar.make(main,
                "No internet connection",
                Snackbar.LENGTH_LONG).setAction("Retry",{

            })
                .show()

        }
        buttonAlert.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirm")
                .setIcon(R.drawable.circle)
                .setMessage("Are you sure want to logout?")
                .setPositiveButton("OK",DialogInterface.OnClickListener { dialog, which ->

                })

                .setNegativeButton("Cancel",DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                }).show()

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}