package com.example.saddan.library_management_sytem;

import java.io.Serializable;

public class Add_BooK_Pojo_Class implements Serializable
{
    private String Bookname;
    private String writer_name;
    private String Genera;
    private  String price;
    private int id;

    public Add_BooK_Pojo_Class(String book_title, String writer_name, String book_genera, String price) {
        Bookname = book_title;
        this.writer_name = writer_name;
        Genera = book_genera;
        this.price = price;
    }

    public Add_BooK_Pojo_Class(String Bookname, String Writername, String genera, String price, int id)
    {
        Bookname = Bookname;
        this.writer_name = Writername;
        Genera = genera;
        this.price = price;
        this.id = id;
    }

    public String getBook_name() {
        return Bookname;
    }

    public String getWriter_name() {
        return writer_name;
    }

    public String getGenera() {
        return Genera;
    }

    public String getPrice() {
        return price;
    }

    public int get_id() {
        return  id;
    }

}
