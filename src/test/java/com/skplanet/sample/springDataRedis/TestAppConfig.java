package com.skplanet.sample.springDataRedis;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class TestAppConfig {

    @Bean
    public JedisConnectionFactory jedisConnFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> redisTemplate =
                new RedisTemplate<String,String>();
        redisTemplate.setConnectionFactory(jedisConnFactory());
        return redisTemplate;
    }
}
