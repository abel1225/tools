package me.abel.redis.client;

import org.junit.Test;
import redis.clients.jedis.*;

import java.io.IOException;
import java.util.Iterator;

public class RedisPoolClientUtilTest {

    @Test
    public void open() {
        JedisPool jedisPool;
        Jedis jedis = null;
        Pipeline pipeline = null;
        try{
            //创建Pool
//            jedisPool = RedisPoolClientUtil.open("esmaster", 8130, "redis#12345");
            jedisPool = RedisPoolClientUtil.open("43.254.46.190", 8130, "redis#12345");
            //从Pool中获取Jedis
            jedis = jedisPool.getResource();

            pipeline = jedis.pipelined();

            //调用Jedis的方法，操作Redis数据
            pipeline.set("yongda:orders:order1", "");
            pipeline.set("yongda:orders:order2", "");
            pipeline.set("yongda:orders:order3", "");
            pipeline.sync();
            //获取数据 get()
//            String value = jedis.get("yongda:orders:*");
//            System.out.println("break的值："+value);
            ScanParams sp = new ScanParams();
            sp.match("yongda:orders:order*");
//            ScanResult<String> result = jedis.scan("0",sp);

            ScanResult<String> result = jedis.sscan("0", "0");
            System.out.println("result："+result.getResult());

            ScanResult<String> result1 = jedis.scan(result.getCursor(),sp);

            Iterator<String> iterator = result.getResult().iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            Iterator<String> iterator1 = result1.getResult().iterator();
            while (iterator1.hasNext()) {
                System.out.println(iterator1.next());
            }
            //设置多个key-value
//            jedis.mset("lunch","饺子111","dinner","小米粥和包子111");

            //获取多个key的值
//            List<String> values  = jedis.mget("break","lunch","dinner");
//            for(String val : values){
//                System.out.println(val);
//            }

        }finally{
            if(pipeline != null) {
                pipeline.close();
            }
            //关闭Jedis对象， 把Jedis放回到线程池
            if( jedis != null){
                jedis.close();
            }
        }
    }

    @Test
    public void close() {

    }
}