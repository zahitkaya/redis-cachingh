package com.spring.redis.cache.controller.rest;

import com.spring.redis.cache.service.RedisCacheService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class RedisCacheController {

    final RedisCacheService redisCacheService;
    int counter = 0;

    @GetMapping("/test")
    public String cacheControl() throws InterruptedException {
        if (counter == 5) {
            redisCacheService.clearCache();
            counter = 0;
        }
        counter++;
        return redisCacheService.longRunningMethod();
    }

}
