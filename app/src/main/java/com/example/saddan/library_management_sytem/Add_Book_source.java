package com.example.saddan.library_management_sytem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.util.ArrayList;

public class Add_Book_source
{
    private Book_Database_helper book_database_helper;
    SQLiteDatabase db;
    public Add_Book_source(Context context)
    {
          book_database_helper=new Book_Database_helper(context);
    }

    public  void connectionOpen()
    {
        db=book_database_helper.getWritableDatabase();
    }
    public void connectionClose()
    {
        db.close();
    }
    public boolean saveBookinformation(Add_BooK_Pojo_Class addBook)
    {
        connectionOpen();

        ContentValues contentValues=new ContentValues();
        contentValues.put(book_database_helper.BOOK_COL_BOOKNAME,addBook.getBook_name());
        contentValues.put(book_database_helper.BOOK_COL_BOOKWRITER,addBook.getWriter_name());
        contentValues.put(book_database_helper.BOOK_COL_BOOKGENERA,addBook.getGenera());
        contentValues.put(book_database_helper.BOOK_COL_PRICE,addBook.getPrice());

        long rowAffected=db.insert(book_database_helper.BOOK_TABLE_NAME,null,contentValues);
        connectionClose();

        if(rowAffected>0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<Add_BooK_Pojo_Class>getAllBook()
    {
        ArrayList<Add_BooK_Pojo_Class> booklist=new ArrayList<>();
        connectionOpen();
        Cursor cursor=db.query(book_database_helper.BOOK_TABLE_NAME,null,null,null,null,
                null,null);
        if(cursor!=null && cursor.getCount()>0)
        {
            cursor.moveToFirst();

            do {
                int id = cursor.getInt(0);
                String Bookname = cursor.getString(1);
                String Writername = cursor.getString(2);
                String genera = cursor.getString(3);
                String price = cursor.getString(4);

                Add_BooK_Pojo_Class addBooKPojoClass = new Add_BooK_Pojo_Class( Bookname, Writername, genera, price,id);
                booklist.add(addBooKPojoClass);
            }while (cursor.moveToNext());
        }
        connectionClose();
        return booklist;
    }
}
