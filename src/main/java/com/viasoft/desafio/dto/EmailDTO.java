package com.viasoft.desafio.dto;

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
public class EmailDTO {

    private String emailDestinario;
    private String nomeDestinatario;
    private String remetente;
    private String assunto;
    private String conteudo;

    public EmailAwsDTO toEmailAwsDTO(EmailDTO emailDTO) {
        return EmailAwsDTO.builder()
                .recipient(emailDTO.getEmailDestinario())
                .recipientName(emailDTO.getNomeDestinatario())
                .sender(emailDTO.getRemetente())
                .subject(emailDTO.getAssunto())
                .content(emailDTO.getConteudo())
                .build();
    }

    public EmailOciDTO toEmailOciDTO(EmailDTO emailDTO) {
        return EmailOciDTO.builder()
                .recipientEmail(emailDTO.getEmailDestinario())
                .recipientName(emailDTO.getNomeDestinatario())
                .senderEmail(emailDTO.getRemetente())
                .subject(emailDTO.getAssunto())
                .body(emailDTO.getConteudo())
                .build();
    }

}
