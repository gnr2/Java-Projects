package org.David.service;

import org.David.model.ProductItem;

import java.util.HashMap;

public interface CartService {

    void viewCart();
    HashMap<ProductItem, Integer> getCart();
    void addItemToCart(ProductItem itemToCart, int quantity);
    void removeItemFromCartByID(ProductItem item);
}
