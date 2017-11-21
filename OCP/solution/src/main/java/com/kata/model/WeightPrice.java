package com.kata.model;

class WeightPrice extends PriceCalculator {
    private final OrderItem orderItem;

    WeightPrice(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public double calculate() {
        // quantity is in grams, price is per kg
        return orderItem.getQuantity() * 4.0/1000;
    }
}
