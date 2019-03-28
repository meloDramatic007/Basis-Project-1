package com.example.saddan.library_management_sytem;

public class Add_BooK_Pojo_Class
{
    private String Bookname;
    private String writer_name;
    private String Genera;
    private  String price;
    private String _id;

    public Add_BooK_Pojo_Class(String book_title, String writer_name, String book_genera, String price) {
        Bookname = book_title;
        this.writer_name = writer_name;
        Genera = book_genera;
        this.price = price;
    }

    public Add_BooK_Pojo_Class(String bookstring, String writer_name, String genera, String price, String _id)
    {
        Bookname = bookstring;
        this.writer_name = writer_name;
        Genera = genera;
        this.price = price;
        this._id = _id;
    }

    public String getBookstring() {
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

    public String get_id() {
        return _id;
    }

}
