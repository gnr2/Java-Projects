package org.example.library;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBookCreation(){
        Book book = new Book("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        assertEquals("Java Programming Language 2nd Edition", book.getTitle());
        assertEquals("Ken Arnold", book.getAuthor());
        assertEquals("0201704331", book.getISBN());
    }
}
