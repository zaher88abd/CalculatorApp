package ca.zaher.m.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    char operation = '!';
    boolean isNewEquation = true;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                enterNumer(0);
                break;
            case R.id.btn_1:
                enterNumer(1);
                break;
            case R.id.btn_2:
                enterNumer(2);
                break;
            case R.id.btn_3:
                enterNumer(3);
                break;
            case R.id.btn_4:
                enterNumer(4);
                break;
            case R.id.btn_5:
                enterNumer(5);
                break;
            case R.id.btn_6:
                enterNumer(6);
                break;
            case R.id.btn_7:
                enterNumer(7);
                break;
            case R.id.btn_8:
                enterNumer(8);
                break;
            case R.id.btn_9:
                enterNumer(9);
                break;
        }
    }

    public void enterNumer(int num) {
        if (isNewEquation) {
            textView.setText(num);
            isNewEquation = false;
        } else {
            textView.setText((String) textView.getText() + num);
        }
    }
}
