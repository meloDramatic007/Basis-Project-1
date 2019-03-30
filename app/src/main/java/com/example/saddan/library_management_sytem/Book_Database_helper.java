package com.example.saddan.library_management_sytem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Book_Database_helper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME="db_book";
    public static int VERSION=3;
    public  static final String BOOK_TABLE_NAME="tbl_book";
    public  static final String BOOK_COL_ID="id";
    public  static final String BOOK_COL_BOOKNAME="book_name";
    public  static final String BOOK_COL_BOOKWRITER="writer_name";
    public  static final String BOOK_COL_BOOKGENERA="book_genera";
    public  static final String BOOK_COL_PRICE="book_price";

    public static  final  String CREAT_TABLE_BOOK="CREATE TABLE  "+
            BOOK_TABLE_NAME+"("+
            BOOK_COL_ID+" INTEGER PRIMARY KEY,"+
            BOOK_COL_BOOKNAME +" TEXT,"+
            BOOK_COL_BOOKWRITER+" TEXT,"+
            BOOK_COL_BOOKGENERA+" TEXT,"+
            BOOK_COL_PRICE+" TEXT"+")";


    public Book_Database_helper( Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
           db.execSQL(CREAT_TABLE_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
