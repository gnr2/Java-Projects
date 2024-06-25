package org.example.library;

public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn){
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if(author == null || author.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if(isbn == null || isbn.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String ISBN) {
        this.isbn = isbn;
    }





}
