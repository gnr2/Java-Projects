package org.example;

import org.example.library.Library;

import java.util.Scanner;

// Create a basic library management system that allows users to add, remove, and search for books.

public class Main {
    public static void main(String[] args) {
        int user_option;
        char exit_choice;
        char redo_choice;
        String user_input;
        boolean isValid;
        Library lib = new Library();


        Scanner scan = new Scanner(System.in);
        do {
            exit_choice = '\0';
            redo_choice = '\0';
            isValid = false;
            user_option = 0;
            user_input = "";

            while (!isValid) {
                System.out.println();
                lib.printShortDivider();
                System.out.print(" Welcome to the Library ");
                lib.printShortDivider();
                lib.printMenu();
                System.out.print("\nChoose an Option: ");

                if (scan.hasNextInt()) {
                    user_option = scan.nextInt();
                    if (user_option < 1 || user_option > 4) {
                        System.out.println("Invalid input. Choose among the choices only.");
                        scan.nextLine();
                    } else {
                        isValid = true;
                        scan.nextLine();
                    }
                } else {
                    System.out.println("Enter numeric values only.");
                    scan.nextLine();
                }
            }
            lib.printLongDivider();

            switch (user_option) {
                case 1:
                    System.out.println('\n');
                    lib.listBooks();
                    System.out.print("\nPress Enter to Continue...");
                    scan.nextLine();
                    break;
                case 2:
                    do {
                        System.out.print("\nBook Title: ");
                        String book_title = scan.nextLine();

                        System.out.print("Book Author: ");
                        String book_author = scan.nextLine();

                        System.out.print("Book ISBN: ");
                        String book_isbn = scan.nextLine();

                        lib.addBook(book_title, book_author, book_isbn);
                        isValid = false;
                        while (!isValid) {
                            System.out.print("\nDo you want to add again? [Y/N]: ");
                            user_input = scan.nextLine();
                            if (user_input.length() != 1) {
                                System.out.println("Invalid input, select only 1 character.");
                            } else {
                                redo_choice = user_input.toUpperCase().charAt(0);
                                if (redo_choice != 'Y' && redo_choice != 'N') {
                                    System.out.println("Choose among the choices only.");
                                } else {
                                    isValid = true;
                                }
                            }
                        }
                    } while (redo_choice == 'Y');
                    break;
                case 3:
                    int search_option;
                    do {
                        search_option = 0;
                        isValid = false;
                        boolean innerIsValid = false;
                        while(!isValid) {
                            System.out.print("\nSearch by\n[1] Book Name\n[2] Book Author" +
                                    "\n[3] Book ISBN\n\nChoose: ");
                            if(scan.hasNextInt()) {
                                search_option = scan.nextInt();
                                if (search_option < 1 || search_option > 3) {
                                    System.out.println("Invalid input!");
                                    scan.nextLine();
                                } else {
                                    isValid = true;
                                    scan.nextLine();
                                }
                            } else {
                                System.out.println("Invalid input. enter numeric values only.");
                                scan.nextLine();
                            }
                        }
                        System.out.print("Search: ");
                        String search_keyword = scan.nextLine().toLowerCase();
                        lib.searchBook(search_option, search_keyword);
                        System.out.print("\nWhat would you like to do next?\n[1] Delete\n[2] " +
                                "Search again\n[3] Back to Menu\n\nChoose: ");

                        isValid = false;
                        while (!isValid) {
                            if (scan.hasNextInt()) {
                                user_option = scan.nextInt();
                                if (user_option < 1 || user_option > 3) {
                                    System.out.print("Choose from 1-3 only: ");
                                    scan.nextLine();
                                } else {
                                    if (user_option == 1) {
                                        System.out.print("Enter the ID number of the book you wish to remove: ");
                                        while(!innerIsValid) {
                                            if (scan.hasNextInt()) {
                                                int remove_id_choice = scan.nextInt();
                                                lib.removeBook(remove_id_choice);
                                                innerIsValid = true;
                                                scan.nextLine();
                                            } else {
                                                System.out.println("Enter numerical values only: ");
                                                scan.nextLine();
                                            }
                                        }
                                        System.out.print("Do you want to search again? [Y/N]: ");
                                        user_input = scan.nextLine();
                                        if (user_input.length() != 1) {
                                            System.out.println("Invalid input, select only 1 character.");
                                        } else {
                                            redo_choice = user_input.toUpperCase().charAt(0);
                                            if (redo_choice != 'Y' && redo_choice != 'N') {
                                                System.out.println("Choose among the choices only.");
                                            } else {
                                                isValid = true;
                                            }
                                        }
                                    } if (user_option == 2) {
                                        scan.nextLine();
                                        System.out.print("Do you want to search again? [Y/N]: ");
                                        user_input = scan.nextLine();
                                        if (user_input.length() != 1) {
                                            System.out.println("Invalid input, select only 1 character.");
                                        } else {
                                            redo_choice = user_input.toUpperCase().charAt(0);
                                            if (redo_choice != 'Y' && redo_choice != 'N') {
                                                System.out.println("Choose among the choices only.");
                                            } else {
                                                isValid = true;
                                            }
                                        }
                                    } if (user_option == 3) {
                                        isValid = true;
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Invalid input. Choose among the choices only.");
                                scan.nextLine();
                            }
                        }

                    } while (redo_choice == 'Y');
                    break;
                case 4:
                    isValid = false;
                    while(!isValid) {
                        System.out.print("\nDo you want to exit the program? [Y/N]: ");
                        user_input = scan.nextLine();
                        if (user_input.length() != 1){
                            System.out.println("Invalid input. Y or N only.");
                        }else {
                            exit_choice = user_input.toUpperCase().charAt(0);
                            if(exit_choice != 'Y' && exit_choice != 'N'){
                                System.out.println("Invalid input.");
                            } else if (exit_choice == 'Y') {
                                isValid = true;
                                System.out.println("Application is closing...");
                                scan.close();
                                System.exit(0);
                            } else if (exit_choice == 'N'){
                                isValid = true;
                                System.out.println("\n\n\n\n\n\n");
                                break;
                            }
                        }

                    }
            }
        } while (true);

    }
}

