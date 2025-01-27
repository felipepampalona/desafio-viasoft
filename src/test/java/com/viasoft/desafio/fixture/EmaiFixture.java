package com.viasoft.desafio.fixture;

import com.viasoft.desafio.dto.EmailAwsDTO;
import com.viasoft.desafio.dto.EmailDTO;
import com.viasoft.desafio.dto.EmailOciDTO;

public class EmaiFixture {

    public static final EmailOciDTO emailOciDTOValido = EmailOciDTO.builder()
            .recipientEmail("luizfelipe@gmail.com")
            .recipientName("Luiz Felipe")
            .senderEmail("felipe@gmail.com")
            .subject("titulo do email")
            .body("corpo do email")
            .build();

    public static final EmailOciDTO emailOciDTOInvalido = EmailOciDTO.builder()
            .recipientEmail("luizfelipegmail.com")
            .recipientName("Luiz Felipe")
            .senderEmail("felipe@gmail.com")
            .subject("assunto do email")
            .body("corpo do email")
            .build();

    public static final EmailAwsDTO emailAwsDTOValido = EmailAwsDTO.builder()
            .recipient("luizfelipe@gmail.com")
            .recipientName("luiz felipe")
            .subject("felipe@gmail.com")
            .subject("assunto do email")
            .content("corpo do email")
            .build();

    public static final EmailAwsDTO emailAwsDTOInvalido = EmailAwsDTO.builder()
            .recipient("luizfelipegmail.com")
            .recipientName("luiz felipe")
            .sender("felipegmail.com")
            .subject("assunto do email")
            .content("conteudo aqui")
            .build();

    public static final EmailDTO emailDTOValido = EmailDTO.builder()
            .emailDestinario("luizfelipe@gmail.com")
            .nomeDestinatario("Luiz Felipe")
            .emailDestinario("felipe@gmail.com")
            .assunto("assunto do email")
            .conteudo("conteudo do email")
            .build();

    public static final EmailDTO emailDTOInvalido = EmailDTO.builder()
            .emailDestinario("luizfelipegmail.com")
            .nomeDestinatario("luiz Felipe")
            .emailDestinario("felipe@gmail.com")
            .assunto("assunto do email")
            .conteudo("conteudo do email")
            .build();
}
