package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;


public class DispatcherTest {

    @Test
    public void applicationCallsViewToPrintListOfAvailableBooksWithColumns() {
        Input input = mock(Input.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        UserDetails userDetails = mock(UserDetails.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        ArrayList<LibraryItem> list = new ArrayList<LibraryItem>();

        dispatcher.start("1", "123-4567", userList);

        verify(templateView).printBookList(list);
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        UserDetails userDetails = mock(UserDetails.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("5", "123-4567", userList);

        verify(bookLibrary).returnALibraryItem(anyString(), anyString());
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutBooks() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        UserDetails userDetails = mock(UserDetails.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        HashMap<LibraryItem, String> list = new HashMap<LibraryItem, String>();

        dispatcher.start("8", "123-4567", userList);

        verify(templateView).printCheckedOutBookList(list);
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutMovies() {
        Input input = mock(Input.class);
        UserDetails userDetails = mock(UserDetails.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        HashMap<LibraryItem, String> list = new HashMap<LibraryItem, String>();

        dispatcher.start("9", "123-4567", userList);

        verify(templateView).printCheckedOutMovieList(list);
    }

    @Test
    public void applicationCallsLibraryToCheckoutAMovie() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        UserDetails userDetails = mock(UserDetails.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("4", "123-4567", userList);

        verify(movieLibrary).checkout(anyString(), anyString());
    }

    @Test
    public void applicationCallsLibraryToReturnAMovie() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        UserDetails userDetails = mock(UserDetails.class);
        MessageView messageView = mock(MessageView.class);
        ArrayList<User> userList = new ArrayList<User>();

        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("6", "123-4567", userList  );

        verify(movieLibrary).returnALibraryItem(anyString(), anyString());
    }
}
