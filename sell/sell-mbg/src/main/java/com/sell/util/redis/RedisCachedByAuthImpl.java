package com.sell.util.redis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;



/**
 * 
 * 
 * 类功能描述: 实现redis的缓存， 基础redis集群模式
 * 
 * @author terryLi
 * @version V1.0, 2014-5-9
 */
public class RedisCachedByAuthImpl implements ICached {
	public static JedisPool jedisPool;

	private String connectStr;
	private int maxTotal = 10;
	private int maxWaitMillis = 100000;// 取得链接最大等待时间
	private Lock clock = new ReentrantLock();
	private int expireSec = 10;
	private int timeOut=5000;
	
	private int minIdle;
	
	private int maxIdle;
	private int db;
	
	
	
	
	
	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}


	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RedisCachedByAuthImpl() {

	}

	public void initRedis() {
		try {
			clock.lock();
			// GenericObjectPoolConfig config = new GenericObjectPoolConfig();
			// config.setMaxTotal(maxTotal);
			// config.setMaxWaitMillis(maxWaitMillis);
			// Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
			// if (this.getConnectStr().indexOf(",") == -1) {
			// jedisClusterNode.add(new HostAndPort(
			// this.connectStr.split(":")[0], new Integer(
			// this.connectStr.split(":")[1])));
			// } else {
			// for (String connect : this.connectStr.split(",")) {
			// jedisClusterNode.add(new HostAndPort(connect.split(":")[0],
			// new Integer(connect.split(":")[1])));
			// }
			// }

			JedisPoolConfig config = new JedisPoolConfig();
			// config.setMaxActive(MAX_ACTIVE);
			config.setMaxTotal(maxTotal);
			config.setMaxWaitMillis(maxWaitMillis);
			config.setMaxIdle(maxIdle);
			config.setMinIdle(minIdle);
			
			String redisConStr = this.getConnectStr();
			if(StringUtils.isBlank(redisConStr)||redisConStr.split(":").length!=2 ){
				throw new Exception("redis连接参数为空");
			}
			String[] ipAndPort = redisConStr.split(":");
			jedisPool = new JedisPool(config, ipAndPort[0], Integer.parseInt(ipAndPort[1]), timeOut,password,db);
			
			// redisCli = new JedisCluster(jedisClusterNode, config);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			clock.unlock();
		}
	}

	@Override
	public String deleteCached(String key) {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			redisCli.del(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}

		return key;
	}

	@Override
	public Object getCached(String key)  {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			String value = redisCli.get(key);
			if (value == null)
				return null;
			return SerializeUtils.objectDeserialization(value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}

		return null;
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
	public Set getKeys(String patternKey){
		return null;
	}

	@Override
	public int size(String key) {
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
	public void addCached(String key, Object value)  {
		this.updaetCached(key, value);
	}

	@Override
	public void updaetCached(String key, Object value)  {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			redisCli.set(key, SerializeUtils.objectSerialiable(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}

	}

	@Override
	public void addCachedExpireSec(String key, Object value, int expireSec)
			{
		this.updateCached(key, value, expireSec);
	}

	@Override
	public void updateCached(String key, Object value, final int expireSec)
			 {
		// this.redisCli.set(key, SerializeUtils.objectSerialiable(value));
		// this.redisCli.expire(key, expireSec);
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			redisCli.setex(key, expireSec,
					SerializeUtils.objectSerialiable(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}

	}

	@Override
	public Set getHashKeys(String key) {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			return redisCli.hkeys(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;
	}

	@Override
	public void updateHashCached(String key, String mapkey, Object value)
			{
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			redisCli.hset(key, mapkey,
					SerializeUtils.objectSerialiable(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
	}

	@Override
	public Object getHashCached(String key, String mapkey)  {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			return SerializeUtils.objectDeserialization(redisCli.hget(key,
					mapkey));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;

	}

	@Override
	public Long deleteHashCached(String key, String mapkey) {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			return redisCli.hdel(key, mapkey);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;
	}

	@Override
	public Long getHashSize(String key)  {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			return redisCli.hlen(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;
	}

	@Override
	public Long incrAndGet(String key){
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			return redisCli.incr(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;
	}

	@Override
	public Long incrAndGetForExpire(String key, int expireSec) {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			Long value = redisCli.incr(key);
			redisCli.expire(key, expireSec);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;

	}

	/**
	 * 取得自增的值
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long getIncrDecrValue(String key) {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			String value = redisCli.get(key);
			if (value == null)
				return 0l;
			return Long.parseLong(value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;

	}

	
	@Override
	public Set getHashValues(String key)  {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			List<String> tmp = redisCli.hvals(key);
			Set<Object> list = new HashSet<Object>();
			for (String bs : tmp) {
				list.add(SerializeUtils.objectDeserialization(bs));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;

	}

	/**
	 * 从元素插入redis列表的左端，并返回列表的大小
	 * 
	 * @param key
	 * @param json
	 * @return
	 */
	public long lpush(String key, Object value) {

		// redisCli.e
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			return redisCli
					.lpush(key, SerializeUtils.objectSerialiable(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return 0l;
	
	}

	/**
	 * 从redis列表的左端移除元素，并返回列表的大小
	 * 
	 * @param key
	 * @param json
	 * @return
	 */
	public Object lpop(String key) {
		
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			String val = redisCli.lpop(key);
			if (val == null)
				return null;
			return SerializeUtils.objectDeserialization(val);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return null;
	
	
	}

	/**
	 * 自减值，并返回减后的值
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long decrAndGet(String key) {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			return redisCli.decr(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
		return 0l;
		
	}



	
	@Override
	public void expireSec(String key, int expireSec){
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
			redisCli.expire(key, expireSec);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (redisCli != null) {
				redisCli.close();
			}
		}
	
	}
	
	public static void main(String[] args) throws Exception {
		final RedisCachedByAuthImpl s = new RedisCachedByAuthImpl();
		s.setConnectStr("139.196.226.117:6379");
		s.initRedis();
		s.lpush("t001", "1");
		s.lpush("t001", "2");
		s.lpush("t001", "3");
		s.lpush("t001", "4");

		s.expireSec("t001", 20);
		System.out.println(s.lpop("t001"));
		
	}

	@Override
	public boolean setNx(String key, String value) throws Exception {
		Jedis redisCli =null;
		try {
			redisCli = jedisPool.getResource();
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

