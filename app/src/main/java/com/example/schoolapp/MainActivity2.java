package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
Button b_createStudent,b_project,b_showStudent,b_showReport,b_report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b_createStudent=findViewById(R.id.b_CreateAccount);
        b_project=findViewById(R.id.b_Project);
        b_report=findViewById(R.id.b_card);
        b_showStudent=findViewById(R.id.b_showStudent);
        b_showReport=findViewById(R.id.b_showReport);
    }
    public void openCreateStudent(View v){
        Intent student=new Intent(this,MainActivity3.class);
        startActivity(student);
    }
    public void openProject(View v){
        Intent project=new Intent(this,MainActivity4.class);
        startActivity(project);
    }
    public void openReport(View v){
        Intent report=new Intent(this,MainActivity6.class);
        startActivity(report);
    }

    public void openShowStudent(View v){
        Intent showStudent=new Intent(this,MainActivity7.class);
        startActivity(showStudent);
    }
    public void openShowReport(View v){
        Intent showReport=new Intent(this,MainActivity9.class);
        startActivity(showReport);
    }
}
