package com.feurle.mydocs.producer.service;

import com.feurle.mydocs.producer.util.RandomMydocsGenerator;
import com.google.gson.Gson;
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
    private KafkaTemplate<String, String> mydocsKafkaTemplate;

    private void sendMydocsMessage(String myDocument) {
        mydocsKafkaTemplate.send("mydocs", myDocument);
    }

    private String generateRandomMyDocument() {
        final Gson gson = new Gson();
        final String mydocJsonString = gson.toJson(RandomMydocsGenerator.generateRandomObject());
        log.info(mydocJsonString);
        return mydocJsonString;
    }

    @Scheduled(fixedRate = 100)
    public void scheduleFixedRateTask() {
        sendMydocsMessage(generateRandomMyDocument());
    }
}
