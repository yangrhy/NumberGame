package com.example.numbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button startButton;
    TextView instructions, oval;
    NumberPicker numPicker1, numPicker2, numPicker3, numPicker4
                , randomNumPicker1, randomNumPicker2, randomNumPicker3, randomNumPicker4;
    int num1, num2, num3, num4, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instructions = (TextView)findViewById(R.id.textViewAnswer);
        startButton = (Button)findViewById(R.id.randomButton);
        numPicker1 = (NumberPicker)findViewById(R.id.numPicker1);
        numPicker2 = (NumberPicker)findViewById(R.id.numPicker2);
        numPicker3 = (NumberPicker)findViewById(R.id.numPicker3);
        numPicker4 = (NumberPicker)findViewById(R.id.numPicker4);
        randomNumPicker1 = (NumberPicker)findViewById(R.id.randNumPicker1);
        randomNumPicker2 = (NumberPicker)findViewById(R.id.randNumPicker2);
        randomNumPicker3 = (NumberPicker)findViewById(R.id.randNumPicker3);
        randomNumPicker4 = (NumberPicker)findViewById(R.id.randNumPicker4);

        oval = (TextView)findViewById(R.id.ovalShape); // set a textView into activity_main.xml to use this

        numPicker1.setMinValue(1);
        numPicker1.setMaxValue(9);
        numPicker2.setMinValue(1);
        numPicker2.setMaxValue(9);
        numPicker3.setMinValue(1);
        numPicker3.setMaxValue(9);
        numPicker4.setMinValue(1);
        numPicker4.setMaxValue(9);


    }

    private class ButtonClick implements Button.OnClickListener {
        public void onClick(View v) {
            if (v.getId() == R.id.randomButton) {
                int[]numArray = new int[4];

            }
        }
    }
}
