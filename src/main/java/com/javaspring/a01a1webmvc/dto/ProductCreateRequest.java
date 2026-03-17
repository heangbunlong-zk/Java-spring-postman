package com.javaspring.a01a1webmvc.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductCreateRequest(

        @NotBlank
        @Size(min = 1, max = 50)
        String name,

        @NotNull
        @Positive
        @Max(10000)
        BigDecimal price,

        @NotNull
        @Positive
        @Max(929387)
        Integer categoryId
) {

}
