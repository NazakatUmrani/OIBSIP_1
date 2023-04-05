package com.nazakatumrani.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button convertButton;
    public EditText input;
    public Spinner fromSpinner;
    public Spinner toSpinner;
    public ArrayAdapter arrayAdapterFrom;
    public ArrayAdapter arrayAdapterTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertButton = findViewById(R.id.convertButton);
        input = findViewById(R.id.inputField);
        fromSpinner = (Spinner) findViewById(R.id.spinnerFrom);
        toSpinner = (Spinner) findViewById(R.id.spinnerTo);
        arrayAdapterFrom = ArrayAdapter.createFromResource(this,R.array.spinnerFromOptions, android.R.layout.simple_spinner_item);
        arrayAdapterTo = ArrayAdapter.createFromResource(this,R.array.spinnerToOptions, android.R.layout.simple_spinner_item);
        fromSpinner.setAdapter(arrayAdapterFrom);
        toSpinner.setAdapter(arrayAdapterTo);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fromSpinner.getSelectedItem().toString().equals("Kelvin (K)")) {
                    if (toSpinner.getSelectedItem().toString().equals("Kelvin (K)"))
                        Toast.makeText(MainActivity.this, input.getText() + "K", Toast.LENGTH_SHORT).show();
                    else if (toSpinner.getSelectedItem().toString().equals("Degree Celsius (°C)")) {
                        double k = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (k - 273.15) + "°C", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Fahrenheit (°F)")) {
                        double k = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (k - 273.15) * 9 / 5 + 32 + "°F", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Rankine (°R)")) {
                        double k = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (k * 1.8) + "°F", Toast.LENGTH_SHORT).show();
                    }
                } else if (fromSpinner.getSelectedItem().toString().equals("Degree Celsius (°C)")) {
                    if (toSpinner.getSelectedItem().toString().equals("Kelvin (K)")) {
                        double c = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (c + 273.15) + "K", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Celsius (°C)")) {
                        Toast.makeText(MainActivity.this, input.getText() + "°C", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Fahrenheit (°F)")) {
                        double c = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (c * 9 / 5) + 32 + "°F", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Rankine (°R)")) {
                        double c = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, ((c * 9 / 5) + 491.67) + "°F", Toast.LENGTH_SHORT).show();
                    }
                } else if (fromSpinner.getSelectedItem().toString().equals("Degree Fahrenheit (°F)")) {
                    if (toSpinner.getSelectedItem().toString().equals("Kelvin (K)")) {
                        double f = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, ((f - 32) * 5 / 9 + 273.15) + "K", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Celsius (°C)")) {
                        double f = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (f - 32) * 5 / 9 + "°C", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Fahrenheit (°F)")) {
                        Toast.makeText(MainActivity.this, input.getText() + "°F", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Rankine (°R)")) {
                        double f = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (f + 459.67) + "°F", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (fromSpinner.getSelectedItem().toString().equals("Degree Rankine (°R)")) {
                    if (toSpinner.getSelectedItem().toString().equals("Kelvin (K)")) {
                        double r = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (r - 5/9) + "K", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Celsius (°C)")) {
                        double r = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (r - 491.67) * 5/9 + "°C", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Fahrenheit (°F)")) {
                        double r = Double.parseDouble(input.getText().toString());
                        Toast.makeText(MainActivity.this, (r - 459.67) + "°F", Toast.LENGTH_SHORT).show();
                    } else if (toSpinner.getSelectedItem().toString().equals("Degree Rankine (°R)")) {
                        Toast.makeText(MainActivity.this, input.getText() + "°R", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}