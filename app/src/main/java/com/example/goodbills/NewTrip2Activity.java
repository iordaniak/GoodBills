package com.example.goodbills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class NewTrip2Activity extends AppCompatActivity {

    TextView title_textview;
    ListView names_listview;
    Button add_button;
    EditText name_editText;
    Button ok_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip2);

        names_listview = findViewById(R.id.listView1);
        add_button = findViewById(R.id.button1);
        name_editText = findViewById(R.id.editText1);
        ok_button = (Button)findViewById(R.id.okButton);
        title_textview = (TextView)findViewById(R.id.tripNameReciever);

//        Get the values from previous activity
        Intent intent = getIntent();
        String str = intent.getStringExtra("trip_name");
        int num = intent.getIntExtra("numberOfTravellers",2);

        title_textview.setText(str);

        final List<String> TravellersList = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (NewTrip2Activity.this, android.R.layout.simple_list_item_1, TravellersList);
        names_listview.setAdapter(adapter);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num>TravellersList.size()){
                    if(name_editText.getText().toString().isEmpty()){
                        Toast.makeText(
                                NewTrip2Activity.this,
                                "You have to write a name",
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        TravellersList.add(name_editText.getText().toString());
                        adapter.notifyDataSetChanged();
                        name_editText.setText("");
                    }
                }
                else{
                    Toast.makeText(
                            NewTrip2Activity.this,
                            "You have added "+num+" Travellers",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num == TravellersList.size()){
                    Trip trip = new Trip(str,num);
                    for(int i=0;i<num;i++){
                        Traveller traveller = new Traveller(TravellersList.get(i));
                        trip.setTraveller(traveller,i);
                    }
                    Intent intent2 = new Intent(getApplicationContext(), TripActivity.class);
                    intent2.putExtra("object_trip", trip);
                    intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(intent2);
                }
                else {
                    Toast.makeText(
                            NewTrip2Activity.this,
                            "You have "+(num-TravellersList.size())+" Travellers left",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}