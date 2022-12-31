//package com.praneth.kafkaassessment1.service;
//
//import com.praneth.kafkaassessment1.entities.PaymentTransaction;
//import com.praneth.kafkaassessment1.payload.PaymentTransactionPayload;
//import kafka.zk.EmbeddedZookeeper;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.hamcrest.core.IsEqual;
//import org.junit.Before;
//import org.junit.ClassRule;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.platform.commons.logging.LoggerFactory;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.listener.MessageListenerContainer;
//import org.springframework.kafka.test.rule.KafkaEmbedded;
//import org.springframework.kafka.test.utils.ContainerTestUtils;
//import org.springframework.kafka.test.utils.KafkaTestUtils;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.Map;
//import java.util.logging.Logger;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.timeout;
//import static org.testcontainers.shaded.com.google.common.base.Verify.verify;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestPropertySource(locations="classpath:application.yml")
//public class ConsumerServiceTest {
//    private PaymentTransactionPayload event = new PaymentTransactionPayload();
//
//    @SpyBean
//    private ConsumerService consumer;
//
//    @Autowired
//    private ProducerService producer;
//
//    @Captor
//    ArgumentCaptor<List<PaymentTransactionPayload>> paymentArgumentCaptor;
//
//
//    private String TOPIC_NAME = "transaction-topic";
//
//    @Captor
//    ArgumentCaptor<String> topicArgumentCaptor;
//
//    @Test
//    public void embeddedKafka_whenSendingToSimpleProducer_thenMessageReceived() {
//
//        event.setCardBalance(100);
//        event.setCardNumber(1234567890);
//        event.setTransactionAmount(10);
//
//        //Producer
//        producer.sendPaymentTransactionMessage(event);
//
//        //consumer
//        Mockito.verify(consumer).consumePaymentTransaction(event);
//
//        List<PaymentTransactionPayload> batchPayload = paymentArgumentCaptor.getValue();
//        assertNotNull(batchPayload);
//        assertThat(batchPayload.size(), IsEqual.equalTo(01));
//        assertTrue(TOPIC_NAME.contains(topicArgumentCaptor.getValue()));
//        testEvents(batchPayload);
//    }
//
//    private void testEvents(List<PaymentTransactionPayload> eventsPayload) {
//        eventsPayload.forEach(record -> {
//            assertNotNull(record);
//            assertEquals(event.getCardBalance(), record.getCardBalance());
//
//        });
//    }
//}