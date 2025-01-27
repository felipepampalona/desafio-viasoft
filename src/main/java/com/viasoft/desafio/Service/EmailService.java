package com.viasoft.desafio.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.viasoft.desafio.dto.EmailDTO;

public interface EmailService {
    void sendEmail(EmailDTO emailDTO) throws JsonProcessingException;
}
