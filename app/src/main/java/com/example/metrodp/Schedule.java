package com.example.metrodp;

import android.icu.util.LocaleData;

import androidx.core.content.res.TypedArrayUtils;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Schedule {
    private String[] vokzalWork = {
            "05:40","05:54",
            "06:06","06:18","06:29","06:40","06:51","06:59",
            "07:05","07:11","07:17","07:24","07:31","07:38","07:45","07:52",
            "08:00","08:08","08:17","08:25","08:32","08:40","08:49","08:57",
            "09:07","09:18","09:29","09:40","09:51",
            "10:02","10:13","10:24","10:35","10:46","10:56",
            "11:08","11:19","11:30","11:41","11:52",
            "12:03","12:14","12:25","12:36","12:47","12:58",
            "13:09","13:20","13:31","13:42","13:53",
            "14:04","14:15","14:26","14:37","14:48","14:59",
            "15:10","15:21","15:32","15:44","15:55",
            "16:05","16:16","16:27","16:38","16:49",
            "17:00","17:10","17:21","17:33","17:44","17:55",
            "18:06","18:17","18:28","18:39","18:49",
            "19:01","19:12","19:21","19:37","19:53",
            "20:09","20:25","20:41","20:57",
            "21:13","21:29","21:45",
            "22:01","22:17","22:33","22:49",
            "23:05"};
    private String[] vokzalWeekend = {
            "05:40","05:58",
            "06:14","06:30","06:46",
            "07:02","07:18","07:34","07:50",
            "08:06","08:22","08:38","08:54",
            "09:10","09:26","09:42","09:58",
            "10:14","10:30","10:46",
            "11:02","11:18","11:34","11:50",
            "12:06","12:22","12:38","12:54",
            "13:10","13:26","13:42","13:58",
            "14:14","14:30","14:46",
            "15:02","15:18","15:35","15:51",
            "16:08","16:24","16:41","16:57",
            "17:13","17:29","17:45",
            "18:01","18:17","18:33","18:49",
            "19:05","19:21","19:37","19:53",
            "20:09","20:25","20:41","20:57",
            "21:13","21:29","21:45",
            "22:01","22:17","22:33","22:49",
            "23:05"};
    private String[] pokrovskaWork = {
            "05:36","05:50",
            "06:02","06:13","06:24","06:35","06:43","06:49","06:55",
            "07:01","07:08","07:15","07:22","07:29","07:36","07:44","07:52",
            "08:01","08:09","08:16","08:24","08:33","08:41","08:51",
            "09:02","09:13","09:24","09:34","09:45","09:56",
            "10:07","10:18","10:29","10:40","10:51",
            "11:02","11:13","11:24","11:35","11:46","11:57",
            "12:08","12:19","12:30","12:41","12:52",
            "13:03","13:14","13:25","13:36","13:47","13:58",
            "14:09","14:20","14:31","14:42","14:54",
            "15:05","15:16","15:26","15:37","15:49",
            "16:00","16:11","16:21","16:32","16:44","16:54",
            "17:05","17:16","17:27","17:38","17:49",
            "18:00","18:11","18:22","18:33","18:45","18:55",
            "19:05","19:21","19:37","19:53",
            "20:09","20:25","20:41","20:57",
            "21:13","21:29","21:45",
            "22:01","22:17","22:33","22:49",
            "23:05"};
    private String[] pokrovskaWeekend = {
            "05:40","05:58",
            "06:14","06:30","06:46",
            "07:02","07:18","07:34","07:50",
            "08:06","08:22","08:38","08:54",
            "09:10","09:26","09:42","09:58",
            "10:14","10:30","10:46",
            "11:02","11:18","11:34","11:50",
            "12:06","12:22","12:38","12:54",
            "13:10","13:26","13:42","13:58",
            "14:14","14:30","14:46",
            "15:02","15:18","15:35","15:51",
            "16:08","16:24","16:41","16:57",
            "17:13","17:29","17:45",
            "18:01","18:17","18:33","18:49",
            "19:05","19:21","19:37","19:53",
            "20:09","20:25","20:41","20:57",
            "21:13","21:29","21:45",
            "22:01","22:17","22:33","22:49",
            "23:05"};

    public final static int LENGHT = 3;

    String[] getSchedule(Calendar date, boolean toggle)
    {
        String[] vokzal;
        String[] pokrovska;
        String[] result = new String[LENGHT*2];
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        boolean isWeekend = dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
        String time = new SimpleDateFormat("HH:mm").format(date.getTime());
        if (toggle)
        {
            isWeekend = !isWeekend;
        }
        if (isWeekend)
        {
            vokzal = vokzalWeekend;
            pokrovska = pokrovskaWeekend;
        }
        else
        {
            vokzal = vokzalWork;
            pokrovska = pokrovskaWork;
        }
        String[] resultVokzal = getValues(time, vokzal);
        String[] resultPokrovska = getValues(time, pokrovska);
        System.arraycopy(resultVokzal, 0, result, 0, LENGHT);
        System.arraycopy(resultPokrovska, 0, result, LENGHT, LENGHT);
        return result;
    }

    private String[] getValues(String time, String[] array)
    {
        int i = 0;
        String[] result = new String[LENGHT];
        for (i = 0; i < array.length; i++)
        {
            if (time.compareTo(array[i]) < 0)
            {
                break;
            }
        }
        if (i == array.length)
        {
            i = 0;
        }
        i--;
        for (int j = 0; j < LENGHT; j++, i++)
        {
            result[j] = TryGetValue(array, i);
        }
        return result;
    }

    private String TryGetValue(String[] array, int index)
    {
        return index < 0 || index >= array.length ? null : array[index];
    }
}
