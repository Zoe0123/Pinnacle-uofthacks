package com.firstapp.acatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


/* The code comes from: https://www.journaldev.com/9231/android-spinner-drop-down-list
 * More of our own code will be added later. */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView  textView=(TextView) findViewById(R.id.txt_bundle);
        Bundle bundle=getIntent().getExtras();
        String data=bundle.get("data").toString();
        String[] arr = data.split("@", 4);
        textView.setText(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);



    }
}