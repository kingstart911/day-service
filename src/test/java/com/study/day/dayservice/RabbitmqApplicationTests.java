package com.study.day.dayservice;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {


    @Test
    @GetMapping("sendMq")
    public void contextLoads() {
        System.out.println("发送消息！！！！=====================");
    }

}