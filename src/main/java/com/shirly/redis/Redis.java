package com.shirly.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

/**
* @author shirly
* @CreateTime 2019年8月5日 下午5:50:02
* @description 
*/
public class Redis {
	
	//连接本地的 Redis 服务
	static Jedis jedis = new Jedis("127.0.0.1",6379);
	
	public static void main(String[] args) {
	    //1.查看服务是否运行，打出pong表示OK=================
	    /*System.out.println("connection is OK==========>: "+jedis.ping());*/
	    
	    //2.rdeis一个key+五大数据类型value================
	    /*//key
	    jedis.set("k1","v1");
		jedis.set("k2","v2");
		jedis.set("k3","v3");
		System.out.println(jedis.get("k3"));
	    Set<String> keys = jedis.keys("*");
	    for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
	    	String key = (String) iterator.next();
	    	System.out.println(key);
	    }
	    System.out.println("jedis.exists====>"+jedis.exists("k2"));
	    System.out.println(jedis.ttl("k1"));
	    //string
	    jedis.append("k1", "myrdeis");
	    System.out.println(jedis.get("k1"));
	    jedis.set("k4", "k4_redis");
	    jedis.mset("str1","v1","str2","v2","str3","v3");
	    System.out.println(jedis.mget("str1","str2","str3"));
	    //list
	    jedis.lpush("mylist", "v1","v2","v3","v4","v5");
	    List<String> list = jedis.lrange("mylist", 0, -1);
	    System.out.println(list);
	    //set
	    jedis.sadd("orders", "jd001");
	    jedis.sadd("orders", "jd002");
	    jedis.sadd("orders", "jd003");
	    Set<String> set1 = jedis.smembers("orders");
	    System.out.println(set1);
	    jedis.srem("orders", "jd002");
	    System.out.println(jedis.smembers("orders").size());
	    //hash
	    jedis.hset("hash1", "userName", "shirly");
	    System.out.println(jedis.hget("hash1", "userName"));
	    Map<String, String> map = new HashMap<>();
	    map.put("tel", "17721013884");
	    map.put("email", "@qq.com");
	    jedis.hmset("hash2", map);
	    List<String> res = jedis.hmget("hash2", "tel");
	    System.out.println(res);
	    //zset
	    jedis.zadd("zset01", 60, "v1");
		jedis.zadd("zset01",70d,"v2");
		jedis.zadd("zset01",80d,"v3");
		jedis.zadd("zset01",90d,"v4");
		Set<String> s1 = jedis.zrange("zset01", 0, -1);
		System.out.println(s1);*/
	    
		/*//3.添加事务================
		Transaction tr = jedis.multi();//被当作一个命令进行执行
		Response<String> resp = tr.get("serialNum");
		tr.set("serialNum", "s002");
		resp = tr.get("serialNum");
		tr.lpush("list", "a");
		tr.lpush("list", "b");
		tr.lpush("list", "c");
		tr.exec();
		//2 transaction.discard();
	    System.out.println("serialNum***********"+resp.get());
	    //加乐观锁
	    boolean retValue = transMethod();
	    System.out.println("retValue-------: " + retValue);*/
		
		/*//4.主从复制
		Jedis jedis_M = new Jedis("127.0.0.1",6379);
	    Jedis jedis_S = new Jedis("127.0.0.1",6380);
	    jedis_S.slaveof("127.0.0.1", 6379);
	    jedis_M.set("k6", "v6");
	    try {
			Thread.sleep(1000);//主从复制有延迟
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println(jedis_S.get("k6"));
//	    jedis_M.close();
//	    jedis_S.close();*/
	    
	    //5.JedisPool
		JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
		JedisPool jedisPool2 = JedisPoolUtil.getJedisPoolInstance();
		System.out.println(jedisPool == jedisPool2);
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set("aa","bb");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JedisPoolUtil.release(jedisPool, jedis);
		}
		
//	    jedis.close();
	}
	
	/**
	 * 使用事务的监听进行交易
	 * 通俗点讲，watch命令就是标记一个键，如果标记了一个键， 在提交事务前如果该键被别人修改过，那事务就会失败，这种情况通常可以在程序中重新再尝试一次。
	 * 首先标记了键balance，然后检查余额是否足够，不足就取消标记，并不做扣减； 足够的话，就启动事务进行更新操作，
	 * 如果在此期间键balance被其它人修改， 那在提交事务（执行exec）时就会报错， 程序中通常可以捕获这类错误再重新执行一次，直到成功。
	 * @return
	 */
	public static boolean transMethod() {
	     int balance;// 可用余额
	     int debt;// 欠额
	     int amtToSubtract = 10;// 实刷额度
	 
	     jedis.watch("balance");
	     //jedis.set("balance","5");//此句不该出现。模拟其他程序已经修改了该条目
	     balance = Integer.parseInt(jedis.get("balance"));
	     if (balance < amtToSubtract) {
	       jedis.unwatch();
	       System.out.println("modify");
	       return false;
	     } else {
	       System.out.println("***********transaction");
	       Transaction transaction = jedis.multi();
	       transaction.decrBy("balance", amtToSubtract);
	       transaction.incrBy("debt", amtToSubtract);
	       transaction.exec();
	       balance = Integer.parseInt(jedis.get("balance"));
	       debt = Integer.parseInt(jedis.get("debt"));
	 
	       System.out.println("*******" + balance);
	       System.out.println("*******" + debt);
	       return true;
	     }
	}

}
