package com.viasoft.desafio.validator;

import com.viasoft.desafio.dto.EmailOciDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EmailOciValidator implements EmailValidator<EmailOciDTO>{

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Override
    public void validate(EmailOciDTO emailOciDTO) {
        Set<ConstraintViolation<EmailOciDTO>> violations = validator.validate(emailOciDTO);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<EmailOciDTO> violation : violations) {
                sb.append(violation.getMessage()).append(", ");
            }
            throw new IllegalArgumentException("Validation failed: " + sb.toString());
        }
    }
}
