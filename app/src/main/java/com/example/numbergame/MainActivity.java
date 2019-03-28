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
    NumberPicker numPicker1, numPicker2, numPicker3, numPicker4;
    int num1, num2, num3, num4, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instructions = (TextView)findViewById(R.id.textViewAnswer);
        startButton = (Button)findViewById(R.id.startButton);
        numPicker1 = (NumberPicker)findViewById(R.id.numPicker1);
        numPicker2 = (NumberPicker)findViewById(R.id.numPicker2);
        numPicker3 = (NumberPicker)findViewById(R.id.numPicker3);
        numPicker4 = (NumberPicker)findViewById(R.id.numPicker4);
        oval = (TextView)findViewById(R.id.ovalShape); // set a textView into activity_main.xml to use this

        numPicker1.setMinValue(0);
        numPicker1.setMaxValue(9);

    }
}
