package com.example.rk.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by DSU on 05-May-16.
 */
public class UserDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="usercontact_db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY = "CREATE TABLE " + UserInformation.NewUserInfo.TABLE_NAME+ "(" + UserInformation.NewUserInfo.USER_NAME + " text," + UserInformation.NewUserInfo.USER_EMAIL + " text," + UserInformation.NewUserInfo.MOBILE_NUMBER + " text," + UserInformation.NewUserInfo.USER_ADDRESS + " text," + UserInformation.NewUserInfo.USER_PASSWORD + " text," + UserInformation.NewUserInfo.USER_CONPWD + " text);";

    public UserDBHelper(Context context)
    {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATION", "database created/opened...");
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATION", "table created...");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
    public void AddInformation(String name, String email, String mobno, String address, String pwd, String conpwd, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserInformation.NewUserInfo.USER_NAME, name);
        contentValues.put(UserInformation.NewUserInfo.USER_EMAIL, email);
        contentValues.put(UserInformation.NewUserInfo.MOBILE_NUMBER, mobno);
        contentValues.put(UserInformation.NewUserInfo.USER_ADDRESS, address);
        contentValues.put(UserInformation.NewUserInfo.USER_PASSWORD, pwd);
        contentValues.put(UserInformation.NewUserInfo.USER_CONPWD, conpwd);

        db.insert(UserInformation.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATION", "New Row Added/Inserted...");
    }
}
