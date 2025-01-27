package com.viasoft.desafio.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viasoft.desafio.Service.EmailService;
import com.viasoft.desafio.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailServiceImpl {

    private final Map<String, EmailService> mapStrategy = Map.of(
            "AWS", new EmailAWSServiceImpl(),
            "OCI", new EmailOCIServiceImpl()
    );

    @Value("${mail.integracao}")
    private String mailIntegration;

    public void sendEmail(EmailDTO emailDTO) throws JsonProcessingException {
        mapStrategy.get(mailIntegration).sendEmail(emailDTO);
    }
}
