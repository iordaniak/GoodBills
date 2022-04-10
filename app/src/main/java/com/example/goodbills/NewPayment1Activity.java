package com.example.goodbills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class NewPayment1Activity extends AppCompatActivity {

    Spinner names_spinner;
    EditText amount_edittext;
    CheckBox split_checkbox;
    Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_payment1);

        names_spinner = findViewById(R.id.spinner_id);
        amount_edittext = findViewById(R.id.editTextNumberDecimal);
        split_checkbox = findViewById(R.id.checkBox);
        next_button = findViewById(R.id.button);

        Intent i = getIntent();
        Trip trip = (Trip) i.getSerializableExtra("object_trip");

        String[] names = new String[trip.getNumOfTravellers()];
        int j = 0;
        for (Traveller t: trip.getTravellers()){
            names[j] = t.getName();
            j++;
        }

        ArrayAdapter<String> namesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                names
        );
        names_spinner.setAdapter(namesAdapter);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                // get the EditText input and convert it to string
                double amount = Double.parseDouble(String.valueOf(amount_edittext.getText()));
                String name = (String) names_spinner.getSelectedItem();
                boolean split = split_checkbox.isChecked();

                Intent intent = new Intent(getApplicationContext(), NewPayment2Activity.class);
                intent.putExtra("amount_paid", amount);
                intent.putExtra("traveller_name", name);
                intent.putExtra("split", split);

                startActivity(intent);

            }
        });



    }
}