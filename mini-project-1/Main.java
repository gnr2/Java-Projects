package org.example;

import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Calculator calc = new Calculator();
        char choose_operator, restart_option;
        char cont = 'Y';
        double x, y = 0;
        Scanner sc = new Scanner(System.in);
        boolean checker = false;

        do {
            System.out.println("\nWelcome! This is a Calculator App.");
            System.out.print("Enter a number: ");
            x = sc.nextDouble();


            do {
                if (!checker) {
                    System.out.print("Enter another number: ");
                    y = sc.nextDouble();
                }

                sc.nextLine();
                checker = false;
                System.out.println("\nSelect an operation\n[A] Addition\n[B] Subtraction\n[C] Multiplication\n[D] Division");
                System.out.print("Choose: ");
                choose_operator = sc.nextLine().charAt(0);
                char operator = Character.toUpperCase(choose_operator);

                switch (operator) {
                    case 'A':
                        x = calc.addNum(x, y);
                        System.out.println("The result is: " + x);
                        break;
                    case 'B':
                        x = calc.sbtrctNum(x, y);
                        System.out.println("The result is: " + x);
                        break;
                    case 'C':
                        x = calc.mltpyNum(x, y);
                        System.out.println("The result is: " + x);
                        break;
                    case 'D':
                        if (x != 0 && y != 0) {
                            x = calc.divideNum(x, y);
                            System.out.println("The result is: " + x);
                            break;
                        } else {
                            System.out.println("Cannot divide with 0s");
                            break;
                        }
                    default:
                        System.out.println("Invalid Selection");
                        checker = true;
                        continue;
                }

                System.out.print("\nContinue?[Y/N]: ");
                cont = sc.nextLine().charAt(0);

            } while (cont == 'Y' || cont == 'y');
            System.out.print("Do you want to restart?[Y/N]: ");
            restart_option = sc.nextLine().charAt(0);

        }while (restart_option == 'Y' || restart_option == 'y');
        sc.close();
        System.out.println("END");

    }
}
