package com.kata.model;

public abstract class PriceCalculator {

    public static PriceCalculator with(OrderItem orderItem) {
        if (isEach(orderItem)) {
            return new EachPrice(orderItem);
        }
        if (isWeight(orderItem)) {
            return new WeightPrice(orderItem);
        }
        if (isSpecial(orderItem)) {
            return new SpecialPrice(orderItem);
        }
        return new NullPrice();
    }

    private static boolean isEach(OrderItem orderItem) {
        return orderItem.getSku().startsWith("EACH");
    }

    private static boolean isWeight(OrderItem orderItem) {
        return orderItem.getSku().startsWith("WEIGHT");
    }

    private static boolean isSpecial(OrderItem orderItem) {
        return orderItem.getSku().startsWith("SPECIAL");
    }

    public abstract double calculate();
}
