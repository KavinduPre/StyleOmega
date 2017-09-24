package com.example.kavindu.styleomega;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.kavindu.styleomega.R.layout.activity_main_menu;

public class MainMenu extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(activity_main_menu);


    }

    public void ExploreButton(View v)
    {
       Intent intent=new Intent(MainMenu.this,  Explore.class);
        startActivity(intent);
    }


    public void LoginButton(View v)
    {

        Intent intent=new Intent(MainMenu.this,Login.class);
        startActivity(intent);
    }

    public void RegisterButton(View v)
    {
         Intent intent=new Intent(MainMenu.this,Register.class);
         startActivity(intent);
    }



}
