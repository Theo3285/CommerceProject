package com.kata.model;

import com.kata.services.InventorySystem;
import com.kata.services.PaymentGateway;
import com.kata.utility.MailMessage;
import com.kata.utility.SmtpClient;

import java.time.LocalDateTime;

/*
 * The order class is used through a web site to checkout a cart of items.
 * If the payment method is by credit card, then the payment details are sent to a payment system through
 * a payment gateway.
 * The cart is then sent to an inventory system to reserve the item
 * Finally, if the Customer requested it, he will be notified by email of his order
 * The system is not only used through a website but also from a Retail point of Sale where customers can pay by cash
 */
public class Order {

    public void checkout(Cart cart, PaymentDetails paymentDetails, boolean notifyCustomer) throws OrderException {
        if (paymentDetails.getPaymentMethod() == PaymentDetails.PaymentMethod.CreditCard) {
            chargeCard(paymentDetails, cart);
        }

        reserveInventory(cart);

        if (notifyCustomer) {
            notifyCustomer(cart);
        }
    }

    private void notifyCustomer(Cart cart) {
        String customerEmail = cart.getCustomerEmail();
        if (!"".equals(customerEmail)) {
            MailMessage message = new MailMessage("orders@somewhere.com", customerEmail);
            SmtpClient client = new SmtpClient("localhost");

            message.setSubject("Your order placed on " + LocalDateTime.now().toString());
            message.setBody("Your order details: \n " + cart.toString());

            client.send(message);
        }
    }

    private void reserveInventory(Cart cart) throws OrderException {
        for (Cart.OrderItem orderItem : cart.getOrderItems()) {
            try {

                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.reserve(orderItem.getSku(), orderItem.getQuantity());

            } catch (InventorySystem.InsufficientInventoryException iie) {
                throw new OrderException("Insuficient Inventory for item : " + orderItem.getSku(), iie);
            } catch (Exception ex) {
                throw new OrderException("Problem reserving inventory", ex);
            }
        }
    }

    private void chargeCard(PaymentDetails paymentDetails, Cart cart) throws OrderException {
        PaymentGateway paymentGateway = new PaymentGateway();
        try {
            paymentGateway.setCredentials("account credentials");
            paymentGateway.setCardNumber(paymentDetails.getCreditCardNumber());
            paymentGateway.setExpiresMonth(paymentDetails.getExpiresMonth());
            paymentGateway.setExpiresYear(paymentDetails.getExpiresYear());
            paymentGateway.setNameOnCard(paymentDetails.getCardHolderName());
            paymentGateway.setAmountToCharge(cart.getTotalAmount());

            paymentGateway.charge();

        } catch (PaymentGateway.AvsMismatchException ex) {
            throw new OrderException("The card gateway rejected the card based on the address provided.", ex);
        } catch (Exception ex) {
            throw new OrderException("There was a problem with your card.", ex);
        }
    }

    public class OrderException extends Exception {
        public OrderException(String message, Exception exception) {
            super(message, exception);
        }
    }
}
