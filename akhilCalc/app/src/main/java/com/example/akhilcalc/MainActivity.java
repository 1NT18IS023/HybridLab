package com.example.akhilcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    String op1 = "";
    String op2 = "";
    String op = "";
    boolean isSecondNum = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
    }

    public void numberEvent(View view)
    {
        Button b = (Button) view;
        if(isSecondNum)
        {
            op2+=b.getText().toString();

        }
        else op1+= b.getText().toString();
        result.setText(op1 + op + op2);
    }

    public void clearEvent(View view)
    {
        result.setText("");
        op1="";
        op2 = "";
        op = "";
        isSecondNum = false;
    }

    public void plusMinusEvent(View view)
    {
        if (op2 != "" || op != "") {
            result.setText("");
        } else {
            if (op1.charAt(0) == '-') {
                op1 = op1.substring(1);
            } else {
                op1 = "-" + op1;
            }

            result.setText(op1);
        }
    }

    public void percentEvent(View view)
    {
        if(op2!=""){result.setText("");}
        else {
            op1 = String.valueOf(Float.valueOf(op1)/100);
            result.setText(op1);
        }

    }

    public void operatorEvent(View view)
    {
        Button b = (Button) view;

        op = b.getText().toString();

        isSecondNum = true;

        result.setText(op1 + op + op2);
    }

    public void equalEvent(View view)
    {

        try {

            float operand1 = Float.parseFloat(op1);
            float operand2 = Float.parseFloat(op2);
            float answer = 0;
            switch(op)
            {
                case "+":
                    answer = operand1 + operand2;
                    break;

                case "-":
                    answer = operand1-operand2;
                    break;

                case "*":answer = operand1*operand2;
                break;


                case "/":answer = operand1/operand2;
                break;
            }
            String output = String.valueOf(String.format("%.2f", answer));

            result.setText(output);
            op1 = output;
            op2 = "";
            isSecondNum = false;
            op = "";
        } catch (Exception e) {
            result.setText("");
        }
    }
        }

