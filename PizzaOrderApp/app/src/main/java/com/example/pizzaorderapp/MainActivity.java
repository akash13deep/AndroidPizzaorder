package com.example.pizzaorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    double prices[] = {9,10,8,8.5,9.5};
    static int i;

   TextView ttv;
Spinner sp;
RadioGroup rg1,rg2;
RadioButton rb1,rb2,rb3,rb4,rb5;
CheckBox cb1,cb2,cb3,cb4,cb5,cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttv = findViewById(R.id.totaltv);

        sp = findViewById(R.id.spinner);

        rg1 = findViewById(R.id.radioGroup);
        rg2 = findViewById(R.id.radioGroup2);

        rb1 = findViewById(R.id.small);
        rb2 = findViewById(R.id.medium);
        rb3 = findViewById(R.id.large);
        rb4 = findViewById(R.id.deli);
        rb5 = findViewById(R.id.pick);

        cb1 = findViewById(R.id.chickencheck);
        cb2 = findViewById(R.id.beefcheck);
        cb3 = findViewById(R.id.pinecheck);
        cb4 = findViewById(R.id.pappcheck);
        cb5 = findViewById(R.id.drinkcheck);
        cb6 = findViewById(R.id.dipcheck);

        cb1.setOnClickListener(this);
        cb2.setOnClickListener(this);
        cb3.setOnClickListener(this);
        cb4.setOnClickListener(this);
        cb5.setOnClickListener(this);
        cb6.setOnClickListener(this);

        List<String> pizzatype = new ArrayList<>();

        pizzatype.add("Neapolitan Pizza");
        pizzatype.add("Chicago Pizza");
        pizzatype.add("Sicilian Pizza");
        pizzatype.add("California Pizza");
        pizzatype.add("Detroit Pizza");

        ArrayAdapter pAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,pizzatype);

        pAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp.setAdapter(pAdapter);
        sp.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v)
    {
       double price = Double.parseDouble(ttv.getText().toString());
        switch(v.getId())
        {
            case R.id.chickencheck:
                if(cb1.isChecked())
                    price+=1;
                else
                    price-=1;

             break;

            case R.id.beefcheck:
                if(cb2.isChecked())
                    price+=1;
                else
                    price-=1;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        i = position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
 //onSelectedItem method    --------  i = position

