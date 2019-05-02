package com.zking.ssm.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 提供了不允许连续错误登录的判断。真正匹配的过程还是交给它的直接父类去完成。
 * 连续登录错误的判断依靠Ehcache缓存来实现。显然match返回true为匹配成功
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    // 声明一个缓存接口，这个接口是Shiro缓存管理的一部分，它的具体实现可以通过外部容器注入
    private Cache<String, AtomicInteger> passwordRetryCache;

    //使用的缓存对象的名字
    private String cacheName = "passwordRetryCache";

    //缓存管理器
    private CacheManager cacheManager;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public void init() {
        passwordRetryCache = cacheManager.getCache(this.cacheName);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        // 自定义一个验证过程：当用户60秒内连续输入密码错误5次以上禁止用户登录一段时间(60秒时间是在ehcache.xml中设置的)
        if (retryCount.incrementAndGet() > 5) {
            throw new ExcessiveAttemptsException();
        }
        boolean match = super.doCredentialsMatch(token, info);
        if (match) {
            passwordRetryCache.remove(username);
        }
        return match;
    }
}