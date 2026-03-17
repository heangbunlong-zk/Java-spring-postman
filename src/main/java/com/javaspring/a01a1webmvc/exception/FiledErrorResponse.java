package com.javaspring.a01a1webmvc.exception;

public record FiledErrorResponse(
        String field,
        String reason
) {
}
