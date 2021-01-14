package com.sowmith.currencyconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText dollarValue;
    private EditText rupeeValue;
    private Button convertButton;
    private Button clearButton;
    private Context context;
    private double conversionFactor = 73.15;
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String dollar;
            String rupee;
            try {
                dollar = dollarValue.getText().toString();
                rupee = rupeeValue.getText().toString();
            } catch (NumberFormatException e) {
                Toast.makeText(context,"Please enter a currency value in numericals",Toast.LENGTH_LONG).show();
                return;
            }

            if(dollar.isEmpty() && rupee.isEmpty()) {
                Toast.makeText(context,"Please enter a currency to convert",Toast.LENGTH_LONG).show();
                return;
            }

            if(!dollar.isEmpty() && !rupee.isEmpty()) {
                Toast.makeText(context,"Please enter only a single currency to convert",Toast.LENGTH_LONG).show();
                return;
            }

            if(!dollar.isEmpty()) {
                double dollarV = Double.parseDouble(dollar);

                double rupeeV = dollarV*conversionFactor;

                rupeeValue.setText(String.valueOf(rupeeV));
            } else if(!rupee.isEmpty()) {
                double rupeeV = Double.parseDouble(rupee);

                double dollarV = rupeeV/conversionFactor;

                rupeeValue.setText(String.valueOf(dollarV));
            }

        }
    };
    private View.OnClickListener clearButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rupeeValue.setText("");
            dollarValue.setText("");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        dollarValue = (EditText) findViewById(R.id.dollarValue);
        rupeeValue = (EditText) findViewById(R.id.rupeeValue);
        convertButton = (Button) findViewById(R.id.convertBtn);
        clearButton = (Button) findViewById(R.id.clearBtn);

        convertButton.setOnClickListener(buttonClickListener);
        clearButton.setOnClickListener(clearButtonClickListener);
    }


}
