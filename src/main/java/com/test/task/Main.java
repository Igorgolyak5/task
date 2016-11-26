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

    public static void main(String[] args) {

        Locale.getDefault();
        ResourceBundle res = ResourceBundle.getBundle("lang");

        Clock event = new Clock();

        String time = null;
        try {
            time = event.getTime();
        }catch (ParseException e){
            LOGGER.error("Exception while parsing time", e);
        }


        if (time != null){
            switch (time) {
                case "MORNING":
                    System.out.println(res.getString("morning"));
                    LOGGER.info("Now is morning");
                    break;
                case "DAY":
                    System.out.println(res.getString("day"));
                    LOGGER.info("Now is day");
                    break;
                case "EVENING":
                    System.out.println(res.getString("evening"));
                    LOGGER.info("Now is evening");
                    break;
                case "NIGHT":
                    System.out.println(res.getString("night"));
                    LOGGER.info("Now is night");
                    break;
            }
        }else LOGGER.warn("Time is null");

    }
}
