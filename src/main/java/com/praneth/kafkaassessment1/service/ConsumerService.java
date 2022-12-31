package com.praneth.kafkaassessment1.service;

import com.praneth.kafkaassessment1.entities.PaymentTransaction;
import com.praneth.kafkaassessment1.payload.PaymentTransactionPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TransactionService transactionService;


    @KafkaListener(topics = {"${spring.kafka.payment-topic}"}, containerFactory = "kafkaListenerJsonFactory", groupId = "group_id")
    public void consumePaymentTransaction(PaymentTransactionPayload paymentTransactionPayload) {

        PaymentTransaction paymentTransaction =new PaymentTransaction();

        paymentTransaction.setTransactionAmount(paymentTransactionPayload.getTransactionAmount());
        paymentTransaction.setCardNumber(paymentTransactionPayload.getCardNumber());
        paymentTransaction.setCardBalance(paymentTransactionPayload.getCardBalance());

        logger.info("**** -> Consumed Payment :: {}", paymentTransaction);

        transactionService.recordTransaction(paymentTransaction);


    }

}
