package org.David.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;
import org.David.model.ProductItem;
import org.David.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter @Setter
public class CartServiceImpl implements CartService{
    private static final Logger log = LoggerFactory.getLogger(CartServiceImpl.class);
    private HashMap<ProductItem, Integer> cart = new HashMap<>();
    private static CartServiceImpl instance;

    public static synchronized CartServiceImpl getInstance(){
        if (instance == null){
            instance = new CartServiceImpl();
        }
        return instance;
    }

    public HashMap<ProductItem, Integer> getCart() {
        return cart;
    }

    @Override
    public void viewCart(){
        double totalPrice = 0;
        log.info("User viewed items in cart");
        System.out.println("Items in Cart:");
        int i = 0;
        ProductServiceImpl productService = ProductServiceImpl.getInstance();
        for(var item: cart.keySet()){
            System.out.println();
            System.out.println("Index: " + productService.getProductItems().indexOf(item));
            System.out.println("Product ID: " + item.getProductId());
            System.out.println("Product Name: " + item.getProductName());
            System.out.println("Product Price: " + item.getProductPrice());
            System.out.println("Quantity: " + cart.get(item));
            i ++;
            totalPrice += item.getProductPrice() * cart.get(item);
        }

        if (totalPrice != 0) {
            System.out.println();
            System.out.println("Total Balance: " + totalPrice);
        }
        if (cart.isEmpty()){
            log.info("Nothing to display, cart is currently empty");
            System.out.println("Your cart is currently empty");
        }
    }

    public void addItemToCart(ProductItem item, int quantity){
        cart.put(item, quantity );
    }


    public void removeItemFromCartByID(ProductItem item) {
        cart.remove(item);
    }
}
