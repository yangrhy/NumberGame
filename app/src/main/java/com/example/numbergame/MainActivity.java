// Ricky Yang
// March 4, 2019
package com.example.numbergame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button processButton, randomButton, newNumButton, restartButton;
    TextView instructions, answerText;
    NumberPicker numPicker1, numPicker2, numPicker3, numPicker4
                , randomNumPicker1, randomNumPicker2, randomNumPicker3, randomNumPicker4
                , newNum1, newNum2, newNum3, newNum4;
    RadioGroup myRadioGroup;
    int num1, num2, num3, num4, sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restartButton = (Button)findViewById(R.id.restartButton);
        answerText = (TextView)findViewById(R.id.answerText);
        myRadioGroup = (RadioGroup)findViewById(R.id.radioGroup);
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


        randomNumPicker1.setMinValue(0);
        randomNumPicker1.setMaxValue(9);
        randomNumPicker2.setMinValue(0);
        randomNumPicker2.setMaxValue(9);
        randomNumPicker3.setMinValue(0);
        randomNumPicker3.setMaxValue(9);
        randomNumPicker4.setMinValue(0);
        randomNumPicker4.setMaxValue(9);

        randomButton.setOnClickListener(new ButtonClick());
        newNumButton.setOnClickListener(new ButtonClick());
        processButton.setOnClickListener(new ButtonClick());
        restartButton.setOnClickListener(new ButtonClick());
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

                Random rand = new Random();
                numbers.add(num1);
                numbers.add(num2);
                numbers.add(num3);
                numbers.add(num4);

                for (int i = 0; i < 4; i++) {
                    int index = rand.nextInt(numbers.size());
                    randNums.add(numbers.get(index));
                    numbers.remove(index);
                }
                randomNumPicker1.setValue(randNums.get(0));
                randomNumPicker2.setValue(randNums.get(1));
                randomNumPicker3.setValue(randNums.get(2));
                randomNumPicker4.setValue(randNums.get(3));
            }
            else if (v.getId() == R.id.newNumButton) {
                FindNewNum();
            }
            else if (v.getId() == R.id.processButton) {
                int radioButtonId = myRadioGroup.getCheckedRadioButtonId();
                ArrayList<Integer>numsToAdd = new ArrayList<>();
                View radioButtonPicked = myRadioGroup.findViewById(radioButtonId);
                // 0 if newNumPicker4 chosen to 3 if newNumPicker1 chosen
                int rbIndex = myRadioGroup.indexOfChild(radioButtonPicked);
                int thisNum1, thisNum2, thisNum3, thisNum4;

                thisNum1 = newNum1.getValue();
                thisNum2 = newNum2.getValue();
                thisNum3 = newNum3.getValue();
                thisNum4 = newNum4.getValue();

                if (rbIndex == 3) {
                    numsToAdd.add(thisNum2);
                    numsToAdd.add(thisNum3);
                    numsToAdd.add(thisNum4);
                }
                else if (rbIndex == 2) {
                    numsToAdd.add(thisNum1);
                    numsToAdd.add(thisNum3);
                    numsToAdd.add(thisNum4);
                }
                else if (rbIndex == 1) {
                    numsToAdd.add(thisNum1);
                    numsToAdd.add(thisNum2);
                    numsToAdd.add(thisNum4);
                }
                else if (rbIndex == 0) {
                    numsToAdd.add(thisNum1);
                    numsToAdd.add(thisNum3);
                    numsToAdd.add(thisNum2);
                }

                FindNum(numsToAdd);
            }
            else if (v.getId() == R.id.restartButton) {
                Restart();
            }
        }
    }

    private void FindNum(ArrayList<Integer>numsChosen) {
        processButton.setEnabled(false);
        String answerString = answerText.getText().toString();
        int theNumber = 0;
        int finalNum;
        ArrayList<Integer>newNumList = new ArrayList<>();

        for(int num: numsChosen) {
            theNumber += num;
        }

        // if number is greater than 9, split number down again and re-add them
        if (theNumber > 9) {
            String newNumString = String.valueOf(theNumber);
            char[]newNumChar = newNumString.toCharArray();
            int newNum = 0;
            for (int i = 0; i< newNumChar.length; i++) {
                int num = Integer.parseInt(String.valueOf(newNumChar[i]));
                newNumList.add(num);
            }

            for (int num: newNumList) {
                newNum += num;
            }
            finalNum = 9 - newNum;
        }
        else if (theNumber < 9) {
            finalNum = 9 - theNumber;
        }
        else{
            finalNum = 9;
        }

        Toast.makeText(this, String.valueOf(finalNum), Toast.LENGTH_LONG).show();
        answerString += String.valueOf(finalNum);
        answerText.setText(answerString);
    }

    private void Restart () {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //this will always start your activity as a new task
        startActivity(intent);
    }

    private void FindNewNum () {
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
        Toast.makeText(this, String.valueOf(result), Toast.LENGTH_LONG).show();

        String resultString = String.valueOf(result);
        char[]resultChar = resultString.toCharArray();
        ArrayList<Integer>resultNums = new ArrayList<>();

        for (int i = 0; i < resultChar.length; i++) {
            resultNums.add(Integer.parseInt(String.valueOf(resultChar[i])));
        }

        if (resultNums.size() == 4) {
            newNum1.setValue(resultNums.get(3));
            newNum2.setValue(resultNums.get(2));
            newNum3.setValue(resultNums.get(1));
            newNum4.setValue(resultNums.get(0));
        }
        else if (resultNums.size() == 3) {
            newNum1.setValue(resultNums.get(3));
            newNum2.setValue(resultNums.get(2));
            newNum3.setValue(resultNums.get(1));
        }
        else if (resultNums.size() == 2) {
            newNum1.setValue(resultNums.get(1));
            newNum2.setValue(resultNums.get(0));
        }
        else if (resultNums.size() == 1) {
            newNum1.setValue(resultNums.get(0));
        }
    }
}
