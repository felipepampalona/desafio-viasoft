package com.viasoft.desafio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viasoft.desafio.dto.EmailDTO;
import com.viasoft.desafio.serviceImpl.EmailServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
@AllArgsConstructor
public class EmailController {

    private EmailServiceImpl emailService;

    @PostMapping(value = "/send")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> sendEmail(@RequestBody EmailDTO emailDTO) throws JsonProcessingException {
        emailService.sendEmail(emailDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
