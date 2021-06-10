package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner_report;
    TextView textView,textView1;
    EditText ed_Maths,ed_Science,ed_Social,ed_hindi,ed_Computer,ed_English;
    Button b_total,b_report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        spinner_report=findViewById(R.id.spinner_report);
        textView=findViewById(R.id.textView13);
        textView1=findViewById(R.id.textView14); 
        ed_Science=findViewById(R.id.ed_Science);
        ed_English=findViewById(R.id.ed_English);
        ed_hindi=findViewById(R.id.ed_hindi);
        ed_Social=findViewById(R.id.ed_social);
        ed_Maths=findViewById(R.id.ed_Maths);
        ed_Computer=findViewById(R.id.ed_Computer);
        b_total=findViewById(R.id.b_total);
        b_report=findViewById(R.id.b_report);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Choose_class, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_report.setAdapter(adapter);
        spinner_report.setOnItemSelectedListener(this);
        b_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double maths=Double.parseDouble(ed_Maths.getText().toString());
                double science=Double.parseDouble(ed_Science.getText().toString());
                double english=Double.parseDouble(ed_English.getText().toString());
                double hindi=Double.parseDouble(ed_hindi.getText().toString());
                double social=Double.parseDouble(ed_Social.getText().toString());
                double computer=Double.parseDouble(ed_Computer.getText().toString());
                double result=(maths+science+english+hindi+social+computer)/600*100;
                textView1.setText(Double.toString(result));
            }
        });



        b_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Report report;
                try{
                    report=new Report(textView.getText().toString(),Integer.parseInt(ed_Maths.getText().toString())
                    ,Integer.parseInt(ed_Science.getText().toString()),Integer.parseInt(ed_Social.getText().toString())
                    ,Integer.parseInt(ed_hindi.getText().toString()),Integer.parseInt(ed_English.getText().toString())
                    ,Integer.parseInt(ed_Computer.getText().toString()),textView1.getText().toString());
                    Toast.makeText(MainActivity6.this,report.toString(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity6.this, "Error Creating", Toast.LENGTH_SHORT).show();
                    report=new Report("error",0,0,0,0,0,0,"error");
                }
                boolean success;
                try(ReportData reportData=new ReportData(MainActivity6.this)){
                    success=reportData.addMarks(report);
                }
                Toast.makeText(MainActivity6.this, "Successful"+success, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String report=parent.getItemAtPosition(position).toString();
        textView.setText(report);
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }

}