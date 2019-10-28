package com.example.subjectessay;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context)  {
        super(context, "subject_essay", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script = "CREATE TABLE SCHEDULE ( id int primary key, TENTHUOC text, GHICHU text, THOIGIAN datetime, MABENHNHAN int)";
        sqLiteDatabase.execSQL(script);
        script = "CREATE TABLE PATIENT ( mabenhnhan text primary key, tenbenhnhan text, matkhau text )";
        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
