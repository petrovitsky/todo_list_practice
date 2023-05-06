package com.goit.todolist.testmvc.currenttime;

import com.goit.todolist.testmvc.currenttime.dto.CurrentTimeRequest;
import com.goit.todolist.testmvc.currenttime.dto.CurrentTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping(value = "/current-time")
@Controller
public class CurrentTimeController {
    private final CurrentTimeService currentTimeService;
    private final LocalizationService localizationService;

    @GetMapping("/get")
    public ModelAndView getCurrentTime(@RequestParam(required = false) String timeZone) {
        ModelAndView result = new ModelAndView("current-time");
        result.addObject("time", currentTimeService.getCurrentTime(timeZone));
        return result;
    }

    @PostMapping("/post-x-form-urlencoded")
    public ModelAndView postCurrentTimeXTimeUrlEncoded(@RequestParam(name = "timeZone", required = false) String tz) {
        ModelAndView result = new ModelAndView("current-time");
        result.addObject("time", currentTimeService.getCurrentTime(tz));
        return result;
    }

    @PostMapping("/post-json")
    public ModelAndView getCurrentTimeJson(@RequestBody CurrentTimeRequest request,
                                           @RequestHeader(name = "Accept-Language", required = false) String acceptLanguage) {
        ModelAndView result = new ModelAndView("current-time");
        result.addObject("time", currentTimeService.getCurrentTime(request.getTimezone(), request.getFormat()));
        result.addObject("currentTimeLable", localizationService.getLocalizationLable(acceptLanguage));
        return result;
    }

    @ResponseBody
    @GetMapping("/getAsObject")
    public CurrentTimeResponse getCurrentTimeAsObject(@RequestParam(name = "tz", required = false) String timezone) {
        try {
            return CurrentTimeResponse.success(currentTimeService.getCurrentTime(timezone));
        } catch (Exception e) {
            e.printStackTrace();
            return CurrentTimeResponse.failed(CurrentTimeResponse.Error.INVALID_TIMEZONE);
        }
    }

    @GetMapping("{timezone}/{format}")
    public ModelAndView getPathVariableTime(@PathVariable(name = "timezone") String timezone,
                                            @PathVariable("format") String format) {
        ModelAndView result = new ModelAndView("current-time");
        result.addObject("time", currentTimeService.getCurrentTime(timezone, format));
        result.addObject("currentTimeLable", localizationService.getLocalizationLable("uk"));
        return result;
    }

}
