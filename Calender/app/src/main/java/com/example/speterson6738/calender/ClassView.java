package com.example.speterson6738.calender;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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


        int[] num=findNumofCourse(AssignmentList, sharedPreferences);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llayout);



        TextView[] tv = new TextView[num.length];
       TextView temp;
        int y=0;

        for (int i = 0; i < num.length; i++)
        {

            temp = new TextView(this);

            temp.setText( AssignmentList[i].course);
            temp.setY(y);
            y+=50;


            linearLayout.addView(temp);

            tv[i] = temp;

        }

        TextView[] as=new TextView[AssignmentList.length];
        TextView tempas;

        for (int i = 0; i < AssignmentList.length; i++)
        {

            tempas = new TextView(this);

            tempas.setText( AssignmentList[num[i]].name); //arbitrary task
            tempas.setY(y);
            y+=50;


            linearLayout.addView(tempas);

           as[i] = tempas;
        }

    }

   int[] findNumofCourse(Assignment[] AssignmentList, SharedPreferences sharedPreferences) {
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
        int[]array;


        array =new int[m];
       array[0]=0;
        for (int i = 0; i < x; i++) {
            String test = AssignmentList[i].course;
            for (int j = i-1; j > 0; j--) {

                if (test.equals(AssignmentList[j].course)) {
                    g = true;
                }
            }
            if (!g) {
                for(int k=1;k<m;k++)
                {
                    if(array[k]==0) {
                        array[k]=i;
                    }
                }

            }
            g=false;
        }
        return array;
    }
}


