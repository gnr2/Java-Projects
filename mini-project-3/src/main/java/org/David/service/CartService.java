package org.David.service;

import org.David.model.ProductItem;

import java.util.ArrayList;

public interface CartService {

    void viewCart();
    void addItemToCart(ProductItem itemToCart, int quantity);
    void removeItemToCartByID(ProductItem item);
}
