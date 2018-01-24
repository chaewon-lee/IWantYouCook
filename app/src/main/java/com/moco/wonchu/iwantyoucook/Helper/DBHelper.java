package com.moco.wonchu.iwantyoucook.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    ImageHelper imageHelper = new ImageHelper();

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        db.execSQL("CREATE TABLE RECIPES( _id INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT,"
                + "recipeName TEXT, author TEXT, uploardDate TEXT, howTo TEXT, description TEXT,"
                + "thumbnail BLOB, mainImg BLOB, likeCount INTEGER);");

        db.execSQL("CREATE TABLE INGREDIENTS( _id INTEGER PRIMARY KEY AUTOINCREMENT, recipeID INTEGER, ingreName TEXT);");

        db.execSQL("CREATE TABLE LIKECOUNT( _id INTEGER PRIMARY KEY AUTOINCREMENT, userID TEXT, recipeID INTEGER);");

        db.execSQL("CREATE TABLE USER( _id INTEGER PRIMARY KEY AUTOINCREMENT, userID TEXT, password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void user_Insert(String userid, String password) {
        // open read and write database
        SQLiteDatabase db = getWritableDatabase();
        // execute insert query
        db.execSQL("INSERT INTO USER VALUES(null, '" + userid + "', '" + password + "');");

        db.close();
    }

    //registration check function
    public boolean user_IsUsernameFree(String userId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE userID = '" + userId + "'", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                return false;
            }
        }
        cursor.close();
        db.close();
        return true;
    }

    //login function
    public boolean user_Login(String userId, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE userID = '" + userId + "' AND password = '" + password + "'", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                return true;
            }
        }
        cursor.close();
        db.close();
        return false;
    }

    public int user_Allcount() {
        // Open available reading database
        SQLiteDatabase db = getReadableDatabase();
        int count = 0;
        // Get all recipes data
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM USER", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                count = cursor.getInt(0);
            }
        }
        cursor.close();
        db.close();

        return count;
    }


}