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

        boolean actual = library.checkout("Kane and Abel", "123-4567");

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
        listOfCheckedOutBooks.add(bookTwo);
        expectedListOfBooks.add(bookOne);
        expectedListOfBooks.add(bookThree);
        expectedListOfBooks.add(bookTwo);
        Library library = new Library(listOfAvailableLibraryBooks, listOfCheckedOutBooks);

        boolean actual = library.returnALibraryItem("Kane and Abel");

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
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        ArrayList<LibraryItem> listOfAvailableLibraryBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> listOfCheckedOutBooks = new ArrayList<LibraryItem>();
        listOfCheckedOutBooks.add(bookTwo);
        listOfAvailableLibraryBooks.add(bookOne);
        listOfAvailableLibraryBooks.add(bookThree);
        Library library = new Library(listOfAvailableLibraryBooks, listOfCheckedOutBooks);
        library.checkout("The Da Vinci Code", "123-4567");
        library.checkout("The Alchemist", "123-4567");

        String listOfBookDetails = library.listOfCheckedOutLibraryItems();

        assertEquals("Kane and Abel\tJeffrey Archer\t\t1979\n" +
                " The Da Vinci Code\tDan Brown\t\t2000\n" +
                " The Alchemist\tPaulo Coelho\t\t1988\n" +
                " ", listOfBookDetails);
    }

    @Test
    public void libraryCanCheckOutAMovie() {
        ArrayList<LibraryItem> expectedLibraryItems = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> avialableLibraryItems = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutLibraryItems = new ArrayList<LibraryItem>();
        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        Movie movieTwo = new Movie("Gladiator", "Ridley Scott", "2000", "7.6");
        Movie movieThree = new Movie("Matrix", "The Wachowskis", "1999", "8.2");
        avialableLibraryItems.add(movieOne);
        avialableLibraryItems.add(movieTwo);
        avialableLibraryItems.add(movieThree);
        expectedLibraryItems.add(movieOne);
        expectedLibraryItems.add(movieThree);
        Library library = new Library(avialableLibraryItems, checkedOutLibraryItems);

        boolean actual = library.checkout("Gladiator", "123-4567");

        assertEquals(expectedLibraryItems, avialableLibraryItems);
        assertEquals(true, actual);
    }

    @Test
    public void libraryCanReturnAMovie() {
        ArrayList<LibraryItem> expectedListOfBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> listOfAvailableLibraryBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> listOfCheckedOutBooks = new ArrayList<LibraryItem>();
        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        Movie movieTwo = new Movie("Gladiator", "Ridley Scott", "2000", "7.6");
        Movie movieThree = new Movie("Matrix", "The Wachowskis", "1999", "8.2");
        listOfAvailableLibraryBooks.add(movieOne);
        listOfAvailableLibraryBooks.add(movieThree);
        listOfCheckedOutBooks.add(movieTwo);
        expectedListOfBooks.add(movieOne);
        expectedListOfBooks.add(movieThree);
        expectedListOfBooks.add(movieTwo);
        Library library = new Library(listOfAvailableLibraryBooks, listOfCheckedOutBooks);

        boolean actual = library.returnALibraryItem("Gladiator");

        assertEquals(expectedListOfBooks, listOfAvailableLibraryBooks);
        assertEquals(true, actual);
    }

    @Test
    public void libraryCanReturnListOfAvailableMovies() {
        ArrayList<LibraryItem> availableMovies = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutMovies = new ArrayList<LibraryItem>();
        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        Movie movieTwo = new Movie("Gladiator", "Ridley Scott", "2000", "7.6");
        Movie movieThree = new Movie("Matrix", "The Wachowskis", "1999", "8.2");
        availableMovies.add(movieOne);
        availableMovies.add(movieTwo);
        availableMovies.add(movieThree);
        Library library = new Library(availableMovies, checkedOutMovies);

        String listOfBookDetails = library.listOfAvailableLibraryItems();

        assertEquals("Gone Girl\tDavid Fincher\t2014\t8\n" +
                " Gladiator\tRidley Scott\t2000\t7.6\n" +
                " Matrix\tThe Wachowskis\t1999\t8.2\n" +
                " ", listOfBookDetails);
    }

    @Test
    public void libraryCanReturnListOfCheckedOutMovies() {
        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        Movie movieTwo = new Movie("Gladiator", "Ridley Scott", "2000", "7.6");
        Movie movieThree = new Movie("Matrix", "The Wachowskis", "1999", "8.2");

        ArrayList<LibraryItem> availableMovies = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutMovies = new ArrayList<LibraryItem>();


        availableMovies.add(movieOne);
        availableMovies.add(movieTwo);
        availableMovies.add(movieThree);
        Library library = new Library(availableMovies, checkedOutMovies);
        library.checkout("Gone Girl", "123-4567");
        library.checkout("Matrix", "123-4567");

        String listOfBookDetails = library.listOfCheckedOutLibraryItems();

        assertEquals("Gone Girl\tDavid Fincher\t2014\t8\n" +
                " Matrix\tThe Wachowskis\t1999\t8.2\n" +
                " ", listOfBookDetails);
    }

}
