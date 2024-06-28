package org.David;

import org.David.model.ProductItem;
import org.David.service.Impl.CartServiceImpl;
import org.David.service.Impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Create a simple e-commerce cart system that allows users to add items to a cart, view the cart, and calculate the total price.

/*
Create Product and Cart classes. ✔️
Implement methods to add products to the cart and calculate the total price. ✔️
Use collections like lists to manage the cart items.
Handle potential exceptions.
 */

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main (String [] args){
        log.info("Application starts");
        ProductServiceImpl shop = ProductServiceImpl.getInstance();
        CartServiceImpl cart = CartServiceImpl.getInstance();
        Scanner scan = new Scanner(System.in);
        String userInput = null;
        boolean isValid;
        int index = 0;

        do {
            isValid = false;

            // User input validation for choice of operation
            while (!isValid) {
                System.out.print("""
                        Mini-Project 3: E-commerce Cart System
                        [1] View Products 
                        [2] View Cart 
                        [3] Search Products
                        [4] Add an Item to the Cart 
                        [5] Remove an Item from the Cart
                        Type [Exit] to Exit the Program
                        
                        Choice: """);
                try {
                    userInput = scan.nextLine().trim();

                    if ( userInput.isEmpty()){
                        throw new InputMismatchException("Invalid input, choice cannot be empty");
                    }
                    if (
                            !userInput.equalsIgnoreCase("exit")  && !userInput.equalsIgnoreCase("1") &&
                                    !userInput.equalsIgnoreCase("2")  && !userInput.equalsIgnoreCase("3")  &&
                                    !userInput.equalsIgnoreCase("4") && !userInput.equalsIgnoreCase("5")
                    ) {
                        throw new InputMismatchException("Invalid input, choose among the choices only");
                    }

                    isValid = true;

                } catch (InputMismatchException e) {
                    log.warn("User input is invalid: {}", userInput);
                    System.out.println(e.getMessage());
                    scan.nextLine();
                }
            }



            switch(userInput){

                case "1": // Case for viewing products in shop
                    shop.doViewProducts();
                    break;
                case "2": // Case for viewing user items in cart
                    shop.doViewCart();
                    break;
                case "3": // Case to search for a product in shop
                    shop.doSearchProduct();
                    break;
                case "4": // Case to add an item to cart
                    shop.doAddItemToCart();
                    break;
                case "5": // Case to remove an item from the cart
                    shop.doRemoveItemFromCart();
                    break;
                case "exit":
                    shop.systemExit();
                    break;
            }

        }while(true);
    }


}