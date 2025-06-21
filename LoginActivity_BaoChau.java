package com.example.myfood_baochau;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity_BaoChau extends AppCompatActivity {
    EditText idUser_BaoChau, idPass_BaoChau;
    Button btnLogin_BaoChau;
    TextView tvRegister_BaoChau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_baochau);

        idUser_BaoChau = findViewById(R.id.idUser_BaoChau);
        idPass_BaoChau = findViewById(R.id.idPass_BaoChau);
        btnLogin_BaoChau = findViewById(R.id.btnLogin_BaoChau);
        tvRegister_BaoChau = findViewById(R.id.tvRegister_BaoChau);

        btnLogin_BaoChau.setOnClickListener(v -> {
            String u = idUser_BaoChau.getText().toString().trim();
            String p = idPass_BaoChau.getText().toString().trim();

            DatabaseHelper_BaoChau helper = new DatabaseHelper_BaoChau(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM User WHERE username = ? AND password = ?", new String[]{u, p});

            if (c.moveToFirst()) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity_BaoChau.class));
                finish();
            } else {
                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }

            c.close();
            db.close();
        });

        tvRegister_BaoChau.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity_BaoChau.class));
        });
    }
}
