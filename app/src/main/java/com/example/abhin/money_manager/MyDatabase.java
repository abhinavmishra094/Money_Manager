package com.example.abhin.money_manager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Blob;


public class MyDatabase
{
    MyDatabaseHelper myDatabaseHelper;

    SQLiteDatabase sqLiteDatabase;

    public MyDatabase(Context context)
    {
        myDatabaseHelper = new MyDatabaseHelper(context,"money.db",null,1);
    }

    public void  open()
    {
        sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
    }

    public void close()
    {
        sqLiteDatabase.close();
    }

    public Cursor getTransactions()
    {
        Cursor transaction  =null;

        transaction = sqLiteDatabase.query("transactions",null,null,null,null,null,null);



        return transaction;
    }

    public Cursor getTransactionsReverse()
    {
        Cursor transaction  =null;


        transaction = sqLiteDatabase.query("transactions",null,null,null,null,null,"_id Desc");



        return transaction;
    }
    public  void insertTransaction(int amount , String type, String category, String date, String time,int blob)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("amount",amount);
        contentValues.put("type",type);
        contentValues.put("category",category);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("image", blob);

        sqLiteDatabase.insert("transactions",null,contentValues);

    }
    public  class  MyDatabaseHelper extends SQLiteOpenHelper {
        public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL("create table transactions(_id integer primary key,amount integer,type text,category text,date text,time text ,image int);");


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }


}


