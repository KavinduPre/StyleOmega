package com.example.kavindu.styleomega;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ManageAccout extends AppCompatActivity {
    DB_Con update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_accout);
        update=new DB_Con(this);


    }
}
