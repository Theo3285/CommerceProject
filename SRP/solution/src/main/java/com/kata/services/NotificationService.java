package com.kata.services;

import com.kata.model.Cart;
import com.kata.utility.MailMessage;
import com.kata.utility.SmtpClient;

import java.time.LocalDateTime;

public class NotificationService implements Notifier {
    private Cart cart;

    public NotificationService(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void toCustomer() {
        String customerEmail = cart.getCustomerEmail();
        if (!"".equals(customerEmail)) {
            MailMessage message = new MailMessage("orders@somewhere.com", customerEmail);
            SmtpClient client = new SmtpClient("localhost");

            message.setSubject("Your order placed on " + LocalDateTime.now().toString());
            message.setBody("Your order details: \n " + cart.toString());

            client.send(message);
        }
    }
}