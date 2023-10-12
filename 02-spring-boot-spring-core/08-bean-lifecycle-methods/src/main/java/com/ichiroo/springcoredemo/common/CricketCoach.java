package com.ichiroo.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor:  " + getClass().getSimpleName());
    }

    //define our init method
    @PostConstruct
    public void doMyStarupStuff(){
        System.out.println("In doMyStartupStuff: "+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 14 minutes lesson 3";
    }
}
