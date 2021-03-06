package com.example.saddan.library_management_sytem;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Add_Book_Fragment extends Fragment implements View.OnClickListener
{
    EditText Book_Title,Writer_Name,Book_Genera,Price;
    Button Add_To_ListBtn;

    public Add_Book_Fragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add__book_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Book_Title=view.findViewById(R.id.book_title_ID);
        Writer_Name=view.findViewById(R.id.writer_nameID);
        Book_Genera=view.findViewById(R.id.book_generaID);
        Price=view.findViewById(R.id.price_ID);
        Add_To_ListBtn=view.findViewById(R.id.add_tolist_btn_ID);
        Add_To_ListBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.add_tolist_btn_ID:
            {
                String book_title,writer_name,book_genera,price;

                book_title=Book_Title.getText().toString();
                writer_name=Writer_Name.getText().toString();
                book_genera=Book_Genera.getText().toString();
                price=Price.getText().toString();


               Add_BooK_Pojo_Class addBook=new Add_BooK_Pojo_Class(book_title,writer_name,book_genera,price);

               Add_Book_source book_source=new Add_Book_source(getActivity());
               boolean saveBookinformation=book_source.saveBookinformation(addBook);
               if(saveBookinformation)
               {
                   Toast.makeText(getActivity(), "Saved Sucessfully", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(getActivity(), "Failed....", Toast.LENGTH_SHORT).show();
               }
                break;
            }
        }
    }
}
