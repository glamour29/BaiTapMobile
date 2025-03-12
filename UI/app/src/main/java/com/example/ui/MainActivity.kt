package com.example.ui

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        Glide.with(this)
            .load(R.drawable.duy)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)

        val myName = findViewById<TextView>(R.id.myName)
        myName.text = getString(R.string.my_name)


        val myHome = findViewById<TextView>(R.id.myHome)
        myHome.text = getString(R.string.my_home)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnNote = findViewById<Button>(R.id.btnNote)

        btnBack.setOnClickListener {
            finish()
        }

        btnNote.setOnClickListener {
            Toast.makeText(this, "Bạn đã nhấn nút ghi chú!", Toast.LENGTH_SHORT).show()
        }
    }
}