package com.example.kelascsqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    public DBController(Context context) {
        super(context, "ProdiTI", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table teman (id integer primary key, nama text, telpon text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists teman");
        onCreate(db);
    }

    public void insertData(HashMap<String, String> queryValues){
        SQLiteDatabase basisData = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama",queryValues.get("nama"));
        nilai.put("telpon",queryValues.get("telpon"));
        basisData.insert("teman", null, nilai);
        basisData.close();
    }

    public ArrayList<HashMap<String, String>> getAllTeman(){
        ArrayList<HashMap<String, String>> daftarTeman = new ArrayList<HashMap<String, String>>();

        String query = "SELECT * FROM teman";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id",cursor.getString(0));
                map.put("nama",cursor.getString(1));
                map.put("telpon",cursor.getString(2));
                daftarTeman.add(map);
            }while(cursor.moveToNext());
        }
        return daftarTeman;
    }

    public void updateData(HashMap<String, String> queryValues){
        SQLiteDatabase basisData = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama",queryValues.get("nama"));
        nilai.put("telpon",queryValues.get("telpon"));
        basisData.update("teman", nilai, "id = ?", new String[]{queryValues.get("id")});
        basisData.close();
    }

    public void deleteData(String id){
        SQLiteDatabase basisData = this.getWritableDatabase();
        basisData.delete("teman", "id = ?", new String[]{id});
        basisData.close();
    }
}
