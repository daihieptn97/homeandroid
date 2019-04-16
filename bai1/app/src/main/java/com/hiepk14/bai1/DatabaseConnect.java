package com.hiepk14.bai1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseConnect extends SQLiteOpenHelper {
    private Context context;
    private String TB_NAME = "QLSV";
    private String KEY_ID = "ID";
    private String KEY_NAME = "NAME";
    private String KEY_DATE = "DATE";
    private String KEY_SCHOOL = "SCHOOL";
    private String KEY_SEX = "SEX";
    private String KEY_LIKE_BONGDA = "bongda";
    private String KEY_LIKE_BONGCHUYEN = "bonchuyen";
    private String KEY_LIKE_BONGRO = "bongro";


    public DatabaseConnect(Context context) {
        super(context, "db.qlsv", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "CREATE TABLE IF NOT EXISTS " + TB_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  , " + KEY_NAME + " TEXT, " + KEY_DATE + " TEXT, "
                + KEY_SCHOOL + " TEXT, "
                + KEY_SEX + " TEXT, "
                + KEY_LIKE_BONGDA + " TEXT, "
                + KEY_LIKE_BONGCHUYEN + " TEXT, "
                + KEY_LIKE_BONGRO + " TEXT "
                + ")";

        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(SinhVien sv) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, sv.getName());
        contentValues.put(KEY_DATE, sv.getDate());
        contentValues.put(KEY_SCHOOL, sv.getSchool());
        contentValues.put(KEY_SEX, sv.getSex());
        contentValues.put(KEY_LIKE_BONGCHUYEN, sv.getBongchuyen());
        contentValues.put(KEY_LIKE_BONGDA, sv.getBongda());
        contentValues.put(KEY_LIKE_BONGRO, sv.getBongro());

        return db.insert(TB_NAME, null, contentValues);
    }

    //    int id, String name, String date, String school, int sex, int bongda, int bongro, int bongchuyen
    public ArrayList<SinhVien> getAllData() {
        ArrayList listSv = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TB_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            listSv.add(
                    new SinhVien(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getInt(4),
                            cursor.getInt(5),
                            cursor.getInt(6),
                            cursor.getInt(7)
                    )
            );

            cursor.moveToNext();
        }

        return listSv;
    }

    public int delete(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String args[] = {name};
        return db.delete(TB_NAME, KEY_NAME + " =?", args);

    }

    public int update(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_DATE, sv.getDate());
        contentValues.put(KEY_SCHOOL, sv.getSchool());
        contentValues.put(KEY_SEX, sv.getSex());
        contentValues.put(KEY_LIKE_BONGCHUYEN, sv.getBongchuyen());
        contentValues.put(KEY_LIKE_BONGDA, sv.getBongda());
        contentValues.put(KEY_LIKE_BONGRO, sv.getBongro());

        String args[] = {sv.getName()};

        return db.update(TB_NAME, contentValues, KEY_NAME = " =?", args);
//        return 0;
    }
}
