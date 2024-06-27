package org.David.factory;

import org.David.model.ProductItem;

public class ProductFactory {
    public static ProductItem createProduct(int productId, String productName, double productPrice){
        return new ProductItem(productId, productName, productPrice);
    }
}
