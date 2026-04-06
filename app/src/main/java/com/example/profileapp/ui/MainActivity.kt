package com.example.profileapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.profileapp.R
import com.example.profileapp.model.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etNim = findViewById<EditText>(R.id.etNim)
        val spProdi = findViewById<Spinner>(R.id.spProdi)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)

        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val cbGaming = findViewById<CheckBox>(R.id.cbGaming)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        val prodiList = arrayOf("Teknik Informatika", "Teknik Sipil", "Teknik Mesin", "Teknik Elektro", "Teknik Industri", "Arsitektur")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, prodiList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spProdi.adapter = adapter

        btnSubmit.setOnClickListener {

            val nama = etNama.text.toString()
            val nim = etNim.text.toString()

            if (nama.isEmpty() || nim.isEmpty()) {
                Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (rgGender.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih gender!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = findViewById<RadioButton>(rgGender.checkedRadioButtonId).text.toString()

            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")
            if (cbGaming.isChecked) hobiList.add("Gaming")

            val user = User(
                nama,
                nim,
                spProdi.selectedItem.toString(),
                gender,
                hobiList.joinToString(", ")
            )

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("DATA_USER", user)
            startActivity(intent)
        }
    }
}