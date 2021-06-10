package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity7 extends AppCompatActivity {
ListView list_Show;
Button b_ViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        list_Show=findViewById(R.id.list_Show);
        b_ViewData=findViewById(R.id.b_ViewData);

        b_ViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentData studentData=new StudentData(MainActivity7.this);
                List<StudentModel> studentModels=studentData.getEveryone();
                ArrayAdapter customerAdapter;
                customerAdapter =new ArrayAdapter<StudentModel>(MainActivity7.this, android.R.layout.simple_list_item_1,studentModels);
                list_Show.setAdapter(customerAdapter);
            }
        });
    }
}