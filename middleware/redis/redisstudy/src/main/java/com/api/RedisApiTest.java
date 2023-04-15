package com.api;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.Iterator;
import java.util.Set;

/**
 * @author mao
 * @createTime 2023/4/15 11:27
 * @Description: 原生Redis的Api方法测试
 */
public class RedisApiTest {
    // 传入空参，在配置文件中已经连接本地的 redis
    Jedis jedis = new Jedis("127.0.0.1",6379);

    @Test
    public void testString() throws InterruptedException {
        System.out.println(jedis.ping());
        jedis.set("name","coffeemao");
        jedis.set("age","18");
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.strlen("name"));
        jedis.append("name", ",hello");
        System.out.println(jedis.get("name"));
        jedis.set("name","coffeemao");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.exists("name"));
        System.out.println(jedis.expire("name", 10));
        System.out.println(jedis.ttl("name"));
        jedis.incr("age");
        System.out.println(jedis.incrBy("age", 10));
        System.out.println(jedis.keys("*"));
        jedis.move("age",1);
        jedis.select(1);
        jedis.keys("*");
        jedis.select(0);
        jedis.setex("time",10,"second");
        System.out.println(jedis.get("time"));
        Thread.sleep(11000);
        System.out.println(jedis.get("time"));
        System.out.println(jedis.flushAll());

    }

    @Test
    public void testList(){
        for (int i = 0; i < 10; i++) {
            jedis.lpush("list",String.valueOf(i));
        }
        // [0,5]
        System.out.println(jedis.lrange("list", 0, 5));
        jedis.flushAll();
        for (int i = 0; i < 5; i++) {
            jedis.lpush("list".concat(String.valueOf(i)),String.valueOf(i));
        }
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        int i = 0;
        while (iterator.hasNext()){
            System.out.println(jedis.lrange(iterator.next(),0,-1));
        }
        jedis.flushAll();

    }

}
