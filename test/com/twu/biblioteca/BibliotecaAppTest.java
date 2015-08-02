package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void applicationCallsViewToPrintAppropriateMessage() {
        View view = mock(View.class);
        ArrayList<Book> listOfAvailableBooks = new ArrayList<Book>();
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<Book>();
        Library library = new Library(listOfAvailableBooks, listOfCheckedOutBooks);
        BibliotecaApp application = new BibliotecaApp(view, library);
        Message s = Message.Welcome;

        when(view.acceptMenuInput()).thenReturn("2");

        application.start();

        verify(view).print(s);
    }

    @Test
    public void applicationCallsViewToPrintListOfBooksWithColumns() {
        View view = mock(View.class);
        ArrayList<Book> listOfAvailableBooks = new ArrayList<Book>();
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<Book>();
        Library library = new Library(listOfAvailableBooks, listOfCheckedOutBooks);
        BibliotecaApp application = new BibliotecaApp(view, library);
        String list = library.toPrintListOfAvailableBook();

        when(view.acceptMenuInput()).thenReturn("1").thenReturn("2");

        application.start();

        verify(view).printBookList(list);
    }

    @Test
    public void applicationCallsViewToPrintMainMenu() {
        View view = mock(View.class);
        ArrayList<Book> listOfAvailableBooks = new ArrayList<Book>();
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<Book>();
        Library library = new Library(listOfAvailableBooks, listOfCheckedOutBooks);
        BibliotecaApp application = new BibliotecaApp(view, library);

        when(view.acceptMenuInput()).thenReturn("2");

        application.start();

        verify(view, atMost(2)).print(Message.MainMenu);
    }

    @Test
    public void applicationCallsViewToAcceptInputForMainMenuFromUser() {
        View view = mock(View.class);
        ArrayList<Book> listOfAvailableBooks = new ArrayList<Book>();
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<Book>();
        Library library = new Library(listOfAvailableBooks, listOfCheckedOutBooks);
        BibliotecaApp application = new BibliotecaApp(view, library);

        when(view.acceptMenuInput()).thenReturn("2");

        application.start();

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToPrintLine() {
        View view = mock(View.class);
        ArrayList<Book> listOfAvailableBooks = new ArrayList<Book>();
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<Book>();
        Library library = new Library(listOfAvailableBooks, listOfCheckedOutBooks);
        BibliotecaApp application = new BibliotecaApp(view, library);

        when(view.acceptMenuInput()).thenReturn("2");

        application.start();

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp(view, library);

        when(view.acceptMenuInput()).thenReturn("4").thenReturn("2");

        application.start();

        verify(library).returnABook(anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutBooks() {
        View view = mock(View.class);
        ArrayList<Book> listOfAvailableBooks = new ArrayList<Book>();
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<Book>();
        Library library = new Library(listOfAvailableBooks, listOfCheckedOutBooks);
        BibliotecaApp application = new BibliotecaApp(view, library);
        String list = library.toPrintListOfCheckedOutBook();

        when(view.acceptMenuInput()).thenReturn("5").thenReturn("2");

        application.start();

        verify(view).printBookList(list);
    }
}
