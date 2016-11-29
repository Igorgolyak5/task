package com.test.task;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Igor on 26.11.16.
 */
public class Clock {

    private static final Logger LOGGER = Logger.getLogger(Clock.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private Date morning;
    private Date day;
    private Date evening;
    private Date night;
    private Date currentDate;
    private Date current;

    public Clock(){
        currentDate = new Date();
    }

    public Clock(String event) throws ParseException {
        currentDate = dateFormat.parse(event);
    }

    public String  getTime() throws ParseException{

        current = dateFormat.parse(dateFormat.format(currentDate));
        morning  = dateFormat.parse(ClockEnum.MORNING.toString());
        day  = dateFormat.parse(ClockEnum.DAY.toString());
        evening = dateFormat.parse(ClockEnum.EVENING.toString());
        night = dateFormat.parse(ClockEnum.NIGHT.toString());

        return validateTime();
    }

    private String validateTime(){
        if(current.after(morning) && current.before(day)){
            LOGGER.info("Time is morning");
            return "MORNING";
        }
        else if (current.after(day) && current.before(evening)){
            LOGGER.info("Time is day");
            return "DAY";
        }
        else if (current.after(evening) && current.before(night)){
            LOGGER.info("Time is evening");
            return "EVENING";
        }
        else
            LOGGER.info("Time is night");
        return "NIGHT";
    }
}
