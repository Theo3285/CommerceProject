package com.kata;

import com.kata.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class OrderShould {

    private Cart cart;
    private PaymentDetails paymentDetails;
    private Order onlineOrder;
    private Order pointOfSaleOrder;

    @Before
    public void setUp() {
        List<Cart.OrderItem> orderItems = Arrays.asList(
                new Cart.OrderItem("1234", 1, 10.0),
                new Cart.OrderItem("5678",3, 5.25)
        );
        this.cart = new Cart(orderItems,"firstname.lastname@somewhere.com");
        this.paymentDetails = new PaymentDetails(PaymentDetails.PaymentMethod.CreditCard);
        this.paymentDetails.setCardHolderName("FirstName LASTNAME");
        this.paymentDetails.setCreditCardNumber("1234-5678-9101-1121");
        this.paymentDetails.setExpiresMonth("04");
        this.paymentDetails.setExpiresYear("2018");
        this.onlineOrder = new OnlineOrder(this.cart, this.paymentDetails);
        this.pointOfSaleOrder = new PointOfSaleOrder(this.cart, this.paymentDetails);
    }

    @Test
    public void
    checkout_an_online_cart() throws Exception {
        onlineOrder.checkout();
    }

    @Test
    public void
    checkout_point_of_sale_by_credit_card() throws Exception {
        pointOfSaleOrder.checkout();
    }
}
