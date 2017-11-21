package com.kata;

import com.kata.model.Cart;
import com.kata.model.OrderItem;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CartTotalAmountShouldReturn {

    Cart cart;

    @Before
    public void setUp() {
        this.cart = new Cart();
    }

    @Test
    public void fiveWithOneEachItem() {
        cart.add(new OrderItem("EACH_WIDGET",1));
        assertThat(cart.totalAmount(), is(5.0));
    }

    @Test
    public void twoWithHalfKiloWeightItem() {
        cart.add(new OrderItem("WEIGHT_PEANUTS",500));
        assertThat(cart.totalAmount(), is(2.0));
    }

    @Test
    public void eightyCentsWithTwoSpecialItem() {
        cart.add(new OrderItem("SPECIAL_CANDYBAR",2));
        assertThat(cart.totalAmount(), is(0.80));
    }
}
