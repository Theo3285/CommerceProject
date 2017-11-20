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
            if (orderItem.getSku().startsWith("EACH")) {
                total += orderItem.getQuantity() * 5.0;
            } else if (orderItem.getSku().startsWith("WEIGHT")) {
                // quantity is in grams, price is per kg
                total += orderItem.getQuantity() * 4.0/1000;
            } else if (orderItem.getSku().startsWith("SPECIAL")) {
                // $0.40 each; 3 for a $1.00
                total += orderItem.getQuantity() * 0.4;
                int setOfThree = orderItem.getQuantity() / 3;
                total -= setOfThree * 0.2;
            }
        }
        return total;
    }

}

