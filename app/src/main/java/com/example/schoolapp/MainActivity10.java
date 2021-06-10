package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity10 extends AppCompatActivity {
Spinner spinner_Subject;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        spinner_Subject=findViewById(R.id.spinner_Subject);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.student_class, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_Subject.setAdapter(adapter);
        textView=findViewById(R.id.textView9);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String subject=parent.getItemAtPosition(position).toString();
        textView.setText(subject);
        }
    public void onNothingSelected(AdapterView<?> parent) {

    }
    }