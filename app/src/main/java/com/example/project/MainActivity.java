package com.example.project;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mail,password;
    Button buttonLogin;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = findViewById(R.id.edittxtMail);
        password = findViewById(R.id.edittxtPassword);
        buttonLogin = findViewById(R.id.btnLogin);
        img = findViewById(R.id.imgMain);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMail = mail.getText().toString();
                String userPassword = password.getText().toString();

                if (TextUtils.isEmpty(userMail)||TextUtils.isEmpty(userPassword)){
                    Toast.makeText(MainActivity.this,"Please enter your informations!!",Toast.LENGTH_LONG).show();
                }
                else if(userMail.equals("example@gmail.com")&& userPassword.equals("1234")){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("Mail",userMail);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this,"Incorrect informations. Please try again!!",Toast.LENGTH_LONG).show();
            }
        });

    }
}