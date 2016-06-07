package com.example.speterson6738.calender;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;



public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // Assignment[] AssignmentList = new Assignment[1];

        SharedPreferences sharedPreferences=getSharedPreferences("Storage", Context.MODE_PRIVATE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Make a new event", Snackbar.LENGTH_LONG)
                        .setAction("startNewEvent", null).show();


            }
        });




        //clearAllEntries(sharedPreferences);


        final TextView test = (TextView) findViewById(R.id.textView);
        test.setText(String.valueOf(sharedPreferences.getFloat("num",0)));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startNewEvent(View v) {
        Intent intent = new Intent(this, NewEvent.class);

        startActivity(intent);
    }


    public void startClassView(View v) {
        Intent intent=new Intent(this, ClassView.class);

        startActivity(intent);
    }
    public void startCvTest(View v){
        Intent intent=new Intent(this, CvTest.class);

        startActivity(intent);

    }
    public void clearAllEntries(SharedPreferences sharedPreferences)
    {
        for (int i=0; i<sharedPreferences.getFloat("num",0); i++)
        {
            Assignment clear=new Assignment(0, 0, "0", "0");
            clear.clearByNum(sharedPreferences, i);
        }
    }
}
