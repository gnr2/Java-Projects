package org.example.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Library extends BookManager {
    private static final Logger log = LoggerFactory.getLogger(Library.class);
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(String bookTitle, String bookAuthor, String bookIsbn) {
        Book book = new Book(bookTitle, bookAuthor, bookIsbn);
        book.setId(books.size() + 1);
        books.add(book);
        log.info("{} by {} has been added to the list", book.getTitle(), book.getAuthor());
    }

    @Override
    public void removeBook(int choice) {
        int removedBookCounter = 0;
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book bookInList = iterator.next();
            if (bookInList.getId() == choice) {
                log.info("{} by {} has been removed from the list", bookInList.getTitle(), bookInList.getAuthor());
                System.out.println(String.format("%-10d%-25s%-25s%-50s", bookInList.getId(), bookInList.getTitle(), bookInList.getAuthor(), bookInList.getISBN()));
                iterator.remove();
                removedBookCounter += 1;
            }
        }

        if (removedBookCounter == 0) {
            log.warn("ID {} does not exist in the system.", choice);
            System.out.println("ID does not exist in the system.");
        }
    }

    @Override
    public void searchBook(int search_option, String keyword){
        int book_counter;

        switch(search_option){
            case 1:
                System.out.println("\nBy Title");
                System.out.println(String.format("%-10s%-25s%-25s%-50s", "Id", "Title", "Author", "ISBN"));
                book_counter = 0;
                for (Book book_in_list : books){
                    if (book_in_list.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                        System.out.println(String.format("%-10d%-25s%-25s%-50s", book_in_list.getId(), book_in_list.getTitle(), book_in_list.getAuthor(), book_in_list.getISBN()));
                        book_counter ++;
                    }
                }

                if (book_counter == 0){
                    log.warn("Book with keywords: {} does not exist in the system.", keyword);
                    System.out.println("Book was not found in the system.");
                }
                break;
            case 2:
                System.out.println("\nBy Author");
                System.out.println(String.format("%-10s%-25s%-25s%-50s", "Id", "Title", "Author", "ISBN"));
                book_counter = 0;
                for (Book book_in_list : books){
                    if (book_in_list.getAuthor().toLowerCase().contains(keyword.toLowerCase())){
                        System.out.println(String.format("%-10d%-25s%-25s%-50s", book_in_list.getId(), book_in_list.getTitle(), book_in_list.getAuthor(), book_in_list.getISBN()));
                        book_counter ++;
                    }
                }

                if (book_counter == 0){
                    log.warn("Book with keywords: {} does not exist in the system.", keyword);
                    System.out.println("Book was not found in the system.");
                }
                break;
            case 3:
                System.out.println("\nBy ISBN");
                System.out.println(String.format("%-10s%-25s%-25s%-50s", "Id", "Title", "Author", "ISBN"));
                book_counter = 0;
                for (Book book_in_list : books){
                    if (book_in_list.getISBN().toLowerCase().contains(keyword.toLowerCase())){
                        System.out.println(String.format("%-10d%-25s%-25s%-50s", book_in_list.getId(), book_in_list.getTitle(), book_in_list.getAuthor(), book_in_list.getISBN()));
                        book_counter ++;
                    }
                }

                if (book_counter == 0){
                    log.warn("Book with keywords: {} does not exist in the system.", keyword);
                    System.out.println("Book was not found in the system.");
                }
                break;
        }
    }

    @Override
    public void listBooks() {
        books = getBooks();
        if (books.isEmpty()) {
            log.info("No books in the system.");
            System.out.println("There are currently no books in the system.");
        } else {
            System.out.println(String.format("%-10s%-25s%-25s%-50s", "Id", "Title", "Author", "ISBN"));
            for (Book book : books) {
                System.out.println(String.format("%-10d%-25s%-25s%-50s", book.getId(), book.getTitle(), book.getAuthor(), book.getISBN()));
            }
            log.info("Total number of books in the system: {}", books.size());
        }

        printLongDivider();
    }
}
