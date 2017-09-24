package com.example.kavindu.styleomega;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText uname,pw;
    private static Button Login;
    String loginFeedback;
    DB_Con login=new DB_Con(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login=(Button)findViewById(R.id.login_button);
        LoginButton();
    }


    public void LoginButton()
    {
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = (EditText) findViewById(R.id.login_uname);
                pw = (EditText) findViewById(R.id.login_pw);


        final String pass=(pw.getText().toString());
                loginFeedback=login.login(pw.getText().toString());


                Login.setOnClickListener(
                        new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                if (pass.equals(loginFeedback))
                                {
                                    Toast.makeText(Login.this, "Welcome "+uname.getText().toString()+"", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(Login.this,  ItemExplore.class);
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
        });


    }



}
