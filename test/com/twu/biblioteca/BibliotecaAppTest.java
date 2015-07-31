package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("2");

        application.start(view, books, library);

        verify(view).printWelcomeMessage();
    }

    @Test
    public void applicationCallsViewToPrintListOfBooksWithColumns() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("1").thenReturn("2");

        application.start(view, books, library);

        verify(view).printBookList(books);
    }

    @Test
    public void applicationCallsViewToPrintMainMenu() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("2");

        application.start(view, books, library);

        verify(view, atMost(2)).printMainMenu();
    }

    @Test
    public void applicationCallsViewToAcceptInputForMainMenuFromUser() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("2");

        application.start(view, books, library);

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToPrintLine() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        Library library = new Library(books);

        when(view.acceptMenuInput()).thenReturn("2");

        application.start(view, books, library);

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToPrintInvalidOption() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("10").thenReturn("2");

        application.start(view, books, library);

        verify(view).printInvalidMenuOption();
    }

    @Test
    public void applicationCallsViewToPrintSuccessfulCheckoutMessage() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        when(view.acceptMenuInput()).thenReturn("3").thenReturn("2");
        when(library.checkout(anyString())).thenReturn(true);

        application.start(view, books, library);

        verify(view).printSuccessfulCheckout();
    }

    @Test
    public void applicationCallsViewToPrintUnsuccessfulCheckoutMessage() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        when(view.acceptMenuInput()).thenReturn("3").thenReturn("2");
        when(library.checkout(anyString())).thenReturn(false);

        application.start(view, books, library);

        verify(view).printUnsuccessfullCheckout();
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        Library library = mock(Library.class);
        when(view.acceptMenuInput()).thenReturn("4").thenReturn("2");

        application.start(view, books, library);

        verify(library).returnABook(anyString());
    }

    @Test
    public void applicationCallsViewToPrintSuccessfulCheckinMessage() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        when(view.acceptMenuInput()).thenReturn("4").thenReturn("2");
        when(library.returnABook(anyString())).thenReturn(true);

        application.start(view, books, library);

        verify(view).printSuccessfulReturn();
    }

    @Test
    public void applicationCallsViewToPrintUnsuccessfulCheckinMessage() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        when(view.acceptMenuInput()).thenReturn("4").thenReturn("2");
        when(library.returnABook(anyString())).thenReturn(false);

        application.start(view, books, library);

        verify(view).printUnsuccessfullReturn();
    }
}
