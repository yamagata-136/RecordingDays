package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


public class Utility extends View{

    public Utility(Context context) {
        super(context);
    }

    /*表示する日数を作成*/
    public String Create_day(){

        String day_cnt_str = Integer.valueOf(MainActivity.DAY_CNT).toString();
        String display_day = day_cnt_str + "日";
        return display_day;
    }

    public void DoInvalidate(){
        invalidate();
    }

}
