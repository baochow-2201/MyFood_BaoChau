package com.example.myfood_baochau;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity_BaoChau extends AppCompatActivity {
    ListView lvRestaurants_BaoChau;
    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Vào HomeActivity", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_home_baochau);

        lvRestaurants_BaoChau = findViewById(R.id.lvRestaurants_BaoChau);
        list = new ArrayList<>();

        DatabaseHelper_BaoChau helper = new DatabaseHelper_BaoChau(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Restaurant", null);

        while (c.moveToNext())
            Log.d("HOME_DEBUG", "Số lượng nhà hàng: " + list.size());
        {
            list.add(c.getString(1) + " - " + c.getString(2)); // name - address
        }

        c.close();
        db.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvRestaurants_BaoChau.setAdapter(adapter);
    }
}
