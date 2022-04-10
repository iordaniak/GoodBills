package com.example.goodbills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.EditText;

import java.util.ArrayList;

public class NewTrip1Activity extends AppCompatActivity {

    private Spinner numbers_spinner;
    EditText title_edittext;
    Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip1);

        numbers_spinner = findViewById(R.id.numberSpinner);
        next_button = (Button)findViewById(R.id.nextButton);
        title_edittext = (EditText)findViewById(R.id.editTextTripName);

//        Setting up the Spinner
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0;i<10;i++){ numbers.add(i+2); }
        
        ArrayAdapter<Integer> numbersAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                numbers
        );
        numbers_spinner.setAdapter(numbersAdapter);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                // get the EditText input and convert it to string
                String title = title_edittext.getText().toString();
                int num = (int) numbers_spinner.getSelectedItem();

                Intent intent = new Intent(getApplicationContext(), NewTrip2Activity.class);
                intent.putExtra("trip_name", title);
                intent.putExtra("numberOfTravellers", num);

                startActivity(intent);
            }
        });

    }

}