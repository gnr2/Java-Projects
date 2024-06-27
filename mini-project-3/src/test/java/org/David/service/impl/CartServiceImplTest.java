package org.David.service.impl;

import org.David.model.CartItem;
import org.David.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceImplTest {

    private CartServiceImpl cartService;

    @BeforeEach
    void setUp() {
        cartService = CartServiceImpl.getInstance();
    }

    @Test
    void testAddItemToCart_NewItem() {
        Product product = new Product(1, "Dell Laptop", 999.99);
        cartService.addItemToCart(product, 2);

        List<CartItem> cart = cartService.getCart();
        assertEquals(1, cart.size());
        assertEquals(2, cart.get(0).getQuantity());
    }

    @Test
    void testAddItemToCart_ExistingItem() {
        Product product = new Product(1, "Dell Laptop", 999.99);
        cartService.addItemToCart(product, 2);
        cartService.addItemToCart(product, 3);

        List<CartItem> cart = cartService.getCart();
        assertEquals(1, cart.size());
        assertEquals(5, cart.get(0).getQuantity());
    }

    @Test
    void testRemoveItemFromCart() {
        Product product = new Product(1, "Dell Laptop", 999.99);
        cartService.addItemToCart(product, 2);
        cartService.removeItemFromCart(product);

        List<CartItem> cart = cartService.getCart();
        assertTrue(cart.isEmpty());
    }

    @Test
    void testViewCart() {
        Product product1 = new Product(1, "Dell Laptop", 999.99);
        Product product2 = new Product(2, "HP Laptop", 899.99);
        cartService.addItemToCart(product1, 2);
        cartService.addItemToCart(product2, 1);

        cartService.viewCart(); // You can visually inspect the console output to verify
    }
}
