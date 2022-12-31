package com.praneth.kafkaassessment1.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "payment_transactions")
@Getter
@Setter
@ToString
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PaymentTransaction extends DateAudit {

    @Id
    @GenericGenerator(
            name = "customers-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "customers_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "100000000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    @GeneratedValue(generator = "customers-sequence-generator")
    @Column(nullable=false, updatable=false)
    @JsonProperty("transactionId")
   private Integer transactionId;

   private float transactionAmount;
   private Long cardNumber;
   private float  cardBalance;



}
