package org.David.service.impl;
import org.David.model.ProductItem;
import org.David.service.Impl.CartServiceImpl;
import org.David.service.Impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CartServiceImplTest {

    private CartServiceImpl cartService;
    private ProductServiceImpl productService;
    ArrayList <ProductItem> items = new ArrayList<>();
    HashMap <ProductItem, Integer>  cart = new HashMap<>();

    @Before
    public void setUp() {
        productService = Mockito.mock(ProductServiceImpl.class);
        cartService = CartServiceImpl.getInstance();
    }

    @Test
    public void testAddProductToCart() {
        ProductItem product = new ProductItem(1, "Product1", 10.0);

        cart.put(product, 1);
        int currentCart = cart.get(product);
        assertEquals(1, currentCart);
    }

    @Test
    public void testRemoveProductFromCart() {
        ProductItem product = new ProductItem(1, "Product1", 10.0);

        cartService.addItemToCart(product, 1);
        cartService.removeItemFromCartByID(product);

        assertEquals(0, cartService.getCart().size());
    }

    @Test
    public void testGetCart() {
        ProductItem product = new ProductItem(1, "Product1", 10.0);

        cartService.addItemToCart(product, 1);
        assertNotNull(cartService.getCart());
    }

}
