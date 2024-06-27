package org.David.service;

import org.David.model.ProductItem;

import java.util.ArrayList;

public interface ProductService {
    void searchProduct(String searchKeyword);
    ArrayList<ProductItem> getProducts();
    void initializeProducts();
    void viewProducts();
    void printSearchResults();
    void viewCart();
    void addItemToCart(int index, int quantity);
    void removeItemToCartByID(int index);

}
