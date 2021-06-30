package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

        private TextView welcoming,amountToPaid;
    private CheckBox tv,computer,tablet,phone;
    private RadioButton creditCard, payAtTheDoor,test;
   private Button buttonPurchase;
   private RadioGroup radiogroup;
   private int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcoming = findViewById(R.id.txtWelcoming);
        amountToPaid = findViewById(R.id.txtAmount);
        buttonPurchase = findViewById(R.id.btnPurchase);
        tv = findViewById(R.id.checkTelevision);
        computer = findViewById(R.id.checkComputer);
        tablet = findViewById(R.id.checkTablet);
        phone = findViewById(R.id.checkPhone);

        radiogroup = findViewById(R.id.radioGroup);
        creditCard = findViewById(R.id.radioCreditCard);
        payAtTheDoor = findViewById(R.id.radioDoor);

        Intent getInfo = getIntent();
        String getMail = getInfo.getStringExtra("Mail");

        welcoming.setText("Welcome, "+getMail);
        Calculation();

        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int selectedRadio = radiogroup.getCheckedRadioButtonId();
               test = findViewById(selectedRadio);
               Toast.makeText(SecondActivity.this,"You are going to pay "+ test.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Calculation(){
        tv.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                total+=3000;
                amountToPaid.setText(total + "$");
            }
            else
            {
                total-=3000;
                amountToPaid.setText(total + "$");
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.isChecked()){
                    total+=3000;
                    amountToPaid.setText(total + "$");
                }
                else{
                    total-=3000;
                    amountToPaid.setText(total + "$");
                }
            }
        });
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(computer.isChecked()){
                    total+=4000;
                    amountToPaid.setText(total + "$");
                }
                else{
                    total-=4000;
                    amountToPaid.setText(total + "$");
                }
            }
        });
        tablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tablet.isChecked()){
                    total+=1500;
                    amountToPaid.setText(total + "$");
                }
                else{
                    total-=1500;
                    amountToPaid.setText(total + "$");
                }
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.isChecked()){
                    total+=2000;
                    amountToPaid.setText(total + "$");
                }
                else{
                    total-=2000;
                    amountToPaid.setText(total + "$");
                }
            }
        });
    }



}