package com.praneth.kafkaassessment1.service;

import com.praneth.kafkaassessment1.payload.PaymentTransactionPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.kafka.payment-topic}")
    private String paymentTransactionTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, PaymentTransactionPayload> kafkaTemplateTransaction;

    public void sendPaymentTransactionMessage(PaymentTransactionPayload paymentTransaction) {
        logger.info("#### -> Publishing Payment :: {}", paymentTransaction);
        kafkaTemplateTransaction.send(paymentTransactionTopic, paymentTransaction);
    }
}
