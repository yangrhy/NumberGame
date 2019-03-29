package com.example.numbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button processButton, randomButton, newNumButton;
    TextView instructions, oval;
    NumberPicker numPicker1, numPicker2, numPicker3, numPicker4
                , randomNumPicker1, randomNumPicker2, randomNumPicker3, randomNumPicker4
                , newNum1, newNum2, newNum3, newNum4;
    int num1, num2, num3, num4, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instructions = (TextView)findViewById(R.id.enterNumLabel);
        randomButton = (Button)findViewById(R.id.randomButton);
        newNumButton = (Button)findViewById(R.id.newNumButton);
        processButton = (Button)findViewById(R.id.processButton);
        numPicker1 = (NumberPicker)findViewById(R.id.numPicker1);
        numPicker2 = (NumberPicker)findViewById(R.id.numPicker2);
        numPicker3 = (NumberPicker)findViewById(R.id.numPicker3);
        numPicker4 = (NumberPicker)findViewById(R.id.numPicker4);
        randomNumPicker1 = (NumberPicker)findViewById(R.id.randNumPicker1);
        randomNumPicker2 = (NumberPicker)findViewById(R.id.randNumPicker2);
        randomNumPicker3 = (NumberPicker)findViewById(R.id.randNumPicker3);
        randomNumPicker4 = (NumberPicker)findViewById(R.id.randNumPicker4);
        newNum1 = (NumberPicker)findViewById(R.id.newNum1);
        newNum2 = (NumberPicker)findViewById(R.id.newNum2);
        newNum3 = (NumberPicker)findViewById(R.id.newNum3);
        newNum4 = (NumberPicker)findViewById(R.id.newNum4);

        //oval = (TextView)findViewById(R.id.ovalShape); // set a textView into activity_main.xml to use this

        numPicker1.setMinValue(0);
        numPicker1.setMaxValue(9);
        numPicker2.setMinValue(0);
        numPicker2.setMaxValue(9);
        numPicker3.setMinValue(0);
        numPicker3.setMaxValue(9);
        numPicker4.setMinValue(0);
        numPicker4.setMaxValue(9);


    }

    private class ButtonClick implements Button.OnClickListener {
        public void onClick(View v) {
            if (v.getId() == R.id.randomButton) {
                int[]numArray = new int[4];

            }
            else if (v.getId() == R.id.newNumButton) {
                int[]numArray = new int[4];

            }
            else if (v.getId() == R.id.randomButton) {
                int[]numArray = new int[4];

            }
        }
    }
}
