package com.mutinda.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private EditText calculations;
    private TextView resultTextView;
    private Button radianButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculations = findViewById(R.id.calculations_txtView);
        resultTextView = findViewById(R.id.result_txtView);
        radianButton = findViewById(R.id.radianButton);

        calculations.setShowSoftInputOnFocus(false);

    }


    private void InputText(String num){
        String oldString = calculations.getText().toString();

        int cursorPosition = calculations.getSelectionStart();
        String leftSubStr = oldString.substring(0,cursorPosition);
        String rightSubStr = oldString.substring(cursorPosition);

        calculations.setText(String.format("%s%s%s", leftSubStr, num, rightSubStr));
        calculations.setSelection(cursorPosition + num.length());
    }
    public void leftBracketOnClick(View view) {
        InputText(getResources().getString(R.string.leftbracket));
    }

    public void clearOnClick(View view) {
        calculations.setText("");
        resultTextView.setText("");
    }

    public void rightBracketOnClick(View view) {
        InputText(getResources().getString(R.string.rightbracket));
    }

    public void divideOnClick(View view) {
        InputText(getResources().getString(R.string.division));
    }

    public void sevenOnCLick(View view) {
        InputText(getResources().getString(R.string.seven));
    }

    public void eightOnCLick(View view) {
        InputText(getResources().getString(R.string.eight));    }

    public void nineOnCLick(View view) {
        InputText(getResources().getString(R.string.nine));    }

    public void mutliplyOnCLick(View view) {
        InputText(getResources().getString(R.string.multiply));
    }

    public void fourOnCLick(View view) {
        InputText(getResources().getString(R.string.four));    }

    public void fiveOnCLick(View view) {
        InputText(getResources().getString(R.string.five));    }

    public void sixOnCLick(View view) {
        InputText(getResources().getString(R.string.six));    }

    public void minusOnCLick(View view) {
        InputText(getResources().getString(R.string.minus));
    }

    public void oneOnCLick(View view) {
        InputText(getResources().getString(R.string.one));    }

    public void twoOnCLick(View view) {
        InputText(getResources().getString(R.string.two));    }

    public void threeOnCLick(View view) {
        InputText(getResources().getString(R.string.three));    }

    public void addOnCLick(View view) {
        InputText(getResources().getString(R.string.add));
    }

    public void percentOnCLick(View view) {
        InputText(getResources().getString(R.string.percentage));
    }

    public void zeroOnCLick(View view) {
        InputText(getResources().getString(R.string.zero));    }

    public void decimalOnCLick(View view) {
        InputText(getResources().getString(R.string.decimal_point));
    }

    public void equalOnCLick(View view) {
        String userExpression = calculations.getText().toString();

        userExpression = userExpression.replaceAll(getResources().getString(R.string.multiply), "*");
        userExpression = userExpression.replaceAll("log", "log10");

        Expression exp = new Expression(userExpression);
        String result = String.valueOf(exp.calculate());


        resultTextView.setText(userExpression);
        calculations.setText(result);
        calculations.setSelection(result.length());
    }

    public void backspaceOnClick(View view) {
        int cursorPos = calculations.getSelectionStart();
        int textLen = calculations.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selected = (SpannableStringBuilder) calculations.getText();
            selected.replace(cursorPos-1, cursorPos, "");
            calculations.setText(selected);
            calculations.setSelection(cursorPos-1);
    }
}

    public void radOnClick(View view) {
        radianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonTxt = radianButton.getText().toString();
                if(buttonTxt.equals(getResources().getString(R.string.radian))){
                    radianButton.setText(getResources().getString(R.string.degrees));
                }else{
                    radianButton.setText(getResources().getString(R.string.radian));
                }
            }
        });
    }

    public void squareRootOnClick(View view) {
        InputText("√(");
    }

    public void sineOnClick(View view) {
        InputText("sin(");
    }

    public void cosineOnClick(View view) {
        InputText("cos(");
    }

    public void tangentOnClick(View view) {
        InputText("tan(");
    }

    public void naturalLogOnClick(View view) {
        InputText("ln(");
    }

    public void logarithmOnClick(View view) {
        InputText("log(");
    }

    public void inverseOnClick(View view) {
        InputText("1/");
    }

    public void powerexpOnClick(View view) {
        InputText("e^(");
    }

    public void squareOnClick(View view) {
        InputText("^(2)");
    }

    public void powerOnclick(View view) {
        InputText("^");
    }

    public void absoluteOnClick(View view) {
        InputText("abs(");
    }

    public void piOnClick(View view) {
        InputText("πX");
    }

    public void exponentialOnClick(View view) {
        InputText("e(");
    }
}