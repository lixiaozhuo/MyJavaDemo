package com.lixiaozhuo.jedis;

import java.util.List;

/**
 * 自定义Jedis常用接口
 * 
 * @author lxz
 *
 */
public interface JedisClient {

	/**
	 * 设置生存时间
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	Long expire(String key, int seconds);

	/**
	 * 返回剩余生存时间
	 * 
	 * @param key
	 * @return
	 */
	Long ttl(String key);

	/**
	 * 数字值增一
	 * 
	 * @param key
	 * @return
	 */
	Long incr(String key);

	String set(String key, String value);

	String get(String key);

	Long del(String key);

	/**
	 * 判断key是否存在
	 * 
	 * @param key
	 * @return
	 */
	Boolean exists(String key);

	Long hset(String key, String field, String value);

	String hget(String key, String field);

	Long hdel(String key, String... field);

	/**
	 * 判断key中field是否存在
	 * 
	 * @param key
	 * @return
	 */
	Boolean hexists(String key, String field);
	
	List<String> hvals(String key);
}
