package com.szw.springbootdemosu.config.redis_config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 Desc:
 <p>
 * Created by zhouxingbin on 2019/7/8.
 */
@Component
public class RedisCacheUtil {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheUtil.class);
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     * @return 缓存的对象
     */
    public <T> ValueOperations<String, T> setCacheObject(String key, T value, long time, TimeUnit timeUnit) {
        System.out.println(key + "*****" + value.toString());
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value);
        if (time == 0) {
            int day = LuaInvConsts.randExpireDay();
            time = day * 24 * 60 * 60;
            timeUnit = TimeUnit.SECONDS;
        }
        redisTemplate.expire(key, time, timeUnit);
        return operation;
    }

    public <T> ValueOperations<String, T> setCacheObject(String key, T value) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value);
        return operation;
    }


    /**
     * 获得缓存的基本对象。
     * @param key  缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 缓存List数据[从左边放]
     * @param key  缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> ListOperations<String, T> setCacheListAtLeft(String key, List<T> dataList) {
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                listOperation.leftPush(key, dataList.get(i));
            }
        }
        return listOperation;
    }

    /**
     * 缓存List数据[从右边放]
     * @param key
     * @param dataList
     * @param <T>
     * @return
     */
    public <T> ListOperations<String, T> setCacheListAtRight(String key, List<T> dataList) {
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                listOperation.rightPush(key, dataList.get(i));
            }
        }
        return listOperation;
    }

    /**
     * 缓存List数据[从右边放]
     * @param key
     * @param dataList
     * @param <T>
     * @return
     */
    @Deprecated
    public <T> ListOperations<String, T> setBvCacheListAtRight(String key, List<T> dataList) {
        if (true) {
            return null;
        }
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                listOperation.rightPush(key, dataList.get(i));
            }
        }
        return listOperation;
    }

    /**
     * 获得缓存的list对象[从左边取]
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<T> getCacheListAtLeft(String key) {
        List<T> dataList = new ArrayList<T>();
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        for (int i = 0; i < size; i++) {
            dataList.add((T) listOperation.leftPop(key));
        }
        return dataList;
    }

    /**
     * 获得缓存的单个对象[从左边取]
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheAtLeft(String key) {
        T value = null;
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        if (size == 0) {
            return null;
        } else {
            value = (T) listOperation.leftPop(key);
        }
        return value;
    }

    /**
     * 获得缓存的list对象[从右边取]
     * @param key
     * @param <T>
     * @return
     */
    public <T> List<T> getCacheListAtRight(String key) {
        List<T> dataList = new ArrayList<T>();
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        for (int i = 0; i < size; i++) {
            dataList.add((T) listOperation.rightPop(key));
        }
        return dataList;
    }

    /**
     * 获得缓存的单个对象[从右边取]
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getCacheAtRight(String key) {
        T value = null;
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        if (size == 0) {
            return null;
        } else {
            value = (T) listOperation.rightPop(key);
        }
        return value;
    }

    /**
     * 获得缓存的list对象范围
     * @param key 缓存的键值 arg1到arg2
     * @return 缓存键值对应的数据
     */
    public <T> List<T> getCacheListIndex(String key, long arg1, long arg2) {
        List<T> dataList = new ArrayList<T>();
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        dataList = listOperation.range(key, arg1, arg2);
        return dataList;
    }

    /**
     * 缓存Set
     * @param key  缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    public <T> BoundSetOperations<String, T> setCacheSet(String key, Set<T> dataSet) {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key); /*T[] t = (T[]) dataSet.toArray();
        setOperation.add(t);*/
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext()) {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 缓存Set
     * @param key  缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    @Deprecated
    public <T> BoundSetOperations<String, T> setExceptionBvToCacheSet(String key, Set<T> dataSet) {
        // 不按baseVersion队列消费则不需这个。。20190803
        if (true) {
            return null;
        }
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key); /*T[] t = (T[]) dataSet.toArray();
        setOperation.add(t);*/
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext()) {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 获得缓存的set
     * @param key
     * @return
     */
/*    public Set<T> getCacheSet(String key) {
        Set<T> dataSet = new HashSet<T>();
        BoundSetOperations<String, T> operation = redisTemplate.boundSetOps(key);
        Long size = operation.size();
        for (int i = 0; i < size; i++) {
            dataSet.add(operation.pop());
        }
        return dataSet;
    }*/
//    /**
//     * 获得缓存的set
//     * @param key
//     * @return
//     */
//    public Set<Long> getCacheLongSet(String key) {
//        Set<Long> dataSet = new HashSet<Long>();
//        BoundSetOperations<String, Long> operation = redisTemplate.boundSetOps(key);
//        Long size = operation.size();
//        for (int i = 0; i < size; i++) {
//            dataSet.add(operation.pop());
//        }
//        return dataSet;
//    }
//
//    /**
//     * 获得缓存的set
//     * @param key
//     * @return
//     */
//    public Set<String> getCacheStringSet(String key) {
//        Set<String> dataSet = new HashSet<String>();
//        BoundSetOperations<String, String> operation = redisTemplate.boundSetOps(key);
//        Long size = operation.size();
//        for (int i = 0; i < size; i++) {
//            dataSet.add(operation.pop());
//        }
//        return dataSet;
//    }

    /**
     * 获得缓存的set
     * @param key
     * @return
     */
    public Set<String> queryCacheStringSet(String key) {
        BoundSetOperations<String, String> operation = redisTemplate.boundSetOps(key);
        return operation.members();
    }

    /**
     * 获得缓存的set
     * @param key
     * @return
     */
    public Set<Long> queryCacheLongSet(String key) {
        BoundSetOperations<String, Long> operation = redisTemplate.boundSetOps(key);
        return operation.members();
    }

    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public <T> HashOperations<String, String, T> setCacheMap(String key, Map<String, T> dataMap, long time, TimeUnit timeUnit) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        if (null != dataMap) {
            for (Map.Entry<String, T> entry : dataMap.entrySet()) {
                hashOperations.put(key, entry.getKey(), entry.getValue());
            }
        }
        if (time == 0) {
            int day = LuaInvConsts.randExpireDay();
            time = day * 24 * 60 * 60;
            timeUnit = TimeUnit.SECONDS;
        }
        redisTemplate.expire(key, time, timeUnit);
        return hashOperations;
    }

    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public <T> HashOperations<String, String, T> setCacheMap(String key, Map<String, T> dataMap) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        if (null != dataMap) {
            for (Map.Entry<String, T> entry : dataMap.entrySet()) {
                hashOperations.put(key, entry.getKey(), entry.getValue());
            }
        }
        return hashOperations;
    }

    public void setCacheLongMapByHashKey(String key, String hashKey, Long value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * 获得缓存的Map
     * @param key
     * @return
     */
    public <T> Map<String, T> getCacheMap(String key) {
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }

    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public <T> HashOperations<String, Integer, T> setCacheIntegerMap(String key, Map<Integer, T> dataMap) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        if (null != dataMap) {
            for (Map.Entry<Integer, T> entry : dataMap.entrySet()) { /*System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); */
                hashOperations.put(key, entry.getKey(), entry.getValue());
            }
        }
        return hashOperations;
    }

    /**
     * 获得缓存的Map
     * @param key
     * @return
     */
    public <T> Map<Integer, T> getCacheIntegerMap(String key/*,HashOperations<String,String,T> hashOperation*/) {
        Map<Integer, T> map = redisTemplate.opsForHash().entries(key); /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }

    /**
     * key是否存在
     * @param key
     * @return
     */
    public boolean existsKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 只修改key不修改value。
     * 如果oldKey不存在抛出异常；
     * 如果newKey不存在则直接将oldKey替换为newKey，不改变oldKey原来的值；
     * 如果newKey存在则该newKey及其value作废，将oldKey替换为newKey，不改变oldKey原来的值；
     *
     * @param oldKey
     * @param newKey
     */
    public void renameKey(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    /**
     * newKey不存在时才重命名
     *
     * @param oldKey
     * @param newKey
     * @return 修改成功返回true
     */
    public boolean renameKeyNotExist(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    /**
     * 删除key
     *
     * @param key
     */
    public Boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 删除多个key
     *
     * @param keys
     */
    public void deleteKey(String... keys) {
        Set<String> kSet = Stream.of(keys).map(k -> k).collect(Collectors.toSet());
        redisTemplate.delete(kSet);
    }

    /**
     * 设置key的生命周期[过期即删除]
     *
     * @param key
     * @param time
     * @param timeUnit
     */
    public void expireKey(String key, long time, TimeUnit timeUnit) {
        redisTemplate.expire(key, time, timeUnit);
    }

    /**
     * 指定key在指定的日期过期【不好用】
     *
     * @param key
     * @param date
     */
    public void expireKeyAt(String key, Date date) {
        redisTemplate.expireAt(key, date);
    }

    /**
     * 查询key的生命周期【返回值需处理】
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public long getKeyExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }

    /**
     * 将key设置为永久有效
     *
     * @param key
     */
    public void persistKey(String key) {
        redisTemplate.persist(key);
    }

    /**
     * 最终加强分布式锁
     * @param key key值
     * @return 是否获取到
     */
    @Deprecated
    public boolean lock(String key, Long LOCK_EXPIRE) {
        String LOCK_PREFIX = "test_lock_";
        String lock = LOCK_PREFIX + key;
        // 利用lambda表达式
        return (Boolean) redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                long expireAt = System.currentTimeMillis() + LOCK_EXPIRE + 1;
                Boolean acquire = redisConnection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());
                if (acquire) {
                    return true;
                } else {
                    byte[] value = redisConnection.get(lock.getBytes());
                    if (Objects.nonNull(value) && value.length > 0) {
                        long expireTime = Long.parseLong(new String(value));
                        if (expireTime < System.currentTimeMillis()) {
                            // 如果锁已经过期
                            byte[] oldValue = redisConnection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + LOCK_EXPIRE + 1).getBytes());
                            // 防止死锁
                            return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
                        }
                    }
                }
                return false;
            }
        });
    }

    public static final String UNLOCK_LUA;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_LUA = sb.toString();
    }

    /**
     * 分布式锁
     * @param key
     * @param expireTime
     * @return
     */
    @Deprecated
    public boolean setLock(String key, long expireTime) {
        try {
            RedisCallback<String> callback = (connection) -> {
                JedisCommands commands = (JedisCommands) connection.getNativeConnection();
                String uuid = UUID.randomUUID().toString();
                return commands.set(key, uuid, "NX", "PX", expireTime);
            };
            Object result = redisTemplate.execute(callback);
            return !StringUtils.isEmpty(result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("set redis occured an exception", e);
        }
        return false;
    }

    public String get(String key) {
        try {
            RedisCallback<String> callback = (connection) -> {
                JedisCommands commands = (JedisCommands) connection.getNativeConnection();
                return commands.get(key);
            };
            Object result = redisTemplate.execute(callback);
            return result.toString();
        } catch (Exception e) {
            logger.error("get redis occured an exception", e);
        }
        return "";
    }

    @Deprecated
    public boolean releaseLock(String key, String requestId) {
        // 释放锁的时候，有可能因为持锁之后方法执行时间大于锁的有效期，此时有可能已经被另外一个线程持有锁，所以不能直接删除
        try {
            List<String> keys = new ArrayList<>();
            keys.add(key);
            List<String> args = new ArrayList<>();
            args.add(requestId);

            // 使用lua脚本删除redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
            // spring自带的执行脚本方法中，集群模式直接抛出不支持执行脚本的异常，所以只能拿到原redis的connection来执行脚本
            RedisCallback<Long> callback = (connection) -> {
                Object nativeConnection = connection.getNativeConnection();
                // 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
                // 集群模式
                if (nativeConnection instanceof JedisCluster) {
                    return (Long) ((JedisCluster) nativeConnection).eval(UNLOCK_LUA, keys, args);
                }
                // 单机模式
                else if (nativeConnection instanceof Jedis) {
                    return (Long) ((Jedis) nativeConnection).eval(UNLOCK_LUA, keys, args);
                }
                return 0L;
            };
            Long result = (Long) redisTemplate.execute(callback);
            return result != null && result > 0;
        } catch (Exception e) {
            logger.error("release lock occured an exception", e);
        } finally {
            // 清除掉ThreadLocal中的数据，避免内存溢出
            //lockFlag.remove();
        }
        return false;
    }

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean tryRreleaseLock(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == false then return 1 end if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    // 测试
    public static String test(Jedis jedis, String lockKey, String requestId) {
        //  String script = "local v = redis.call('get', KEYS[1]) return type(v)";
        String script = "local v = redis.call('get', KEYS[1]) if v == false then return 1 else return 0 end";
        //  String script = "return redis.call('get', KEYS[1])";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        return result + "";
    }

    /**
     * 对key自增
     * @param key
     * @return
     */
    public Long getIncr(String key) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();
        return increment;
    }

    public List<Object> range(String key, long start, long end) {
        List<Object> list = redisTemplate.opsForList().range(key, start, end);
        return list;
    }


    /**
     * 有序集合 - add
     * @param key
     * @param value
     * @param score
     */
    public boolean zsetCacheString(String key, String value, Long score, long expireTime, TimeUnit timeUnit) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        //zset内部是按分数来排序的
        boolean result = zSetOperations.add(key, value, score);
        if (expireTime == 0 || timeUnit == null) {
            long time = 1 * 60 * 60;
            timeUnit = TimeUnit.SECONDS;
            redisTemplate.expire(key, time, timeUnit);
        } else {
            redisTemplate.expire(key, expireTime, timeUnit);
        }
        return result;
    }

    /**
     * 有序集合 - get
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> zsetReverseRangeCacheString(String key, long start, long end) {
        Set<String> stringSet = redisTemplate.opsForZSet().reverseRange(key, start, end);
        return new ArrayList<>(stringSet);
    }

}
