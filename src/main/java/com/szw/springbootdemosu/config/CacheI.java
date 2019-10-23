package com.szw.springbootdemosu.config;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public interface CacheI {
    Set keys(String key);

    /**
     * String 存在就修改，不存在就新增
     *
     * @param key
     * @param value
     */
    void set(byte[] key, byte[] value);

    /**
     * String 不存在就修改,存在就不操作
     *
     * @param key
     * @param value
     */
    void setnx(byte[] key, byte[] value);

    /**
     * 不存在，返回null
     *
     * @param key
     * @return
     */
    byte[] get(byte[] key);

    /**
     * 同set
     *
     * @param key
     * @param o
     */
    void set(String key, Object o);

    /**
     * 同setnx
     *
     * @param key
     * @param o
     */
    void setnx(String key, Object o);

    List mget(Class clazz, String... keys);

    /**
     * 获取对象
     *
     * @param key
     * @param clazz
     * @return
     */
    Object get(String key, Class clazz);

    /**
     * 删除指定key
     *
     * @param key
     */
    void delete(String key);

    /**
     * 删除指定key
     *
     * @param keys
     */
    void delete(String... keys);

    /**
     * 删除指定key
     *
     * @param key
     */
    void delete(byte[] key);


    /**
     * 排序set,根据范围scroe分数取元素
     * @param key
     * @param minScore
     * @param maxScore
     * @param clazz
     * @return
     */
    List zget(String key, double minScore, double maxScore, Class clazz);

    /**
     * 排序set,根据index序号取元素
     * @param key
     * @param start
     * @param end
     * @param clazz
     * @return
     */
    List zgetByindex(String key, long start, long end, Class clazz);

    Long zrem(String key, Object... member);

    /**
     * 如果在添加时参数中的某一成员已经存在，该命令将更新此成员的分数为新值，
     * 同时再将该成员基于新值重新排序。如果键不存在，该命令将为该键创建一个新的Sorted-Sets
     * @param key
     * @param score
     * @param o
     */
    void zadd(String key, double score, Object o);

    /**
     * 返回有序集key中，score值在min和max之间(默认包括score值等于min或max)的成员。
     * @param key
     * @param start
     * @param end
     * @return
     */
    Long zcount(String key, double start, double end);

    /**
     * 为指定的Key设定Field/Value对，如果Key不存在，
     * 该命令将创建新Key以参数中的Field/Value对，
     * 如果参数中的Field在该Key中已经存在，则用新值覆盖其原有值
     * @param key
     * @param field
     * @param value
     */
    void hset(String key, String field, String value);

    void hmset(String key, Map map);

    /**
     * 为指定的Key设定Field/Value对，如果Key不存在，
     * 该命令将创建新Key以参数中的Field/Value对，
     * 如果参数中的Field在该Key中已经存在，则用新值覆盖其原有值
     * @param key
     * @param field
     */
    void hdel(String key, String field);

    String hget(String key, String field);

    /**
     * Hash 返回 key 指定的哈希集中所有的字段和值。
     * @param key
     * @return
     */
    Map hgetAll(String key);

    void sadd(String key, String... member);

    Set smembers(String key);

    void srem(String key, String... member);

    long scount(String key);

    boolean sismember(String key, String member);

    String typeKey(String key);

    Long getIncr(String key);

    Long getIncrby(String key, Long value);

    /**
     * 不存在，返回null
     * @param key
     * @return
     */
    String get(String key);

    void  newSet(String key, String value);


    public void setPrintKey(String key, String value, Long expireSecond);
    Jedis getResource();

    /**
     * 设置失效时间  单位秒
     * */
    public void setExpire(String key, int time);
}
