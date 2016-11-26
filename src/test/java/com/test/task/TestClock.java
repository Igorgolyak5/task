package com.test.task;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

/**
 * Created by Igor on 26.11.16.
 */
public class TestClock {

    private Clock clock;

    @Test
    public  void testGetTime() throws ParseException {
        clock = new Clock();
        switch (clock.getTime()){
            case "MORNING": break;
            case "DAY": break;
            case "EVENING":break;
            case "NIGHT": break;
            default:
                Assert.fail();
        }
    }

    @Test
    public void testMorningSixHourAndOneSecond()throws ParseException{
        clock = new Clock("6:00:01");
        Assert.assertEquals(clock.getTime(), "MORNING");
    }

    @Test
    public void testMorningEightHours()throws ParseException{
        clock = new Clock("8:00:00");
        Assert.assertEquals(clock.getTime(), "MORNING");
    }

    @Test
    public void testMorningHalfPastEight()throws ParseException{
        clock = new Clock("07:30:00");
        Assert.assertEquals(clock.getTime(), "MORNING");
    }

    @Test
    public void testDayNineHoursAndOneSecond()throws ParseException{
        clock = new Clock("09:00:01");
        Assert.assertEquals(clock.getTime(), "DAY");
    }

    @Test
    public void testDayTwelveHours()throws ParseException{
        clock = new Clock("12:30:00");
        Assert.assertEquals(clock.getTime(), "DAY");
    }

    @Test
    public void testDayTwentyOneIsFail()throws ParseException{
        clock = new Clock("21:00:00");
        Assert.assertNotEquals(clock.getTime(), "DAY");
    }

    @Test
    public void testEveningTwentyAndOneSecond()throws ParseException{
        clock = new Clock("20:00:01");
        Assert.assertEquals(clock.getTime(), "EVENING");
    }

    @Test
    public void testEveningTwentyTwoHours()throws ParseException{
        clock = new Clock("22:00:00");
        Assert.assertEquals(clock.getTime(), "EVENING");
    }

    @Test
    public void testEveningTwentyOneHours()throws ParseException{
        clock = new Clock("21:00:00");
        Assert.assertEquals(clock.getTime(), "EVENING");
    }

    @Test
    public void testNightOneHour() throws ParseException{
        clock = new Clock("01:00:00");
        Assert.assertEquals(clock.getTime(), "NIGHT");
    }

    @Test
    public void testNightSixHour() throws ParseException{
        clock = new Clock("5:59:59");
        Assert.assertEquals(clock.getTime(), "NIGHT");
    }

    @Test
    public void testNightSevenHourIsFail() throws ParseException {
        clock = new Clock("7:00:00");
        Assert.assertNotEquals(clock.getTime(), "NIGHT");
    }

}
