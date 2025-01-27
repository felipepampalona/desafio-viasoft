package com.viasoft.desafio.validator;

import com.viasoft.desafio.dto.EmailOciDTO;
import com.viasoft.desafio.fixture.EmaiFixture;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmailOciValidatorTest {

    @Mock
    private Validator validator;

    @InjectMocks
    private EmailOciValidator emailOciValidator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        emailOciValidator = new EmailOciValidator();
    }

    @Test
    public void testValidateValidEmail() {
        EmailOciDTO emailOciDTO = EmaiFixture.emailOciDTOValido;

        assertDoesNotThrow(() -> emailOciValidator.validate(emailOciDTO));
    }

    @Test
    public void testValidateInvalidEmail() {
        EmailOciDTO emailOciDTO = EmaiFixture.emailOciDTOInvalido;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> emailOciValidator.validate(emailOciDTO));
        assertTrue(exception.getMessage().contains("Validation failed: E-mail destinatário inválido"));
    }

    @Test
    public void testValidateEmptyFields() {
        EmailOciDTO emailOciDTO = EmaiFixture.emailOciDTOInvalido;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> emailOciValidator.validate(emailOciDTO));
        assertTrue(exception.getMessage().contains("Validation failed"));
    }
}
