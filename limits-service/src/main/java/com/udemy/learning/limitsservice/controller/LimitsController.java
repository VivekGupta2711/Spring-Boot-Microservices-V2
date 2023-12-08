package com.udemy.learning.limitsservice.controller;

import com.udemy.learning.limitsservice.bean.Limits;
import com.udemy.learning.limitsservice.configuration.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private LimitsConfiguration limitsConfiguration;

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        //removed hardcoding from here
//        return new Limits(1, 1000);
        //Take the values from application.properties file
        return new Limits(limitsConfiguration.getMinimum(), limitsConfiguration.getMaximum());
    }

}
