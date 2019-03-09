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

    double userWeight,
           converted_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_icon);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final RadioButton poundsToKilos = findViewById(R.id.pndsToKilo_rdiobtn);
        final RadioButton kilosToPounds = findViewById(R.id.kiloToPnds_rdiobtn);
        final EditText weightVal = findViewById(R.id.weightInput_edtTxt);
        Button convertWeight = findViewById(R.id.convertWeight_btn);
        final TextView displayConvertedWeight = findViewById(R.id.displayValue_txtView);

        convertWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieve and store the converted weight
                userWeight = Double.parseDouble(weightVal.getText().toString());
                if(poundsToKilos.isChecked()){
                    if(userWeight <= 500){
                        converted_weight = userWeight * 0.453592;
                        displayConvertedWeight.setText(String.format("%.1f kilograms", converted_weight));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Max Weight Exceeded", Toast.LENGTH_LONG).show();
                    }
                }
                else if (kilosToPounds.isChecked()){
                    if(userWeight <= 500){
                        converted_weight = userWeight * 2.20462;
                        displayConvertedWeight.setText(String.format("%.1f kilograms", converted_weight));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Max Weight Exceeded", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
