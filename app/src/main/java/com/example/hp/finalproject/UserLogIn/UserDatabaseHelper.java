package com.example.hp.finalproject.UserLogIn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Users.db" ;
    public static final String TABLE_NAME = "User_table" ;
    public static final String COL_1 = "Username" ;
    public static final String COL_2 = "Email" ;
    public static final String COL_3 = "Password" ;

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME+ "(Username TEXT PRIMARY KEY ," +
                " Email TEXT, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

//insert user in database

    public boolean insertData(String username , String email , String password ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues() ;
        contentValues.put(COL_1,username);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,password);
        long result = db.insert(TABLE_NAME , null , contentValues) ;
        if (result == -1) return false ;
        else return true ;
    }

    public boolean checkUser(String username) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?",new String[]{username}) ;
        if (cursor.getCount()>0) return false ;
        else return true ;
    }
}
