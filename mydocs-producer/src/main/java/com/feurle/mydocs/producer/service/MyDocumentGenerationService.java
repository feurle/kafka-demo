package com.feurle.mydocs.producer.service;

import com.feurle.mydocs.producer.domain.MyDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyDocumentGenerationService {

    private final Logger log = LoggerFactory.getLogger(MyDocumentGenerationService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, MyDocument> mydocsKafkaTemplate;

    private void sendSimpleMessage(String msg) {
        kafkaTemplate.send("feurle", msg);
    }

    @Scheduled (fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        long tm = System.currentTimeMillis() / 1000;
        log.info(
                "Fixed delay task - {}", tm);
        sendSimpleMessage(String.valueOf(tm));
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        log.info(
                "Fixed rate task - {}", System.currentTimeMillis() / 1000);
    }
}
