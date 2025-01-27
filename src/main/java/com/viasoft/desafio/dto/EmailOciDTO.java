package com.viasoft.desafio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailOciDTO {

    @Size(max = 40, message = "E-mail destinatário deve conter no maximo 40 caracteres")
    @Email(message = "E-mail destinatário inválido")
    private String recipientEmail;
    @Size(max = 50, message = "Nome destinário deve conter no maximo 50 caracteres")
    private String recipientName;
    @Size(max = 40, message = "E-mail remetente deve conter no maximo 40 caracteres")
    @Email(message = "E-mail remetente inválido")
    private String senderEmail;
    @Size(max = 100, message = "Assunto do e-mail deve conter no maximo 100 caracteres")
    private String subject;
    @Size(max = 250, message = "Conteúdo do e-mail deve conter no maximo 250 caracteres")
    private String body;

}
