package com.example.speterson6738.calender;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.Serializable;

/**
 * Created by speterson6738 on 4/6/2016.
 */
public class Assignment implements Serializable
{
    public float dueDate;//Due date does not work yet, i did not know what would happen with api so i just used a float
    public String course;
    public String name;
    public float duration;



    public Assignment (float newdueDate, float newduration, String newName, String newCourse)
    {
        dueDate=newdueDate;
        duration=newduration;
        name=newName;
        course=newCourse;
    }
    public void store(SharedPreferences sharedPreferences)//checks how many assignments are saved, saves the assignment and increases the counter by 1
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        int t=(int) sharedPreferences.getFloat("num", 0);
        String num=String.valueOf(t);
        t++;
        editor.putFloat("num", t);


        editor.putString("name"+num, name);
        editor.putString("course"+num, course);
        editor.putFloat("duration"+num, duration);

        editor.apply();
    }


    public void accessByNum(SharedPreferences sharedPreferences, int num)//access by the number in sequence it was saved
    {
        String snum=String.valueOf(num);
        name=sharedPreferences.getString("name"+snum, "null");
        course=sharedPreferences.getString("course"+snum, "null");
        duration=sharedPreferences.getFloat("duration"+snum, 0);
    }
    public void accessByName(SharedPreferences sharedPreferences, String nam)//does not really work yet
    {
        String test="1";

        int i=0;
      /*  while (i<sharedPreferences.getFloat("num", 1))
        {

           String AsName = sharedPreferences.getString("name" + Integer.toString(i), "null");
            if (AsName.equals(nam))
            {

                break;
            }
            i++;
        }*/
        name=sharedPreferences.getString("name"+test, "null");
        course=sharedPreferences.getString("course"+test, "null");
        duration=sharedPreferences.getFloat("duration"+Integer.toString(i),0);
    }

    public void clearByNum(SharedPreferences sharedPreferences, int num)//deletes based on number
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.remove("name"+Integer.toString(num));
        editor.remove("course"+Integer.toString(num));
        editor.remove("duration"+Integer.toString(num));
        float t=sharedPreferences.getFloat("num",0);
        t--;
        editor.putFloat("num",t);
        editor.apply();
    }


}
