package com.study.day.dayservice.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.study.day.dayservice.common.CommonException;
import com.study.day.dayservice.entity.PersonEntity;
import com.study.day.dayservice.map.PersonDao;
import com.study.day.dayservice.response.Response;
import com.study.day.dayservice.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyapeng on 2021/1/8 18:07
 */
@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonDao personDao;



    @Autowired
    private RedisUtil redisUtil;

    public Response getPerson(String gid) {
        Object person=null;
        try {
             person = redisUtil.get(gid);
            if (null == person) {

                 person = personDao.findByGid(gid);
                redisUtil.set(gid, person);

            }
        } catch (CommonException e) {
            e.printStackTrace();
        }

        redisUtil.set("chenyapeng", "dai125239864");
        return new Response<>(person);
    }

    public List<String> save(List<PersonEntity> personEntityList) {
        List<String> longList = new ArrayList<>();
        personEntityList.forEach(t -> {
            PersonEntity oldPerson = personDao.findByGid(t.getGid());

            if (null != oldPerson && !oldPerson.getName().equals(t.getName())) {
                PersonEntity findPerson = personDao.findByName(t.getName());
                Assert.isNull(findPerson, "名称已存在，不可重复添加！");
            }
            personDao.save(t);
            longList.add(t.getGid());

        });
        return longList;

    }
}
