package com.example.calculadoraaaaa;

import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {

    private TextView screen;
    private double numero1, numero2;
    private String operacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        screen = findViewById(R.id.Screen);

        // Set onClick listeners for number buttons
        setNumberButtonListeners();

        // Set onClick listeners for operation buttons
        setOperationButtonListeners();
    }

    // Method to handle number button clicks
    private void setNumberButtonListeners() {
        int[] numberButtonIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        for (int numberButtonId : numberButtonIds) {
            Button button = findViewById(numberButtonId);
            button.setOnClickListener(view -> {
                String currentText = screen.getText().toString();
                String newText = currentText + button.getText().toString();
                screen.setText(newText);
            });
        }
    }

    private void setOperationButtonListeners() {
        int[] operationButtonIds = {R.id.btnAdd, R.id.btnSubtract, R.id.btnAnd, R.id.btnDivide};
        for (int operationButtonId : operationButtonIds) {
            Button button = findViewById(operationButtonId);
            button.setOnClickListener(view -> {
                numero1 = Double.parseDouble(screen.getText().toString());
                operacion = button.getText().toString();
                screen.setText("");
            });
        }

        // Equals button click
        findViewById(R.id.btnEqual).setOnClickListener(view -> {
            numero2 = Double.parseDouble(screen.getText().toString());
            double result = performOperation(numero1, numero2, operacion);
            screen.setText(String.valueOf(result));
        });

        // Clear button click
        findViewById(R.id.btnCE).setOnClickListener(view -> screen.setText(""));
    }

    // Method to perform basic arithmetic operations
    private double performOperation(double numero1, double numero2, String operacion) {
        switch (operacion) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                if (numero2 == 0) return 0; // Handle division by zero
                return numero1 / numero2;
            default:
                return 0;
        }
    }
}



