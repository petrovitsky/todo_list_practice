package com.goit.todolist.testmvc.cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RequestMapping("/cookie")
@Controller
public class CookieController {
    public static final String UID_COOKIE_NAME = "uid";

    @GetMapping
    public ModelAndView get(@CookieValue(value = UID_COOKIE_NAME, required = false) String uid,
                            HttpServletResponse response) {
        final ModelAndView modelAndView = new ModelAndView("cookie");
        modelAndView.addObject("cookieValue", uid);
        if (uid == null) {
            response.addCookie(new Cookie(UID_COOKIE_NAME, UUID.randomUUID().toString()));
        }
        System.out.println("uid inc = " + uid);

        return modelAndView;
    }
}
