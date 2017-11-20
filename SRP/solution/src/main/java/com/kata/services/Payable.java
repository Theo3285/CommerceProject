package com.kata.services;

import com.kata.model.OrderException;

public interface Payable {
    void chargeCreditCard() throws OrderException;
}
