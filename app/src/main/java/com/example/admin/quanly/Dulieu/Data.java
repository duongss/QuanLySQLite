package com.example.admin.quanly.Dulieu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.quanly.Doituong.Sach;

import java.util.ArrayList;
public class Data extends SQLiteOpenHelper {
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "data";
    private static final String TABLE_NAME = "Exx";
    private static final String KEY_ID = "Id";
    private static final String KEY_NAME = "Ten";
    private static final String KEY_MOTA = "Mota";
    private static final String KEY_GIATIEN = "Giatien";
    public Data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE ="CREATE TABLE "+ TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT," + KEY_MOTA
                + " TEXT,"  + KEY_GIATIEN + " TEXT"+")";
       db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    ///
    public void addS(Sach sach)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,sach.getTensach());
        values.put(KEY_MOTA,sach.getMota());
        values.put(KEY_GIATIEN,sach.getGiatien());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public int update(Sach sach)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,sach.getTensach());
        values.put(KEY_MOTA,sach.getMota());
        values.put(KEY_GIATIEN,sach.getGiatien());
        return db.update(TABLE_NAME,values,KEY_ID+" =?",new String[]{String.valueOf(sach.getId())});
    }

    public void delete(Sach sach){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,KEY_ID+" =?",new String[]{String.valueOf(sach.getId())});
        db.close();
    }
    public ArrayList<Sach> getAll(){
        ArrayList<Sach> lists = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Sach sach = new Sach();
                sach.setId(cursor.getInt(0));
                sach.setTensach(cursor.getString(1));
                sach.setMota(cursor.getString(2));
                sach.setGiatien(cursor.getInt(3));
                lists.add(sach);

            }
            while(cursor.moveToNext());

        }
        return lists;
    }

}
