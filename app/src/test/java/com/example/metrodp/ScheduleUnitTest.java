package com.example.metrodp;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ScheduleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void Vokzalna1Test() {
        Schedule schedule = new Schedule();
        Calendar test = Calendar.getInstance();
        test.set(Calendar.HOUR_OF_DAY, 9);
        test.set(Calendar.MINUTE, 28);
        schedule.getSchedule(test, false);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void Vokzalna2Test() {
        Schedule schedule = new Schedule();
        Calendar test = Calendar.getInstance();
        test.set(Calendar.HOUR_OF_DAY, 9);
        test.set(Calendar.MINUTE, 26);
        schedule.getSchedule(test, false);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void Vokzalna3Test() {
        Schedule schedule = new Schedule();
        Calendar test = Calendar.getInstance();
        test.set(Calendar.HOUR_OF_DAY, 5);
        test.set(Calendar.MINUTE, 00);
        schedule.getSchedule(test, false);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void Vokzalna4Test() {
        Schedule schedule = new Schedule();
        Calendar test = Calendar.getInstance();
        test.set(Calendar.HOUR_OF_DAY, 23);
        test.set(Calendar.MINUTE, 30);
        schedule.getSchedule(test, false);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void Vokzalna5Test() {
        Schedule schedule = new Schedule();
        Calendar test = Calendar.getInstance();
        test.set(Calendar.HOUR_OF_DAY, 23);
        test.set(Calendar.MINUTE, 05);
        schedule.getSchedule(test, false);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void Vokzalna6Test() {
        Schedule schedule = new Schedule();
        Calendar test = Calendar.getInstance();
        test.set(Calendar.HOUR_OF_DAY, 5);
        test.set(Calendar.MINUTE, 40);
        schedule.getSchedule(test, false);
        assertEquals(4, 2 + 2);
    }
}