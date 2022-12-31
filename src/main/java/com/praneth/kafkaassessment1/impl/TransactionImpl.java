package com.praneth.kafkaassessment1.impl;

import com.praneth.kafkaassessment1.entities.PaymentTransaction;

import java.util.List;

public interface TransactionImpl {

     PaymentTransaction recordTransaction(PaymentTransaction addRecordsPayload);
     List<PaymentTransaction> getAllTransaction();

}
