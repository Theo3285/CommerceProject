package com.kata.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<OrderItem> orderItems;
    private String customerEmail;

    public Cart() {
        this.orderItems = new ArrayList<OrderItem>();
    }

    public void add(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public double totalAmount() {
        double total = 0.0;
        for (OrderItem orderItem : orderItems) {
            total += PriceCalculator.with(orderItem).calculate();
        }
        return total;
    }

}

