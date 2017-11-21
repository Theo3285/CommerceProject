package com.kata.model;

import com.kata.services.*;

/*
 * The order class is used through a web site to checkout a cart of items.
 * If the payment method is by credit card, then the payment details are sent to a payment system through
 * a payment gateway.
 * The cart is then sent to an inventory system to reserve the item
 * Finally, if the Customer requested it, he will be notified by email of his order
 * The system is not only used through a website but also from a Retail point of Sale where customers can pay by cash
 */
public class OnlineOrder extends Order {

    private final Notifier notifier;
    private final Reservable reservable;
    private final Payable payable;

    public OnlineOrder(Cart cart, PaymentDetails paymentDetails) {
        super(cart);
        notifier = new NotificationService(cart);
        reservable = new InventoryService(cart);
        payable = new PaymentProcessor(cart, paymentDetails);
    }

    @Override
    public void checkout() throws OrderException {
        payable.chargeCreditCard();
        reservable.againstInventory();
        notifier.toCustomer();
    }
}
