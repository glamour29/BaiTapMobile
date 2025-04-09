package com.example.btvnt2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.btvnt2.databinding.ActivityMainBinding
import com.example.btvnt2.databinding.ActivityTrangCaNhan2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val danhSachTen = arrayOf("Nguyễn Văn A", "Trần Thị B", "Lê Văn C", "Phạm Minh D")
    private var soSach = 2 // Bắt đầu với 2 cuốn sách

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDoi.setOnClickListener {
            hienThiDanhSachTen()
        }

        binding.btnThem.setOnClickListener {
            if (areAllCheckBoxesChecked()) {
                themSachMoi()
            } else {
                Toast.makeText(this, "Hãy chọn hết các sách trước khi thêm!", Toast.LENGTH_SHORT).show()
            }
        }

        // Chuyển sang màn hình cá nhân khi bấm nút
        binding.btnCaNhan.setOnClickListener {
            val intent = Intent(this, TrangCaNhan::class.java)
            startActivity(intent)
        }
    }

    // Hiển thị danh sách tên trong AlertDialog
    private fun hienThiDanhSachTen() {
        AlertDialog.Builder(this)
            .setTitle("Chọn tên nhân viên")
            .setItems(danhSachTen) { _, which ->
                binding.edtTenNV.setText(danhSachTen[which])
                Toast.makeText(this, "Bạn chọn: ${danhSachTen[which]}", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Hủy", null)
            .show()
    }

    private fun areAllCheckBoxesChecked(): Boolean {
        for (i in 0 until binding.line2.childCount) {
            val view = binding.line2.getChildAt(i)
            if (view is CheckBox && !view.isChecked) {
                return false
            }
        }
        return true
    }

    // Hàm thêm sách mới vào danh sách
    private fun themSachMoi() {
        soSach++
        val newCheckBox = CheckBox(this).apply {
            text = "Sách $soSach"
            id = View.generateViewId() // Tạo ID tự động
            setBackgroundResource(R.drawable.khungbogoctrang)

            val layoutParams = LinearLayout.LayoutParams(
                convertDpToPx(300f),
                convertDpToPx(50f)
            ).apply {
                setMargins(
                    convertDpToPx(20f),
                    convertDpToPx(10f),
                    convertDpToPx(20f),
                    convertDpToPx(10f)
                )
            }
            this.layoutParams = layoutParams
        }

        binding.line2.addView(newCheckBox) // Sử dụng binding để thêm vào container
        Toast.makeText(this, "Đã thêm Sách $soSach", Toast.LENGTH_SHORT).show()
    }

    // Hàm chuyển dp thành px
    private fun convertDpToPx(dp: Float): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }
}