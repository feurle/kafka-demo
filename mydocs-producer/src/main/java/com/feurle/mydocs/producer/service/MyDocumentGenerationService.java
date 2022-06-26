package com.feurle.mydocs.producer.service;

import com.feurle.mydocs.producer.domain.MyDocument;
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
        mydocsKafkaTemplate.send("mydocs",myDocument);
    }

    private String generateRandomMydocument() {
        MyDocument myDocument = RandomMydocsGenerator.generateRandomObject();
        final Gson gson = new Gson();
        String mydocJsonString = gson.toJson(myDocument);
        log.info(mydocJsonString);
        return mydocJsonString;
    }


    @Scheduled (fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        sendMydocsMessage(generateRandomMydocument());
        log.info("Fixed delay task - {}", System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        sendMydocsMessage(generateRandomMydocument());
        log.info("Fixed rate task - {}", System.currentTimeMillis() / 1000);
    }
}
