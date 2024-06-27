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

//        shop.viewProducts();
//        shop.searchProduct("106");
//
//        shop.viewCart();
//        shop.addItemToCart(0,1);
//        shop.addItemToCart(1,2);
//        shop.addItemToCart(2,3);
//        shop.viewCart();
//        shop.addItemToCart(0, 10);
//        shop.viewCart();
//        shop.searchProduct("24105");
//        shop.printSearchResults();
//        shop.removeItemToCartByID(1);
//        shop.viewCart();

        do {
            isValid = false;

            while (!isValid) {
                System.out.println("Mini-Project 3: E-commerce Cart System");
                System.out.print("[1] View Products \n[2] View Cart \n[3] Search Products\n[4] Add an Item to the Cart " +
                        "\n[5] Remove an Item from the Cart \nType [Exit] to Exit the Program \nChoice: ");
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
                case "1":
                    System.out.println();
                    shop.viewProducts();
                    System.out.println();
                    scan.nextLine();
                    break;
                case "2":
                    System.out.println();
                    shop.viewCart();
                    System.out.println();
                    scan.nextLine();
                    break;
                case "3":
                    System.out.println();
                    isValid = false;
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
                    shop.searchProduct(userInput);
                    shop.printSearchResults();
                    System.out.println();
                    scan.nextLine();
                    break;
                case "4":
                    int quantity = 0;
                    isValid = false;
                    System.out.println();
                    shop.viewProducts();
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
                    shop.addItemToCart(index, quantity);
                    scan.nextLine();
                    break;
                case "5":
                    System.out.println();
                    shop.viewCart();
                    isValid = false;
                    while(!isValid) {
                        try {
                            System.out.print("Choose the index of item to be removed: ");
                            if (scan.hasNextInt()) {
                                index = scan.nextInt();
                            } else {
                                throw new InputMismatchException(" ");
                            }

                            isValid = true;
                            scan.nextLine();
                        } catch (InputMismatchException e) {
                            log.info("Item does not exist: {}", userInput);
                            System.out.println(e.getMessage());
                            scan.nextLine();
                        }

                        shop.removeItemToCartByID(index);
                        System.out.println();
                    }
                    break;
                case "exit":
                    log.info("User chose to close the program");
                    System.out.println("Application is closing...");
                    scan.close();
                    System.exit(0);
                    break;
            }

        }while(true);
    }


}