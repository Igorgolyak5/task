package com.test.task;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Igor on 26.11.16.
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final ResourceBundle RES = ResourceBundle.getBundle("lang", Locale.getDefault());

    public static void main(String[] args) {

        Clock clock = new Clock();

        String time = null;
        try {
            time = clock.getTime();
        }catch (ParseException e){
            LOGGER.error("Exception while parsing time", e);
        }

        printTime(time);
    }

    private static void printTime(String time){
        if (time != null){
            switch (time) {
                case "MORNING":
                    System.out.println(RES.getString("morning"));
                    LOGGER.info("Now is morning");
                    break;
                case "DAY":
                    System.out.println(RES.getString("day"));
                    LOGGER.info("Now is day");
                    break;
                case "EVENING":
                    System.out.println(RES.getString("evening"));
                    LOGGER.info("Now is evening");
                    break;
                case "NIGHT":
                    System.out.println(RES.getString("night"));
                    LOGGER.info("Now is night");
                    break;
            }
        }else LOGGER.warn("Time is null");
    }
}
