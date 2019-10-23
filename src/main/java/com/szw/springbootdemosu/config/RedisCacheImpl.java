package com.szw.springbootdemosu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.*;

@Component
public class RedisCacheImpl implements CacheI {

	@Autowired
	private JedisPool jedisPool;

	public Jedis getResource() {
		return jedisPool.getResource();
	}

	@Override
	public void set(byte[] key, byte[] value) {
		Jedis jedis = this.getResource();
		try {
			jedis.set(key, value);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public byte[] get(byte[] key) {
		Jedis jedis = this.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public Long getIncr(String key) {
		Jedis jedis = this.getResource();
		try {
			return jedis.incr(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public Long getIncrby(String key, Long value) {
		Jedis jedis = this.getResource();
		try {
			return jedis.incrBy(key, value);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public void set(String key, Object o) {
		key = wrapperKey(key);
		this.set(key.getBytes(), SerializeUtil.serialize(o));
	}

	@Override
	public Object get(String key, Class clazz) {
		key = wrapperKey(key);
		byte[] bty = this.get(key.getBytes());
		Object result = null;
		if (bty != null) {
			result = SerializeUtil.deSeialize(bty, clazz);
		}
		return result;
	}

	@Override
	public void delete(String key) {
		key = wrapperKey(key);
		this.delete(key.getBytes());
	}

	public boolean contain(String key) {
		key = wrapperKey(key);
		return this.contain(key.getBytes());
	}

	public boolean contain(byte[] key) {
		Jedis jedis = this.getResource();
		try {
			return jedis.exists(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}

	}

	@Override
	public void delete(byte[] key) {
		Jedis jedis = this.getResource();
		try {
			jedis.del(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}

	}

	@Override
	public void setnx(byte[] key, byte[] value) {
		Jedis jedis = this.getResource();
		try {
			jedis.setnx(key, value);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public void setnx(String key, Object o) {
		key = wrapperKey(key);
		this.setnx(key.getBytes(), SerializeUtil.serialize(o));
	}

	public List zget(String key, double minScore, double maxScore, Class clazz) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			Set<byte[]> s = jedis.zrangeByScore(key.getBytes(), minScore, maxScore);
			List l = new ArrayList();
			Iterator<byte[]> it = s.iterator();
			while (it.hasNext()) {
				byte[] b = it.next();
				if (b != null)
					l.add(SerializeUtil.deSeialize(b, clazz));
			}
			return l;
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public List zgetByindex(String key, long start, long end, Class clazz) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			Set<byte[]> s = jedis.zrange(key.getBytes(), start, end);
			List l = new ArrayList();
			Iterator<byte[]> it = s.iterator();
			while (it.hasNext()) {
				byte[] b = it.next();
				l.add(SerializeUtil.deSeialize(b, clazz));
			}
			return l;
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public void zadd(String key, double score, Object o) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			jedis.zadd(key.getBytes(), score, SerializeUtil.serialize(o));
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public void zadd(String key, long score, Object o) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			jedis.zadd(key.getBytes(), score, SerializeUtil.serialize(o));
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public Long zcount(String key, double start, double end) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			Long num = jedis.zcount(key.getBytes(), start, end);
			return num;
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public void hset(String key, String field, String value) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			if (value != null)
				jedis.hset(key, field, value);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public void hmset(String key, Map map) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			if (map != null)
				jedis.hmset(key, map);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	public String hget(String key, String field) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.hget(key, field);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public void hdel(String key, String field) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			jedis.hdel(key, field);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public Map hgetAll(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.hgetAll(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public Set keys(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.keys(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}

	}

	@Override
	public void sadd(String key, String... member) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			jedis.sadd(key, member);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public Set smembers(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		Set s = null;
		try {
			s = jedis.smembers(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
		return s;
	}

	@Override
	public void srem(String key, String... member) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			jedis.srem(key, member);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public long scount(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.scard(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public boolean sismember(String key, String member) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			return jedis.sismember(key, member);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public Long zrem(String key, Object... member) {
		if (member == null || member.length < 1)
			return (long) -1;
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			byte[][] bts = new byte[member.length][];
			for (int i = 0; i < member.length; i++) {
				bts[i] = SerializeUtil.serialize(member[i]);
			}
			return jedis.zrem(key.getBytes(), bts);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public List mget(Class clazz, String... keys) {
		keys = wrapperKey(keys);
		Jedis jedis = this.getResource();
		try {
			byte[][] bts = new byte[keys.length][];
			for (int i = 0; i < keys.length; i++) {
				bts[i] = SerializeUtil.serialize(keys[i]);
			}
			List<byte[]> result = jedis.mget(bts);
			List finalResult = new ArrayList();
			for (int i = 0; i < result.size(); i++) {
				Object o = SerializeUtil.deSeialize(result.get(i), clazz);
				finalResult.add(o);
			}
			return finalResult;
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public void delete(String... keys) {
		keys = wrapperKey(keys);
		Jedis jedis = this.getResource();
		try {
			jedis.del(keys);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	@Override
	public String typeKey(String key) {
		key = wrapperKey(key);
		Jedis jedis = this.getResource();
		try {
			String keyType = jedis.type(key);
			return keyType;
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	private String wrapperKey(String key) {
		return key;
	}

	private String[] wrapperKey(String... key) {
		return key;
	}

	@Override
	public String get(String key) {
		Jedis jedis = this.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

    @Override
    public void newSet(String key, String value) {
        Jedis jedis = this.getResource();
        try {
        	jedis.set(key,value);
        } catch (Exception e) {
            throw new JedisException(e);
        } finally {
            jedis.close();
        }
    }

    @Override
    public void setPrintKey(String key, String value,Long expireSecond){
		Jedis jedis = this.getResource();
		try {
			// NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
			jedis.set(key, value, "NX", "PX", expireSecond);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 设置失效时间  单位秒
	 * */
	@Override
	public void setExpire(String key,int time){
		Jedis jedis = this.getResource();
		try {
			// 设置失效时常
			jedis.expire(key.getBytes(),time);
		} catch (Exception e) {
			throw new JedisException(e);
		} finally {
			jedis.close();
		}
	}
}
