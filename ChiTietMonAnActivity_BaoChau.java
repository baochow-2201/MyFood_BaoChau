package com.example.myfood_baochau;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class ChiTietMonAnActivity_BaoChau extends AppCompatActivity {

    TextView tvName_BaoChau, tvDesc_BaoChau, tvPrice_BaoChau;
    RadioGroup rgSize_BaoChau;
    Button btnAddToCart_BaoChau;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_baochau);

        tvName_BaoChau = findViewById(R.id.tvName_BaoChau);
        tvDesc_BaoChau = findViewById(R.id.tvDesc_BaoChau);
        tvPrice_BaoChau = findViewById(R.id.tvPrice_BaoChau);
        rgSize_BaoChau = findViewById(R.id.rgSize_BaoChau);
        btnAddToCart_BaoChau = findViewById(R.id.btnAddToCart_BaoChau);

        tvName_BaoChau.setText("Phở Bò Tái");
        tvDesc_BaoChau.setText("Thịt bò tái mềm, nước dùng đậm đà");
        tvPrice_BaoChau.setText("Giá: 35000đ");

        rgSize_BaoChau.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbSmall_BaoChau) {
                tvPrice_BaoChau.setText("Giá: 35000đ");
            } else if (checkedId == R.id.rbMedium_BaoChau) {
                tvPrice_BaoChau.setText("Giá: 45000đ");
            } else if (checkedId == R.id.rbLarge_BaoChau) {
                tvPrice_BaoChau.setText("Giá: 55000đ");
            }
        });

        btnAddToCart_BaoChau.setOnClickListener(v -> {
            Toast.makeText(this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
        });
    }
}
