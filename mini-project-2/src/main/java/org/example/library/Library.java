package org.example.library;

import java.util.ArrayList;
import java.util.Iterator;

public class Library extends BookManager{
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(String book_title, String book_author, String book_isbn){
        Book book = new Book(book_title, book_author, book_isbn);
        book.setId(books.size() + 1);
        books.add(book);

        System.out.println("\n" + book.getTitle() + " has been successfully added to the library.");
    }

    @Override
    public void removeBook(int choice){
        int removed_book_counter = 0;
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book_in_list = iterator.next();
            if (book_in_list.getId() == choice) {
                System.out.println(book_in_list.getTitle() + " by " + book_in_list.getAuthor()
                        + " has been removed from the list");
                iterator.remove();
                removed_book_counter += 1;
            }
        }

        if (removed_book_counter == 0) {
            System.out.println("ID does not exist in the system.");
        }
    }

    @Override
    public void searchBook(int search_option, String keyword){
        int book_counter;
        switch(search_option){
            case 1:
                System.out.println("\nBy Title");
                book_counter = 0;
                for (Book book_in_list : books){
                    if (book_in_list.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                        System.out.println(book_in_list.getId() + "\t" + book_in_list.getTitle() + "\t" +
                                book_in_list.getAuthor() + "\t" + book_in_list.getISBN());
                        book_counter ++;
                    }
                }

                if (book_counter == 0){
                    System.out.println("Book was not found in the system.");
                }
                break;
            case 2:
                System.out.println("\nBy Author");
                book_counter = 0;
                for (Book book_in_list : books){
                    if (book_in_list.getAuthor().toLowerCase().contains(keyword.toLowerCase())){
                        System.out.println(book_in_list.getId() + "\t" + book_in_list.getTitle() + "\t" +
                                book_in_list.getAuthor() + "\t" + book_in_list.getISBN());
                        book_counter ++;
                    }
                }

                if (book_counter == 0){
                    System.out.println("Book was not found in the system.");
                }
                break;
            case 3:
                System.out.println("\nBy ISBN");
                book_counter = 0;
                for (Book book_in_list : books){
                    if (book_in_list.getISBN().toLowerCase().contains(keyword.toLowerCase())){
                        System.out.println(book_in_list.getId() + "\t" + book_in_list.getTitle() + "\t" +
                                book_in_list.getAuthor() + "\t" + book_in_list.getISBN());
                        book_counter ++;
                    }
                }

                if (book_counter == 0){
                    System.out.println("Book was not found in the system.");
                }
                break;
        }
    }



    @Override
    public void listBooks(){
        books = getBooks();
        if (books.isEmpty()){
            System.out.println("There are currently no books in the system.");
        }else{
            for (Book book_in_list : books ){
                System.out.println( book_in_list.getId() + "\t" + book_in_list.getTitle() + "\t" + book_in_list.getAuthor() +
                        "\t" + book_in_list.getISBN() + "\n");
        }
            System.out.println("Total number of books in the system: " + books.size());
        }

        printLongDivider();
    }

}
