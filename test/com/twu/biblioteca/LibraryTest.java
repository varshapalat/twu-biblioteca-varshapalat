package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void libraryCanCheckOutABook() {
        ArrayList<Book> expectedListOfBooks = new ArrayList<Book>();
        ArrayList<Book> listOfAvialableLibraryBooks = new ArrayList<Book>();

        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        listOfAvialableLibraryBooks.add(bookOne);
        listOfAvialableLibraryBooks.add(bookTwo);
        listOfAvialableLibraryBooks.add(bookThree);

        expectedListOfBooks.add(bookOne);
        expectedListOfBooks.add(bookThree);
        Library library = new Library(listOfAvialableLibraryBooks);

        boolean actual = library.checkout("Kane and Abel");

        assertEquals(expectedListOfBooks, listOfAvialableLibraryBooks);
        assertEquals(true, actual);
    }

    @Test
    public void libraryCanReturnABook() {
        ArrayList<Book> expectedListOfBooks = new ArrayList<Book>();
        ArrayList<Book> listOfAvailableLibraryBooks = new ArrayList<Book>();

        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");

        listOfAvailableLibraryBooks.add(bookOne);
        listOfAvailableLibraryBooks.add(bookThree);
        expectedListOfBooks.add(bookOne);
        expectedListOfBooks.add(bookThree);
        expectedListOfBooks.add(bookTwo);
        Library library = new Library(listOfAvailableLibraryBooks);
        library.listOfCheckedOutLibraryBooks.add(bookTwo);

        boolean actual = library.returnABook("Kane and Abel");

        assertEquals(expectedListOfBooks, listOfAvailableLibraryBooks);
        assertEquals(true, actual);
    }

    @Test
    public void libraryCanReturnListOfAvailableBooks() {
        ArrayList<Book> listOfAvailableLibraryBooks = new ArrayList<Book>();
        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");

        listOfAvailableLibraryBooks.add(bookOne);
        listOfAvailableLibraryBooks.add(bookTwo);
        listOfAvailableLibraryBooks.add(bookThree);
        Library library = new Library(listOfAvailableLibraryBooks);

        String listOfBookDetails = library.toPrintListOfAvailableBook();

        assertEquals("The Da Vinci Code\tDan Brown\t\t2000\n" +
                " Kane and Abel\tJeffrey Archer\t\t1979\n" +
                " The Alchemist\tPaulo Coelho\t\t1988\n" +
                " ", listOfBookDetails);
    }
}
