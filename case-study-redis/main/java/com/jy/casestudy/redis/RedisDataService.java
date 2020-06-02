package com.jy.casestudy.redis;

import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author yj
 * @since 2020-06-02 12:41
 **/
public class RedisDataService {

    private static final int LOCK_TIME = 5;
    private static final TimeUnit LOCK_TIME_UNIT = TimeUnit.SECONDS;
    private static final int MAX_TRIES = 3;

    private final ValueOperations<String, String> opsForValue;

    public String concurrentLoadData(String key) {
        long timestamp = System.currentTimeMillis();
        String lockKey = buildLockKey(key);
        boolean success = acquireLock(lockKey, timestamp);
        if(success) {
            return acquireLockSuccess(key, lockKey);
        } else {
            return acquireLockFailed(key, lockKey);
        }
    }

    /**
     * 构建lock key
     */
    private static String buildLockKey(String key) {
        return key +  ":" + "lock";
    }

    /**
     * 抢占锁
     */
    private boolean acquireLock(String key, long timestamp) {
        return opsForValue.setIfAbsent(key, Objects.toString(timestamp), LOCK_TIME, LOCK_TIME_UNIT);
    }

    /**
     * 抢占锁成功逻辑
     */
    public String acquireLockSuccess(String key, String lockKey) {
        RedisOperations<String, String> redisOperations = opsForValue.getOperations();
        //重新检查该key是否存在, 如果是则直接返回
        if(redisOperations.hasKey(key)) {
            return opsForValue.get(key);
        }
        //监视锁
        redisOperations.watch(key);
        //加载数据
        String data = loadBusinessData();
        //开启事务，缓存数据并释放锁
        redisOperations.multi();
        opsForValue.set(key, data);
        redisOperations.delete(lockKey);
        redisOperations.exec();
        return data;
    }

    /**
     * 抢占锁失败逻辑
     */
    public String acquireLockFailed(String key, String lockKey) {
        int maxTries = MAX_TRIES;
        while (maxTries-- > 0) {
            //sleep一会
            try { Thread.sleep(1000);} catch (InterruptedException e) { e.printStackTrace();}
            RedisOperations<String, String> redisOperations = opsForValue.getOperations();
            //判断该key对应的数据是否已经被加载, 如果是则直接返回该数据
            if(redisOperations.hasKey(key)) {
                return opsForValue.get(key);
            }
            //如果锁不存在，不存在超时情况，重新执行抢锁逻辑
            if(!redisOperations.hasKey(lockKey)) {
                return concurrentLoadData(key);
            }
        }
        return null;
    }

    private String loadBusinessData() {
        return "";
    }


    public RedisDataService(ValueOperations<String, String> opsForValue) {
        this.opsForValue = opsForValue;
    }
}
