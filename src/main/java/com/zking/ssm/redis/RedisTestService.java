package com.zking.ssm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisTestService {

    @Autowired
    private RedisUtil redisUtil;

    public void setValue(String key, Object value) {
        redisUtil.set(key, value);
    }

    public Object getValue(String key) {
        return redisUtil.get(key);
    }
}
