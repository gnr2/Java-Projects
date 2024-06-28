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
import java.util.Scanner;

@Getter @Setter
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ArrayList<ProductItem> productItems;
    private static ProductServiceImpl instance;
    private ArrayList<ProductItem> searchResults;
    private CartService cart;
    public Scanner scan = new Scanner(System.in);



    public ArrayList<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(ArrayList<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public static void setInstance(ProductServiceImpl instance) {
        ProductServiceImpl.instance = instance;
    }

    public ArrayList<ProductItem> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<ProductItem> searchResults) {
        this.searchResults = searchResults;
    }

    public CartService getCart() {
        return cart;
    }

    public void setCart(CartService cart) {
        this.cart = cart;
    }

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
        int i = 0;
        System.out.println(String.format("%-10s%-10s%-20s%-10s", "Index", "ID", "Product Name", "Product Price"));
        for (ProductItem productItem : productItems){
            System.out.println(String.format("%-10d%-10d%-20s%-10.2f", i, productItem.getProductId(), productItem.getProductName(), productItem.getProductPrice() ));
            i += 1;
        }
    }

    @Override
    public void printSearchResults(){
        log.info("Printing product search results");
        int i =0;
        System.out.println(String.format("%-10s%-10s%-20s%-10s", "Index", "ID", "Product Name", "Product Price"));
        for(ProductItem productItem : searchResults)
            System.out.println(String.format("%-10d%-10d%-20s%-10.2f", i, productItem.getProductId(), productItem.getProductName(), productItem.getProductPrice() ));
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
        cart.removeItemFromCartByID(instance.getProductItems().get(index));
        System.out.println("Item removed");
    }

    public void doViewProducts(){
        Scanner scan = new Scanner(System.in);
        System.out.println();
        instance.viewProducts();
        System.out.println();
        scan.nextLine();
    }

    public void doViewCart(){
        System.out.println();
        instance.viewCart();
        System.out.println();
        scan.nextLine();
    }

    public void doSearchProduct(){
        System.out.println();
        String userInput = null;
        boolean isValid = false;
        while(!isValid) {
            System.out.print("Search for an Item: ");
            try {
                userInput = scan.nextLine().trim();
                if (userInput.isEmpty()) {
                    throw new InputMismatchException("Provide an input to search for");
                }

                isValid = true;
            } catch (Exception e) {
                log.info("User searched for an invalid item: {}", userInput);
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
        instance.searchProduct(userInput);
        instance.printSearchResults();
        System.out.println();
        scan.nextLine();
    }

    public void doAddItemToCart(){
        int quantity = 0;
        boolean isValid = false;
        int index = 0;
        System.out.println();
        instance.viewProducts();
        while(!isValid) {
            try {
                System.out.print("Add an item to the cart (index): ");
                if(scan.hasNextInt()){
                    if (index >= 0)
                        index = scan.nextInt();
                } else {
                    throw new InputMismatchException("");
                }

                System.out.print("Add an item to the cart (quantity): ");
                if(scan.hasNextInt()) {
                    quantity = scan.nextInt();
                    if (quantity <= 0) {
                        throw new InputMismatchException("");
                    }
                }
                isValid = true;
                scan.nextLine();
            } catch (InputMismatchException e){
                log.info("Cannot add the Item with index of {}", index);
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
        instance.addItemToCart(index, quantity);
        scan.nextLine();
    }

    public void doRemoveItemFromCart(){
        System.out.println();
        instance.viewCart();
        boolean isValid = false;
        int index = 0;

        while(!isValid) {
            try {
                System.out.print("Choose the index of item to be removed: ");
                if (scan.hasNextInt()) {
                    index = scan.nextInt();
                } else {
                    throw new InputMismatchException(" ");
                }

                instance.removeItemToCartByID(index);
                isValid = true;
                scan.nextLine();
            } catch (InputMismatchException e) {
                log.info("Item with index [{}] does not exist", index);
                System.out.println(e.getMessage());
                scan.nextLine();
            }


            System.out.println();
        }
    }

    public void systemExit(){
        log.info("User chose to close the program");
        System.out.println("Application is closing...");
        scan.close();
        System.exit(0);
    }


}
