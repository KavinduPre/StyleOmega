package com.example.kavindu.styleomega;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static EditText uname,pw;
    private static Button Login;
    DB_Con log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton();
    }

    public void LoginButton()
    {
        uname=(EditText)findViewById(R.id.login_uname);
        pw=(EditText)findViewById(R.id.login_pw);
        Login=(Button)findViewById(R.id.login_button);

        Login.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if (uname.getText().toString().equals("k") && pw.getText().toString().equals("k"))
                        {
                            Toast.makeText(Login.this, "Welcome "+uname.getText().toString()+"", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Login.this, Explore.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(Login.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                            Toast.makeText(Login.this,"Try Again",Toast.LENGTH_SHORT).show();

                        }
                    }
                }
        );

    }



}
