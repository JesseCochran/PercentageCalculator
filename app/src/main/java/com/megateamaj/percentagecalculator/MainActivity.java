package com.megateamaj.percentagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView amountOff, newTotal;
    EditText percentage, currentTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountOff = findViewById(R.id.TextViewNumberEqualResult);
        newTotal = findViewById(R.id.TextViewRemaining);
        percentage = findViewById(R.id.editTextNumberPercentage);
        currentTotal = findViewById(R.id.editTextNumber);

        percentage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             calculatePercentage();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        currentTotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculatePercentage();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void calculatePercentage() {
        String numberText = currentTotal.getText().toString();
        String percentageText = percentage.getText().toString();
        if (!numberText.isEmpty() && !percentageText.isEmpty()){
            double number = Double.parseDouble(numberText);
            double percentage = Double.parseDouble(percentageText);

            //shows decimals
            double percentageOff = number * (percentage / 100);
            double total = number - percentageOff;
//            newTotal.setText("" + total);
//            amountOff.setText("" + percentageOff);

            String formattedResult;
            if (percentageOff == (int) percentageOff) {
                formattedResult = String.format("%d", (int) percentageOff); // Show as integer if it's a whole number
            } else {
                formattedResult = String.format("%.2f", percentageOff); // Show as decimal with two decimal places
            }
            amountOff.setText(formattedResult);

            String formattedTotal;
            if (total == (int) total) {
                formattedTotal = String.format("%d", (int) total); // Show as integer if it's a whole number
            } else {
                formattedTotal = String.format("%.2f", total); // Show as decimal with two decimal places
            }
            newTotal.setText(formattedTotal);
        }
        else{
            newTotal.setText("");
            amountOff.setText("");
        }
    }
}