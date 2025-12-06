package com.devrenno.study_kafka.producer;

import com.devrenno.study_kafka.dto.OrdemCompra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class KafkaProducerAplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(KafkaProducerAplication.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            OrdemCompra ordem = new OrdemCompra("bicicleta caloi", 2, new BigDecimal(2200.55));
            kafkaTemplate.send("test-topic", ordem);
            log.info("Ordem de compra enviada: {}", ordem);
        }
    }
}
