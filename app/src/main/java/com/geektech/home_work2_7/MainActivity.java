package com.geektech.home_work2_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Double dFirstWar;
    private Double dSecondWar;
    private Integer firstWar, secondWar;
    private Boolean isClickOperation = false, oddNumber = false;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);

    }
    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
                break;
            case R.id.btn_clear:
                tvResult.setText("0");
                dFirstWar = 0.0;
                dSecondWar = 0.0;
                isClickOperation = false;
                oddNumber = false;
                break;
            case R.id.fractional_number:
                setNumber(".");
                break;
        }
    }

    private void setNumber(String number) {
        if (tvResult.getText().toString().equals("0") && number != ".") {
            tvResult.setText(number);
        }else if(isClickOperation) {
            tvResult.setText(number);
        }else{
            tvResult.append(number);
        }
        isClickOperation = false;
    }

    public void onOperationClick(View view) {

        switch (view.getId()) {
            case R.id.btn_plus:
                operation("+");
                break;
            case R.id.btn_minus:
                operation("-");
                break;
            case R.id.btn_multiply:
                operation("x");
                break;
            case R.id.btn_division:
                operation("/");
                break;
            case R.id.btn_modulus:
                operation("%");
                break;
            case R.id.negativeNumber:
                operation("+/-");
                break;
            case R.id.btn_equal:
                dSecondWar = Double.parseDouble(tvResult.getText().toString());
                Double dResult = 0.0;
                Integer result = 0;

                if (dFirstWar % 1 == 0.0 && dSecondWar % 1 == 0.0 && !oddNumber) {

                    firstWar = dFirstWar.intValue();
                    secondWar = dSecondWar.intValue();

                    switch (operation) {
                            case "+":
                                result = firstWar + secondWar;
                                break;
                            case "-":
                                result = firstWar - secondWar;
                                break;
                            case "x":
                                result = firstWar * secondWar;
                                break;
                            case "/":
                                result = firstWar / secondWar;
                                break;
                            case "%":
                                result = firstWar * secondWar / 100;
                                break;
                    }
                    tvResult.setText(result.toString());

                } else {
                    switch (operation) {
                        case "+":
                            dResult = dFirstWar + dSecondWar;
                            break;
                        case "-":
                            dResult = dFirstWar - dSecondWar;
                            break;
                        case "x":
                            dResult = dFirstWar * dSecondWar;
                            break;
                        case "/":
                            dResult = dFirstWar / dSecondWar;
                            break;
                        case "%":
                            dResult = dFirstWar * dSecondWar / 100;
                            break;
                    }
                    tvResult.setText(dResult.toString());
                }
                isClickOperation = true;
                break;
        }
        if (dFirstWar % 2 == 0){
            oddNumber = false;
        }
    }

    private void operation(String x) {
        dFirstWar = Double.parseDouble(tvResult.getText().toString());
        if (dFirstWar % 2 == 0){
            oddNumber = false;
        }
        isClickOperation = true;
        switch (x){
            case "+":
                operation = "+";
                break;
            case"-":
                operation = "-";
                break;
            case "x":
                operation = "x";
                break;
            case "/":
                operation = "/";
                if (dFirstWar % 2 != 0){
                    oddNumber = true;
                }else {
                    oddNumber = false;
                }
                break;
            case "%":
                operation = "%";
                break;
            case "+/-":
                operation = "+/-";
                dFirstWar *= -1;
                tvResult.setText("-" + tvResult.getText());
                break;
        }
    }

}