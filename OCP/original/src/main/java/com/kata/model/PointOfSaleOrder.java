package com.kata.model;

import com.kata.services.Payable;
import com.kata.services.PaymentProcessor;

public class PointOfSaleOrder extends Order {

    private final PaymentDetails paymentDetails;
    private final Payable payable;

    public PointOfSaleOrder(Cart cart, PaymentDetails paymentDetails) {
        super(cart);
        this.paymentDetails = paymentDetails;
        payable = new PaymentProcessor(cart, paymentDetails);
    }

    @Override
    public void checkout() throws OrderException {
        payable.chargeCreditCard();
    }
}
