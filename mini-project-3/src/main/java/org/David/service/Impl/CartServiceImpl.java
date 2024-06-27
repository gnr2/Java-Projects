package org.David.service.Impl;

import java.util.ArrayList;

import org.David.model.CartItem;
import org.David.model.Product;
import org.David.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartServiceImpl implements CartService{
    private static final Logger log = LoggerFactory.getLogger(CartServiceImpl.class);
    private  ArrayList <CartItem> cart;
    private static CartServiceImpl instance;

    private CartServiceImpl(){
        cart = new ArrayList<>();
    }

    public static synchronized CartServiceImpl getInstance(){
        if (instance == null){
            instance = new CartServiceImpl();
        }
        return instance;
    }

    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    @Override
    public void viewCart(){
        int totalPrice = 0;
        log.info("User viewed items in cart");
        System.out.println("Items in Cart:");
        for (CartItem item : cart){
            System.out.println(item.getQuantity() + " - " + item.getProduct().getProductName() + " " + item.getProduct().getProductPrice() * item.getQuantity());
            totalPrice += (item.getProduct().getProductPrice() * (double)item.getQuantity());
        }

        if (totalPrice != 0) {
            System.out.println("Total Balance: " + totalPrice);
        }
        if (cart.isEmpty()){
            log.info("Nothing to display, cart is currently empty");
            System.out.println("Your cart is currently empty");
        }
    }

    @Override
    public void addItemToCart(Product itemToCart, int quantity){
        CartServiceImpl cart = CartServiceImpl.getInstance();
        boolean itemIsInList = false;

        for(CartItem item : cart.getCart()){
            if (itemToCart.getProductId() == item.getProduct().getProductId()){
                item.setQuantity(item.getQuantity() + quantity);
                itemIsInList = true;
                break;
            }
        }
        if(!itemIsInList) {
            CartItem item = new CartItem(itemToCart, quantity);
            cart.getCart().add(item);
        }

    }

    // add quantity only if item is already in cart
    @Override
    public void selectItem(int productId, int quantity, ArrayList<Product> itemOptions){
        int iteratorCounter = 0;
        for(Product product : itemOptions){
            if (productId == product.getProductId()){
                log.info("User is attempting to add item with id \"{}\" and a quantity of \"{}\"", productId, quantity);
                addItemToCart(product, quantity);
                log.info("Product {} with ID {} is added to cart", product.getProductName(), product.getProductId());
                System.out.println("Item has been added succesfully to cart");
                iteratorCounter ++;
                break;
            }
        }

        if (iteratorCounter == 0){
            log.warn("Failed to add Item. Item with id \"{}\" does not exist", productId);
            System.out.println("Product does not exist");
        }


    }

    @Override
    public void removeItemToCartByID(int id){
        CartServiceImpl cart = CartServiceImpl.getInstance();
        cart.getCart().removeIf(cartItem -> (cartItem.getProduct().getProductId() == id));
    }

}
