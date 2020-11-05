package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {


    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.Display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String toAdd){
        String previous = display.getText().toString();

        int cursor = display.getSelectionStart();
        String left = previous.substring(0, cursor);
        String right = previous.substring(cursor);

        display.setText(String.format("%s%s%s", left, toAdd, right));
        display.setSelection(cursor + 1);

    }

    public void zeroButton(View view){
        updateText("0");

    }

    public void oneButton(View view){
        updateText("1");
    }

    public void twoButton(View view){
        updateText("2");

    }

    public void threeButton(View view){
        updateText("3");

    }

    public void fourButton(View view){
        updateText("4");

    }

    public void fiveButton(View view){
        updateText("5");
    }

    public void sixButton(View view){
        updateText("6");

    }

    public void sevenButton(View view){
        updateText("7");
    }

    public void eightButton(View view){
        updateText("8");

    }

    public void nineButton(View view){
        updateText("9");

    }


    public void backButton(View view){
        int cursor = display.getSelectionStart();
        int length = display.getText().length();

        if (cursor != 0 && length != 0){

            SpannableStringBuilder select = (SpannableStringBuilder) display.getText();
            select.replace(cursor - 1, cursor, "");
            display.setText(select);
            display.setSelection(cursor - 1);

        }

    }

    public void paranButton(View view){


    }

    public void exponentButton(View view){
        updateText("^");
    }

    public void divisionButton(View view){
        updateText("÷");
    }

    public void multiplyButton(View view){
        updateText("×");
    }

    public void subtractButton(View view){
        updateText("-");
    }

    public void addButton(View view){
        updateText("+");

    }

    public void addSubtract(View view){

    }

    public void intDivideButton(View view){
        updateText("/");

    }

    public void decimalButton(View view){
        updateText(".");

    }

    public void modulusButton(View view){
        updateText("%");
    }

    public void clearButton(View view){
        display.setText("");
    }

    public void equalsButton(View view){
        String expression = display.getText().toString();

        expression = expression.replaceAll("÷", "/");
        expression = expression.replaceAll("×", "*");

        Expression answer = new Expression(expression);

        String result = String.valueOf(answer.calculate());

        display.setText(result);
        display.setSelection(result.length());


    }

}