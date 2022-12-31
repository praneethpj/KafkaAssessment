package com.praneth.kafkaassessment1.payload;



import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.io.Serializable;



public class PaymentTransactionPayload implements Serializable {

    private static final long serialVersionUID = 1L;



    private float transactionAmount;

    private long cardNumber;


    private float cardBalance;
    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        if(String.valueOf(transactionAmount).isEmpty()){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,"Transaction Amount cannot be empty");
        }
        this.transactionAmount = transactionAmount;
    }

    public long getCardNumber() {

    return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        if(cardNumber==0){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,"Card Number empty");
        }
        else if(String.valueOf(cardNumber).length()<9 || String.valueOf(cardNumber).length()>11){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,cardNumber+" Card Number length should be 10 ");
        }

        this.cardNumber = cardNumber;
    }

    public float getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(float cardBalance) {
        if(String.valueOf(cardBalance).isEmpty()){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,"cardBalance cannot be empty");
        }
        this.cardBalance = cardBalance;
    }




    @Override
    public String toString() {
        return "AddRecordsPayload [transactionAmount=" + transactionAmount + ", cardNumber=" + cardNumber
                + ", cardBalance=" + cardBalance + "]";
    }



}