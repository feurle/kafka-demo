package com.feurle.mydocs.producer.util;

import com.feurle.mydocs.producer.domain.MyDocument;
import com.feurle.mydocs.producer.domain.enumeration.DocType;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMydocsGenerator {

    public static MyDocument generateRandomObject() {
        MyDocument myDocument = MyDocument.builder()
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
                .url(getRandomString())
                .customerNr(getRandomNumberAsString())
                .build();
        return myDocument;

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
        return new String(array, Charset.forName("UTF-8"));
    }

    private static String getRandomNumberAsString() {
        Random random = new Random();
        return Long.toString(random.longs(10000000,99999999).findFirst().getAsLong());
    }

    private static Integer getRandomYear() {
        Random random = new Random();
        return random.ints(2000, 2022)
                .findFirst()
                .getAsInt();
    }
}
