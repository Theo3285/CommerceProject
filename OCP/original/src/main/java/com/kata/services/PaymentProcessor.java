package com.kata.services;

import com.kata.model.Cart;
import com.kata.model.OrderException;
import com.kata.model.PaymentDetails;
import com.kata.services.PaymentGateway;

public class PaymentProcessor implements Payable {
    private Cart cart;
    private PaymentDetails paymentDetails;

    public PaymentProcessor(Cart cart, PaymentDetails paymentDetails) {
        this.cart = cart;
        this.paymentDetails = paymentDetails;
    }

    @Override
    public void chargeCreditCard() throws OrderException {
        PaymentGateway paymentGateway = new PaymentGateway();
        try {
            paymentGateway.setCredentials("account credentials");
            paymentGateway.setCardNumber(paymentDetails.getCreditCardNumber());
            paymentGateway.setExpiresMonth(paymentDetails.getExpiresMonth());
            paymentGateway.setExpiresYear(paymentDetails.getExpiresYear());
            paymentGateway.setNameOnCard(paymentDetails.getCardHolderName());
            paymentGateway.setAmountToCharge(cart.totalAmount());

            paymentGateway.charge();

        } catch (PaymentGateway.AvsMismatchException ex) {
            throw new OrderException("The card gateway rejected the card based on the address provided.", ex);
        } catch (Exception ex) {
            throw new OrderException("There was a problem with your card.", ex);
        }
    }
}