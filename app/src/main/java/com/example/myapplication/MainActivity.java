package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements MyDialog.NoticeDialogListener{
    public static int DAY_CNT;
    private SharedPreferences dataStore;
    private String day_cnt_str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*日数カウント読み込み*/
        dataStore = getSharedPreferences("DataStore", MODE_PRIVATE);
        String str = dataStore.getString("input", "Nothing");

        if (!str.equals("Nothing")) {
            //System.out.println(str);
            DAY_CNT = Integer.parseInt(str);
        } else {
            DAY_CNT = 0;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //day_cnt_str = util.Create_day();
        day_cnt_str = Integer.valueOf(DAY_CNT).toString()+"日";
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(day_cnt_str);

        /*ボタンインスタンス作成*/
        final Button btn_add = findViewById(R.id.Button1);
        final Button btn_reset = findViewById(R.id.reset);

        ButtonAdd Add = new ButtonAdd();
        ButtonReset Reset = new ButtonReset();

        btn_add.setOnClickListener(Add);
        btn_reset.setOnClickListener(Reset);

    }

    private class ButtonAdd implements View.OnClickListener {
        /*日数カウント*/
        public void onClick(View view) {
            TextView text = (TextView) findViewById(R.id.textView);
            DAY_CNT++;
            day_cnt_str = Integer.valueOf(DAY_CNT).toString() + "日";
            text.setText(day_cnt_str);

            /*データ保存*/
            SharedPreferences.Editor editor = dataStore.edit();
            editor.putString("input", Integer.valueOf(DAY_CNT).toString());
            editor.apply();
        }
    }

    private class ButtonReset implements View.OnClickListener {

        public void onClick(View view) {
            MyDialog dialog = new MyDialog();
            dialog.show(getSupportFragmentManager(), "my_dialog");
        }
    }

    @Override
    public void onDialogClick(DialogFragment dialog) {
        TextView text = (TextView) findViewById(R.id.textView);
        day_cnt_str = Integer.valueOf(DAY_CNT).toString() + "日";
        text.setText(day_cnt_str);
    }




}