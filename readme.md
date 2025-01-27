# Desafio Back-end Viasoft

##  Objetivo

Desenvolver uma aplicação REST com um endpoint que receba dados para envio de e-mails. Sem alterar o objeto de entrada, a aplicação deve adaptá-lo para diferentes classes de envio, com base em configurações definidas no arquivo application.properties. O objeto deve ser serializado e exibido no console, simulando o envio de e-mails por plataformas como AWS ou OCI.

## Tecnologias utilizadas
- **Java 17**
- **Spring Boot**
- **Maven**

## Configuração
As configurações para envio de e-mail podem ser alteradas na variavel de ambiente: mailPlatform, podendo ser: OCI ou AWS.

## endpoint

```http
  POST /emails/send
```

```json
{
   "emailDestinario": "luiz@gmail.com",
   "nomeDestinatario": "Luiz felipe",
   "remetente": "LuizFelipe@mail.com",
   "assunto": "novo E-mail",
   "conteudo": "conteudo do email"
}
```


