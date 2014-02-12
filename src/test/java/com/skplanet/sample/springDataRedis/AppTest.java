package com.skplanet.sample.springDataRedis;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestAppConfig.class })
public class AppTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    @Before
    public void setup() {
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }

    @Test
    public void springDataRedisTest() {
        listOps.leftPush("springDataRedis", "leftPush1");
        listOps.leftPush("springDataRedis", "leftPush2");
        listOps.leftPush("springDataRedis", "leftPush3");
        System.out.println("Left push X 3 =>" + listOps.range("springDataRedis", 0, -1));
        listOps.rightPush("springDataRedis", "rightPush1");
        System.out.println("Right push X 1 =>" + listOps.range("springDataRedis", 0, -1));
        listOps.rightPushAll("springDataRedis", "rightPush2", "rightPush3", "rightPush4");
        System.out.println("Right push all  =>" + listOps.range("springDataRedis", 0, -1));
        //redisTemplate.boundListOps("springDataRedis2").leftPush("hellow world2yyyy");
    }

    @After
    public void down() {
    }
}