package com.ichiroo.springcoredemo.config;

import com.ichiroo.springcoredemo.common.Coach;
import com.ichiroo.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
