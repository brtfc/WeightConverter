package com.princeadom.weightconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String convertedWeight;

    //get the selected radio button
    public void getUnit(View view){

        //is the button checked?
        boolean radioBtn_checked = ((RadioButton) view).isChecked();

        //get the user input value and convert it into a double value instead of a string
        EditText userWeight = findViewById(R.id.weightInput_edtTxt);
        double inputWeight = Double.parseDouble(userWeight.getText().toString());

        //check which radio button was clicked and assign its ID to the integer variable
        switch (view.getId()){
            case R.id.KilosToPounds:
                if(radioBtn_checked){
                    convertedWeight = String.format("%.2fkg is %.2flbs",inputWeight,inputWeight * 2.20462);
                }
                break;
            case R.id.PoundsToKilos:
                if(radioBtn_checked){
                    convertedWeight = String.format("%.2flbs is %.2fkg",inputWeight,inputWeight * 0.453592);
                }
                break;

        }

    }

    //use the selected radio button to convert the weight and populate the text view area with it
    public void convertWeight(View view){
        TextView displayConvertedWeight = findViewById(R.id.displayValue_txtView);
        displayConvertedWeight.setText(convertedWeight);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
