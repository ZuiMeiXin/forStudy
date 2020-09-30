package com.hisoft.config.cache;

import com.hisoft.config.util.JedisUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {
    private final String id;

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        Jedis jedis = JedisUtil.getResource();
        jedis.set(SerializationUtils.serialize(key), SerializationUtils.serialize(value));
        JedisUtil.close(jedis);
    }

    @Override
    public Object getObject(Object key) {
        Jedis jedis = JedisUtil.getResource();
        byte[] bytes = jedis.get(SerializationUtils.serialize(key));
        JedisUtil.close(jedis);
        if (bytes != null) {
            Object deserialize = SerializationUtils.deserialize(bytes);
            return deserialize;
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        Jedis jedis = JedisUtil.getResource();
        byte[] bytes = jedis.get(SerializationUtils.serialize(key));
        jedis.del(bytes);
        JedisUtil.close(jedis);
        if (bytes != null) {
            Object deserialize = SerializationUtils.deserialize(bytes);
            return deserialize;
        }
        return null;
    }

    @Override
    public void clear() {
        Jedis jedis = JedisUtil.getResource();
        jedis.flushDB();
        JedisUtil.close(jedis);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
