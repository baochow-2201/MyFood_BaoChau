package com.example.myfood_baochau;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity_BaoChau extends AppCompatActivity {
    EditText idUser_BaoChau, idPass_BaoChau, idRePass_BaoChau;
    Button btnRegister_BaoChau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_baochau);

        Toast.makeText(this, "Vào RegisterActivity", Toast.LENGTH_SHORT).show();

        idUser_BaoChau = findViewById(R.id.idUser_BaoChau);
        idPass_BaoChau = findViewById(R.id.idPass_BaoChau);
        idRePass_BaoChau = findViewById(R.id.idRePass_BaoChau);
        btnRegister_BaoChau = findViewById(R.id.btnRegister_BaoChau);

        btnRegister_BaoChau.setOnClickListener(v -> {
            String u = idUser_BaoChau.getText().toString().trim();
            String p = idPass_BaoChau.getText().toString().trim();
            String rp = idRePass_BaoChau.getText().toString().trim();

            if (u.isEmpty() || p.isEmpty() || rp.isEmpty()) {
                Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!p.equals(rp)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            DatabaseHelper_BaoChau helper = new DatabaseHelper_BaoChau(this);
            SQLiteDatabase db = helper.getWritableDatabase();

            Cursor c = db.rawQuery("SELECT * FROM User WHERE username = ?", new String[]{u});
            if (c.moveToFirst()) {
                Toast.makeText(this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
            } else {
                ContentValues values = new ContentValues();
                values.put("username", u);
                values.put("password", p);
                db.insert("User", null, values);
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                finish();
            }

            c.close();
            db.close();
        });
    }
}
