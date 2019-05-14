package com.minghui.pay.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;

@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate<String, Object> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory, FastJsonConfig fastJsonConfig) {
		 RedisTemplate<String, Object> template = new RedisTemplate<>();
		 FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
		 fastJsonRedisSerializer.setFastJsonConfig(fastJsonConfig);
		 template.setKeySerializer(new StringRedisSerializer());
		 template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		 template.setConnectionFactory(redisConnectionFactory);
		 return template;
	}
	
	@Bean(name = "valueOperation")
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }
	
	@Bean(name = "setOperation")
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }
	
	@Bean(name = "listOperation")
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }
	
	@Bean(name = "zSetOperation")
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
