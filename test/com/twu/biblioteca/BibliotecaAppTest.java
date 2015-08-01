package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void applicationCallsViewToPrintAppropriateMessage() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<Book> books = new ArrayList<Book>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("2");

        application.start(view, library);

        Message s = Message.Welcome;
        verify(view).print(s);
    }

    @Test
    public void applicationCallsViewToPrintListOfBooksWithColumns() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<Book> books = new ArrayList<Book>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("1").thenReturn("2");

        application.start(view, library);
        String list = library.toPrintListOfAvailableBook();

        verify(view).printBookList(list);
    }

    @Test
    public void applicationCallsViewToPrintMainMenu() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<Book> books = new ArrayList<Book>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("2");

        application.start(view, library);

        verify(view, atMost(2)).print(Message.MainMenu);
    }

    @Test
    public void applicationCallsViewToAcceptInputForMainMenuFromUser() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<Book> books = new ArrayList<Book>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("2");

        application.start(view, library);

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToPrintLine() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<Book> books = new ArrayList<Book>();
        Library library = new Library(books);

        when(view.acceptMenuInput()).thenReturn("2");

        application.start(view, library);

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        Library library = mock(Library.class);
        when(view.acceptMenuInput()).thenReturn("4").thenReturn("2");

        application.start(view, library);

        verify(library).returnABook(anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutBooks() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<Book> books = new ArrayList<Book>();
        Library library = new Library(books);
        when(view.acceptMenuInput()).thenReturn("5").thenReturn("2");

        application.start(view, library);
        String list = library.toPrintListOfCheckedOutBook();

        verify(view).printBookList(list);
    }
}
