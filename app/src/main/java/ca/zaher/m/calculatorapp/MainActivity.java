package ca.zaher.m.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    char operation = '!';
    boolean isNewEquation = true;
    boolean isFlatNumber = false;
    double temp;
    TextView textView;
    TextView tv_operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        tv_operation = findViewById(R.id.tv_operation);
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
                enterOperation('s');
                break;
            case R.id.btn_change:
                operation = 'c';
                break;
            case R.id.btn_equal:
                operation = '=';
                break;
            case R.id.btn_float:
                enterFloatNumber();
                break;
        }
    }

    private void enterOperation(char c) {
        if (operation == '!' && isNewEquation == false) {
            operation = c;
            tv_operation.setText(String.valueOf(c));
            isNewEquation = true;
            temp = Double.parseDouble(textView.getText().toString());
        } else if (operation != '!' && isNewEquation == true) {
            operation = c;
            tv_operation.setText(String.valueOf(c));
        } else if (operation != '!' && isNewEquation == false) {
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
            tv_operation.setText(String.valueOf(c));
            isNewEquation = true;
            temp = Double.parseDouble(textView.getText().toString());

        }

    }

    private void clearAll() {
        textView.setText(getString(R.string.default_text));
        operation = '!';
        isNewEquation = true;
        isFlatNumber = false;
    }

    private void clear() {
        textView.setText(getString(R.string.default_text));
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
