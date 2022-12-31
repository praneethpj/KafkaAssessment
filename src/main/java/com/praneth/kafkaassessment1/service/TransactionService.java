package com.praneth.kafkaassessment1.service;


import com.praneth.kafkaassessment1.entities.PaymentTransaction;
import com.praneth.kafkaassessment1.impl.TransactionImpl;
import com.praneth.kafkaassessment1.payload.PaymentTransactionPayload;
import com.praneth.kafkaassessment1.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements TransactionImpl {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private ProducerService producerService;

    public void publishTransactions(List<PaymentTransactionPayload> addRecordsPayload){
        logger.info("publishTransactions");

        for (PaymentTransactionPayload paymentTransactionPayload:addRecordsPayload){
            producerService.sendPaymentTransactionMessage(paymentTransactionPayload);
        }
    }

    @Override
    public PaymentTransaction recordTransaction(PaymentTransaction addRecordsPayload) {
        logger.info("recordTransaction");
       PaymentTransaction paymentTransaction= transactionRepository.save(addRecordsPayload);
       logger.info(paymentTransaction.getTransactionId().toString());
        logger.info(paymentTransaction.getTransactionAmount()+"");
        logger.info(paymentTransaction.getCardNumber()+"");
        logger.info(paymentTransaction.getCardBalance()+"");
        logger.info(paymentTransaction.getTransactionTimestamp()+"");

       return paymentTransaction;
    }

    @Override
    public List<PaymentTransaction> getAllTransaction() {
        logger.info("getAllTransaction");
        List<PaymentTransaction> paymentTransactions=transactionRepository.findAll();
        System.out.println("TransactionId \t TransactionTimestamp \t TransactionAmount \t CardNumber \t CardBalance");
        for (PaymentTransaction paymentTransactiontmp:paymentTransactions){
            System.out.println(paymentTransactiontmp.getTransactionId()+"\t\t\t"+paymentTransactiontmp.getTransactionTimestamp()+"\t\t"+paymentTransactiontmp.getTransactionAmount()+"\t\t\t"+paymentTransactiontmp.getCardNumber()+"\t\t\t"+paymentTransactiontmp.getCardBalance());
        }

        return paymentTransactions;
    }
}
