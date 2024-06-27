package org.David.service;

import org.David.model.CartItem;
import org.David.model.Product;
import org.David.service.Impl.CartServiceImpl;

import java.util.ArrayList;

public interface CartService {

    ArrayList <CartItem> getCart();
    void viewCart();
    void addItemToCart(Product itemToCart, int quantity);
    void selectItem(int productId, int quantity, ArrayList<Product> itemOptions);
    void removeItemToCartByID(int id);

}
