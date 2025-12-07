package com.devrenno.study_kafka.producer;

import com.devrenno.study_kafka.dto.PurchaseOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class KafkaProducerApplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(KafkaProducerApplication.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            PurchaseOrder order = new PurchaseOrder("bicicleta caloi", 2, new BigDecimal("2200.55"));
            kafkaTemplate.send("purchase-order-topic", order);
            log.info("Ordem de compra enviada: {}", order);
        }

        System.out.println("mycheltest");
    }
}
