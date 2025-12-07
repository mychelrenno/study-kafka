package com.devrenno.study_kafka.dto;

import java.math.BigDecimal;

public record PurchaseOrder(
        String product,
        int quantity,
        BigDecimal price
) {
}
