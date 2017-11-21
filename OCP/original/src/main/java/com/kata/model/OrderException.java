package com.kata.model;

public class OrderException extends Exception {
    public OrderException(String message, Exception exception) {
        super(message, exception);
    }
}
