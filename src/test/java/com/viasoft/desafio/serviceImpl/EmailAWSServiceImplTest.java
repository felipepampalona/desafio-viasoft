package com.viasoft.desafio.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viasoft.desafio.dto.EmailAwsDTO;
import com.viasoft.desafio.dto.EmailDTO;
import com.viasoft.desafio.validator.EmailAwsValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class EmailAWSServiceImplTest {

    @Mock
    private EmailAwsValidator emailAWSValidator;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private EmailAWSServiceImpl emailAWSServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendEmail() throws JsonProcessingException {
        EmailDTO emailDTO = mock(EmailDTO.class);
        EmailAwsDTO emailAwsDTO = mock(EmailAwsDTO.class);

        when(emailDTO.toEmailAwsDTO(emailDTO)).thenReturn(emailAwsDTO);
        when(objectMapper.writeValueAsString(emailAwsDTO)).thenReturn("emailJson");

        emailAWSServiceImpl.sendEmail(emailDTO);

        verify(emailAWSValidator).validate(emailAwsDTO);
        verify(objectMapper).writeValueAsString(emailAwsDTO);
    }
}
