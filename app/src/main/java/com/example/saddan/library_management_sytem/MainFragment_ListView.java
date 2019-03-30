package com.example.saddan.library_management_sytem;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainFragment_ListView extends Fragment
{

    private ListView listView;
    private Button addBookbtn;
    private UserPrefferences userPrefferences;
    private MainFragmentInterface gotoAddbookInterface;
    public MainFragment_ListView()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fargment_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
            userPrefferences=new UserPrefferences(getActivity());
           listView=view.findViewById(R.id.list_viewID);
        addBookbtn=view.findViewById(R.id.addBook_btnID);
        if(userPrefferences.getAdminLoginStatus())
        {
            addBookbtn.setVisibility(view.VISIBLE);
        }

        addBookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                  gotoAddbookInterface= (MainFragmentInterface) getActivity();
                  gotoAddbookInterface.gotoAddbookFragment();
            }
        });

        Add_Book_source add_book_source=new Add_Book_source(getActivity());
        ArrayList<Add_BooK_Pojo_Class> addbook=add_book_source.getAllBook();
        Book_list_view_adapter book_list_adapter=new Book_list_view_adapter(getActivity(),addbook);
        listView.setAdapter(book_list_adapter);

    }

    interface MainFragmentInterface{
        void gotoAddbookFragment();
    }
}
