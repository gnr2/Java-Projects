package com.EllisDavid.library;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegrationTest {
    private Library library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        library = new Library();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testLibraryAndBookManagerAddBook() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        Book book = library.getBooks().get(0);
        assertNotNull(book);
        assertEquals("Java Programming Language 2nd Edition", book.getTitle());
        assertEquals("Ken Arnold", book.getAuthor());
        assertEquals("0201704331", book.getISBN());
    }

    @Test
    public void testLibraryAndBookManagerRemoveBook() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        assertEquals(1, library.getBooks().size());
        library.removeBook(1);
        assertEquals(0, library.getBooks().size());
    }

    @Test
    public void testLibraryAndBookManagerSearchBookByTitle() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.searchBook(1, "Java");
        assertTrue(outContent.toString().contains("Java Programming Language 2nd Edition"));
    }

    @Test
    public void testLibraryAndBookManagerSearchBookByAuthor() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.searchBook(2, "Ken");
        assertTrue(outContent.toString().contains("Ken Arnold"));
    }

    @Test
    public void testLibraryAndBookManagerSearchBookByIsbn() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.searchBook(3, "0201704331");
        assertTrue(outContent.toString().contains("0201704331"));
    }

    @Test
    public void testLibraryAndBookManagerListBooks() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.listBooks();
        assertTrue(outContent.toString().contains("Java Programming Language 2nd Edition"));
    }
}
