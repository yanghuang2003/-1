//package com.ruoyi.wrms.common;
//
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//public class RedisConfiguration {
//    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate redisTemplate = new RedisTemplate();
//        //设置redis的连接工厂对象
//        redisTemplate.setConnectionFactory(factory);
//        //设置redis key的序列化器
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        return redisTemplate;
//    }
//}
