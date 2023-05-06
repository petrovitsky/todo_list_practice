package com.goit.todolist.testmvc.currenttime.httpjsoncontroller;

import com.goit.todolist.testmvc.currenttime.CurrentTimeService;
import com.goit.todolist.testmvc.currenttime.InvalidTimeZoneException;
import com.goit.todolist.testmvc.currenttime.dto.CurrentTimeRequest;
import com.goit.todolist.testmvc.currenttime.dto.CurrentTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/time")
@RestController
public class TimeApiController {
    private final CurrentTimeService currentTimeService;

    @PostMapping
    public CurrentTimeResponse get(@RequestBody CurrentTimeRequest req) {
        System.out.println("req.toString() = " + req.toString());
        try {
            final String time = currentTimeService.getCurrentTime(req.getTimezone(), req.getFormat());
            return CurrentTimeResponse.success(time);
        } catch (InvalidTimeZoneException ex) {
            ex.printStackTrace();
            return CurrentTimeResponse.failed(CurrentTimeResponse.Error.INVALID_TIMEZONE);
        }
    }
}
