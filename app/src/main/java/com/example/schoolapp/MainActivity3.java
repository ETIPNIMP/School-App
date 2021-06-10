package com.example.schoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Spinner spinner_class;
TextView textView;
EditText ed_name,ed_Father,ed_phone,ed_mother,ed_age,ed_email,ed_address,ed_rollno;
Button b_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        spinner_class=findViewById(R.id.spinner_class);
        ed_name=findViewById(R.id.ed_name);
        ed_Father=findViewById(R.id.ed_Father);
        ed_mother=findViewById(R.id.ed_Mother);
        ed_age=findViewById(R.id.ed_age);
        ed_phone=findViewById(R.id.ed_Phone);
        ed_email=findViewById(R.id.ed_email);
        ed_address=findViewById(R.id.ed_address);
        ed_rollno=findViewById(R.id.ed_rollno);
        b_submit=findViewById(R.id.b_submit);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.student_class, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_class.setAdapter(adapter);
        spinner_class.setOnItemSelectedListener(this);
        textView=findViewById(R.id.textView6);

        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentModel studentModel;
                try {
                    studentModel=new StudentModel(ed_rollno.getText().toString(),ed_name.getText().toString(),ed_Father.getText().toString()
                            ,ed_mother.getText().toString(),ed_phone.getText().toString(),ed_age.getText().toString()
                            ,ed_email.getText().toString(),ed_address.getText().toString());
                    Toast.makeText(MainActivity3.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity3.this, "error creating", Toast.LENGTH_SHORT).show();
                    studentModel=new StudentModel("error","error","error","error","error","error","error","error");
                }
               boolean success;
               try(StudentData studentData=new StudentData(MainActivity3.this)) {
                   success = studentData.addOne(studentModel);
               }
                Toast.makeText(MainActivity3.this, "Successful"+success, Toast.LENGTH_SHORT).show();
            }
        });
    }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text=parent.getItemAtPosition(position).toString();
                textView.setText("Your Class is:"+ text);
                if(position == 10){
                Intent class11=new Intent(this,MainActivity10.class);
            startActivity(class11);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}