package com.EllisDavid.library;

// Abstract class containing the functions for library

public abstract class BookManager {

    public abstract void addBook(String book_title, String book_author, String book_isbn);

    public abstract void removeBook(int choice);

    public abstract void searchBook(int search_option, String keyword);

    public abstract void listBooks();

    public void printShortDivider() {
        for (int i = 0; i < 10; i++) {
            System.out.print("=");
        }
    }

    public void printLongDivider() {
        for (int i = 0; i < 44; i++) {
            System.out.print("=");
        }
    }

    public void printMenu(){
        System.out.println("\n[1] View List of All Books.\n[2] Add a New Book." +
                "\n[3] Search for a Book.\n[4] Exit.");
    }


}
