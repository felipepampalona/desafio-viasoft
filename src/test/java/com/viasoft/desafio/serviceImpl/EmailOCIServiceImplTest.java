package com.viasoft.desafio.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viasoft.desafio.dto.EmailDTO;
import com.viasoft.desafio.dto.EmailOciDTO;
import com.viasoft.desafio.validator.EmailOciValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class EmailOCIServiceImplTest {

    @Mock
    private EmailOciValidator emailOciValidator;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private EmailOCIServiceImpl emailOCIServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendEmail() throws JsonProcessingException {
        EmailDTO emailDTO = mock(EmailDTO.class);
        EmailOciDTO emailOciDTO = mock(EmailOciDTO.class);

        when(emailDTO.toEmailOciDTO(emailDTO)).thenReturn(emailOciDTO);
        doNothing().when(emailOciValidator).validate(emailOciDTO);
        when(objectMapper.writeValueAsString(emailOciDTO)).thenReturn("emailOciDTOJson");

        emailOCIServiceImpl.sendEmail(emailDTO);

        verify(emailDTO).toEmailOciDTO(emailDTO);
        verify(emailOciValidator).validate(emailOciDTO);
        verify(objectMapper).writeValueAsString(emailOciDTO);
    }
}
