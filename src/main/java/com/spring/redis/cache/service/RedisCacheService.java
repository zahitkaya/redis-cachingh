package com.spring.redis.cache.service;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {
    @Cacheable(cacheNames = "mySpeacialCache")
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(5000);
        return "Method worked!";
    }

    @CacheEvict(cacheNames = "mySpeacialCache")
    public void clearCache() {
        System.out.println("Cache was cleaned!");
    }
}
