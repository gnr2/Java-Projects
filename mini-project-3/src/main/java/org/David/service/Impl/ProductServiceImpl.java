package org.David.service.Impl;

import lombok.Getter;
import lombok.Setter;
import org.David.factory.ProductFactory;
import org.David.model.ProductItem;
import org.David.service.CartService;
import org.David.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;

@Getter @Setter
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ArrayList<ProductItem> productItems;
    private static ProductServiceImpl instance;
    private ArrayList<ProductItem> searchResults;
    private CartService cart;

    private ProductServiceImpl(){
        productItems = new ArrayList<>();
        initializeProducts();
        cart = CartServiceImpl.getInstance();
    }

    public static synchronized ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public ArrayList<ProductItem> getProducts(){
        return productItems;
    }

    @Override
    public void initializeProducts() {
        productItems.add(ProductFactory.createProduct(24101, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(24102, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(24103, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(24104, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(24105, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(24106, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(24107, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(24108, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(24109, "Dell Laptop", 499));
        productItems.add(ProductFactory.createProduct(241010, "Dell Laptop", 499));
    }

    @Override
    public void viewProducts(){
        log.info("User is viewing list of Products");
        System.out.println("Products:");
        for (ProductItem productItem : productItems){
            System.out.println(productItem.getProductId() + " " + productItem.getProductName() + " " + productItem.getProductPrice());
        }
    }

    @Override
    public void printSearchResults(){
        log.info("Printing product search results");
        for(ProductItem productItem : searchResults)
            System.out.println(productItem.getProductId() + " " + productItem.getProductName() + " " + productItem.getProductPrice());
    }

    @Override
    public void searchProduct(String searchKeyword){
        log.info("User is searching for product with keyword \"{}\"", searchKeyword);
        ProductServiceImpl products = ProductServiceImpl.getInstance();
        ArrayList <ProductItem> searchResults = new ArrayList<>();
        int productCounter = 0;

        for (ProductItem productItem : products.getProducts()){
            if (productItem.getProductName().toLowerCase().contains(searchKeyword.toLowerCase())){
                productCounter ++;
                searchResults.add(productItem);
            } else if (Integer.toString(productItem.getProductId()).contains(searchKeyword)){
                searchResults.add(productItem);
                productCounter ++;
            }
        }

        if(productCounter == 0){
            log.warn("Product name with keyword \"{}\" does not exist", searchKeyword);
            System.out.println("Product does not exist");
        }

        this.searchResults = searchResults;
    }

    public void viewCart(){
        cart.viewCart();
    }

    public void addItemToCart(int index, int quantity) throws IndexOutOfBoundsException {
        for (ProductItem item : productItems) {
            if (index > productItems.size() - 1 || index < 0) {
                log.warn("Cannot add item with index {}, Item does not exist", index);
                throw new IndexOutOfBoundsException("Product does not exist");
            } else  {
                cart.addItemToCart(productItems.get(index), quantity);
                log.info("Item {} with Id {} has been successfully added to the cart", item.getProductName(), item.getProductId());
                break;
            }
        }
        cart.addItemToCart(productItems.get(index), quantity);
    }

    public void removeItemToCartByID(int index){
        //log.info("User is attempting to remove Product {} with ID of {}", productItems.getProductItem().getProductName(), productItems.getProductItem()..getProductId());
        cart.removeItemToCartByID(productItems.get(index));
        System.out.println("Item removed");
    }



}
