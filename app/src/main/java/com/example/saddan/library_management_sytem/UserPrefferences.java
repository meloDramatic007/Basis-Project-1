package com.example.saddan.library_management_sytem;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPrefferences
{
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public UserPrefferences(Context context)
    {
        sharedPreferences=context.getSharedPreferences("user_preff",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void setAdminLoginStatus(boolean adminStatus)
    {
        editor.putBoolean("AdminStatus",adminStatus);
        editor.commit();
    }

    public boolean getAdminLoginStatus()
    {
        return  sharedPreferences.getBoolean("AdminStatus",false);
    }

}
