package com.shirly.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
* @author shirly
* @CreateTime 2019年8月5日 下午5:50:02
* @description 
*/
public class JedisPoolUtil {
	
	//被volatile修饰的变量不会被本地线程缓存，对该变量的读写都是直接操作共享内存。
	private static volatile JedisPool jedisPool = null;
	
	private JedisPoolUtil() {
		
	}
	
	public static JedisPool getJedisPoolInstance() {
		if (null == jedisPool) {
			synchronized(JedisPool.class) {
				if (null == jedisPool) {
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					 poolConfig.setMaxActive(1000);
			         poolConfig.setMaxIdle(32);
			         poolConfig.setMaxWait(100*1000);
			         poolConfig.setTestOnBorrow(true);
					jedisPool = new JedisPool(poolConfig, "127.0.0.1");
				}
			}
		}
		return jedisPool;
	}
	
	/**
	 * 用完Jedis实例需要返还给JedisPool
	 * @param jedisPool
	 * @param jedis
	 */
	public static void release(JedisPool jedisPool, Jedis jedis) {
		if (null != jedis) {
			jedisPool.returnResourceObject(jedis);
		}
	}
}