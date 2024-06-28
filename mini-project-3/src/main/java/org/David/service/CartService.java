package org.David.service;

import org.David.model.ProductItem;

public interface CartService {

    void viewCart();
    void addItemToCart(ProductItem itemToCart, int quantity);
    void removeItemFromCartByID(ProductItem item);
}
