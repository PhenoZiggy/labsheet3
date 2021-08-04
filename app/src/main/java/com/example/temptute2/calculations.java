package com.example.temptute2;

import android.widget.EditText;

public class calculations {
    public static float convertCelciusToFahrenheit(Float value) {
        Float ans = (value * 9/5) + 32;
        return ans;
    }
    public float convertFahrenheitToCelcius(Float value) {
        Float ans = (value - 32) * 5/9;
        return ans;
    }
}
