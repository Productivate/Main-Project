package com.example.speterson6738.calender;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;


public class NewEvent extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        final EditText name=(EditText) findViewById(R.id.editTextAssignmentName);
        final Button submit=(Button) findViewById(R.id.buttonSubmit);
        final EditText course=(EditText) findViewById(R.id.editTextCourse);
        final EditText duration=(EditText) findViewById(R.id.editTextduration);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//user enters in information for the new event/assignment and it saves it then goes back to calendar
                final float time=Float.parseFloat(duration.getText().toString());

                final Assignment ex;
                SharedPreferences sharedPreferences=getSharedPreferences("Storage", Context.MODE_PRIVATE);


                ex=new Assignment(0,time,name.getText().toString(),course.getText().toString());
                ex.store(sharedPreferences);
                returnEvent(ex);

            }
        });


//http://www.law.auckland.ac.nz/en/about/news/news-stories/news-2015/07/2015SparkIdeasChallengeWinners.html

    }

    public void returnEvent( Assignment assignment)
    {
        Intent intent=new Intent(this, Calendar.class);
        startActivity(intent);

    }
}




