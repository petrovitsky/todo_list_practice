package com.goit.todolist.testmvc.currenttime;

import org.springframework.stereotype.Service;

@Service
public class LocalizationService {
    public String getLocalizationLable(String acceptLanguage) {
        if ("uk".equals(acceptLanguage)){
            return  "Поточний час";
        }
        else return "Current time";
    }
}
