package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void libraryCanCheckOutABook() {
        ArrayList<ArrayList<String>> expectedListOfBooks = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> listOfAllLibraryBooks = new ArrayList<ArrayList<String>>();

        ArrayList<String> bookOne = new ArrayList<String>();
        bookOne.add("The Da Vinci Code");
        bookOne.add("Dan Brown");
        bookOne.add("2000");
        ArrayList<String> bookTwo = new ArrayList<String>();
        bookTwo.add("Kane and Abel");
        bookTwo.add("Jeffrey Archer");
        bookTwo.add("1979");
        ArrayList<String> bookThree = new ArrayList<String>();
        bookThree.add("The Alchemist");
        bookThree.add("Paulo Coelho");
        bookThree.add("1988");
        listOfAllLibraryBooks.add(bookOne);
        listOfAllLibraryBooks.add(bookTwo);
        listOfAllLibraryBooks.add(bookThree);

        expectedListOfBooks.add(bookOne);
        expectedListOfBooks.add(bookThree);
        Library library = new Library(listOfAllLibraryBooks);

        library.checkout("Kane and Abel");

        assertEquals(expectedListOfBooks, listOfAllLibraryBooks);
    }
    @Test
    public void libraryCanReturnABook() {
        ArrayList<ArrayList<String>> expectedListOfBooks = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> listOfAllLibraryBooks = new ArrayList<ArrayList<String>>();

        ArrayList<String> bookOne = new ArrayList<String>();
        bookOne.add("The Da Vinci Code");
        bookOne.add("Dan Brown");
        bookOne.add("2000");
        ArrayList<String> bookTwo = new ArrayList<String>();
        bookTwo.add("Kane and Abel");
        bookTwo.add("Jeffrey Archer");
        bookTwo.add("1979");
        ArrayList<String> bookThree = new ArrayList<String>();
        bookThree.add("The Alchemist");
        bookThree.add("Paulo Coelho");
        bookThree.add("1988");
        listOfAllLibraryBooks.add(bookOne);
        listOfAllLibraryBooks.add(bookThree);
        expectedListOfBooks.add(bookOne);
        expectedListOfBooks.add(bookThree);
        expectedListOfBooks.add(bookTwo);
        Library library = new Library(listOfAllLibraryBooks);
        library.listOfCheckedOutLibraryBooks.add(bookTwo);

        library.returnABook("Kane and Abel");

        assertEquals(expectedListOfBooks, listOfAllLibraryBooks);
    }
}
