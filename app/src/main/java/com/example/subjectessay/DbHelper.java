package com.example.subjectessay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context)  {
        super(context, "subject_essay", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script = "CREATE TABLE SCHEDULE ( id int primary key, TENTHUOC text, GHICHU text, THOIGIAN datetime, MABENHNHAN int)";
        sqLiteDatabase.execSQL(script);
//        script = "CREATE TABLE PATIENT ( mabenhnhan text primary key, tenbenhnhan text, matkhau text )";
//        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SCHEDULE");
    }

    public void addFirst() {
        Schedule schedule = new Schedule(1, "Banadon","Sau khi an");
        Schedule schedule1 = new Schedule(2, "vitamin","Khi met");
        Schedule schedule2 = new Schedule(3, "thuoc ngu","truoc khi ngu");
        insertSchedule(schedule);
        insertSchedule(schedule1);
        insertSchedule(schedule2);
    }

    public int insertSchedule(Schedule schedule) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", schedule.getId());
        contentValues.put("TENTHUOC", schedule.getTenThuoc());
        contentValues.put("GHICHU", schedule.getGhiChu());
        int result =(int)sqLiteDatabase.insert("SCHEDULE", null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public ArrayList<Schedule> getMySchedule(int id) {
        ArrayList<Schedule> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from SCHEDULE", null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        while(cursor.isAfterLast() == false){
            list.add(new Schedule(cursor.getInt(0), cursor.getString(1), cursor.getString(0)));
            cursor.moveToNext();
        }
        cursor.close();
        sqLiteDatabase.close();
        return  list;
    }

}
