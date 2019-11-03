package com.example.subjectessay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context)  {
        super(context, "subject_essay", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        onUpgrade(sqLiteDatabase,0,0);
        String script = "CREATE TABLE SCHEDULE ( id int primary key, TENTHUOC text, GHICHU text, GIO text, NGAY text, MABENHNHAN int)";
        sqLiteDatabase.execSQL(script);
//        script = "CREATE TABLE PATIENT ( mabenhnhan text primary key, tenbenhnhan text, matkhau text )";
//        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SCHEDULE");
    }

    public void addFirst() {
        Schedule schedule = new Schedule(1, "Banadon", new Date(), new Date(),"Sau khi an1");
//        Schedule schedule1 = new Schedule(2, "vitamin", new Date(), new Date(),"Khi met");
//        Schedule schedule2 = new Schedule(3, "thuoc ngu", new Date(), new Date(),"truoc khi ngu");
        insertSchedule(schedule);
//        insertSchedule(schedule1);
//        insertSchedule(schedule2);
    }

    public int insertSchedule(Schedule schedule) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", schedule.getId());
        contentValues.put("TENTHUOC", schedule.getTenThuoc());
        contentValues.put("GHICHU", schedule.getGhiChu());
        contentValues.put("GIO", schedule.getHourFormat(schedule.getGio()));
        contentValues.put("NGAY", schedule.getDateFormat(schedule.getNgay()));
        contentValues.put("MABENHNHAN", 1);
        int result = (int)sqLiteDatabase.insert("SCHEDULE", null, contentValues);
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
            String ngayString = cursor.getString(4);
            String gioString = cursor.getString(3);

            try {
                Date ngay = new SimpleDateFormat("dd/MM/yyyy").parse(ngayString);
                Date gio = new SimpleDateFormat("hh:mm a").parse(gioString);
                list.add(new Schedule(cursor.getInt(0), cursor.getString(1), gio, ngay, cursor.getString(4)));

            }
            catch (Exception e){

            }
//            list.add(new Schedule(cursor.getInt(0), cursor.getString(1), new Date(), new Date(), cursor.getString(4)));

            cursor.moveToNext();
        }
        cursor.close();
        sqLiteDatabase.close();
        return  list;
    }

    public boolean deleteAll(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String sql = "delete from SCHEDULE";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
        return true;
    }

}
