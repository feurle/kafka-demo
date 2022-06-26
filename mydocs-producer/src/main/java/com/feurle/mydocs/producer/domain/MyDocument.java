package com.feurle.mydocs.producer.domain;

import com.feurle.mydocs.producer.domain.enumeration.DocType;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Getter
@Setter
@Builder
@ToString
public class MyDocument {

    private String customerReference;
    private String gwReference;
    private String orderId;
    private String creationDate;
    private DocType docType;
    private String invoiceNumber;
    private Integer financialYear;
    private String docFormat;
    private String docId;
    private String docDateTime;
    private String url;
    private String customerNr;
}
