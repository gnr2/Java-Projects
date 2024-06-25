package org.example;
import Classes.Calculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x, y;
        String user_input;
        char choose_operator, restart_option, cont;
        Scanner scan = new Scanner(System.in);
        boolean isValid;

        do {

            // Initialization of variables
            x = 0;
            y = 0;
            user_input = null;
            choose_operator = '\0';
            restart_option = '\0';
            cont = 'Y';
            isValid = false;

            System.out.println("\nWelcome! This is a Calculator App.");

            // Get first number
            while (!isValid) {
                System.out.print("Enter a number: ");
                if (scan.hasNextDouble()) {
                    x = scan.nextDouble();
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scan.next();  // Clear the invalid input
                }
            }

            do{
                isValid = false;

                // Get second number

                while (!isValid) {
                    System.out.print("Enter another number: ");
                    if (scan.hasNextDouble()) {
                        y = scan.nextDouble();
                        isValid = true;
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scan.next();  // Clear the invalid input
                    }
                }

                // Consume the leftover newline
                scan.nextLine();
                isValid = false;

                // Operation selection
                while(!isValid) {
                    System.out.println("\nSelect an operation\n[A] Addition\n[B] Subtraction\n[C] Multiplication\n[D] Division");
                    System.out.print("Choose: ");

                    user_input = scan.nextLine();
                    if (user_input.length() != 1) {
                        System.out.println("Invalid input, select only 1 character.");
                    } else {
                        choose_operator = user_input.toUpperCase().charAt(0);
                        if (choose_operator != 'A' && choose_operator != 'B' && choose_operator != 'C' && choose_operator != 'D'){
                            System.out.println("Choose among the choices only.");
                        }else{
                            isValid = true;
                        }
                    }
                }
                // Switch cases for each opeartion
                switch (choose_operator) {
                    case 'A':
                        // Addition
                        x = Calculator.addNum(x, y);
                        System.out.println("The result is: " + x);
                        break;
                    case 'B':
                        // Subtraction
                        x = Calculator.sbtrctNum(x, y);
                        System.out.println("The result is: " + x);
                        break;
                    case 'C':
                        // Multiplication
                        x = Calculator.mltpyNum(x, y);
                        System.out.println("The result is: " + x);
                        break;
                    case 'D':
                        // Division
                        if (y != 0) {
                            x = Calculator.divideNum(x, y);
                            System.out.println("The result is: " + x);
                        } else {
                            System.out.println("Cannot divide by zero");
                        }
                        break;
                }

                isValid = false;

                // Continue operation with existing value
                System.out.print("\nContinue with the result?[Y/N]: ");

                while(!isValid) {
                    user_input = scan.nextLine();

                    if (user_input.length() != 1) {
                        System.out.print("Invalid input. Y or N only: ");
                    } else {
                        cont = user_input.toUpperCase().charAt(0);
                        if (cont != 'Y' && cont != 'N') {
                            System.out.print("\nInvalid input. Y or N only: ");
                        } else {
                            isValid = true;
                        }
                    }
                }

            } while (cont == 'Y');

            isValid = false;
            // Restart all values
            System.out.print("Do you want to restart?[Y/N]: ");

            while (!isValid){
                user_input = scan.nextLine();
                if (user_input.length() != 1){
                    System.out.print("Invalid input. Y or N only: ");
                } else {
                    restart_option = user_input.toUpperCase().charAt(0);
                    if (restart_option != 'Y' && restart_option != 'N') {
                        System.out.print("Invalid input. Y or N only: ");
                    } else {
                        isValid = true;
                        System.out.print("\n\n\n\n\n\n\n\n\n\n");
                    }
                }
            }

    }while (restart_option == 'Y');
        System.out.println("\nApplication is closing...");
        scan.close();
    }
}