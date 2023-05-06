package com.goit.todolist.testmvc.currenttime.dto;

import lombok.Data;

@Data
public class CurrentTimeRequest {
    private String timezone;
    private String format;
}
