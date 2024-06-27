package org.David.factory;

import org.David.model.Product;

public class ProductFactory {
    public static Product createProduct(int productId, String productName, double productPrice){
        return new Product(productId, productName, productPrice);
    }
}
