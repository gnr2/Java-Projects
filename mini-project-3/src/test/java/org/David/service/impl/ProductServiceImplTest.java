package org.David.service.impl;
import org.David.service.Impl.ProductServiceImpl;
import org.David.model.ProductItem;
import org.David.factory.ProductFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProductServiceImplTest {

    ArrayList<ProductItem> items = new ArrayList<>();
    private ProductServiceImpl productService;

    @Before
    public void setUp() {
        productService = ProductServiceImpl.getInstance();
    }

    @Test
    public void testAddProduct() {
        ProductItem product = new ProductItem(1, "Product1", 10.0);
        items.add(product);
        assertEquals(product, items.get(0));
    }

    @Test
    public void testGetProductById() {

        ProductItem product = new ProductItem(1, "Product1", 10.0);
        items.add(product);

        ProductItem fetchedProduct = items.get(0);
        assertNotNull(fetchedProduct);
        assertEquals(1, fetchedProduct.getProductId());
    }

    @Test
    public void testGetAllProducts() {
        ProductItem product1 = new ProductItem(1, "Product1", 10.0);
        ProductItem product2 = new ProductItem(2, "Product2", 15.0);
        items.add(product1);
        items.add(product2);

        assertEquals(2, items.size());
    }

}
