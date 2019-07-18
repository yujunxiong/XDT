package com.sell.portal.redis;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.sell.util.redis.SerializeUtils;


public class CustomizeRedisSerializer<T> implements RedisSerializer<T> {

	@Override
	public byte[] serialize(T t) throws SerializationException {
		try {
			return SerializeUtils.serialize(t);
		} catch (Exception ex) {
			throw new SerializationException("Could not serialize object: " + ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		try {
			return (T)SerializeUtils.deserialize(bytes);
		} catch (Exception ex) {
			throw new SerializationException("Could not deserialize object: " + ex.getMessage(), ex);
		}
	}

}
