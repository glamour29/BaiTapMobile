package com.example.btvnt2  // Thay đổi từ "com.example.ui" thành "com.example.btvnt2"

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TrangCaNhan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trang_ca_nhan2)  // Kiểm tra tên layout đúng chưa

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnNote = findViewById<Button>(R.id.btnNote)

        btnBack.setOnClickListener {
            finish() // Kết thúc Activity và quay lại màn hình trước
        }

        btnNote.setOnClickListener {
            Toast.makeText(this, "Bạn đã nhấn nút ghi chú!", Toast.LENGTH_SHORT).show()
        }
    }
}
