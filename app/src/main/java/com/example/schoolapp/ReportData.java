package com.example.schoolapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ReportData extends SQLiteOpenHelper {
    public static final int REPORT_VERSION=1;
    public static final String REPORT_TABLE = "REPORT_TABLE";
    public static final String COL_STUDY="COL_STUDY";
    public static final String COL_MATHS="COL_MATHS";
    public static final String COL_SCIENCE="COL_SCIENCE";
    public static final String COL_SOCIAL="COL_SOCIAL";
    public static final String COL_HINDI="COL_HINDI";
    public static final String COL_ENGLISH="COL_ENGLISH";
    public static final String COL_COMPUTER="COL_COMPUTER";
    public static final String COL_TOTAL="COL_TOTAL";

    public ReportData(@Nullable Context context) {
        super(context, "Report.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String report="CREATE TABLE "+REPORT_TABLE+"("+COL_STUDY+" TEXT,"+COL_MATHS+" INT,"
                +COL_SCIENCE+"  INT,"+COL_SOCIAL+"  INT,"+COL_HINDI+"  INT,"
                +COL_ENGLISH+"  INT,"+COL_COMPUTER+"  INT,"+COL_TOTAL+" TEXT"+")";
        db.execSQL(report);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+REPORT_TABLE);
        onCreate(db);
    }
    public boolean addMarks(Report report) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_STUDY,report.getStudy());
        cv.put(COL_MATHS,report.getMaths());
        cv.put(COL_SCIENCE,report.getScience());
        cv.put(COL_SOCIAL,report.getSocial());
        cv.put(COL_HINDI,report.getHindi());
        cv.put(COL_ENGLISH,report.getEnglish());
        cv.put(COL_COMPUTER,report.getComputer());
        cv.put(COL_TOTAL,report.getTotal());
        long insert = db.insert(REPORT_TABLE, null, cv);
        return insert != -1;
    }
    public List<Report> getMarks() {
        List<Report> returnReport = new ArrayList<>();
        String query = "SELECT * FROM " + REPORT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String study = cursor.getString(0);
                int maths = cursor.getInt(1);
                int science = cursor.getInt(2);
                int social = cursor.getInt(3);
                int hindi = cursor.getInt(4);
                int english = cursor.getInt(5);
                int computer = cursor.getInt(6);
                String total = cursor.getString(7);
                Report report = new Report(study, maths, science, social, hindi, english, computer, total);
                returnReport.add(report);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnReport;
    }
}
