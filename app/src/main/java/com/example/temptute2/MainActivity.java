package com.example.temptute2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_value;
    RadioButton btn_celsius;
    RadioButton btn_faren;
    Button button;
    TextView answer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final EditText et_value = findViewById(R.id.et_value);
        //et_value = findViewById(R.id.et_value);
        btn_celsius = findViewById(R.id.btn_celsius);
        btn_faren = findViewById(R.id.btn_faren);
        button = findViewById(R.id.button);
        answer = findViewById(R.id.answer);
    }
    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    calculations calculations = new calculations();
    String temp_value = et_value.getText().toString();

    private void calculateAnswer() {
        if(TextUtils.isEmpty(temp_value)){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Float temp = Float.parseFloat(temp_value);
            if( btn_celsius.isChecked()){

// convert it into Fahrenheit and display the answer
                temp = calculations.convertCelciusToFahrenheit(temp);
            }
            else if (btn_faren.isChecked()){
// convert it into Celcius and display the answer
                temp = calculations.convertFahrenheitToCelcius(temp);
            }
            else{
                Toast.makeText(this, "PLease select a Radio",
                        Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }
            answer.setText(new Float(temp).toString());



        }
    }

}