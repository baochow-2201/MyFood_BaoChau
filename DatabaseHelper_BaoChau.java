package com.example.myfood_baochau;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper_BaoChau extends SQLiteOpenHelper {
    public static final String DB_NAME = "Food_BaoChau.db";
    public static final int DB_VERSION = 1;

    public DatabaseHelper_BaoChau(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE User (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT)");

        db.execSQL("CREATE TABLE Restaurant (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "address TEXT, " +
                "image TEXT)");

        db.execSQL("CREATE TABLE Food (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "price REAL, " +
                "size TEXT, " +
                "description TEXT, " +
                "restaurant_id INTEGER, " +
                "image TEXT)");

        insertSampleData(db);
    }

    private void insertSampleData(SQLiteDatabase db) {
        // Người dùng
        db.execSQL("INSERT INTO User (username, password) VALUES " +
                "('alice', '123'), ('bob', 'abc'), ('charlie', 'pass'), ('david', '1111'), ('eva', 'qwerty')");

        // Nhà hàng
        db.execSQL("INSERT INTO Restaurant (name, address, image) VALUES " +
                "('Phở Bò', '124/2A Lê Lai, Q10', 'phobo.jpg')," +
                "('Bún Chả Hà Nội', 'Nguyễn Bá Tuyển, QTB', 'bunchahanoi.jpg')," +
                "('Cơm Gà', '11a Nguyễn Trãi, Q5', 'comga.jpg')," +
                "('Cơm Gà Xối Mỡ', '11a Nguyễn Trãi, Q5', 'comgaxm.jpg')," +
                "('Gỏi Gà', '113 Nguyễn Thị Minh Khai, Q1', 'goiga.jpg')");

        // Món ăn
        db.execSQL("INSERT INTO Food (name, price, size, description, restaurant_id, image) VALUES " +
                "('Phở Bò Tái', 35000, 'Vừa', 'Phở bò truyền thống với thịt tái mềm', 1, 'pho_bo.jpg')," +
                "('Nem Rán', 30000, '2 cái', 'Chả giò chiên giòn Hà Nội', 2, 'nem_ran.jpg')," +
                "('Cơm Tấm Trứng Ốp', 30000, 'Dĩa', 'Cơm tấm với trứng ốp la', 3, 'comtam.jpg')," +
                "('Bánh Mì Thịt Nướng', 20000, 'Ổ', 'Bánh mì với thịt', 4, 'banhmi.jpg')," +
                "('Trà sữa', 20000, 'Ly', 'Truyền thống', 1, 'tra_sua.jpg')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS Food");
        db.execSQL("DROP TABLE IF EXISTS Restaurant");
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }
}
