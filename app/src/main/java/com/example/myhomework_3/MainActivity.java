package com.example.myhomework_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private int firstOperand, secondOperand;
    private boolean is0perationClich;

    private Button button;
    String operator = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_open);
        button.setOnClickListener(view -> {
            Bundle bunble = new Bundle();
            bunble.putString("RESULT", textView.getText().toString());
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("BUDLE", bunble);
            startActivity(intent);
            finish();
        });


        // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //     Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //   v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //    return insets;
        //  });
        textView = findViewById(R.id.text_view);
    }

    public void onNamberClick(View view) {

        String textButton = ((MaterialButton) view).getText().toString();

        if (textButton.equals("AC")) {
            textView.setText("0");
            firstOperand = 0;

        } else if (textView.getText().toString().equals("0") || is0perationClich) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }

        is0perationClich = false;
    }

    public void onOperationClick(View view) {
        Button button = (Button) view;
        if (view.getId() != R.id.btn_equal) {
            firstOperand = Integer.parseInt(textView.getText().toString());
            operator = button.getText().toString();
        } else {
            secondOperand = Integer.parseInt(textView.getText().toString());
            // 33         12             21
            int result;

            switch (operator) {
                case "/":
                    result = firstOperand / secondOperand;
                    break;
                case "X":
                    result = firstOperand * secondOperand;
                    break;
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                default:
                    result = firstOperand - secondOperand;
            }
            textView.setText(String.valueOf(result));

        }

        is0perationClich = true;
    }

}