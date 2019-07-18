package com.sell.portal.redis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.sell.util.redis.ICached;

public class RedisCacheManager implements ICached {

	private static final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

	@Autowired
	RedisTemplate<Object, Object> objectRedisTemplate;

	@Override
	public void addCached(String key, Object value) throws Exception {
		try {
			this.updaetCached(key, value);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public void updaetCached(String key, Object value) throws Exception {
		try {
			objectRedisTemplate.opsForValue().set(key, value);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public void addCachedExpireSec(String key, Object value, int expireSec) throws Exception {
		try {
			this.updateCached(key, value, expireSec);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public void expireSec(String key, int expireSec) throws Exception {
		try {
			objectRedisTemplate.expire(key, expireSec, TimeUnit.SECONDS);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public String deleteCached(String key) throws Exception {
		try {
			objectRedisTemplate.delete(key);
			return key;
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public void updateCached(String key, Object value, int expireSec) throws Exception {
		try {
			objectRedisTemplate.opsForValue().set(key, value, expireSec, TimeUnit.SECONDS);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Object getCached(String key) throws Exception {
		try {
			return objectRedisTemplate.opsForValue().get(key);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set getKeys(String key) throws Exception {
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public int size(String key) throws Exception {
		try {
			Set keys = this.getKeys(key);
			if (keys == null) {
				return 0;
			}
			return keys.size();
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set getValues(String key) throws Exception {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set getHashKeys(String key) throws Exception {
		try {
			return objectRedisTemplate.opsForHash().keys(key);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public void updateHashCached(String key, String mapkey, Object value) throws Exception {
		try {
			objectRedisTemplate.opsForHash().put(key, mapkey, value);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Object getHashCached(String key, String mapkey) throws Exception {
		try {
			return objectRedisTemplate.opsForHash().get(key, mapkey);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Long deleteHashCached(String key, String mapkey) throws Exception {
		try {
			return objectRedisTemplate.opsForHash().delete(key, mapkey);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Long getHashSize(String key) throws Exception {
		try {
			return objectRedisTemplate.opsForHash().size(key);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set getHashValues(String key) throws Exception {
		try {
			return list2set(objectRedisTemplate.opsForHash().values(key));
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@SuppressWarnings("rawtypes")
	private Set list2set(List values) {
		try {
			Set<Object> set = new HashSet<Object>();
			for (Object value : values) {
				set.add(value);
			}
			return set;
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Long getIncrDecrValue(String key) throws Exception {
		try {
			String value = (String) objectRedisTemplate.opsForValue().get(key);
			if (value == null)
				return 0l;
			return Long.parseLong(value);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Long incrAndGetForExpire(String key, int expireSec) throws Exception {
		try {
			Long incr = this.incrAndGet(key);
			if (incr != null) {
				objectRedisTemplate.expire(key, expireSec, TimeUnit.SECONDS);
			}
			return incr;
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Long incrAndGet(String key) throws Exception {
		try {
			if (key != null) {
				return objectRedisTemplate.getConnectionFactory().getConnection().incr(key.getBytes());
			} else {
				return null;
			}
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Long decrAndGet(String key) throws Exception {
		try {
			if (key != null) {
				return objectRedisTemplate.getConnectionFactory().getConnection().decr(key.getBytes());
			}
			{
				return null;
			}
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public boolean setNx(String key, String value) throws Exception {
		try {
			return objectRedisTemplate.opsForValue().setIfAbsent(key, value);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public long lpush(String key, Object value) {
		try {
			return objectRedisTemplate.opsForList().leftPush(key, value);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}

	@Override
	public Object lpop(String key) {
		try {
			return objectRedisTemplate.opsForList().leftPop(key);
		} finally {
			releaseRedisConn(objectRedisTemplate);
		}
	}
	
	@SuppressWarnings({ "rawtypes" })
	private void releaseRedisConn(RedisTemplate template) {
	}
}
