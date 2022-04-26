package com.example.trabalhopdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SymbolTable;
import android.security.identity.EphemeralPublicKeyNotFoundException;

import java.util.ArrayList;

public class dataBase extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String sqltablecreate = "CREATE TABLE SAVED_TABLE (COLUMN_TITLE TEXT, COLUMN_TEXT TEXT)";
            sqLiteDatabase.execSQL(sqltablecreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SAVED_TABLE");
    }

    public dataBase(Context con){
        super(con,  "saved_results.db",null,1);
    }

    public void addResult(String title, String text){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues sv = new ContentValues();
        sv.put("COLUMN_TITLE",title);
        sv.put("COLUMN_TEXT",text);
        sql.insert("SAVED_TABLE",null,sv);
    }

    public ArrayList <String> readTitles(){
        ArrayList <String> a = new ArrayList<String>();
        SQLiteDatabase sql = this.getReadableDatabase();
        Cursor sv = sql.rawQuery("SELECT COLUMN_TITLE FROM SAVED_TABLE",null);
        while(sv.moveToNext()){
            a.add(sv.getString(0));
        }
        return a;
    }

    public String readText(String title){
        ArrayList <String> a = new ArrayList<String>();
        SQLiteDatabase sql = this.getReadableDatabase();
        Cursor sv = sql.rawQuery("SELECT COLUMN_TEXT FROM SAVED_TABLE WHERE COLUMN_TITLE='"+title+"'",null);
        while(sv.moveToNext()){
            a.add(sv.getString(0));
        }
        return a.get(0);
    }
}
