package com.javaspring.a01a1webmvc.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String code,
        String name,
        BigDecimal price
) {
}
