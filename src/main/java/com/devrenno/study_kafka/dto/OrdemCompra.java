package com.devrenno.study_kafka.dto;

import java.math.BigDecimal;

public record OrdemCompra(
        String produto,
        int quantidade,
        BigDecimal preco
) {
}
