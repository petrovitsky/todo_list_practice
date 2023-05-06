package com.goit.todolist.testmvc.currenttime;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Service
public class CurrentTimeService {
    public String getCurrentTime(String timezone) throws InvalidTimeZoneException {
        return getCurrentTime(timezone, "dd.MM.yyyy hh:mm:ss");
    }

    public String getCurrentTime(String timezone, String format) throws InvalidTimeZoneException {
        if (timezone == null || timezone.isBlank()) {
            return LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern(format));
        }

        if(!isTimezoneExists(timezone)){
            throw new InvalidTimeZoneException(timezone);
        }

            Date date = new Date();
            DateFormat df = new SimpleDateFormat(format);
            df.setTimeZone(TimeZone.getTimeZone(timezone));

            return df.format(date);


    }

    private boolean isTimezoneExists(String time) {
        return Arrays.asList(TimeZone.getAvailableIDs())
                .contains(time);
    }

}
