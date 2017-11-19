package com.kata.model;

public abstract class Order {
    protected Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }
    abstract public void checkout() throws OrderException;
}
