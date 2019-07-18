package com.sell.util.redis;

import java.util.Set;


public interface ICached {
	
	/**
	 * 设置值，不设置过期时间
	 * @return
	 */
	void addCached(String key,Object value)throws Exception;
	/**
	 * 更新缓步
	 * @return
	 */
	void updaetCached(String key,Object value)throws Exception;
	
	/**
	 * 设置值，不设置过期时间
	 * @return
	 */
	void addCachedExpireSec(String key,Object value, final int expireSec)throws Exception;
	
	/**
	 * 设置redis超时时间
	 * @return
	 */
	void expireSec(String key,final int expireSec)throws Exception;
	
	/**
	 * 删除 缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	String deleteCached(String key)throws Exception;
	/**
	 * 新增或更新 缓存
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	void updateCached(String key, Object value, final int expireSec)throws Exception;
	/**
	 * 获取缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Object getCached(String key)throws Exception;
	/**
	 * 根据 正则表达式key 获取 列表,现阶段不提供该方法
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	Set getKeys(String key)throws Exception;
	
	/**
	 * 现不提供该方法
	 * @param key
	 * @return
	 * @throws Exception
	 */
	int size(String key)throws Exception;
	/**
	 * 现不提供该方法
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Set getValues(String key)throws Exception;
	
	
	/**
	 * 根据 正则表达式key 获取 列表
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	Set getHashKeys(String key)throws Exception;
	
	
	
	/**
	 * 更新 缓存
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	void updateHashCached(String key,String mapkey,Object value)throws Exception;
	

	/**
	 * 获取缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Object getHashCached(String key,String mapkey)throws Exception;
	
	
	/**
	 * 删除 缓存
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Long deleteHashCached(String key,String mapkey)throws Exception;
	
	/**
	 * 获取 map的长度
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Long getHashSize(String key)throws Exception;
	/**
	 * 获取 map中的所有值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Set getHashValues(String key)throws Exception;
	
	/**
	 * 取得自增的值 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Long getIncrDecrValue(String key) throws Exception;
	/**
	 * 自增值，并返回增加后的值
	 * @param key
	 * @param expireSec 数据有效期
	 * @return
	 * @throws Exception
	 */
	public Long incrAndGetForExpire(String key,int expireSec) throws Exception ;
	
	/**
	 * 自增值，并返回增加后的值（没有设置失效，数据一直存放于redis）
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Long incrAndGet(String key) throws Exception;
	
	/**
	 * 自减值，并返回减后的值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Long decrAndGet(String key) throws Exception;
	
	/**
	 * 将元素插入redis列表的左端，并返回列表的大小
	 * @param key
	 * @param json
	 * @return
	 */
	public long lpush(String key,Object value);
	
	/**
	 * 从redis列表的左端移除元素，并返回列表的大小
	 * @param key
	 * @param json
	 * @return
	 */
	public Object lpop(String key);
	
	public boolean setNx(String key, String value) throws Exception;
	
}