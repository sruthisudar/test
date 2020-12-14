package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    ArrayList<Register> regList = new ArrayList<>();
    ArrayList<String> courseNames = new ArrayList<>();
    Spinner sp;
    Button addButton;
    RadioButton graduated, ungraduated;
    CheckBox accomodation, medical;
    TextView welcome, hours,fees,cost;
    public static double originalFees=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome=findViewById(R.id.welcomeMember);
        welcome.setText("Welcome back "+LoginActivity.studentName);
        sp =findViewById(R.id.spCourses);
        hours=findViewById(R.id.totalHours);
        fees=findViewById(R.id.totalFees);
        cost=findViewById(R.id.totalCost);
        accomodation=findViewById(R.id.ckAccomodation);
        medical=findViewById(R.id.ckMedical);
        graduated=findViewById(R.id.rdGraduated);
        ungraduated=findViewById(R.id.rdUngraduated);
        addButton=findViewById(R.id.addBtn);
        fillData();
     //fill the first spinner with cuisine names
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,courseNames);
        sp.setAdapter(a);
        hours.setText(String.valueOf(regList.get(0).getHours()));
        originalFees=regList.get(0).getFees();
        sp.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        graduated.setOnClickListener(this);
        ungraduated.setOnClickListener(this);

        accomodation.setOnCheckedChangeListener(new ChkBoxEvent());
        medical.setOnCheckedChangeListener(new ChkBoxEvent());
        addButton.setOnClickListener(this);

        // filling the spinner
        ArrayAdapter i = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,courseNames);
        sp.setAdapter(i);
        sp.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        // setting total to first value of the dropDown Menu
        cost.setText(Double.toString(regList.get(0).getFees())); // changing double to String type
    }

    public void fillData(){
        regList.add(new Register("Java",6,1300));
        regList.add(new Register("Swift",5,1500));
        regList.add(new Register("iOS",5,1100));
        regList.add(new Register("Android",7,1400));
        regList.add(new Register("DataBase",4,1000));
        for (int i = 0;i < regList.size(); i++){
            courseNames.add(regList.get(i).getCourses());  // filling the arraylist with the name of coffee types
        }

    }
@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    graduated.setChecked(true);
    hours.setText(Double.toString(Double.parseDouble(regList.get(position).getCourses())));// changing double to String type
    originalFees= Double.parseDouble(regList.get(position).getCourses());

        }

@Override
public void onNothingSelected(AdapterView<?> parent) {

        }

@Override
public void onClick(View v) {
        double tot = originalFees;


        switch (v.getId()){
        case R.id.rdGraduated:
        tot = originalFees ;
        break;
        case R.id.rdUngraduated:
        tot = originalFees ;
        break;
        case R.id.addBtn:
        double cost = parseDouble(fees.getText().toString());
        int fees = Integer.parseInt(hours.getText().toString());
            cost *=fees;
            tot = fees;
            break;
            default:
        }
        hours.setText(String.format("%.2f",tot));

        }

    private class ChkBoxEvent implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            double tot=Double.parseDouble(hours.getText().toString());
            if (compoundButton.getId()==R.id.ckAccomodation)
                if(accomodation.isChecked())
                    tot+=1000;
                else
                    tot-=0;
            if (compoundButton.getId()==R.id.ckMedical)
                if(medical.isChecked())
                    tot+=700;
                else
                    tot-=0;
            cost.setText(String.format("%.2f",tot));



        }
    }

}





