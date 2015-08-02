package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void libraryCanCheckOutABook() {
        ArrayList<LibraryItem> expectedLibraryItems = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> avialableLibraryItems = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutLibraryItems = new ArrayList<LibraryItem>();
        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        avialableLibraryItems.add(bookOne);
        avialableLibraryItems.add(bookTwo);
        avialableLibraryItems.add(bookThree);
        expectedLibraryItems.add(bookOne);
        expectedLibraryItems.add(bookThree);
        Library library = new Library(avialableLibraryItems, checkedOutLibraryItems);

        boolean actual = library.checkout("Kane and Abel");

        assertEquals(expectedLibraryItems, avialableLibraryItems);
        assertEquals(true, actual);
    }

    @Test
    public void libraryCanReturnABook() {
        ArrayList<LibraryItem> expectedListOfBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> listOfAvailableLibraryBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> listOfCheckedOutBooks = new ArrayList<LibraryItem>();
        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        listOfAvailableLibraryBooks.add(bookOne);
        listOfAvailableLibraryBooks.add(bookThree);
        expectedListOfBooks.add(bookOne);
        expectedListOfBooks.add(bookThree);
        expectedListOfBooks.add(bookTwo);
        Library library = new Library(listOfAvailableLibraryBooks, listOfCheckedOutBooks);
        library.checkedOutLibraryItems.add(bookTwo);

        boolean actual = library.returnABook("Kane and Abel");

        assertEquals(expectedListOfBooks, listOfAvailableLibraryBooks);
        assertEquals(true, actual);
    }

    @Test
    public void libraryCanReturnListOfAvailableBooks() {
        ArrayList<LibraryItem> listOfAvailableLibraryBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> listOfCheckedOutBooks = new ArrayList<LibraryItem>();
        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        listOfAvailableLibraryBooks.add(bookOne);
        listOfAvailableLibraryBooks.add(bookTwo);
        listOfAvailableLibraryBooks.add(bookThree);
        Library library = new Library(listOfAvailableLibraryBooks, listOfCheckedOutBooks);

        String listOfBookDetails = library.listOfAvailableLibraryItems();

        assertEquals("The Da Vinci Code\tDan Brown\t\t2000\n" +
                " Kane and Abel\tJeffrey Archer\t\t1979\n" +
                " The Alchemist\tPaulo Coelho\t\t1988\n" +
                " ", listOfBookDetails);
    }

    @Test
    public void libraryCanReturnListOfCheckedOutBooks() {
        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        ArrayList<LibraryItem> listOfAvailableLibraryBooks = null;
        ArrayList<LibraryItem> listOfCheckedOutBooks = new ArrayList<LibraryItem>();
        Library library = new Library(listOfAvailableLibraryBooks, listOfCheckedOutBooks);
        library.checkedOutLibraryItems.add(bookOne);
        library.checkedOutLibraryItems.add(bookThree);

        String listOfBookDetails = library.listOfCheckedOutLibraryItems();

        assertEquals("The Da Vinci Code\tDan Brown\t\t2000\n" +
                " The Alchemist\tPaulo Coelho\t\t1988\n" +
                " ", listOfBookDetails);
    }
}
