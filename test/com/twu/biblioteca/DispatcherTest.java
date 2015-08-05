package com.twu.biblioteca;


import org.junit.Test;

import static org.mockito.Mockito.*;


public class DispatcherTest {

    @Test
    public void applicationCallsViewToPrintListOfAvailableBooksWithColumns() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher dispatcher = new Dispatcher(view, bookLibrary, movieLibrary);

        dispatcher.start("1");

        verify(view).printList(anyString());
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher dispatcher = new Dispatcher(view, bookLibrary, movieLibrary);

        dispatcher.start("5");

        verify(bookLibrary).returnALibraryItem(anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutBooks() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher dispatcher = new Dispatcher(view, bookLibrary, movieLibrary);

        dispatcher.start("8");

        verify(view).printList(anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutMovies() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher dispatcher = new Dispatcher(view, bookLibrary, movieLibrary);

        dispatcher.start("9");

        verify(view).printList(anyString());
    }

    @Test
    public void applicationCallsLibraryToCheckoutAMovie() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher dispatcher = new Dispatcher(view, bookLibrary, movieLibrary);

        dispatcher.start("4");

        verify(movieLibrary).checkout(anyString());
    }

    @Test
    public void applicationCallsLibraryToReturnAMovie() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher dispatcher = new Dispatcher(view, bookLibrary, movieLibrary);

        dispatcher.start("6");

        verify(movieLibrary).returnALibraryItem(anyString());
    }
}
