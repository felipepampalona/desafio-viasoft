package com.viasoft.desafio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viasoft.desafio.error.Errors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdviceControllerTest {

    private AdviceController adviceController;

    @BeforeEach
    public void setUp() {
        adviceController = new AdviceController();
    }

    @Test
    public void testHandleJsonProcessingException() {
        JsonProcessingException exception = new JsonProcessingException("Test JSON error") {};

        ResponseEntity<Errors> response = adviceController.handleJsonProcessingException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Erro ao processar o JSON: Test JSON error", response.getBody().getMessage());
    }

    @Test
    public void testHandleIllegalArgumentException() {
        IllegalArgumentException exception = new IllegalArgumentException("Test illegal argument");

        ResponseEntity<Errors> response = adviceController.handleIllegalArgumentException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Test illegal argument", response.getBody().getMessage());
    }
}
