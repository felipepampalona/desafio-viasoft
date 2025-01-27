package com.viasoft.desafio.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viasoft.desafio.Service.EmailService;
import com.viasoft.desafio.dto.EmailAwsDTO;
import com.viasoft.desafio.dto.EmailDTO;
import com.viasoft.desafio.validator.EmailAwsValidator;
import com.viasoft.desafio.validator.EmailOciValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.logging.Logger;

@AllArgsConstructor
@NoArgsConstructor
public class EmailAWSServiceImpl implements EmailService {

    private static final Logger logger = Logger.getLogger(EmailAWSServiceImpl.class.getName());
    private EmailAwsValidator emailAWSValidator = new EmailAwsValidator();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void sendEmail(EmailDTO emailDTO) throws JsonProcessingException {
        EmailAwsDTO email = emailDTO.toEmailAwsDTO(emailDTO);
        emailAWSValidator.validate(email);
        logger.info(objectMapper.writeValueAsString(email));
    }
}
