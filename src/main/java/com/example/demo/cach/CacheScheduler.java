package com.example.demo.cach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CacheScheduler {
    private static final Logger logger = LoggerFactory.getLogger(CacheScheduler.class);

    @Autowired
    private CacheManager cacheManager;

    @Scheduled(fixedDelayString = "${cache.evict.delay}")
    public void evictCache() {
        logger.info("Evicting cache...");
        cacheManager.getCache("specification").clear();
        logger.info("Cache evicted successfully.");
    }
}
