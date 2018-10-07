package net.sppan.base.service;

import java.util.List;

/**
 * RedisService
 * @author: yangzhigang
 * @Date: 2018/10/7 10:34
 * @Description:
 */
public interface RedisService {
    boolean set(String key, String value) throws Exception;

    String get(String key) throws Exception;

    boolean expire(String key, long expire) throws Exception;

    <T> boolean setList(String key, List<T> list) throws Exception;

    <T> List<T> getList(String key, Class<T> clz) throws Exception;

    long lpush(String key, Object obj) throws Exception;

    long rpush(String key, Object obj) throws Exception;

    void hmset(String key, Object obj) throws Exception;

    <T> T hget(String key, Class<T> clz) throws Exception;

    void del(String key) throws Exception;

    <T> List<T>  hmGetAll(String key, Class<T> clz) throws Exception;

    String lpop(String key) throws Exception;
}
