package com.example.numbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

        newNum1.setMinValue(0);
        newNum1.setMaxValue(9);
        newNum2.setMinValue(0);
        newNum2.setMaxValue(9);
        newNum3.setMinValue(0);
        newNum3.setMaxValue(9);
        newNum4.setMinValue(0);
        newNum4.setMaxValue(9);
        newNum1.setEnabled(false);
        newNum2.setEnabled(false);
        newNum3.setEnabled(false);
        newNum4.setEnabled(false);

        randomNumPicker1.setMinValue(0);
        randomNumPicker1.setMaxValue(9);
        randomNumPicker2.setMinValue(0);
        randomNumPicker2.setMaxValue(9);
        randomNumPicker3.setMinValue(0);
        randomNumPicker3.setMaxValue(9);
        randomNumPicker4.setMinValue(0);
        randomNumPicker4.setMaxValue(9);
        randomNumPicker1.setEnabled(false);
        randomNumPicker2.setEnabled(false);
        randomNumPicker3.setEnabled(false);
        randomNumPicker4.setEnabled(false);

        randomButton.setOnClickListener(new ButtonClick());
        newNumButton.setOnClickListener(new ButtonClick());
        processButton.setOnClickListener(new ButtonClick());

    }

    private class ButtonClick implements Button.OnClickListener {
        public void onClick(View v) {

            if (v.getId() == R.id.randomButton) {
                num1 = numPicker1.getValue();
                num2 = numPicker2.getValue();
                num3 = numPicker3.getValue();
                num4 = numPicker4.getValue();
                ArrayList<Integer>numbers = new ArrayList<>();
                ArrayList<Integer>randNums = new ArrayList<>();

                Random randNum = new Random();
                numbers.add(num1);
                numbers.add(num2);
                numbers.add(num3);
                numbers.add(num4);

                for (int i = 0; i < 4; i++) {
                    int index = randNum.nextInt(numbers.size());
                    randNums.add(numbers.get(index));
                    numbers.remove(index);
                }
                randomNumPicker1.setValue(randNums.get(0));
                randomNumPicker2.setValue(randNums.get(1));
                randomNumPicker3.setValue(randNums.get(2));
                randomNumPicker4.setValue(randNums.get(3));
            }
            else if (v.getId() == R.id.newNumButton) {
                int result;
                String firstNum = "";
                String secNum = "";
                firstNum += numPicker1.getValue();
                firstNum += numPicker2.getValue();
                firstNum += numPicker3.getValue();
                firstNum += numPicker4.getValue();
                secNum += randomNumPicker1.getValue();
                secNum += randomNumPicker2.getValue();
                secNum += randomNumPicker3.getValue();
                secNum += randomNumPicker4.getValue();

                int number1 = Integer.parseInt(firstNum);
                int number2 = Integer.parseInt(secNum);

                if (number1 >= number2) {
                    result = number1 - number2;
                }
                else {
                    result = number2 - number1;
                }

                String resultString = String.valueOf(result);

            }
            else if (v.getId() == R.id.processButton) {

            }
        }
    }
}
