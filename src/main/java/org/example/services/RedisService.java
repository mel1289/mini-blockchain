package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
    private final JedisPool jedisPool;

    @Autowired
    public RedisService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        testConnection();
        this.setValue("foo", "42");
    }

    private void testConnection() {
        try (Jedis jedis = jedisPool.getResource()) {
            String response = jedis.ping();
            if ("PONG".equals(response)) {
                System.out.println("REDIS OK!");
            } else {
                System.out.println("REDIS NOK!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getValue(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }

    public void setValue(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        }
    }
}
