package com.hisoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//标注配置类  相当于写了一个xml文件
@Configuration
public class RedisConfig {
    //标注在方法上，注入spring容器一个bean：id就是方法名redisTemplate bean是返回值对象
    //方法的参数通过自动装配赋值
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer); // key序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // value序列化
        redisTemplate.setHashKeySerializer(stringSerializer); // Hash key序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer()); // Hash value序列化
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
