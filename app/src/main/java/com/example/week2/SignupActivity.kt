package com.example.week2


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week2.R.*

class SignupActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    lateinit var spinner: Spinner
    lateinit var textView: TextView
    lateinit var searchView: AutoCompleteTextView

    lateinit var date: EditText
    var countries = arrayOf(
        "Nepal", "India", "USA", "France"
    )

    val cities = arrayOf(
        // Asia
        "Kathmandu",
        "Tokyo",
        "Beijing",
        "Seoul",
        "Bangkok",
        "Mumbai",
        "Jakarta",
        "Manila",
        "Dubai",
        "Singapore",
        // Europe
        "London",
        "Paris",
        "Berlin",
        "Madrid",
        "Rome",
        "Amsterdam",
        "Vienna",
        "Prague",
        "Zurich",
        "Barcelona",
        // North America
        "New York",
        "Los Angeles",
        "Chicago",
        "Houston",
        "Toronto",
        "Vancouver",
        "Mexico City",
        "Miami",
        "San Francisco",
        "Las Vegas",
        // South America
        "São Paulo",
        "Rio de Janeiro",
        "Buenos Aires",
        "Lima",
        "Bogotá",
        "Santiago",
        "Quito",
        "Caracas",
        "Montevideo",
        "Asunción",
        // Africa
        "Cairo",
        "Cape Town",
        "Lagos",
        "Nairobi",
        "Johannesburg",
        "Accra",
        "Algiers",
        "Casablanca",
        "Addis Ababa",
        "Kigali",
        // Australia and Oceania
        "Sydney",
        "Melbourne",
        "Brisbane",
        "Auckland",
        "Wellington",
        "Perth",
        "Adelaide",
        "Hobart",
        "Suva",
        "Canberra"
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = findViewById<Spinner>(R.id.spinner2)
        textView = findViewById(R.id.textView12)
        searchView = findViewById(R.id.autoCompleteTextView3)

        date = findViewById(R.id.editTextDate)
        date.isFocusable = false
        date.isClickable = true

        date.setOnClickListener {
            LoadCalendar()

        }
        val autoAdapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_list_item_1,
            cities


        )

        searchView.setAdapter(autoAdapter)
        searchView.threshold = 1

        val adapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_spinner_item,
            countries
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = this


    }

    private fun LoadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@SignupActivity,
            DatePickerDialog.OnDateSetListener
            { view, year, month, dayOfMonth ->
                date.setText(String.format("%04d/%02d/%02d", year, month + 1, dayOfMonth))
            }, year, month, day
        )
        dialog.show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {

            textView.text = "You have selected " + parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }





}