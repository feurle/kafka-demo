package com.feurle.mydocs.producer.util;

import com.feurle.mydocs.producer.domain.MyDocument;
import com.feurle.mydocs.producer.domain.enumeration.DocType;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMydocsGenerator {

    public static MyDocument generateRandomObject() {
        return MyDocument.builder()
                .customerReference(getRandomNumberAsString())
                .gwReference(getRandomNumberAsString())
                .orderId(getRandomNumberAsString())
                .creationDate(getRandomDate())
                .docType(getRandomDocType())
                .invoiceNumber(getRandomNumberAsString())
                .financialYear(getRandomYear())
                .docFormat(getRandomNumberAsString())
                .docId(getRandomNumberAsString())
                .docDateTime(getRandomDate())
                .url(getRandomUrl())
                .customerNr(getRandomNumberAsString())
                .build();
    }

    private static DocType getRandomDocType() {
        final Random random = new Random();
        DocType[] docTypes = DocType.values();
        return docTypes[random.nextInt(docTypes.length)];
    }

    private static String getRandomDate() {
        final String DATE_FORMAT = "MMM d, yyyy HH:mm a";
        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(new Date(ThreadLocalRandom.current().nextInt() * 1000L));
    }

    private static String getRandomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    private static String getRandomUrl() {
        final String alphaNumericString = "0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);
        sb.append("http://");
        for (int i = 0; i < 10; i++) {
            int index = (int) (alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        sb.append(".com");
        return sb.toString();
    }


    private static String getRandomNumberAsString() {
        Random random = new Random();
        return Long.toString(random.longs(10000000,99999999)
                .findFirst()
                .getAsLong());
    }

    private static Integer getRandomYear() {
        Random random = new Random();
        return random.ints(2000, 2022)
                .findFirst()
                .getAsInt();
    }
}
