package com.twu.biblioteca;


import org.junit.Test;

import static org.mockito.Mockito.*;


public class DispatcherTest {

    @Test
    public void applicationCallsViewToPrintListOfAvailableBooksWithColumns() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher application = new Dispatcher(view, bookLibrary, movieLibrary);
        String list = bookLibrary.listOfAvailableLibraryItems();

        when(view.acceptInput()).thenReturn("1").thenReturn("9");

        application.start();

        verify(view).printList(list);
    }

    @Test
    public void applicationCallsViewToPrintMainMenu() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher application = new Dispatcher(view, bookLibrary, movieLibrary);

        when(view.acceptInput()).thenReturn("9");

        application.start();

        verify(view, atMost(2)).print(Message.MainMenu);
    }

    @Test
    public void applicationCallsViewToAcceptInputForMainMenuFromUser() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher application = new Dispatcher(view, bookLibrary, movieLibrary);

        when(view.acceptInput()).thenReturn("9");

        application.start();

        verify(view).acceptInput();
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher application = new Dispatcher(view, bookLibrary, movieLibrary);

        when(view.acceptInput()).thenReturn("7").thenReturn("9");

        application.start();

        verify(bookLibrary).returnALibraryItem(anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutBooks() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher application = new Dispatcher(view, bookLibrary, movieLibrary);

        when(view.acceptInput()).thenReturn("3").thenReturn("9");
        application.start();

        verify(view).printList(anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutMovies() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher app = new Dispatcher(view, bookLibrary, movieLibrary);

        when(view.acceptInput()).thenReturn("4").thenReturn("9");
        when(movieLibrary.listOfCheckedOutLibraryItems()).thenReturn(anyString());

        app.start();

        verify(view).printList(movieLibrary.listOfCheckedOutLibraryItems());
    }

    @Test
    public void applicationCallsLibraryToCheckoutAMovie() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher app = new Dispatcher(view, bookLibrary, movieLibrary);

        when(view.acceptInput()).thenReturn("6").thenReturn("9");

        app.start();

        verify(movieLibrary).checkout(anyString());
    }

    @Test
    public void applicationCallsLibraryToReturnAMovie() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher app = new Dispatcher(view, bookLibrary, movieLibrary);

        when(view.acceptInput()).thenReturn("8").thenReturn("9");

        app.start();

        verify(movieLibrary).returnALibraryItem(anyString());
    }
}
