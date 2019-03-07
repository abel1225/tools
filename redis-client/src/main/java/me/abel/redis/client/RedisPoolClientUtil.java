package me.abel.redis.client;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:
 * @author: able.li
 * @create: 2019/3/1 13:06
 */
public class RedisPoolClientUtil {

    private static JedisPool jedisPool;

    public static JedisPool open(String host,int port, String pwd){
        if( jedisPool == null){
            //创建池
            JedisPoolConfig config = new JedisPoolConfig();
            //设置最大的线程数，也就是Jedis对象的个数
            config.setMaxTotal(100);
            //设置空闲数
            config.setMaxIdle(2);
            //设置检查对象，保证从Pool中获取的Jedis一定是可用的
            config.setTestOnBorrow(false);
            config.setTestOnReturn(true);

            //创建Pool对象
            /**
             *  poolConfig:配置器
             *  host：redis的ip
             *  port: 端口
             *  timeout：连接Redis的超时，毫秒单位
             *  password：访问密码
             *
             */
//            jedisPool = new JedisPool(config, host, port, 6000);
            jedisPool = new JedisPool(config, host, port, 6000, pwd);

        }
        return jedisPool;
    }

    //关闭线程池，释放资源
    public static void close() {
        if (jedisPool != null) {
            jedisPool = null;
        }
    }

}
