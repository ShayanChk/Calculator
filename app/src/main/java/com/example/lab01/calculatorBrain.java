//name: Shayan Chabook
//studentID: 159844208
//email add:schabook@myseneca.ca

package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class calculatorBrain extends AppCompatActivity {

    ArrayList<String> inputs = new ArrayList<String>();

    public EditText display;
    public EditText theDisplay;
    Button numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven,
    numberEight, numberNine, numberZero, equal, division, multiplication, subtraction,clear, add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        display = (EditText)findViewById(R.id.theText);

        numberOne = findViewById(R.id.numOne);
        numberTwo = findViewById(R.id.numTwo);
        numberThree = findViewById(R.id.numThree);
        numberFour = findViewById(R.id.num4);
        numberFive = findViewById(R.id.num5);
        numberSix = findViewById(R.id.num6);
        numberSeven = findViewById(R.id.num7);
        numberEight = findViewById(R.id.num8);
        numberNine = findViewById(R.id.num9);
        numberZero = findViewById(R.id.zero);
        equal = findViewById(R.id.result);
        division = findViewById(R.id.div);
        multiplication = findViewById(R.id.multiply);
        subtraction = findViewById(R.id.minus);
        clear = findViewById(R.id.theClear);
        add = findViewById(R.id.plus);



        numberOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("1");
                updateDisplay("1");
            }
        });

        numberTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("2");
                updateDisplay("2");

            }
        });

        numberThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("3");
                updateDisplay("3");
            }
        });

        numberFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("4");
                updateDisplay("4");

            }
        });

        numberFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("5");
                updateDisplay("5");

            }
        });

        numberSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("6");
                updateDisplay("6");
            }
        });

        numberSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("7");
                updateDisplay("7");

            }
        });

        numberEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("8");
                updateDisplay("8");
            }
        });

        numberNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("9");
                updateDisplay("9");

            }
        });

        numberZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("0");
                updateDisplay("0");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                push("=");
                updateDisplay("=");
                updateDisplay(Integer.toString((result())));
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("/");
                updateDisplay("/");
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("*");
                updateDisplay("*");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("+");
                updateDisplay("+");
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push("-");
                updateDisplay("-");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //push("-");
                updateDisplay(" ");
            }
        });
    }

    public void push(String userValue)
    {
        inputs.add(userValue);
    }

    public int result()
    {
        int result=0, terminate = 1;

        if(inputs.get(0).equals("+") || inputs.get(0).equals("-") || inputs.get(0).equals("/") || inputs.get(0).equals("*"))
        {
            result = -888;
        }
        else {
            String theSign = null;
            StringBuffer firstHalf = new StringBuffer();
            StringBuffer secondHalf = new StringBuffer();

            int counter = 0;

            for (int i = 0; i < inputs.size(); i++) {

                if (!inputs.get(i).equals("+") && !inputs.get(i).equals("-") && !inputs.get(i).equals("/") && !inputs.get(i).equals("*")) {
                    if (!inputs.get(i).equals("=") && terminate != -1) {
                        if (counter == 0) {
                            firstHalf.append(inputs.get(i));
                        } else {
                            secondHalf.append(inputs.get(i));
                        }
                    }
                } else {
                    if (inputs.get(i + 1).equals("+") || inputs.get(i + 1).equals("-") || inputs.get(i + 1).equals("/") || inputs.get(i + 1).equals("*") || inputs.get(i + 1).equals("=")) {
                        terminate = -1;
                        result = -888;
                    } else {
                        theSign = inputs.get(i);
                        counter = 1;
                    }

                }

            }

            int count = 0;
            for(int i =0; i < inputs.size(); i++)
            {
                if(inputs.get(i).equals("+") || inputs.get(i).equals("-") || inputs.get(i).equals("/") || inputs.get(i).equals("*"))
                {
                    count += 1;
                }
            }

            if(count > 1)
            {
                terminate = -1;
                result = -888;
            }

            if (terminate != -1) {
                int firstNumber, secondNumber;

                firstNumber = Integer.parseInt(firstHalf.toString());
                secondNumber = Integer.parseInt(secondHalf.toString());

                firstHalf.delete(0, firstHalf.length());
                secondHalf.delete(0, secondHalf.length());

                if (theSign.equals("-"))
                    result = firstNumber - secondNumber;
                if (theSign.equals("+"))
                    result = firstNumber + secondNumber;
                if (theSign.equals("*"))
                    result = firstNumber * secondNumber;
                if (theSign.equals("/"))
                    result = firstNumber / secondNumber;
            }
        }
        return result;
    }

    public void updateDisplay(String toAdd)
    {
        if (toAdd.equals("-888"))
        {
            //display.setText(String.format("%s", theError));
            String theError = "Error!";
            String theOldString = display.getText().toString();
            int positionOfCursor = display.getSelectionStart();
            String leftSide = theOldString.substring(0, positionOfCursor);
            String rightSide = theOldString.substring(positionOfCursor);
            display.setText(String.format("%s%s%s", rightSide, theError, leftSide));
        }
       else if (toAdd.equals(" "))
        {
            display.setText("");
            inputs.clear();
        }
        else
        {
            String theOldString = display.getText().toString();
            int positionOfCursor = display.getSelectionStart();
            String leftSide = theOldString.substring(0, positionOfCursor);
            String rightSide = theOldString.substring(positionOfCursor);
            display.setText(String.format("%s%s%s", rightSide, toAdd, leftSide));
        }
    }

    public void updateTheDisplay(String toAdd)
    {
        if (toAdd.equals("-1"))
        {
            String theError = "Error!";
            display.setText(String.format("%s", theError));
        }
        else
        {
            display.setText(String.format("%s", toAdd));
            inputs.clear();
        }

    }

    public void showError()
    {

        inputs.clear();
    }
}
