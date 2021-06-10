package com.example.schoolapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentData extends SQLiteOpenHelper {
    public static final int STUDENT_VERSION=1;
    public static final String STUDENT_TABLE = "STUDENT_TABLE";
    public static final String COL_STUDENT_NAME = "STUDENT_NAME";
    public static final String COL_STUDENT_ROLLnO = "STUDENT_ROLLnO";
    public static final String COL_STUDENT_PHONE = "STUDENT_PHONE";
    public static final String COL_STUDENT_FATHER = "STUDENT_FATHER";
    public static final String COL_STUDENT_MOTHER = "STUDENT_MOTHER";
    public static final String COL_STUDENT_EMAIL = "STUDENT_EMAIL";
    public static final String COL_STUDENT_ADDRESS = "STUDENT_ADDRESS";
    public static final String COL_STUDENT_AGE = "STUDENT_AGE";

    public StudentData(@Nullable Context context) {
        super(context, "Student.db", null, STUDENT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + STUDENT_TABLE + "(" + COL_STUDENT_ROLLnO + " Text," + COL_STUDENT_NAME + " TEXT,"
                + COL_STUDENT_FATHER + " TEXT," + COL_STUDENT_MOTHER + " TEXT," + COL_STUDENT_PHONE + " TEXT,"
                + COL_STUDENT_AGE + " INT," + COL_STUDENT_EMAIL + " TEXT," + COL_STUDENT_ADDRESS + " TEXT " + ")";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+STUDENT_TABLE);
        onCreate(db);
    }

    public boolean addOne(StudentModel studentModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_STUDENT_ROLLnO, studentModel.getRollNo());
        cv.put(COL_STUDENT_NAME, studentModel.getName());
        cv.put(COL_STUDENT_FATHER, studentModel.getFather());
        cv.put(COL_STUDENT_MOTHER, studentModel.getMother());
        cv.put(COL_STUDENT_PHONE, studentModel.getPhone());
        cv.put(COL_STUDENT_AGE, studentModel.getAge());
        cv.put(COL_STUDENT_EMAIL, studentModel.getEmail());
        cv.put(COL_STUDENT_ADDRESS, studentModel.getAddress());
        long insert = db.insert(STUDENT_TABLE, null, cv);
        return insert != -1;
    }

    public List<StudentModel> getEveryone() {
        List<StudentModel> returnList = new ArrayList<>();
        String query = "SELECT * FROM " + STUDENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String  studentRoll=cursor.getString(0);
             String studentName=cursor.getString(1);
             String studentFather=cursor.getString(2);
             String studentMother=cursor.getString(3);
             String studentPhone=cursor.getString(4);
                String studentAge=cursor.getString(5);
             String studentEmail=cursor.getString(6);
             String studentAddress=cursor.getString(7);
                StudentModel studentModel=new StudentModel(studentRoll,studentName,studentFather,studentMother,studentPhone,studentAge,studentEmail,studentAddress);
                returnList.add(studentModel);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
