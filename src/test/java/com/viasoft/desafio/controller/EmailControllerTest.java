package com.viasoft.desafio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viasoft.desafio.dto.EmailDTO;
import com.viasoft.desafio.fixture.EmaiFixture;
import com.viasoft.desafio.serviceImpl.EmailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmailControllerTest {

    @Mock
    private EmailServiceImpl emailService;

    @InjectMocks
    private EmailController emailController;

    private EmailDTO emailDTO;

    @BeforeEach
    public void setUp() {
        emailDTO = EmaiFixture.emailDTOValido;
    }

    @Test
    public void testSendEmailValidEmail() throws JsonProcessingException {
        doNothing().when(emailService).sendEmail(emailDTO);
        ReflectionTestUtils.setField(emailService, "mailIntegration", "AWS");

        ResponseEntity<?> response = emailController.sendEmail(emailDTO);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(emailService, times(1)).sendEmail(emailDTO);
    }

    @Test
    public void testSendEmailInvalidEmail() throws JsonProcessingException {
        doThrow(new IllegalArgumentException("Validation failed")).when(emailService).sendEmail(emailDTO);
        ReflectionTestUtils.setField(emailService, "mailIntegration", "AWS");
        assertThrows(IllegalArgumentException.class, () -> emailController.sendEmail(emailDTO));

        verify(emailService, times(1)).sendEmail(emailDTO);
    }
}