package com.jedisdemo;

import com.hisoft.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
    @Test
    public void test01() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String pong = jedis.ping();
        System.out.println(pong);
        jedis.select(15);
        String name = jedis.get("name");
        String age = jedis.get("age");
        System.out.println("name:" + name);
        System.out.println("age:" + age);

        /*value 最大不超过512M*/
        /**/
        jedis.set("mytest", "this is value max 512M");
        System.out.println(jedis.get("mytest"));
        jedis.close();
    }

    @Test
    public void test02() {
        Jedis jedis = JedisUtil.getResource();
        jedis.set("name", "小呆呆");
        String name = jedis.get("name");
        System.out.println(name);
        JedisUtil.close(jedis);

    }
}
