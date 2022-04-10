package com.example.goodbills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewPayment2Activity extends AppCompatActivity {

    TextView title_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_payment2);

        title_textview = (TextView)findViewById(R.id.text_id);


        Intent i = getIntent();
        String name = i.getStringExtra("traveller_name");
        double amount = i.getDoubleExtra("amount_paid",0.0);

        title_textview.setText(name+" has paid "+amount+" euros");


    }
}