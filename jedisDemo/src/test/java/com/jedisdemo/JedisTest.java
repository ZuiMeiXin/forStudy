package com.jedisdemo;

import com.hisoft.util.JedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;//Spring-test依赖
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*运行时创建Spring容器*/
@RunWith(SpringJUnit4ClassRunner.class)
/*根据配置文件创建容器*/
@ContextConfiguration("classpath:applicationContext.xml")
public class JedisTest {
    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private JedisCluster cluster;

    @Test
    public void test01() {
//        创建一个Jedis的连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        测试连接
        String pong = jedis.ping();
        System.out.println(pong);
//        设置数据库
        jedis.select(15);
//        执行redis命令 获取redis数据库中的值
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

    @Test
    public void test03() {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("name", "小呆呆");
            String name = jedis.get("name");
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Test
    public void test04() throws IOException {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("127.0.0.1", 7001));
        nodes.add(new HostAndPort("127.0.0.1", 7002));
        nodes.add(new HostAndPort("127.0.0.1", 7003));
        nodes.add(new HostAndPort("127.0.0.1", 7004));
        nodes.add(new HostAndPort("127.0.0.1", 7005));
        nodes.add(new HostAndPort("127.0.0.1", 7006));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("string", "this is a test");
        System.out.println(cluster.get("string"));
        cluster.close();
    }

    @Test
    public void test05() throws IOException {

        cluster.set("string", "this is a test");
        System.out.println(cluster.get("string"));
        cluster.close();
    }

}