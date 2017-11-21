package com.kata.model;

class EachPrice extends PriceCalculator {
    private final OrderItem orderItem;

    EachPrice(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public double calculate() {
        return orderItem.getQuantity() * 5.0;
    }
}
