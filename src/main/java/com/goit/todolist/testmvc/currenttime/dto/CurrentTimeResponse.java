package com.goit.todolist.testmvc.currenttime.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CurrentTimeResponse {
    private boolean success;
    private String time;
    private Error error;

    public enum Error {
        OK,
        INVALID_TIMEZONE
    }

    public static CurrentTimeResponse success(String time) {
        return CurrentTimeResponse.builder().success(true).error(Error.OK).time(time).build();
    }

    public static CurrentTimeResponse failed(Error error) {
        return CurrentTimeResponse.builder().error(error).success(false).build();
    }
}
