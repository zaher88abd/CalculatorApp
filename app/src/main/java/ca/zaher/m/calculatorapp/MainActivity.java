package ca.zaher.m.calculatorapp;

import android.annotation.SuppressLint;
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

    @SuppressLint("SetTextI18n")
    private void showResult() {
        if (operation != '!' && !isNewEquation)
            switch (operation) {
                case '+':
                    setTVResult(temp + Double.parseDouble(textView.getText().toString()));
                    break;
                case '-':
                    setTVResult(temp - Double.parseDouble(textView.getText().toString()));
                    break;
                case '*':
                    setTVResult(temp * Double.parseDouble(textView.getText().toString()));
                    break;
                case '/':
                    if (!textView.getText().toString().equals("0")) {
                        setTVResult(temp / Double.parseDouble(textView.getText().toString()));
                    } else {
                        textView.setText(R.string.divied_by_zero);
                    }
                    break;
            }
        operation = '!';
        isNewEquation = true;
        tv_operation.setText("");
    }

    private void enterOperation(char c) {
        tv_operation.setText(String.valueOf(c));
        if (operation == '!') {
            operation = c;
            isNewEquation = true;
            temp = Double.parseDouble(textView.getText().toString());
        } else if (isNewEquation) {
            operation = c;
        } else {
            switch (operation) {
                case '+':
                    setTVResult(temp + Double.parseDouble(textView.getText().toString()));
//                    textView.setText(String.valueOf(temp + Double.parseDouble(textView.getText().toString())));
                    break;
                case '-':
                    setTVResult(temp - Double.parseDouble(textView.getText().toString()));
//                    textView.setText(String.valueOf(temp - Double.parseDouble(textView.getText().toString())));
                    break;
                case '*':
                    setTVResult(temp * Double.parseDouble(textView.getText().toString()));
//                    textView.setText(String.valueOf(temp * Double.parseDouble(textView.getText().toString())));
                    break;
                case '/':
                    if (!textView.getText().toString().equals("0"))
                        setTVResult(temp / Double.parseDouble(textView.getText().toString()));
//                        textView.setText(String.valueOf(temp / Double.parseDouble(textView.getText().toString())));
                    else {
                        textView.setText(R.string.divied_by_zero);
                    }
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
        tv_operation.setText("");
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
            String temp_string = textView.getText().toString() + ".";
            textView.setText(temp_string);
            isNewEquation = false;
            isFlatNumber = true;
        }

    }

    public void enterNumber(String num) {
        if (isNewEquation) {
            textView.setText(num);
            isNewEquation = false;
        } else {
            String temp_string = textView.getText().toString() + num;
            textView.setText(temp_string);
        }
    }

    public void setTVResult(double value) {
        if ((value - (long) value) > 0) {
            textView.setText(String.valueOf(value));
        } else {
            textView.setText(String.valueOf((long) value));

        }

    }
}
