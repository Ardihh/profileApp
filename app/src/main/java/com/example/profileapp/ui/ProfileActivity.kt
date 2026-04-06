package com.example.profileapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profileapp.R
import com.example.profileapp.model.User

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val user = intent.getParcelableExtra<User>("DATA_USER")

        if (user == null) {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        findViewById<TextView>(R.id.tvNama).text = "Nama: ${user.nama}"
        findViewById<TextView>(R.id.tvNim).text = "NIM: ${user.nim}"
        findViewById<TextView>(R.id.tvProdi).text = "Prodi: ${user.prodi}"
        findViewById<TextView>(R.id.tvGender).text = "Gender: ${user.gender}"
        findViewById<TextView>(R.id.tvHobi).text = "Hobi: ${user.hobi}"

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}