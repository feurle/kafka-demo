package com.feurle.mydocs.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyDocumentGenerationService {

    private final Logger log = LoggerFactory.getLogger(MyDocumentGenerationService.class);

    @Scheduled (fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        log.info(
                "Fixed delay task - {}", System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        log.info(
                "Fixed rate task - {}", System.currentTimeMillis() / 1000);
    }
}
