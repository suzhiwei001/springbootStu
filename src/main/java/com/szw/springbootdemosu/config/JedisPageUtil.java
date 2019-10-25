package com.szw.springbootdemosu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: uzdz
 * @date: 2018/8/27 11:44
 * @description: SaaS 3.0 redis工具类
 */
@Component
public class JedisPageUtil {

	private static final Logger logger = LoggerFactory.getLogger(JedisPageUtil.class);

	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private JedisPool jedisPool;

	/**
	 * 关闭 Redis
	 */
	public void destory() {
		jedisPool.destroy();
	}

	/**
	 * 获取 master jedis
	 * 
	 * @return
	 */
	public Jedis getResource() {
		return jedisPool.getResource();
	}

	/**
	 * 回收 jedis
	 * 
	 * @param jedis
	 */
	public void returnResource(Jedis jedis) {
		if (jedis == null) {
			return;
		}
		try {
			jedis.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 * 销毁 jedis
	 * 
	 * @param jedis
	 */
	public void returnBrokenResource(Jedis jedis) {
		if (jedis == null) {
			return;
		}
		try {
			jedisPool.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 * key缓存是否存在
	 *
	 * @param key 键
	 */
	public boolean exists(String key) {
		boolean result = false;
		Jedis jedis = null;
		try {
			jedis = getResource();

            result = jedis.exists(SerializeUtil.serialize(key));
		} catch (Exception e) {
			logger.warn("exists： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return result;
	}

	/**
	 * 设置List缓存
	 *
	 * @param key          键
	 * @param value        值
	 * @param cacheSeconds 超时时间，0为不超时
	 */
	public boolean setList(String key, List<Object> value, int cacheSeconds) {
		Jedis jedis = null;
		try {
			jedis = getResource();

            List<byte[]> ids = value.stream().map(data -> SerializeUtil.serialize(data)).collect(Collectors.toList());

            if (!ids.isEmpty()) {
                byte[][] data = ids.toArray(new byte[ids.size()][]);

                jedis.rpush(SerializeUtil.serialize(key), data);

                if (cacheSeconds != 0) {
                    jedis.expire(SerializeUtil.serialize(key), cacheSeconds);
                }
            }

			return true;
		} catch (Exception e) {
			logger.warn("setList： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	/**
	 * 获取List缓存
	 *
	 * @param key 键
	 * @return 值
	 */
	public List<Object> getList(String key, long start, long end) {
        List<byte[]> value = null;
		List<Object> resValue = new ArrayList<>();
		Jedis jedis = null;
		try {
			jedis = getResource();
			if (jedis.exists(SerializeUtil.serialize(key))) {
                value = jedis.lrange(SerializeUtil.serialize(key), start, end);
            }
		} catch (Exception e) {
			logger.warn("getList： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}

		if (value != null) {
			value.stream().forEach((data) -> {
				resValue.add(SerializeUtil.unserialize(data));
			});
		}

		return resValue;
	}

	/**
	 * 获取list中的个数
	 *
	 * @param key   键
	 */
	public Long llen(String key) {
		Jedis jedis = null;
		try {
			jedis = getResource();
			return jedis.llen(SerializeUtil.serialize(key));
		} catch (Exception e) {
			logger.warn("getObjectList： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return 0L;
	}

	/**
	 * 删除缓存
	 *
	 * @param key 键
	 */
	public long del(String key) {
		long result = 0;
		Jedis jedis = null;
		try {
			jedis = getResource();
			if (jedis.exists(SerializeUtil.serialize(key))) {
				result = jedis.del(SerializeUtil.serialize(key));
				logger.debug("del {}", key);
			} else {
				logger.debug("del {} not exists", key);
			}
		} catch (Exception e) {
			logger.warn("del：key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return result;
	}

	/**
	 * 清除List缓存中指定的值
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public long listRem(String key, Object value) {
		long result = 0;
		Jedis jedis = null;
		try {
			jedis = getResource();
			result = jedis.lrem(SerializeUtil.serialize(key), 0, SerializeUtil.serialize(value));
		} catch (Exception e) {
			logger.warn("listObjectAdd：key {}，value {}， exception {}", key, value, e);
		} finally {
			returnResource(jedis);
		}
		return result;
	}


	public boolean setNx(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getResource();
			Long n = jedis.setnx(key, value);
			if(n == 1){
				// key的超时时间设置1小时
				jedis.expire(key, 60 * 60);
			}
			return n == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("setNx： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	public boolean setNx(String key, String value,int ms) {
		Jedis jedis = null;
		try {
			jedis = getResource();
			Long n = jedis.setnx(key, value);
			if(n == 1){
				// key的超时时间设置1小时
				jedis.expire(key, ms);
			}
			return n == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("setNx： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	public boolean setVal(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getResource();
			jedis.set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("setVal： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	public String getVal(String key) {
		Jedis jedis = null;
		try {
			jedis = getResource();
			String value = jedis.get(key);

			return value;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("setVal： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public boolean delVal(String key) {
		Jedis jedis = null;
		try {
			jedis = getResource();
			Long n = jedis.del(key);
			return n == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("delVal： key {}，exception {}", key, e);
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	private static final String LOCK_SUCCESS = "OK";
	private static final String SET_IF_NOT_EXIST = "NX";//key不存在时，我们进行set操作
	private static final String SET_WITH_EXPIRE_TIME = "PX";//我们要给这个key加一个过期的设置，具体时间由第五个参数决定

	/**
	 * 尝试获取分布式锁
	 *
	 * @param lockKey 锁
	 * @param requestId 请求标识
	 * @param expireTime 超期时间
	 * @return 是否获取成功
	 */
	public boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
		String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
		if (LOCK_SUCCESS.equals(result)) {
			return true;
		}
		return false;
	}

	private static final Long RELEASE_SUCCESS = 1L;

	/**
	 * 释放分布式锁
	 * @param lockKey 锁
	 * @param requestId 请求标识
	 * @return 是否释放成功
	 */
	public boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
		if (RELEASE_SUCCESS.equals(result)) {
			return true;
		}
		return false;
	}
}