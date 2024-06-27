package org.David;

import org.David.service.Impl.CartServiceImpl;
import org.David.service.Impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        shop.viewProducts();
        shop.searchProductByName("106");

        cart.selectItem(24105, 2,shop.getProducts() );
        cart.selectItem(24106, 3,shop.getProducts() );
        cart.viewCart();

//        do {
//            isValid = false;
//
//            while (!isValid) {
//                System.out.println("Mini-Project 3: E-commerce Cart System");
//                System.out.print("[1] View Products \n[2] View Cart \n[3] Search Products\n[4] Add an Item to the Cart " +
//                        "\n[5] Remove an Item from the Cart \nType [Exit] to Exit the Program \nChoice: ");
//                try {
//                    userInput = scan.nextLine().trim();
//
//                    if ( userInput.isEmpty()){
//                        throw new InputMismatchException("Invalid input, choice cannot be empty");
//                    }
//                    if (
//                            !userInput.equalsIgnoreCase("exit")  && !userInput.equalsIgnoreCase("1") &&
//                                    !userInput.equalsIgnoreCase("2")  && !userInput.equalsIgnoreCase("3")  &&
//                                    !userInput.equalsIgnoreCase("4") && !userInput.equalsIgnoreCase("5")
//                    ) {
//                        throw new InputMismatchException("Invalid input, choose among the choices only");
//                    }
//
//                    isValid = true;
//
//                } catch (InputMismatchException e) {
//                    log.warn("User input is invalid: {}", userInput);
//                    System.out.println(e.getMessage());
//                    scan.nextLine();
//                }
//            }

//            switch(userInput){
//                case "1":
//                    System.out.println();
//                    shop.viewProducts();
//                    System.out.println();
//                    break;
//                case "2":
//                    System.out.println();
//                    cart.viewCart();
//                    System.out.print("Search for an Item: ");
//                    isValid = false;
//                    while(!isValid) {
//                        try {
//                            userInput = scan.nextLine().trim();
//                            if (userInput.isEmpty()) {
//                                throw new InputMismatchException("Provide an input to search for");
//                            }
//
//                            isValid = true;
//                        } catch (Exception e) {
//                            log.info("User searched for an invalid item: {}", userInput);
//                            System.out.println(e.getMessage());
//                        }
//                    }
//                    System.out.println();
//                case "3":
//                    System.out.println();
//
//                    break;
//                case "4":
//
//                    break;
//                case "5":
//
//                    break;
//                case "exit":
//                    log.info("User chose to close the program");
//                    System.out.println("Application is closing...");
//                    scan.close();
//                    System.exit(0);
//                    break;
//            }

//        }while(true);
    }


}