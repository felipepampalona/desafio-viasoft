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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailAwsDTO {

    @Size(max = 45, message = "E-mail destinatário deve conter no maximo 45 caracteres")
    @Email(message = "E-mail destinatário inválido")
    private String recipient;
    @Size(max = 60, message = "Nome destinatário deve conter no maximo 60 caracteres")
    private String recipientName;
    @Size(max = 45, message = "E-mail remetente deve conter no maximo 45 caracteres")
    @Email(message = "E-mail remetente inválido")
    private String sender;
    @Size(max = 120, message = "Assunto do e-mail deve conter no maximo 120 caracteres")
    private String subject;
    @Size(max = 256, message = "Conteúdo do e-mail deve conter no maximo 256 caracteres")
    private String content;


}
