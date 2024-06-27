package org.David.service;

import org.David.model.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> searchProductByName(String searchKeyword);
    ArrayList<Product> getProducts();
    void initializeProducts();
    void viewProducts();
    void printSearchResults(ArrayList<Product> searchResults);
}
