package org.example.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        library = new Library();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testAddBook() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        assertEquals(1, library.getBooks().size());
        assertEquals("Java Programming Language 2nd Edition", library.getBooks().get(0).getTitle());
    }

    @Test
    public void testRemoveBook() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        assertEquals(1, library.getBooks().size());
        library.removeBook(1);
        assertEquals(0, library.getBooks().size());
    }

    @Test
    public void testSearchBookByTitle() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.searchBook(1, "Java");
        String expectedOutput = String.format("%-10d%-25s%-25s%-50s%n", 1, "Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testSearchBookByAuthor() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.searchBook(2, "Ken");
        String expectedOutput = String.format("%-10d%-25s%-25s%-50s%n", 1, "Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testSearchBookByIsbn() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.searchBook(3, "0201704331");
        String expectedOutput = String.format("%-10d%-25s%-25s%-50s%n", 1, "Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testListBooks() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.listBooks();
        String expectedOutput = String.format("%-10d%-25s%-25s%-50s%n", 1, "Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
