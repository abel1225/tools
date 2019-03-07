package me.abel.redis.client;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisClientUtilTest {

    @Test
    public void redisTest(){
        Jedis jedis = new Jedis("43.254.46.190", 8130);
        jedis.auth("redis#12345");

        System.out.println("Server is running: "+jedis.ping());
        // push值
        jedis.lpush("hello", "wy","hhhhh","licon","jsp");
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        List<String> list = jedis.lrange("hello",0,5);
        list.forEach(s -> System.out.println("value:"+s));
        jedis.close();
    }

}