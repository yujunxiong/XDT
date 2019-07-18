package com.sell.util.redis;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;



/**
 * 
 * 
 * 类功能描述: 实现redis的缓存， 基础redis集群模式
 * 
 * @author terryLi
 * @version V1.0, 2014-5-9
 */
public class RedisCachedCustorImpl implements ICached {

	public JedisCluster redisCli;
	private String connectStr;
	private int maxTotal = 2;
	private int maxWaitMillis = 2000;// 取得链接最大等待时间
	private Lock clock = new ReentrantLock();
	private int expireSec = 10;

	public RedisCachedCustorImpl(String connectStr) {
		this.connectStr = connectStr;
		initRedisCluster();
	}

	private void initRedisCluster() {
		try {
			clock.lock();
			GenericObjectPoolConfig config = new GenericObjectPoolConfig();
			config.setMaxTotal(maxTotal);
			config.setMaxWaitMillis(maxWaitMillis);
			Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
			if (this.getConnectStr().indexOf(",") == -1) {
				jedisClusterNode.add(new HostAndPort(
						this.connectStr.split(":")[0], new Integer(
								this.connectStr.split(":")[1])));
			} else {
				for (String connect : this.connectStr.split(",")) {
					jedisClusterNode.add(new HostAndPort(connect.split(":")[0],
							new Integer(connect.split(":")[1])));
				}
			}
			redisCli = new JedisCluster(jedisClusterNode, config);
		} finally {
			clock.unlock();
		}
	}

	@Override
	public String deleteCached(String key) throws Exception {
		redisCli.del(key);
		return key;
	}

	

	@Override
	public Object getCached(String key) throws Exception {
		String value = this.redisCli.get(key);
		if (value == null)
			return null;
		return SerializeUtils.objectDeserialization(value);
	}

	/**
	 * 集群模式，不提供基于keys的模糊查询功能，通过自己实现循环调用节点查询key
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Set getKeys(String patternKey) throws Exception {
		return null;
	}

	@Override
	public int size(String key) throws Exception {
		if (getKeys(key) == null)
			return 0;
		return getKeys(key).size();
	}

	@Override
	public Set getValues(String patternKey) throws Exception {
		return null;
	}

	public String getConnectStr() {
		return connectStr;
	}

	public void setConnectStr(String connectStr) {
		this.connectStr = connectStr;
	}


	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	
	
	
	public int getExpireSec() {
		return expireSec;
	}

	public void setExpireSec(int expireSec) {
		this.expireSec = expireSec;
	}

	@Override
	public void addCached(String key, Object value) throws Exception {
		this.updaetCached(key, value);
	}
	@Override
	public void updaetCached(String key, Object value) throws Exception {
		this.redisCli.set(key, SerializeUtils.objectSerialiable(value));

	}
	@Override
	public void addCachedExpireSec(String key, Object value, int expireSec)
			throws Exception {
		this.updateCached(key, value, expireSec);
	}
	@Override
	public void updateCached(String key, Object value, final int expireSec)
			throws Exception {
		//this.redisCli.set(key, SerializeUtils.objectSerialiable(value));
		//this.redisCli.expire(key, expireSec);
		this.redisCli.setex(key, expireSec, SerializeUtils.objectSerialiable(value));//(key, , "1", "1", expireSec);

	}
	

	@Override
	public Set getHashKeys(String key) throws Exception {

		return this.redisCli.hkeys(key);
	}

	@Override
	public void updateHashCached(String key, String mapkey, Object value)
			throws Exception {
		this.redisCli
				.hset(key, mapkey, SerializeUtils.objectSerialiable(value));
	}

	@Override
	public Object getHashCached(String key, String mapkey) throws Exception {
		return SerializeUtils.objectDeserialization(this.redisCli.hget(key,
				mapkey));
	}

	@Override
	public Long deleteHashCached(String key, String mapkey) throws Exception {
		return this.redisCli.hdel(key, mapkey);
	}

	@Override
	public Long getHashSize(String key) throws Exception {
		return this.redisCli.hlen(key);
	}

	@Override
	public Long incrAndGet(String key) throws Exception {
		return this.redisCli.incr(key);
	}
	@Override
	public Long incrAndGetForExpire(String key,int expireSec) throws Exception {
		Long value= this.redisCli.incr(key);
		this.redisCli.expire(key, expireSec);
		return value;
	}
	/**
	 * 取得自增的值 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long getIncrDecrValue(String key) throws Exception{
		String value=this.redisCli.get(key);
		if(value==null)return 0l;
		return Long.parseLong(value);
	}
	@Override
	public Set getHashValues(String key) throws Exception {
		List<String> tmp = this.redisCli.hvals(key);
		Set<Object> list = new HashSet<Object>();
		for (String bs : tmp) {
			list.add(SerializeUtils.objectDeserialization(bs));
		}
		return list;
	}
	
	/**
	 * 从元素插入redis列表的左端，并返回列表的大小
	 * @param key
	 * @param json
	 * @return
	 */
	public long lpush(String key,Object value){
		
		//redisCli.e
		return this.redisCli.lpush(key, SerializeUtils.objectSerialiable(value));
	}
	
	
	/**
	 * 从redis列表的左端移除元素，并返回列表的大小
	 * @param key
	 * @param json
	 * @return
	 */
	public Object lpop(String key){
		String val= this.redisCli.lpop(key);
		if(val==null)return null;
		return SerializeUtils.objectDeserialization(val);
	}
	/**
	 * 自减值，并返回减后的值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long decrAndGet(String key) throws Exception{
		return this.redisCli.decr(key);
	}
	public static void main(String[] args) throws Exception {
		final RedisCachedCustorImpl s = new RedisCachedCustorImpl("139.196.226.117:6379");
		
		
		s.lpush("t001", "1");
		s.lpush("t001", "2");
		s.lpush("t001", "3");
		s.lpush("t001", "4");
		
		s.expireSec("t001", 20);
		System.out.println(s.lpop("t001"));
		Thread.sleep(30*1000);
		
		
		ExecutorService exec = Executors.newCachedThreadPool();   
		final  CyclicBarrier barrier = new CyclicBarrier(2000);  
		
		for(int i=0;i<2000;i++){
			final int index=i;
			exec.submit(new Runnable() {
				@Override
				public void run() {
					try {
						try {
							System.out.println("===============");
							Thread.sleep(10000);
							barrier.await();
						} catch (BrokenBarrierException e) {
							e.printStackTrace();
						}
						for(int v=0;v<100;v++){
							System.out.println(s.lpush("test_list", "--"));
						}
						//semp.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		}
		
		//Thread.sleep(1000*20);
		System.out.println(10+"="+s.redisCli.llen("test_list"));
		for(int i=0;i<s.redisCli.llen("test_list");i++){
			final int index=i;
			exec.submit(new Runnable() {
				@Override
				public void run() {
					try {
						try {
							Thread.sleep(10000);
							barrier.await();
						} catch (BrokenBarrierException e) {
							e.printStackTrace();
						}
						System.out.println(s.lpop("test_list"));
						//semp.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			});
		}
		//semp.release();   
		//s.redisCli.l
		//s.decrAndGet("1--1");
		////System.out.println(s.getIncrDecrValue("1--1"));
		//int size=3000;
		// byte[] seri=SerializeUtils.serialize(value);
		// this.redisCli.set(key,SafeEncoder.encode(seri));

		// s.redisCli.set("s8", "li李");
		

		// System.out.println(s.getCached("liqin"));
		/*
		 * Jedis node4 = new Jedis("192.168.1.150", 7000); node4.connect();
		 * node4.set("22", "3");
		 */
	}

	@Override
	public void expireSec(String key,int expireSec) throws Exception {
		this.redisCli.expire(key, expireSec);
	}

	@Override
	public boolean setNx(String key, String value) throws Exception {
		try {
			Long result = redisCli.setnx(key, value);
			if(result ==1L){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return false;
	}

}

class ReisText implements Serializable {
	public String name;
	public String id;
	
	public ReisText(String name,String id){
		this.name=name;
		this.id=id;
	}

	@Override
	public String toString() {
		return "ReisText [name=" + name + ", id=" + id + "]";
	}
}