package com.example.rk.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Search_Fun_Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search__fun__food);

        Spinner spinner;
        final Spinner spinnerSelected;
        ArrayAdapter<CharSequence> adapter;

        spinner = (Spinner)findViewById(R.id.spinnerSearch);
        adapter = ArrayAdapter.createFromResource(this,R.array.search_areas,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //spinnerSelected = adapterView.getItemAtPosition(i);
                //Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(i)+"selected",Toast.LENGTH_LONG).show();

               startActivity(new Intent(Search_Fun_Food.this, restaurants_list.class));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
