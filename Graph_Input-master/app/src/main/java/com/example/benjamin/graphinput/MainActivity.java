package com.example.benjamin.graphinput;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GraphView view = new GraphView(this);
        view.setPosition(new Point(110, 110));

        setContentView(view);
    }
}
