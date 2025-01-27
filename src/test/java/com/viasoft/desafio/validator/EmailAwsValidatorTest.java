package com.viasoft.desafio.validator;

import com.viasoft.desafio.dto.EmailAwsDTO;
import com.viasoft.desafio.fixture.EmaiFixture;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmailAwsValidatorTest {

    @Mock
    private Validator validator;

    @InjectMocks
    private EmailAwsValidator emailAwsValidator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        emailAwsValidator = new EmailAwsValidator();
    }

    @Test
    public void testValidateValidEmail() {
        EmailAwsDTO emailAwsDTO = EmaiFixture.emailAwsDTOValido;

        assertDoesNotThrow(() -> emailAwsValidator.validate(emailAwsDTO));
    }

    @Test
    public void testValidateInvalidEmail() {
        EmailAwsDTO emailAwsDTO = EmaiFixture.emailAwsDTOInvalido;

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> emailAwsValidator.validate(emailAwsDTO));
        assertTrue(exception.getMessage().contains("Validation failed"));
    }

    @Test
    public void testValidateEmptyFields() {
        EmailAwsDTO emailAwsDTO = EmaiFixture.emailAwsDTOInvalido;

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> emailAwsValidator.validate(emailAwsDTO));
        assertTrue(exception.getMessage().contains("Validation failed"));
    }
}