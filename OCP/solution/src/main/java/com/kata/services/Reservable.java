package com.kata.services;

import com.kata.model.OrderException;

public interface Reservable {
    void againstInventory() throws OrderException;
}
