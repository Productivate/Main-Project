package com.example.speterson6738.calender;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ClassView extends AppCompatActivity {//does not work yet

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("Storage", Context.MODE_PRIVATE);
        Assignment[] AssignmentList;
        int x = (int) sharedPreferences.getFloat("num", 0);
        AssignmentList = new Assignment[x];

        for (int i = 0; i < x; i++) {
            Assignment temp = new Assignment(0, 0, "null", "null");
            temp.accessByNum(sharedPreferences, i);
            AssignmentList[i] = temp;
        }


        int num=findNumofCourse(AssignmentList, sharedPreferences);



        TextView[] tv = new TextView[num];
        TextView temp;
        int y=0;

        for (int i = 0; i < num; i++)
        {

            temp = new TextView(this);

            temp.setText( AssignmentList[i].course); //arbitrary task
            temp.setY(y);
            y+=50;

            // add the textview to the linearlayout
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rlayout);
            relativeLayout.addView(temp);

            tv[i] = temp;
        }

       /* for (int i = 0; i < x; i++)
        {

            temp = new TextView(this);

            temp.setText( AssignmentList[i].name); //arbitrary task
            temp.setY(y);
            y+=50;

            // add the textview to the linearlayout
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rlayout);
            relativeLayout.addView(temp);

            tv[i] = temp;
        }*/


        /*String course1=AssignmentList[0].course;
        TextView C1=(TextView)findViewById(R.id.textViewCourse1);
        C1.setText(course1);
        TextView C1AS1=(TextView)findViewById(R.id.textViewC1AS1);
        C1AS1.setText(AssignmentList[0].name);
        TextView C1AS2=(TextView)findViewById(R.id.textViewC1AS2);

        for (int i=1; i<x; i++)
        {
            if(AssignmentList[i].course.equals(course1)) {
                C1AS2.setText(AssignmentList[i].name);
            }
        }*/


    }


    int findNumofCourse(Assignment[] AssignmentList, SharedPreferences sharedPreferences) {
        int x = (int) sharedPreferences.getFloat("num", 0);

        int m = 0;
        boolean g = false;

        for (int i = 0; i < x; i++) {
            String test = AssignmentList[i].course;
            for (int j = i-1; j > 0; j--) {

                if (test.equals(AssignmentList[j].course)) {
                    g = true;
                }

            }
            if (!g) {

                m++;

            }
            g=false;
        }

        return m;


    }
}


