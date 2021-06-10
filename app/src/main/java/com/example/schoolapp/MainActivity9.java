package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity9 extends AppCompatActivity {
Button b_viewReport;
ListView l_report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        b_viewReport=findViewById(R.id.b_viewReport);
        l_report=findViewById(R.id.l_report);

        b_viewReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReportData reportData=new ReportData(MainActivity9.this);
                List<Report> reports=reportData.getMarks();
                ArrayAdapter customerAdapter;
                customerAdapter =new ArrayAdapter<Report>(MainActivity9.this, android.R.layout.simple_list_item_1,reports);
                l_report.setAdapter(customerAdapter);
            }
        });
    }
}