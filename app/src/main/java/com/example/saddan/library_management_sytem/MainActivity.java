package com.example.saddan.library_management_sytem;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private FragmentManager fragmentManager;
    private UserPrefferences userPrefferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         userPrefferences=new UserPrefferences(this);

        fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();

        MainFragment_ListView mainFragment_listView=new MainFragment_ListView();
        ft.add(R.id.fragment_containerID,mainFragment_listView);
        ft.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem LoginAdmin=menu.findItem(R.id.admin_loginID);
        MenuItem LogOut=menu.findItem(R.id.log_outID);

        if(userPrefferences.getAdminLoginStatus())
        {
            LoginAdmin.setVisible(false);
            LogOut.setVisible(true);
        }
        else
        {
            LoginAdmin.setVisible(true);
            LogOut.setVisible(false);
        }
        return true;
    }

    public void AdminLoginClick(MenuItem item)
    {

       final Dialog dialog=new Dialog(this);
       dialog.setContentView(R.layout.dialog_admin_loggin);
        Button enter=dialog.findViewById(R.id.enter_btnID);

        final Intent reStart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        reStart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                userPrefferences.setAdminLoginStatus(true);
                Toast.makeText(MainActivity.this, "Loggin successful", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                startActivity(reStart);
            }
        });
       dialog.show();


    }


    public void Log_outClick(MenuItem item)
    {
        final Intent reStart = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        reStart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if(userPrefferences.getAdminLoginStatus())
        {
            userPrefferences.setAdminLoginStatus(false);
            Toast.makeText(this, "Admin Logout successfully", Toast.LENGTH_SHORT).show();
            startActivity(reStart);
        }
    }
}
