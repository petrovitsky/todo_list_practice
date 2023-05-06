package com.goit.todolist.testmvc.currenttime;

public class InvalidTimeZoneException  extends RuntimeException {
    public InvalidTimeZoneException(String timezone) {
        super("Invalid timezone: " +  timezone);
    }
}
