package com.company.objects.shopping_cart;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ShoppingCartUnitTests {

    Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itemAdded() {
        Assertions.assertTrue(cart.items.contains(new Item("Pepsi", 1.99)));
    }

    @Test
    public void skipsDuplicate() {
        Assertions.assertFalse(cart.add(new Item("Crush", 1.99)));
    }

    @Test
    public void removedItem() {
        Assertions.assertTrue(cart.items.remove(new Item("Crush", 1.99)));
    }

    @Test
    public void subtotalIsValid() {
        Assertions.assertEquals(3.98, cart.getSubtotal());
    }

    @Test
    public void taxIsValid() {
        Assertions.assertEquals(0.52, cart.getTax());
    }

    @Test
    public void totalIsValid() {
        Assertions.assertEquals(4.50, cart.getTotal());
    }

    @Test(expected = IllegalStateException.class)
    public void invalidRemoveState() {
        cart.remove("Pepsi");
        cart.remove("Crush");
        cart.remove("Crush");
    }

    @Test(expected = IllegalStateException.class)
    public void invalidCheckoutState(){
        cart.remove("Pepsi");
        cart.remove("Crush");
        cart.checkOut();
    }
}
