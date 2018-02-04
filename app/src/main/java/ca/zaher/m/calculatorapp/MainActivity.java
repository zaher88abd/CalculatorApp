package ca.zaher.m.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    char operation = '!'; // to save teh operation
    boolean isNewEquation = true; // to know start write for begin
    boolean isFlatNumber = false; // to know the number is has float point
    double temp; // to save the number
    TextView textView;
    //// TODO: 2018-02-04 view operation sighn

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                enterNumber("0");
                break;
            case R.id.btn_1:
                enterNumber("1");
                break;
            case R.id.btn_2:
                enterNumber("2");
                break;
            case R.id.btn_3:
                enterNumber("3");
                break;
            case R.id.btn_4:
                enterNumber("4");
                break;
            case R.id.btn_5:
                enterNumber("5");
                break;
            case R.id.btn_6:
                enterNumber("6");
                break;
            case R.id.btn_7:
                enterNumber("7");
                break;
            case R.id.btn_8:
                enterNumber("8");
                break;
            case R.id.btn_9:
                enterNumber("9");
                break;
            case R.id.btn_clear:
                clear();
                break;
            case R.id.btn_clear_all:
                clearAll();
                break;
            case R.id.btn_sum:
                enterOperation('+');
                break;
            case R.id.btn_sub:
                enterOperation('-');
                break;
            case R.id.btn_mult:
                enterOperation('*');
                break;
            case R.id.btn_division:
                enterOperation('/');
                break;
            case R.id.btn_sqr:
                textView.setText(String.valueOf(Math.sqrt(Double.parseDouble(textView.getText().toString()))));

                break;
            case R.id.btn_change:
                textView.setText(String.valueOf(-1 * Double.parseDouble(textView.getText().toString())));
                break;
            case R.id.btn_equal:
                showResult();
                break;
            case R.id.btn_float:
                enterFloatNumber();
                break;
        }
    }

    private void showResult() {
        if (operation != '!' && !isNewEquation)
            switch (operation) {
                case '+':
                    textView.setText(String.valueOf(temp + Double.parseDouble(textView.getText().toString())));
                    break;
                case '-':
                    textView.setText(String.valueOf(temp - Double.parseDouble(textView.getText().toString())));
                    break;
                case '*':
                    textView.setText(String.valueOf(temp * Double.parseDouble(textView.getText().toString())));
                    break;
                case '/':
                    if (!textView.getText().toString().equals("0"))
                        textView.setText(String.valueOf(temp / Double.parseDouble(textView.getText().toString())));
                    break;
            }
        operation = '!';
        isNewEquation = true;
    }

    private void enterOperation(char c) {
        if (operation == '!' && !isNewEquation) {
            operation = c;
            isNewEquation = true;
            temp = Double.parseDouble(textView.getText().toString());
        } else if (operation != '!' && isNewEquation) {
            operation = c;
        } else if (operation != '!' && !isNewEquation) {
            switch (operation) {
                case '+':
                    textView.setText(String.valueOf(temp + Double.parseDouble(textView.getText().toString())));
                    break;
                case '-':
                    textView.setText(String.valueOf(temp - Double.parseDouble(textView.getText().toString())));
                    break;
                case '*':
                    textView.setText(String.valueOf(temp * Double.parseDouble(textView.getText().toString())));
                    break;
                case '/':
                    if (!textView.getText().toString().equals("0"))
                        textView.setText(String.valueOf(temp / Double.parseDouble(textView.getText().toString())));
                    break;
            }
            operation = c;
            isNewEquation = true;
            temp = Double.parseDouble(textView.getText().toString());

        }

    }

    private void clearAll() {
        textView.setText(getString(R.string.default_text));
        operation = '!';
        isNewEquation = true;
        isFlatNumber = false;
        temp = 0;
    }

    private void clear() {
        textView.setText(getString(R.string.default_text));
        isNewEquation = true;
    }

    private void enterFloatNumber() {
        if (!isFlatNumber) {
            textView.setText(textView.getText().toString() + ".");
            isNewEquation = false;
            isFlatNumber = true;
        }

    }

    public void enterNumber(String num) {
        if (isNewEquation) {
            textView.setText(num);
            isNewEquation = false;
        } else {
            textView.setText(textView.getText().toString() + num);
        }
    }
}
