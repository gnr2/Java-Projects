package org.example.library;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
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
        // You can enhance this test by capturing console output or modifying searchBook to return results
    }

    @Test
    public void testSearchBookByAuthor() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.searchBook(2, "Ken");
        // Similar to above, capture or check output/results
    }

    @Test
    public void testSearchBookByIsbn() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.searchBook(3, "0201704331");
        // Similar to above, capture or check output/results
    }

    @Test
    public void testListBooks() {
        library.addBook("Java Programming Language 2nd Edition", "Ken Arnold", "0201704331");
        library.listBooks();
        // Ensure the listBooks method works as expected
    }
}
