package com.feurle.mydocs.producer.domain;

import com.feurle.mydocs.producer.domain.enumeration.DocType;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyDocument {

    private String customerReference;
    private String gwReference;
    private String orderId;
    private ZonedDateTime creationDate;
    private DocType docType;
    private String invoiceNumber;
    private Integer financialYear;
    private String docFormat;
    private String docId;
    private ZonedDateTime docDateTime;
    private String url;
    private String customerNr;
}
