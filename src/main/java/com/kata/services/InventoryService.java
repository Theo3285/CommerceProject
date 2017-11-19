package com.kata.services;

import com.kata.model.Cart;
import com.kata.model.OrderException;

public class InventoryService implements Reservable {
    private Cart cart;

    public InventoryService(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void againstInventory() throws OrderException {
        for (Cart.OrderItem orderItem : cart.getOrderItems()) {
            try {

                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.reserve(orderItem.getSku(), orderItem.getQuantity());

            } catch (InventorySystem.InsufficientInventoryException iie) {
                throw new OrderException("Insuficient Inventory for item : " + orderItem.getSku(), iie);
            } catch (Exception ex) {
                throw new OrderException("Problem reserving inventory", ex);
            }
        }
    }
}