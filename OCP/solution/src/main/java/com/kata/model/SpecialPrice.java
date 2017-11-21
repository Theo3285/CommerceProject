package com.kata.model;

class SpecialPrice extends PriceCalculator {
    private final OrderItem orderItem;

    SpecialPrice(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public double calculate() {
        // $0.40 each; 3 for a $1.00
        double total = 0.0;
        total += orderItem.getQuantity() * 0.4;
        int setOfThree = orderItem.getQuantity() / 3;
        total -= setOfThree * 0.2;
        return total;
    }
}
