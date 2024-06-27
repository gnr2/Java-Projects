package org.David.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private int productId;
    private String productName;
    private double productPrice;

    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

}
