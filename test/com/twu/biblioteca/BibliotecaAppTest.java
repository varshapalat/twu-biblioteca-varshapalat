package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void applicationCallsViewToPrintAppropriateMessage() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp(view, bookLibrary, movieLibrary);
        Message s = Message.Welcome;

        when(view.acceptMenuInput()).thenReturn("2");

        application.start();

        verify(view).print(s);
    }

    @Test
    public void applicationCallsViewToPrintListOfBooksWithColumns() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp(view, bookLibrary, movieLibrary);
        String list = bookLibrary.listOfAvailableLibraryItems();

        when(view.acceptMenuInput()).thenReturn("1").thenReturn("2");

        application.start();

        verify(view).printList(list);
    }

    @Test
    public void applicationCallsViewToPrintMainMenu() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp(view, bookLibrary, movieLibrary);

        when(view.acceptMenuInput()).thenReturn("2");

        application.start();

        verify(view, atMost(2)).print(Message.MainMenu);
    }

    @Test
    public void applicationCallsViewToAcceptInputForMainMenuFromUser() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp(view, bookLibrary, movieLibrary);

        when(view.acceptMenuInput()).thenReturn("2");

        application.start();

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToPrintLine() {
        View view = mock(View.class);
        ArrayList<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> availableMovies = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutMovies = new ArrayList<LibraryItem>();
        Library bookLibrary = new Library(availableBooks, checkedOutBooks);
        Library movieLibrary = new Library(availableMovies, checkedOutMovies);
        BibliotecaApp application = new BibliotecaApp(view, bookLibrary, movieLibrary);

        when(view.acceptMenuInput()).thenReturn("2");

        application.start();

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp(view, bookLibrary, movieLibrary);

        when(view.acceptMenuInput()).thenReturn("4").thenReturn("2");

        application.start();

        verify(bookLibrary).returnABook(anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutBooks() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        BibliotecaApp application = new BibliotecaApp(view, bookLibrary, movieLibrary);
        String list = bookLibrary.listOfCheckedOutLibraryItems();

        when(view.acceptMenuInput()).thenReturn("5").thenReturn("2");

        application.start();

        verify(view).printList(list);
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutMovies() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        BibliotecaApp app = new BibliotecaApp(view, bookLibrary, movieLibrary);

        when(view.acceptMenuInput()).thenReturn("7").thenReturn("2");
        when(movieLibrary.listOfCheckedOutLibraryItems()).thenReturn(anyString());

        app.start();

        verify(view).printList(movieLibrary.listOfCheckedOutLibraryItems());
    }

    @Test
    public void applicationCallsLibraryCheckoutToCheckoutAMovie() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        BibliotecaApp app = new BibliotecaApp(view, bookLibrary, movieLibrary);

        when(view.acceptMenuInput()).thenReturn("8").thenReturn("2");

        app.start();

        verify(movieLibrary).checkout(anyString());
    }
}
