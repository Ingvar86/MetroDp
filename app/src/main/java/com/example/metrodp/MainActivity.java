package com.example.metrodp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Schedule schedule = new Schedule();

    private TextView time1;
    private TextView time2;
    private TextView time3;
    private TextView time4;
    private TextView time5;
    private TextView time6;
    private CheckBox toggle;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);
        time4 = findViewById(R.id.time4);
        time5 = findViewById(R.id.time5);
        time6 = findViewById(R.id.time6);
        toggle = findViewById(R.id.toggle);

        startTimer();

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateView();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        updateView();
        startTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timer != null)
        {
            timer.cancel();
            timer = null;
        }
    }

    private void startTimer()
    {
        if (timer == null)
        {
            timer = new Timer();
        }

        timer.schedule(new TimerTask() {
            private int count = 0;
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateView();
                    }
                });
            }
        }, 0, 3*1000);
    }


    private void updateView()
    {

        String[] values = schedule.getSchedule(Calendar.getInstance(),toggle.isChecked());

        time1.setText(values[0]);
        time2.setText(values[1]);
        time3.setText(values[2]);
        time4.setText(values[3]);
        time5.setText(values[4]);
        time6.setText(values[5]);
    }

}
