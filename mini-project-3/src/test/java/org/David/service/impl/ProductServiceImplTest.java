package org.David.service.impl;

import org.David.model.Product;
import org.David.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private List<Product> products;
    private static ProductServiceImpl instance;

    private ProductServiceImpl() {
        products = new ArrayList<>();
        initializeProducts();
    }

    public static synchronized ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    private void initializeProducts() {
        products.add(new Product(1, "Dell Laptop", 999.99));
        products.add(new Product(2, "HP Laptop", 899.99));
        // Add more products as needed
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void viewProducts() {
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getProductPrice());
        }
    }

    @Override
    public Product searchProductByName(String searchKeyword) {
        Optional<Product> product = products.stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(searchKeyword))
                .findFirst();
        return product.orElse(null);
    }
}
