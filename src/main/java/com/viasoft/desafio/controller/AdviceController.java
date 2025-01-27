package com.viasoft.desafio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viasoft.desafio.error.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Errors> handleJsonProcessingException(JsonProcessingException ex) {
        Errors error = new Errors(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao processar o JSON: " + ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Errors> handleIllegalArgumentException(IllegalArgumentException ex) {
        Errors error = new Errors(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

}
