package ca.zaher.m.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    char operation = '!';
    boolean isNewEquation = true;
    boolean isFlatNumber = false;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
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
                operation = '+';
                break;
            case R.id.btn_sub:
                operation = '-';
                break;
            case R.id.btn_mult:
                operation = '*';
                break;
            case R.id.btn_division:
                operation = '/';
                break;
            case R.id.btn_sqr:
                operation = 's';
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


    private void clearAll() {

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
