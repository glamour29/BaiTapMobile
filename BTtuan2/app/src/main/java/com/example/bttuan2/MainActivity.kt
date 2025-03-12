package com.example.bttuan2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtHoTen = findViewById<EditText>(R.id.edtHoTen)
        val edtTuoi = findViewById<EditText>(R.id.edtTuoi)
        val btnKiemTra = findViewById<Button>(R.id.btnKiemTra)
        val txtResult = findViewById<TextView>(R.id.result)

        btnKiemTra.setOnClickListener {
            val hoTen = edtHoTen.text.toString().trim()
            val tuoi = edtTuoi.text.toString().toIntOrNull()

            val ketQua = if (tuoi == null) {
                "Vui lòng nhập tuổi hợp lệ"
            } else {
                "$hoTen là " + when {
                    tuoi > 65 -> "Người già"
                    tuoi in 6..65 -> "Người lớn"
                    tuoi in 2..5 -> "Trẻ em"
                    tuoi >= 0 -> "Em bé"
                    else -> "Tuổi không hợp lệ"
                }
            }

            txtResult.text = ketQua  // Hiển thị kết quả đúng
        }
    }
}
