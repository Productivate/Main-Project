package com.example.speterson6738.calender;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class editEvent extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        final EditText name=(EditText) findViewById(R.id.editTextAssignmentName2);
        final Button save=(Button) findViewById(R.id.buttonSave);
        final EditText course=(EditText) findViewById(R.id.editTextCourse2);
        final EditText duration=(EditText) findViewById(R.id.editTextduration2);
        final Button delete=(Button) findViewById(R.id.buttonDelete);
        final Button Goback=(Button) findViewById(R.id.buttonGb);
        Bundle bundle=getIntent().getExtras();
        final int num=bundle.getInt("num");
        final Assignment example=new Assignment(0,0,"0","0");
        final SharedPreferences sharedPreferences = getSharedPreferences("Storage", Context.MODE_PRIVATE);
        example.accessByNum(sharedPreferences, num);

        name.setText(example.name);
        course.setText(example.course);
        duration.setText(Float.toString(example.duration));


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//user enters in information for the new event/assignment and it saves it then goes back to calendar
                final float time=Float.parseFloat(duration.getText().toString());

                final Assignment ex;
                SharedPreferences sharedPreferences=getSharedPreferences("Storage", Context.MODE_PRIVATE);


                ex=new Assignment(0,time,name.getText().toString(),course.getText().toString());
                ex.store(sharedPreferences);
                goBack();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                example.clearByNum(sharedPreferences, num);
                goBack();
            }
        });






    }

    public void goBack()
    {
        Intent intent=new Intent(this, ClassView.class);
        startActivity(intent);

    }
}