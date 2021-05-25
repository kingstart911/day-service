package com.study.day.dayservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.day.dayservice.entity.PersonEntity;
import com.study.day.dayservice.response.Response;
import com.study.day.dayservice.service.PersonService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by chenyapeng on 2021/1/8 14:40
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("getPerson")
    public Response getPerson(@RequestParam(name = "gid", required = true) String gid){
        return personService.getPerson(gid);
    }


    @PostMapping("save")
    public List<String> save(@RequestBody List<PersonEntity> personEntityList ) {
        return personService.save(personEntityList);
    }
    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1() {
        String messageId = String.valueOf(java.util.UUID.randomUUID());
        String messageData = "message: M A N ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", new PersonEntity("2222","chenyaPj回火"));
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return "ok";
    }

    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman is all ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", new PersonEntity("2222","chenyaPj回火"));
        womanMap.put("createTime", createTime);
        JSONObject json = new JSONObject(womanMap);
        rabbitTemplate.convertAndSend("topicExchange", "dai12523986", json);
        return "ok";
    }
}


