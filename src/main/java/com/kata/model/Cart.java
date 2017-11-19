package com.kata.model;

import java.util.List;

/*
 *
 */
public class Cart {

    private final List<OrderItem> orderItems;
    private final String customerEmail;
    private double totalAmount;

    public Cart(List<OrderItem> orderItems, String customerEmail) {
        this.orderItems = orderItems;
        this.customerEmail = customerEmail;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public double getTotalAmount() {
        return calculateTotalAmount();
    }

    public double calculateTotalAmount() {
        this.totalAmount = 0.0;
        for (OrderItem orderItem : orderItems) {
            this.totalAmount += orderItem.getAmount() * orderItem.getQuantity();
        }
        return this.totalAmount;
    }

    @Override
    public String toString() {
        StringBuilder cartDetails = new StringBuilder();
        cartDetails.append("Cart{");
        for (OrderItem orderItem : orderItems
             ) {
            cartDetails.append("Sku='" + orderItem.getSku() +
                    "', Quantity=" + orderItem.getQuantity() +
                    ", Amount=" + orderItem.getAmount() +
                    ", ");
        }
        cartDetails.append("customerEmail='" + customerEmail + '\'' +
                ", totalAmount=" + totalAmount +
                "}");
        return cartDetails.toString();
    }

    public static class OrderItem {

        private final String sku;
        private final int quantity;
        private final double amount;

        public OrderItem(String sku, int quantity, double amount) {
            this.sku = sku;
            this.quantity = quantity;
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        public String getSku() {
            return sku;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}

