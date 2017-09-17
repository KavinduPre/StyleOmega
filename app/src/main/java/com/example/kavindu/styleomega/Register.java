package com.example.kavindu.styleomega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DB_Con styleomega;
    EditText fname,lname,uname,pw,email;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        styleomega=new DB_Con(this);
        fname=(EditText)findViewById(R.id.rfname);
        lname=(EditText)findViewById(R.id.rlname);
        uname=(EditText)findViewById(R.id.runame);
        pw=(EditText)findViewById(R.id.rpw);
        email=(EditText)findViewById(R.id.remail);
        register=(Button)findViewById(R.id._register);
        register();
    }




    public void register(){
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean done=styleomega.register(fname.getText().toString(),lname.getText().toString(),uname.getText().toString(),pw.getText().toString(),email.getText().toString());
                        if(done==true) {
                            Toast.makeText(Register.this, "You Are Registered", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Register.this, Explore.class);
                            startActivity(intent);

                        }
                        else
                            Toast.makeText(Register.this,"DataBase Error",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
