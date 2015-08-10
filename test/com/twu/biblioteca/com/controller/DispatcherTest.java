package com.twu.biblioteca.com.controller;


import com.twu.biblioteca.com.controller.Dispatcher;
import com.twu.biblioteca.com.model.Library;
import com.twu.biblioteca.com.model.LibraryItem;
import com.twu.biblioteca.com.model.User;
import com.twu.biblioteca.com.view.Input;
import com.twu.biblioteca.com.view.Message;
import com.twu.biblioteca.com.view.MessageView;
import com.twu.biblioteca.com.view.TemplateView;
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
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        ArrayList<LibraryItem> list = new ArrayList<LibraryItem>();

        dispatcher.start("1", "123-4567", userList);

        verify(templateView).printBookList(list);
    }

    @Test
    public void applicationCallsViewToPrintListOfAvailableMoviesWithColumns() {
        Input input = mock(Input.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        ArrayList<LibraryItem> list = new ArrayList<LibraryItem>();

        dispatcher.start("2", "abc-defg", userList);

        verify(templateView).printMovieList(list);
    }

    @Test
    public void applicationCallsViewToReturnABook() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

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
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        HashMap<LibraryItem, String> list = new HashMap<LibraryItem, String>();

        dispatcher.start("8", "123-4567", userList);

        verify(templateView).printCheckedOutBookList(list);
    }

    @Test
    public void applicationCallsViewToPrintListOfCheckedOutMovies() {
        Input input = mock(Input.class);
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

        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("4", "123-4567", userList);

        verify(movieLibrary).checkout(anyString(), anyString());
    }

    @Test
    public void applicationCallsLibraryToCheckoutABook() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("3", "123-4567", userList);

        verify(bookLibrary).checkout(anyString(), anyString());
    }

    @Test
    public void applicationCallsMessageViewToPrintSuccessfulCheckoutBook() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        when(bookLibrary.checkout(anyString(),anyString())).thenReturn(true);

        dispatcher.start("3", "123-4567", userList);

        verify(messageView).printMessage(Message.SuccesfulBookCheckout);
    }

    @Test
    public void applicationCallsMessageViewToPrintUnsuccessfulCheckoutBook() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        when(bookLibrary.checkout(anyString(), anyString())).thenReturn(false);

        dispatcher.start("3", "123-4567", userList);

        verify(messageView).printMessage(Message.UnsuccesfulBookCheckout);
    }

    @Test
    public void applicationCallsMessageViewToPrintSuccessfulCheckoutMovie() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        when(movieLibrary.checkout(anyString(),anyString())).thenReturn(true);

        dispatcher.start("4", "123-4567", userList);

        verify(messageView).printMessage(Message.SuccesfulMovieCheckout);
    }

    @Test
    public void applicationCallsMessageViewToPrintUnsuccessfulCheckoutMovie() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        when(movieLibrary.checkout(anyString(), anyString())).thenReturn(false);

        dispatcher.start("4", "123-4567", userList);

        verify(messageView).printMessage(Message.UnsuccesfulMovieCheckout);
    }

    @Test
    public void applicationCallsLibraryToReturnAMovie() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        ArrayList<User> userList = new ArrayList<User>();

        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("6", "123-4567", userList);

        verify(movieLibrary).returnALibraryItem(anyString(), anyString());
    }

    @Test
    public void applicationCallsMessageViewToPrintSuccessfulReturnMovie() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        ArrayList<User> userList = new ArrayList<User>();

        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        when(movieLibrary.returnALibraryItem(anyString(), anyString())).thenReturn(true);

        dispatcher.start("6", "123-4567", userList);

        verify(messageView).printMessage(Message.SuccessfulMovieReturn);
    }

    @Test
    public void applicationCallsMessageViewToPrintSuccessfulReturnBook() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        ArrayList<User> userList = new ArrayList<User>();

        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        when(bookLibrary.returnALibraryItem(anyString(), anyString())).thenReturn(true);

        dispatcher.start("5", "123-4567", userList);

        verify(messageView).printMessage(Message.SuccessfulBookReturn);
    }

    @Test
    public void applicationCallsMessageViewToPrintUnsuccessfulReturnBook() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        ArrayList<User> userList = new ArrayList<User>();

        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        when(bookLibrary.returnALibraryItem(anyString(), anyString())).thenReturn(false);

        dispatcher.start("5", "123-4567", userList);

        verify(messageView).printMessage(Message.UnsuccesfulBookReturn);
    }

    @Test
    public void applicationCallsMessageViewToPrintUnsuccessfulReturnMovie() {
        Input input = mock(Input.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        MessageView messageView = mock(MessageView.class);
        ArrayList<User> userList = new ArrayList<User>();

        TemplateView templateView = mock(TemplateView.class);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);
        when(movieLibrary.returnALibraryItem(anyString(), anyString())).thenReturn(false);

        dispatcher.start("6", "123-4567", userList);

        verify(messageView).printMessage(Message.UnsuccesfulMovieReturn);
    }

    @Test
    public void applicationCallsTemplateViewToPrintUserDetailsInProperFormat() {
        Input input = mock(Input.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("10", "123-4567", userList);

        verify(templateView).printUserDetails(userList, "123-4567");
    }

    @Test
    public void applicationCallsTemplateViewToPrintUserProfileInProperFormat() {
        Input input = mock(Input.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("11", "123-4567", userList);

        verify(templateView).printCustomerDetails(userList);
    }

    @Test
    public void applicationCallsMessageViewToPrintInvalidOption() {
        Input input = mock(Input.class);
        MessageView messageView = mock(MessageView.class);
        TemplateView templateView = mock(TemplateView.class);
        Library bookLibrary = mock(Library.class);
        Library movieLibrary = mock(Library.class);
        ArrayList<User> userList = new ArrayList<User>();

        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        dispatcher.start("12", "123-4567", userList);

        verify(messageView).printMessage(Message.InvaildMenuOption);
    }
}
