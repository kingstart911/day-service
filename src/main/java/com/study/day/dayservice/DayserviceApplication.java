package com.study.day.dayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages ={"com.study.day.dayservice"} )
public class DayserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DayserviceApplication.class, args);
    }

}
