package org.example.library;

// Class for the Book object

public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getAuthor(){
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return isbn;
    }






}
