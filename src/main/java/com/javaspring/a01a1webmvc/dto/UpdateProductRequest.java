package com.javaspring.a01a1webmvc.dto;

import java.math.BigDecimal;

public record UpdateProductRequest(
        String name,
        BigDecimal price
) {
}