package com.example.crudop;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.support.annotation.Nullable;
//Akimport android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(@Nullable Context context)
    {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create Table Userdetails(name TEXT primary key, contact TEXT,age TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("drop table if exists Userdetails");
    }
    public boolean insertData(String name,String contact,String age)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("name",name);
        contentvalues.put("contact",contact);
        contentvalues.put("age",age);
        long result = db.insert("Userdetails",null,contentvalues);
        if(result==-1)return false;
        else return true;

    }

    public boolean updateData(String name,String contact,String age)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact",contact);
        contentValues.put("age",age);
        Cursor cursor = db.rawQuery("select * from Userdetails where name = ?",new String[] {name});
        if (cursor.getCount()>0)
        {
            long result = db.update("Userdetails", contentValues, "name=?", new String[] {name});
            if (result == -1)return false;
            else return true;
        }

        else return false;
    }

    public boolean deleteData(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        Cursor cursor = db.rawQuery("select * from Userdetails where name = ?",new String[] {name});
        if (cursor.getCount()>0)
        {
            long result = db.delete("Userdetails", "name=?", new String[] {name});
            if (result == -1)return false;
            else return true;
        }

        else return false;
    }
    public Cursor viewData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetails",null);
        return cursor;
    }
}
