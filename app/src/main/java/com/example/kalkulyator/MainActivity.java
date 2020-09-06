package com.example.kalkulyator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {


    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, buttonPercent, buttonPlus, buttonMinus, buttonMultiply, buttonDivision, buttonEqual, buttonClear, buttonDot, buttonBracket;
    TextView textViewInput, textViewOutput;
    String process;
    boolean checkBracket = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonMultiply = findViewById(R.id.buttonMultiply);

        buttonEqual = findViewById(R.id.buttonEqual);

        buttonClear = findViewById(R.id.buttonClear);
        buttonDot = findViewById(R.id.buttonDot);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonBracket = findViewById(R.id.buttonBracket);

        textViewInput = findViewById(R.id.tvInput);
        textViewOutput = findViewById(R.id.tvOutput);
        buttonClear.setOnClickListener(v -> {
            textViewInput.setText("");
            textViewOutput.setText("");
        });


        btn0.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "0");
        });

        btn1.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "1");
        });

        btn2.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "2");
        });

        btn3.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "3");
        });

        btn4.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "4");
        });

        btn5.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "5");
        });

        btn6.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "6");
        });

        btn6.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "6");
        });

        btn7.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "7");
        });

        btn8.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "8");
        });

        btn9.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "9");
        });

        buttonPlus.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "+");
        });


        buttonMinus.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "-");
        });

        buttonMultiply.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "×");
        });

        buttonDivision.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "÷");
        });

        buttonDot.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + ".");
        });

        buttonPercent.setOnClickListener(v -> {
            process = textViewInput.getText().toString();
            textViewInput.setText(process + "%");
        });

        buttonBracket.setOnClickListener(v -> {

            if (checkBracket) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process + ")");
                checkBracket = false;
            } else {
                process = textViewInput.getText().toString();
                textViewInput.setText(process + "(");
                checkBracket = true;
            }

        });
        buttonEqual.setOnClickListener(v -> {
            process = textViewInput.getText().toString();

            process = process.replaceAll("×", "*");
            process = process.replaceAll("%", "/100");
            process = process.replaceAll("÷", "/");


            Context rhino = Context.enter();

            rhino.setOptimizationLevel(-1);

            String finalResult = "";

            try {
                Scriptable scriptable = rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
            } catch (Exception e) {
                finalResult = "0";
            }

            textViewOutput.setText(finalResult);
        });


    }
}