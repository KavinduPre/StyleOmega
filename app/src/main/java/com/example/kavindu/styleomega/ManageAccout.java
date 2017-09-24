package com.example.kavindu.styleomega;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class ManageAccout extends AppCompatActivity {
    DB_Con update=new DB_Con(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_accout);

        EditText unmae=(EditText)findViewById(R.id.login_uname);
        update.getDetails(unmae.getText().toString());
        TextView txt=(TextView) findViewById(R.id.textView);
        String text=update.getMfname();
        txt.setText(text);



    }



}
