package com.firstapp.acatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/* The code comes from: https://www.journaldev.com/9231/android-spinner-drop-down-list
* More of our own code will be added later. */

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        final Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);


        Button button=(Button)findViewById(R.id.button);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Nearby me");
        categories.add("Within city");
        categories.add("Within state");
        categories.add("Doesn't matter");

        List<String> categories2 = new ArrayList<String>();
        categories2.add("$10 or less");
        categories2.add("$10 to $49");
        categories2.add("$50 to $99");
        categories2.add("$100 to $399");
        categories2.add("$400 or above");

        List<String> categories3 = new ArrayList<String>();
        categories3.add("Casual");
        categories3.add("Formal");

        List<String> categories4 = new ArrayList<String>();
        categories4.add("Yes");
        categories4.add("No");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories4);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);
        spinner3.setAdapter(dataAdapter3);
        spinner4.setAdapter(dataAdapter4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                String str = String.valueOf(spinner.getSelectedItem()) + "@"
                        + String.valueOf(spinner2.getSelectedItem()) + "@"
                        + String.valueOf(spinner3.getSelectedItem()) + "@"
                        + String.valueOf(spinner4.getSelectedItem());
                intent.putExtra("data", str);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}