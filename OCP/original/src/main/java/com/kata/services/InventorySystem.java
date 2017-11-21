package com.kata.services;

/*
 * Inventoy system used when purchase items online
 */
public class InventorySystem {

    public void reserve (String sku, int quantity) throws InsufficientInventoryException{
        //Throw an exception when the stock of reserved items is empty
        //Remove one item from the inventory otherwise
        //throw new InsufficientInventoryException();
    }

    public class InsufficientInventoryException extends Exception {

    }
}
