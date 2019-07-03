#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.impl;

import ${package}.business.dal.interfaces.RedisRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis集成实现类
 *
 * @author : joy.x.wei
 * @Data : 2018/12/27
 * @Time : 10:55 AM
 */
@Slf4j
@Service
public class RedisRepoImpl implements RedisRepo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean put(String key, String value) {
        try {
            stringRedisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("put异常", e);
        }
        return false;
    }

    @Override
    public String get(String key) {
        try {
            return stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error("get异常", e);
        }
        return null;
    }

    @Override
    public boolean delete(String key) {
        try {
            stringRedisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            log.error("delete异常", e);
        }

        return false;
    }

    @Override
    public boolean lock(String key, String value, long timeout) {
        try {
            stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.error("put异常", e);
        }
        return false;
    }
}
