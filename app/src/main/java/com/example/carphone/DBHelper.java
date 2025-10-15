package com.example.carphone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList; import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="app.db"; private static final int DB_VERSION=2;
    public static final String TBL_CAR="Car", TBL_PHONE="Phone";
    public DBHelper(Context c){ super(c, DB_NAME, null, DB_VERSION); }
    @Override public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TBL_CAR+" (id INTEGER PRIMARY KEY AUTOINCREMENT, brand TEXT NOT NULL, model TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TBL_PHONE+" (id INTEGER PRIMARY KEY AUTOINCREMENT, brand TEXT NOT NULL, model TEXT NOT NULL, price REAL NOT NULL)");
        seedCars(db); seedPhones(db);
    }
    @Override public void onUpgrade(SQLiteDatabase db,int o,int n){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TBL_CAR+" (id INTEGER PRIMARY KEY AUTOINCREMENT, brand TEXT NOT NULL, model TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TBL_PHONE+" (id INTEGER PRIMARY KEY AUTOINCREMENT, brand TEXT NOT NULL, model TEXT NOT NULL, price REAL NOT NULL)");
    }
    private void seedCars(SQLiteDatabase db){
        ContentValues cv=new ContentValues();
        cv.put("brand","Toyota"); cv.put("model","Yaris"); db.insert(TBL_CAR,null,cv);
        cv.clear(); cv.put("brand","Honda"); cv.put("model","Civic"); db.insert(TBL_CAR,null,cv);
        cv.clear(); cv.put("brand","Mazda"); cv.put("model","2"); db.insert(TBL_CAR,null,cv);
    }
    private void seedPhones(SQLiteDatabase db){
        ContentValues cv=new ContentValues();
        cv.put("brand","Xiaomi"); cv.put("model","Redmi Note 13"); cv.put("price",6990); db.insert(TBL_PHONE,null,cv);
        cv.clear(); cv.put("brand","Samsung"); cv.put("model","Galaxy A55"); cv.put("price",12990); db.insert(TBL_PHONE,null,cv);
        cv.clear(); cv.put("brand","Apple"); cv.put("model","iPhone 13"); cv.put("price",18900); db.insert(TBL_PHONE,null,cv);
    }
    public List<Car> getAllCars(){
        ArrayList<Car> list=new ArrayList<>(); SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT id,brand,model FROM "+TBL_CAR+" ORDER BY id DESC",null);
        try{ while(c.moveToNext()) list.add(new Car(c.getInt(0),c.getString(1),c.getString(2))); } finally{ c.close(); }
        return list;
    }
    public List<Phone> getAllPhones(){
        ArrayList<Phone> list=new ArrayList<>(); SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT id,brand,model,price FROM "+TBL_PHONE+" ORDER BY id DESC",null);
        try{ while(c.moveToNext()) list.add(new Phone(c.getInt(0),c.getString(1),c.getString(2),c.getDouble(3))); } finally{ c.close(); }
        return list;
    }
}
