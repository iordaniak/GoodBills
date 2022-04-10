package com.example.goodbills;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class TripActivity extends AppCompatActivity {

    TextView title_textview;
    ListView names_listview;
    ListView expenses_listview;
    Button newpayment_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip3);

        title_textview = findViewById(R.id.textView_id);
        names_listview = findViewById(R.id.listView1);
        expenses_listview = findViewById(R.id.listView2);
        newpayment_button = findViewById(R.id.newpayment_id);

//        Get the values from previous Activity
        Intent i = getIntent();
        Trip trip = (Trip) i.getSerializableExtra("object_trip");

        title_textview.setText(trip.getName());

//        ListViews for names and expenses
        String[] ListNames = new String[trip.getNumOfTravellers()];
        final List<Double> ListExpenses = new ArrayList<Double>();
        int j = 0;
        for (Traveller t: trip.getTravellers()){
            ListNames[j] = t.getName();
            ListExpenses.add(t.getExpenses());
            j++;
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (TripActivity.this, android.R.layout.simple_list_item_1, ListNames);
        names_listview.setAdapter(adapter);

        final ArrayAdapter<Double> adapter2 = new ArrayAdapter<>
                (TripActivity.this, android.R.layout.simple_list_item_1, ListExpenses);
        expenses_listview.setAdapter(adapter2);


        newpayment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewPayment1Activity.class);
                intent.putExtra("object_trip", trip);
                startActivity(intent);
            }
        });
    }
}