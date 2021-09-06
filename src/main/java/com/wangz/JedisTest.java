package com.wangz;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;


public class JedisTest {
    Jedis jedis =null;

    @Before
    public void init(){
        jedis = new Jedis("192.168.124.71",6379);
        jedis.auth("123456");
        //心跳机制
        String ping = jedis.ping();
        System.out.println("ping = " + ping);
    }

    @Test
    public void testString(){
        String age = jedis.set("age", "123");
        System.out.println("age = " + age);
        String name = jedis.get("name");
        System.out.println("name = " + name);
        jedis.set("user:lol:ll","xiix");
    }

    @After
    public void close(){
        if (jedis !=null){
            jedis.close();
        }
    }

}
