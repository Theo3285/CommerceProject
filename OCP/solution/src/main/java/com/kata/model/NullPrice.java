package com.kata.model;

class NullPrice extends PriceCalculator {

    @Override
    public double calculate() {
        return 0;
    }
}
