package com.lixiaozhuo.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * 测试Jedis
 * @author lxz
 *
 */
public class JedisTest {
	
	/**
	 * 单机版
	 * @throws Exception
	 */
	@Test
	public void testJedis() throws Exception {
		//创建一个连接Jedis对象,参数:host,port
		Jedis jedis = new Jedis("192.168.25.128", 6379);
		//直接使用jedis操作redis,所有jedis的命令对应一个方法
		jedis.set("test123", "测试");
		String string = jedis.get("test123");
		System.out.println(string);
		//关闭连接
		jedis.close();
	}
	
	/**
	 * 连接池
	 * @throws Exception
	 */
	@Test
	public void testJedisPool() throws Exception {
		//创建一个连接池对象,参数:host,port
		JedisPool jedisPool = new JedisPool("192.168.25.128", 6379);
		//从连接池获得一个连接 jedis对象
		Jedis jedis =jedisPool.getResource();
		//使用jedis操作redis,所有jedis的命令对应一个方法
		String string = jedis.get("test123");
		System.out.println(string);
		//关闭连接,每次使用完毕后关闭连接,连接池回收资源
		jedis.close();
		//关闭连接池
		jedisPool.close();
	}
	
	/**
	 * 集群版
	 * @throws Exception
	 */
	@Test
	public void testJedisCluster() throws Exception {
		//创建一个JedisCluster对象,参数:nodes set类型,set中包含若干个HostAndPort
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.128",7001));
		nodes.add(new HostAndPort("192.168.25.128",7002));
		nodes.add(new HostAndPort("192.168.25.128",7003));
		nodes.add(new HostAndPort("192.168.25.128",7004));
		nodes.add(new HostAndPort("192.168.25.128",7005));
		nodes.add(new HostAndPort("192.168.25.128",7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		//直接使用JedisCluser对象操作redis
		jedisCluster.set("集群测试", "测试结果1");
		String string = jedisCluster.get("集群测试");
		System.out.println(string);
		//关闭JedisCluster
		jedisCluster.close();
	}
}
