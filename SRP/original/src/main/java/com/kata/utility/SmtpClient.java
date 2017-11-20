package com.kata.utility;

public class SmtpClient {

    private String host;

    public SmtpClient(String host) {
        this.host = host;
    }

    public void send(MailMessage message) {
        System.out.println(message.getSubject() +
            " \n to : " + message.getRecipient() +
            " \n through : " + this.host +
            " \n message content is : \n" + message.getBody());
    }
}
