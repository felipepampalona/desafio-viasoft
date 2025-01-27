package com.viasoft.desafio.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viasoft.desafio.Service.EmailService;
import com.viasoft.desafio.dto.EmailDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmailServiceImplTest {

    @InjectMocks
    private EmailServiceImpl emailServiceImpl;

    @Mock
    private EmailService emailAWSServiceImpl;

    @Mock
    private EmailService emailOCIServiceImpl;

    @BeforeEach
    public void setUp() {
        Map<String, EmailService> mapStrategy = Map.of(
                "AWS", emailAWSServiceImpl,
                "OCI", emailOCIServiceImpl
        );
        ReflectionTestUtils.setField(emailServiceImpl, "mapStrategy", mapStrategy);
    }

    @Test
    public void testSendEmailWithAWS() throws JsonProcessingException {
        ReflectionTestUtils.setField(emailServiceImpl, "mailIntegration", "AWS");
        EmailDTO emailDTO = new EmailDTO();
        emailServiceImpl.sendEmail(emailDTO);
        verify(emailAWSServiceImpl, times(1)).sendEmail(emailDTO);
    }

    @Test
    public void testSendEmailWithOCI() throws JsonProcessingException {
        ReflectionTestUtils.setField(emailServiceImpl, "mailIntegration", "OCI");
        EmailDTO emailDTO = new EmailDTO();
        emailServiceImpl.sendEmail(emailDTO);
        verify(emailOCIServiceImpl, times(1)).sendEmail(emailDTO);
    }
}