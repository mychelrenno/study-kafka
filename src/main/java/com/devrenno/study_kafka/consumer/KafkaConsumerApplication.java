package com.devrenno.study_kafka.consumer;

import com.devrenno.study_kafka.dto.PurchaseOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerApplication {

    private final Logger log = LoggerFactory.getLogger(KafkaConsumerApplication.class);

    @KafkaListener(topics = "purchase-order-topic", groupId = "purchase-order-group")
    public void consumirOrdemCompra(PurchaseOrder dto, Acknowledgment ack) {
        try {
            log.info("Ordem de compra recebida: {}", dto);


            ack.acknowledge(); // confirma sucesso
        } catch (Exception e) {
            log.error("Ocorreu um erro ao processar ordem de compra: {}", dto);
        }

        System.out.println("mycheltest");
    }

}
