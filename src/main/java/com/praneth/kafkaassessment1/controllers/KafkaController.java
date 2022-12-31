package com.praneth.kafkaassessment1.controllers;

import com.praneth.kafkaassessment1.entities.PaymentTransaction;
import com.praneth.kafkaassessment1.payload.PaymentTransactionPayload;
import com.praneth.kafkaassessment1.service.ProducerService;
import com.praneth.kafkaassessment1.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/transaction")
@Validated
public class KafkaController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private TransactionService transactionService;


    @PostMapping(value = "/publish")
    public Map<String, Object> publishMessage(@Valid @RequestBody  List<PaymentTransactionPayload>  paymentTransactionPayload) {
        transactionService.publishTransactions(paymentTransactionPayload);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Successfully publisher PaymentTransaction..!");
        map.put("payload", paymentTransactionPayload);

        return  map;
    }

    @GetMapping(value = "/allrecords")
    public  List<PaymentTransaction> getAllrecords(){
        return transactionService.getAllTransaction();
    }
}
