package com.praneth.kafkaassessment1.repositories;

import com.praneth.kafkaassessment1.entities.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<PaymentTransaction, Integer> {

}
