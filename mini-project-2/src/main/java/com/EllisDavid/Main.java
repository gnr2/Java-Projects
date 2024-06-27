package com.EllisDavid;

import com.EllisDavid.library.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

// Create a basic library management system that allows users to add, remove, and search for books.

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Variable declaration
        int user_option;
        char exit_choice;
        char redo_choice;
        String user_input;
        boolean isValid;
        Library lib = new Library();

        Scanner scan = new Scanner(System.in);
        do {
            // Assignment of initial values to prevent error
            redo_choice = '\0';
            isValid = false;
            user_option = 0;

            // Loop to ensure user inputs the correct choice for action
            while (!isValid) {
                System.out.println();
                lib.printShortDivider();
                System.out.print(" Welcome to the Library ");
                lib.printShortDivider();
                lib.printMenu();
                System.out.print("\nChoose an Option: ");

                try {
                    if (scan.hasNextInt()) {
                        user_option = scan.nextInt();
                        if (user_option < 1 || user_option > 4) {
                            throw new IllegalArgumentException("Invalid input. Choose among the choices only.");
                        }
                        isValid = true;
                        scan.nextLine();
                        log.info("User selected option: {}", user_option);
                    } else {
                        throw new IllegalArgumentException("Enter numeric values only.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    log.error("Error in user input: {}", e.getMessage());
                    scan.nextLine();
                }
            }
            lib.printLongDivider();

            switch (user_option) {
                case 1:
                    // Use case for displaying the list of books
                    System.out.println();
                    lib.listBooks();
                    System.out.print("\nPress Enter to Continue...");
                    scan.nextLine();
                    break;
                case 2:
                    // Use case for adding a new book to the list
                    do {
                        isValid = false;
                        while (!isValid) {
                            try {
                                System.out.print("\nBook Title: ");
                                String book_title = scan.nextLine().trim();
                                if (book_title.isEmpty()) {
                                    throw new IllegalArgumentException("Book title cannot be empty");
                                }

                                log.info("User entered a book name to the system.");

                                System.out.print("Book Author: ");
                                String book_author = scan.nextLine().trim();
                                if (book_author.isEmpty()) {
                                    throw new IllegalArgumentException("Book author cannot be empty");
                                }

                                log.info("User entered a book author to the system.");

                                System.out.print("Book ISBN: ");
                                String book_isbn = scan.nextLine().trim();
                                if (book_isbn.isEmpty()) {
                                    throw new IllegalArgumentException("Book ISBN cannot be empty");
                                }

                                log.info("User entered a book ISBN to the system.");

                                lib.addBook(book_title, book_author, book_isbn);
                                isValid = true;

                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                log.error("Error in adding book: {}", e.getMessage());
                            }
                        }

                        // Code block for add again
                        isValid = false;
                        while (!isValid) {
                            try {
                                System.out.print("\nDo you want to add again? [Y/N]: ");
                                user_input = scan.nextLine().trim();
                                if (user_input.length() != 1) {
                                    throw new IllegalArgumentException("Invalid input, select only 1 character.");
                                }

                                redo_choice = user_input.toUpperCase().charAt(0);
                                if (redo_choice != 'Y' && redo_choice != 'N') {
                                    throw new IllegalArgumentException("Choose among the choices only.");
                                }

                                isValid = true;
                                log.info("User chose to add another book: {}", redo_choice);

                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                log.error("Error in user input: {}", e.getMessage());
                            }
                        }
                    } while (redo_choice == 'Y');
                    break;
                case 3:
                    // Use case for book search and remove
                    int search_option;
                    boolean innerIsValid;
                    do {
                        search_option = 0;
                        isValid = false;
                        innerIsValid = false;
                        while (!isValid) {
                            try {
                                System.out.print("\nSearch by\n[1] Book Title\n[2] Book Author" +
                                        "\n[3] Book ISBN\n\nChoose: ");
                                if (scan.hasNextInt()) {
                                    search_option = scan.nextInt();
                                    if (search_option < 1 || search_option > 3) {
                                        throw new IllegalArgumentException("Invalid input!");
                                    }
                                    isValid = true;
                                    scan.nextLine(); // clear the buffer
                                    log.info("User selected search option: {}", search_option);
                                } else {
                                    throw new IllegalArgumentException("Invalid input. Enter numeric values only.");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                log.error("Error in user input: {}", e.getMessage());
                                scan.nextLine(); // clear the buffer
                            }
                        }
                        System.out.print("Search: ");
                        String search_keyword = scan.nextLine().toLowerCase();
                        log.info("User searching with keyword: {}", search_keyword);
                        lib.searchBook(search_option, search_keyword);
                        System.out.print("\nWhat would you like to do next?\n[1] Delete\n[2] " +
                                "Search again\n[3] Back to Menu\n\nChoose: ");

                        // Additional options (1. Remove, 2. Search, 3. Exit)
                        isValid = false;
                        while (!isValid) {
                            try {
                                if (scan.hasNextInt()) {
                                    user_option = scan.nextInt();
                                    if (user_option < 1 || user_option > 3) {
                                        throw new IllegalArgumentException("Choose from 1-3 only.");
                                    }
                                    if (user_option == 1) {
                                        System.out.print("Enter the ID number of the book you wish to remove: ");
                                        innerIsValid = false;
                                        while (!innerIsValid) {
                                            try {
                                                if (scan.hasNextInt()) {
                                                    int remove_id_choice = scan.nextInt();
                                                    lib.removeBook(remove_id_choice);
                                                    log.info("User removed book with ID: {}", remove_id_choice);
                                                    innerIsValid = true;
                                                    scan.nextLine(); // clear the buffer
                                                } else {
                                                    throw new IllegalArgumentException("Enter numerical values only.");
                                                }
                                            } catch (IllegalArgumentException e) {
                                                System.out.println(e.getMessage());
                                                log.error("Error in user input: {}", e.getMessage());
                                                scan.nextLine(); // clear the buffer
                                            }
                                        }
                                    }
                                    isValid = true;
                                    scan.nextLine(); // clear the buffer
                                    log.info("User selected next action after search: {}", user_option);
                                } else {
                                    throw new IllegalArgumentException("Invalid input. Choose among the choices only.");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                log.error("Error in user input: {}", e.getMessage());
                                scan.nextLine(); // clear the buffer
                            }
                        }

                        if (user_option == 2) {
                            isValid = false;
                            while (!isValid) {
                                try {
                                    System.out.print("Do you want to search again? [Y/N]: ");
                                    user_input = scan.nextLine().trim();
                                    if (user_input.length() != 1) {
                                        throw new IllegalArgumentException("Invalid input, select only 1 character.");
                                    }
                                    redo_choice = user_input.toUpperCase().charAt(0);
                                    if (redo_choice != 'Y' && redo_choice != 'N') {
                                        throw new IllegalArgumentException("Choose among the choices only.");
                                    }
                                    isValid = true;
                                    log.info("User chose to search again: {}", redo_choice);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    log.error("Error in user input: {}", e.getMessage());
                                }
                            }
                        } else if (user_option == 3) {
                            break;
                        }

                    } while (redo_choice == 'Y');
                    break;
                case 4:
                    // Use case to exit the program
                    isValid = false;
                    while (!isValid) {
                        try {
                            System.out.print("\nDo you want to exit the program? [Y/N]: ");
                            user_input = scan.nextLine().trim();
                            if (user_input.length() != 1) {
                                throw new IllegalArgumentException("Invalid input. Y or N only.");
                            }
                            exit_choice = user_input.toUpperCase().charAt(0);
                            if (exit_choice != 'Y' && exit_choice != 'N') {
                                throw new IllegalArgumentException("Invalid input.");
                            }
                            if (exit_choice == 'Y') {
                                isValid = true;
                                log.info("User chose to exit the application.");
                                System.out.println("Application is closing...");
                                scan.close();
                                System.exit(0);
                            } else if (exit_choice == 'N') {
                                isValid = true;
                                log.info("User chose not to exit the application.");
                                System.out.println("\n\n\n\n\n\n");
                                break;
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            log.error("Error in user input: {}", e.getMessage());
                        }
                    }
            }
        } while (true);
    }
}
