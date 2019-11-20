package com.redis.jodis;

import io.codis.jodis.JedisResourcePool;
import io.codis.jodis.RoundRobinJedisPool;
import redis.clients.jedis.Jedis;

/**
 * @version 1.0
 * @ProjectName: fremer
 * @Package: com.ham.han.fremer.jodis
 * @ClassName: Jredis
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/9/21 18:12
 */
public class Jredis {
    public static void main(String[] args) {
        JedisResourcePool jedisPool = RoundRobinJedisPool.create()
                .curatorClient("172.16.101.88:2181", 30000).zkProxyDir("/jodis/codis-demo").build();
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set("bar", "basssss");
            String value = jedis.get("bar");
            jedis.hset("rediskey","valkey", "value");
            System.out.println(value);
        }
    }
}
