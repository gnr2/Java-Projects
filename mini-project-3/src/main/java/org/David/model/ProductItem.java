package org.David.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductItem {
    private int productId;
    private String productName;
    private double productPrice;

    public ProductItem(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

}
