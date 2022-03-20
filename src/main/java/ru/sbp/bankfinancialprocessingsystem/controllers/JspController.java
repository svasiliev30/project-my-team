package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/bank")
public class JspController {

    @Value("${appName}")
    private String appName;

    @Value("${dbType}")
    private String dbType;

    @RequestMapping("/testjsp")
    public ModelAndView info() {

        ModelAndView modelAndView = new ModelAndView("/views/info.jsp");
        modelAndView.addObject("appName", appName);
        modelAndView.addObject("dbType", dbType);
        modelAndView.addObject("dateAndTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

        return modelAndView;
    }

}
