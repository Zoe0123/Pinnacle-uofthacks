package com.firstapp.acatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.schema.Model;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Object;
import java.util.Timer;
import java.util.TimerTask;


/* The code comes from: https://www.journaldev.com/9231/android-spinner-drop-down-list
 * More of our own code will be added later. */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        String distance, budget, formality, first_date;
        TextView  textView=(TextView) findViewById(R.id.txt_bundle);
        Bundle bundle=getIntent().getExtras();
        String data=bundle.get("data").toString();
        String[] arr = data.split("@", 4);

        //TODO: send to recommendation string to the user

        String input = "";
        // If statement to turn the string inputs to int inputs to our model
        // distance
        if (arr[0].equalsIgnoreCase("Nearby Me")){
            distance = "0";
        }else if (arr[0].equalsIgnoreCase("Within city")){
            distance = "1";
        }else if (arr[0].equalsIgnoreCase("Within state")){
            distance = "2";
        }
        else{
            distance = "3";
        }
        input += distance;
        //budget
        if (arr[1].equalsIgnoreCase("$10 or less")){
            budget = "0";
        }else if (arr[1].equalsIgnoreCase("$10 to $49")){
            budget = "1";
        }else if (arr[1].equalsIgnoreCase("$50 to $99")){
            budget = "2";
        }
        else if (arr[1].equalsIgnoreCase("$100 to $399")){
            budget = "3";
        }
        else{
            budget = "4";
        }
        input += "," + budget;
        //formality
        if (arr[2].equalsIgnoreCase("Casual")){
            formality = "0";
        }
        else{
            formality = "1";
        }
        input += "," + formality;
        //formality
        if (arr[3].equalsIgnoreCase("Yes")){
            first_date = "0";
        }
        else{
            first_date = "1";
        }
        input += "," + first_date;

        //get input about weather and covid from a python py file
        /*cite: MarkAllen4512 and Sevas from
        https://stackoverflow.com/questions/10097491/call-and-receive-output-from-python-script-in-java */

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // inside run is the task to be performed
                String s = null;

                try {

                    // run the python file
                    // using the Runtime exec method:
                    Process p = Runtime.getRuntime().exec("python3 utils.py");

                    BufferedReader stdInput = new BufferedReader(new
                            InputStreamReader(p.getInputStream()));

                    BufferedReader stdError = new BufferedReader(new
                            InputStreamReader(p.getErrorStream()));

                    // read the output from the command
                    s = stdInput.readLine();
                } catch (IOException e) {
                    System.out.println("exception happened:");
                    e.printStackTrace();
                    System.exit(-1);
                }

            }
        };
        //set timer so weather will be checked at regular intervals
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 100, 1000);


       //connect the recommendation model with the front end
        try {
            Model model = Model.newInstance(context);

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 1}, DataType.FLOAT32);
            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Model.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            System.out.println("exception happened:");
            e.printStackTrace();
            System.exit(-1);
        }








    }
}