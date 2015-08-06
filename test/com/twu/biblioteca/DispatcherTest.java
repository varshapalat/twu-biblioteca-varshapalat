package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;


public class DispatcherTest {

    @Test
    public void applicationCallsViewToPrintListOfAvailableBooksWithColumns() {
        View view = mock(View.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        UserDetails userDetails = mock(UserDetails.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher dispatcher = new Dispatcher(view, messageView, templateView, bookLibrary, movieLibrary);
        ArrayList<LibraryItem> list = new ArrayList<LibraryItem>();

        dispatcher.start("1", "123-4567", userDetails);

        verify(templateView).printBookList(list);
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library movieLibrary = mock(Library.class);
        UserDetails userDetails = mock(UserDetails.class);
        Dispatcher dispatcher = new Dispatcher(view, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("5", "123-4567", userDetails);

        verify(bookLibrary).returnALibraryItem(anyString(), anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutBooks() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        UserDetails userDetails = mock(UserDetails.class);
        Dispatcher dispatcher = new Dispatcher(view, messageView, templateView, bookLibrary, movieLibrary);
        HashMap<LibraryItem, String> list = new HashMap<LibraryItem, String>();

        dispatcher.start("8", "123-4567", userDetails);

        verify(templateView).printCheckedOutBookList(list);
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutMovies() {
        View view = mock(View.class);
        UserDetails userDetails = mock(UserDetails.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        Dispatcher dispatcher = new Dispatcher(view, messageView, templateView, bookLibrary, movieLibrary);
        HashMap<LibraryItem, String> list = new HashMap<LibraryItem, String>();

        dispatcher.start("9", "123-4567", userDetails);

        verify(templateView).printCheckedOutMovieList(list);
    }

    @Test
    public void applicationCallsLibraryToCheckoutAMovie() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        UserDetails userDetails = mock(UserDetails.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(view, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("4", "123-4567", userDetails);

        verify(movieLibrary).checkout(anyString(), anyString());
    }

    @Test
    public void applicationCallsLibraryToReturnAMovie() {
        View view = mock(View.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        UserDetails userDetails = mock(UserDetails.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(view, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("6", "123-4567", userDetails);

        verify(movieLibrary).returnALibraryItem(anyString(), anyString());
    }
}
