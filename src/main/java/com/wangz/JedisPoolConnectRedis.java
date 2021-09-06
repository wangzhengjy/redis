package com.wangz;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*
*
* 连接池工具类
* */
public class JedisPoolConnectRedis {
    private static JedisPool jedisPool;

    static {
        //创建连接池对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大连接数 默认8
        jedisPoolConfig.setMaxTotal(5);
        //最大空闲量  默认8
        jedisPoolConfig.setMaxIdle(5);
        //最少空闲量 默认0
        jedisPoolConfig.setMinIdle(0);
        //等待时间
        jedisPoolConfig.setMaxWaitMillis(100);
        //初始化 JedidPool
         jedisPool = new JedisPool(jedisPoolConfig, "192.168.124.71",6379,100, "123456");
    }

    /*
    * 静态方法
    *  获取Jedis对象
    * */

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
