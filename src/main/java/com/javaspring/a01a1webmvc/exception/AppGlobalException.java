package com.javaspring.a01a1webmvc.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class AppGlobalException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handle(MethodArgumentNotValidException e) {
        log.error(e.getMessage());

        List<FiledErrorResponse> filedErrorResponseList = new ArrayList<>();

        e.getFieldErrors().forEach(fieldError ->
                filedErrorResponseList.add(
                        new FiledErrorResponse(
                                fieldError.getField(),
                                fieldError.getDefaultMessage()
                        )
                )
        );
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Request data is invalid..!")
                .timestamp(Instant.now())
                .errorDetail(filedErrorResponseList)
                .build();
    }

}