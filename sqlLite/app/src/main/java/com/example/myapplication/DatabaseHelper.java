package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int version = 1;
    public static String dbName = "Company.db";
    public static final String TABLE_NAME = "Empdata";
    public static final String COL1 = "id";
    public static final String COL2 = "name";
    public static final String COL3 = "dept";
    public static final String COL4 = "age";
    public static final String COL5 = "ph_no";
    private static final String CREATE_TABLE = "create table if not exists " + TABLE_NAME + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL2 + " TEXT NOT NULL," + COL3 + " TEXT, " + COL4 + " INTEGER," + COL5+ " TEXT);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private Context context;



    public DatabaseHelper(Context context) {
        super(context,dbName,null,version);
        context=this.context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {}
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
        public boolean InsertEmployee(Employee objEmp)   {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COL2,objEmp.getEmployeeName());
            cv.put(COL3,objEmp.getEmployeeDept());
            cv.put(COL4,objEmp.getEmployeeAge());
            cv.put(COL5,objEmp.getEmployeePh());
            long result = db.insert(TABLE_NAME,null,cv);
            if(result == -1)
                return false;
            else
                return true;
    }
}