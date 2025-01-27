package com.viasoft.desafio.validator;

import com.viasoft.desafio.dto.EmailAwsDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EmailAwsValidator implements EmailValidator<EmailAwsDTO> {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


    @Override
    public void validate(EmailAwsDTO emailAwsDTO) {
        Set<ConstraintViolation<EmailAwsDTO>> violations = validator.validate(emailAwsDTO);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<EmailAwsDTO> violation : violations) {
                sb.append(violation.getMessage()).append(", ");
            }
            throw new IllegalArgumentException("Validation failed: " + sb.toString());
        }
    }
}