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
import android.widget.TextView;

public class CvTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_test);
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

        Button btn=(Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {//When the button is pressed, it finds the Assignment corresponding with that number and displays the name and course name
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getSharedPreferences("Storage", Context.MODE_PRIVATE);
                Assignment test=new Assignment(0, 0, "test", "void");

                EditText numVal = (EditText) findViewById(R.id.editText2);
                String contents=numVal.getText().toString();
                test.accessByNum(sharedPreferences,Integer.parseInt(contents));

                TextView txtClass = (TextView) findViewById(R.id.textViewCourse);
                TextView txtName = (TextView) findViewById(R.id.textViewName);
                txtClass.setText(test.course);
                txtName.setText(test.name);

            }
        });
    }
}
