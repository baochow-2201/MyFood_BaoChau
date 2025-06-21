package com.example.myfood_baochau;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodListActivity_BaoChau extends AppCompatActivity {
    ListView lvFood_BaoChau;
    ArrayList<String> listFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodlist_baochau);

        lvFood_BaoChau = findViewById(R.id.lvFood_BaoChau);
        listFoods = new ArrayList<>();

        int resId = getIntent().getIntExtra("restaurant_id", -1);

        DatabaseHelper_BaoChau helper = new DatabaseHelper_BaoChau(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Food WHERE restaurant_id = ?", new String[]{String.valueOf(resId)});
        while (c.moveToNext()) {
            String name = c.getString(1);
            double price = c.getDouble(2);
            String size = c.getString(3);
            listFoods.add(name + " - " + size + " - " + price + "đ");
        }

        c.close();
        db.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listFoods);
        lvFood_BaoChau.setAdapter(adapter);
    }
}
