package com.example.saddan.library_management_sytem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Book_list_view_adapter extends ArrayAdapter
{
    private Context context;
    private ArrayList<Add_BooK_Pojo_Class> addBooK;

    public Book_list_view_adapter( Context context, ArrayList<Add_BooK_Pojo_Class> addBooK)
    {
        super(context,R.layout.book_list_view_adapter_layout,addBooK);
        this.context=context;
        this.addBooK=addBooK;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent)
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.book_list_view_adapter_layout,parent,false);


        TextView BookName=convertView.findViewById(R.id.book_name_adapterID);
        TextView WriterName=convertView.findViewById(R.id.writer_name_adapterID);
        TextView Genera=convertView.findViewById(R.id.genera_adapterID);
        TextView Price=convertView.findViewById(R.id.price_adapterID);


        BookName.setText(addBooK.get(position).getBook_name());
        WriterName.setText(addBooK.get(position).getWriter_name());
        Genera.setText(addBooK.get(position).getGenera());
        Price.setText(addBooK.get(position).getPrice());

        return convertView;
    }
}
