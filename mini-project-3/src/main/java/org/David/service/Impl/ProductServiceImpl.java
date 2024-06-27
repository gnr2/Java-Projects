package org.David.service.Impl;

import lombok.Getter;
import lombok.Setter;
import org.David.factory.ProductFactory;
import org.David.model.Product;
import org.David.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Getter @Setter
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ArrayList<Product> products;
    private static ProductServiceImpl instance;

    private ProductServiceImpl(){
        products = new ArrayList<>();
        initializeProducts();
    }

    public static synchronized ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    @Override
    public void initializeProducts() {
        products.add(ProductFactory.createProduct(24101, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(24102, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(24103, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(24104, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(24105, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(24106, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(24107, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(24108, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(24109, "Dell Laptop", 499));
        products.add(ProductFactory.createProduct(241010, "Dell Laptop", 499));
    }

    @Override
    public void viewProducts(){
        log.info("User is viewing list of Products");
        System.out.println("Products:");
        ProductServiceImpl products = ProductServiceImpl.getInstance();
        for (Product product : products.getProducts()){
            System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getProductPrice());
        }
    }

    @Override
    public void printSearchResults(ArrayList <Product> searchResults){
        for(Product product : searchResults)
            System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getProductPrice());
    }

    public ArrayList<Product> searchProductByName(String searchKeyword){
        log.info("User is searching for product with keyword \"{}\"", searchKeyword);
        ProductServiceImpl products = ProductServiceImpl.getInstance();
        ArrayList <Product> searchResults = new ArrayList<>();
        int productCounter = 0;

        for (Product product : products.getProducts()){
            if (product.getProductName().toLowerCase().contains(searchKeyword.toLowerCase())){
                productCounter ++;
                searchResults.add(product);
            } else if (Integer.toString(product.getProductId()).contains(searchKeyword)){
                searchResults.add(product);
                productCounter ++;
            }
        }

        if(productCounter == 0){
            log.warn("Product name with keyword \"{}\" does not exist", searchKeyword);
            System.out.println("Product does not exist");
        }

        return searchResults;


    }



}
