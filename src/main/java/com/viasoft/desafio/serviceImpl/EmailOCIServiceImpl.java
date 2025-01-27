package com.viasoft.desafio.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viasoft.desafio.Service.EmailService;
import com.viasoft.desafio.dto.EmailDTO;
import com.viasoft.desafio.dto.EmailOciDTO;
import com.viasoft.desafio.validator.EmailOciValidator;
import lombok.NoArgsConstructor;

import java.util.logging.Logger;

@NoArgsConstructor
public class EmailOCIServiceImpl implements EmailService {

    private static final Logger logger = Logger.getLogger(EmailOCIServiceImpl.class.getName());

    private EmailOciValidator emailOciValidator = new EmailOciValidator();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void sendEmail(EmailDTO emailDTO) throws JsonProcessingException {
        EmailOciDTO email = emailDTO.toEmailOciDTO(emailDTO);
        emailOciValidator.validate(email);
        logger.info(objectMapper.writeValueAsString(email));
    }
}
