package com.test.task;

/**
 * Created by Igor on 26.11.16.
 */
public enum ClockEnum {

   MORNING("06:00:00"),
   DAY("09:00:00"),
   EVENING("19:00:00"),
   NIGHT("23:00:00");

   private final String time;


   ClockEnum(String time) {
       this.time = time;
   }

   @Override
   public String toString() {
      return time;
   }
}
