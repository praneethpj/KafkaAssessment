package com.praneth.kafkaassessment1.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"transactionTimestamp"},
        allowGetters = true
)
@EnableJpaAuditing
public abstract class DateAudit implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private String transactionTimestamp;

    @PrePersist
    public void onCreate() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        transactionTimestamp= simpleDateFormat.format(new Date());

    }

    public String getTransactionTimestamp(){
        return transactionTimestamp;
    }

}