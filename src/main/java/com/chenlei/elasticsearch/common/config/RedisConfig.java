/*
package com.chenlei.elasticsearch.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

import java.time.Duration;

*/
/**
 * Redis配置
 * 
 *//*

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.database}")
    private String dataBase;

    */
/**
     * redis单机配置
     * 
     * @return
     *//*

    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration c = new RedisStandaloneConfiguration(host, Integer.valueOf(port));
        c.setPassword(RedisPassword.of(password));
        if (!StringUtils.isEmpty(dataBase)) {
            c.setDatabase(Integer.valueOf(dataBase));
        }
        return c;
    }

    */
/**
     * 设置Jedis连接配置
     * 
     * @param redisStandaloneConfiguration
     * @return
     *//*

    @Bean
    JedisConnectionFactory jedisConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();
        builder.connectTimeout(Duration.ofMillis(9999999));
        builder.readTimeout(Duration.ofMillis(9999999));
        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration, builder.build());
        return factory;
    }

    */
/**
     * 设置RedisTemplate，设置key,value序列化器
     * 
     * @param jedisConnectionFactory
     * @return
     *//*

    @Bean
    RedisTemplate<?, ?> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer(om);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
*/
