package com.ichiroo.springcoredemo.rest;

import com.ichiroo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

//    @Autowired
//    public DemoController(Coach theCoach){
//        myCoach = theCoach;
//    }

    @Autowired
    public void dm(@Qualifier("baseballCoach") Coach theCoach,
                   @Qualifier("baseballCoach") Coach theAnotherCoach){
        System.out.println("In constructor:  " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach = anotherCoach, "+(myCoach==anotherCoach);
    }
}
