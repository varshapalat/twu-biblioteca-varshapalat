package com.twu.biblioteca.com.controller;

import com.twu.biblioteca.com.controller.Application;
import com.twu.biblioteca.com.controller.Authenticator;
import com.twu.biblioteca.com.controller.Dispatcher;
import com.twu.biblioteca.com.model.User;
import com.twu.biblioteca.com.view.Input;
import com.twu.biblioteca.com.view.Message;
import com.twu.biblioteca.com.view.MessageView;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        Authenticator authenticator = mock(Authenticator.class);
        MessageView messageView = mock(MessageView.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        ArrayList<User> userList = new ArrayList<User>();
        Application application = new Application(authenticator, dispatcher, userList, messageView);
        Input input = mock(Input.class);

        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(input);

        verify(messageView).printMessage(Message.Welcome);
    }

    @Test
    public void applicationCallsViewToPrintIntialMessage() {
        Authenticator authenticator = mock(Authenticator.class);
        MessageView messageView = mock(MessageView.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        ArrayList<User> userList = new ArrayList<User>();
        Application application = new Application(authenticator, dispatcher, userList, messageView);
        Input input = mock(Input.class);

        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(input);

        verify(messageView, times(2)).printMessage(Message.Initial);
    }

    @Test
    public void applicationCallsViewToPrintLoginMessage() {
        Authenticator authenticator = mock(Authenticator.class);
        MessageView messageView = mock(MessageView.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        ArrayList<User> userList = new ArrayList<User>();
        Application application = new Application(authenticator, dispatcher, userList, messageView);
        Input input = mock(Input.class);

        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(input);

        verify(messageView, times(1)).printMessage(Message.Login);
    }


    @Test
    public void applicationCallsViewToAcceptChoiceInput() {
        Input input = mock(Input.class);
       Dispatcher dispatcher = mock(Dispatcher.class);
       MessageView messageView = mock(MessageView.class);
        Authenticator authenticator = mock(Authenticator.class);
       ArrayList<User> userList = new ArrayList<User>();

        Application application = new Application(authenticator, dispatcher, userList, messageView);


       when(input.acceptInput()).thenReturn("1").thenReturn("2").thenReturn("2").thenReturn("7").thenReturn("2").thenReturn("2");
        when(authenticator.authenticate(anyString(), anyString())).thenReturn("librarian");
        application.start(input);

        verify(input,times(5)).acceptInput();
    }

    @Test
    public void applicationCallsAuthenticatorToAuthenticateUser() {
        Input input = mock(Input.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        Authenticator authenticator = mock(Authenticator.class);
        ArrayList<User> userList = new ArrayList<User>();
        MessageView messageView = mock(MessageView.class);

        Application application = new Application(authenticator, dispatcher, userList, messageView);



        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate(anyString(), anyString())).thenReturn("librarian");

        application.start(input);

        verify(authenticator).authenticate("123-4567", "qwerty");
    }

    @Test
    public void applicationCallsDispatcherToPerformAppropriateFunctionalityForLibrarian() {
        Authenticator authenticator = mock(Authenticator.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        Input input = mock(Input.class);
        MessageView messageView = mock(MessageView.class);
        ArrayList<User> userList = new ArrayList<User>();

        Application application = new Application(authenticator, dispatcher, userList, messageView);


        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("6").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start( input);

        verify(dispatcher).start("6", "123-4567", userList);
    }

    @Test
    public void applicationCallsViewToPrintLibrarianMenu() {
        Authenticator authenticator = mock(Authenticator.class);
        MessageView messageView = mock(MessageView.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        ArrayList<User> userList = new ArrayList<User>();
        Application application = new Application(authenticator, dispatcher, userList, messageView);
        Input input = mock(Input.class);

        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(input);

        verify(messageView, times(1)).printMessage(Message.LibrarianMainMenu);
    }

    @Test
    public void applicationCallsViewToPrintCustomerMenu() {
        Authenticator authenticator = mock(Authenticator.class);
        MessageView messageView = mock(MessageView.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        ArrayList<User> userList = new ArrayList<User>();
        Application application = new Application(authenticator, dispatcher, userList, messageView);
        Input input = mock(Input.class);

        when(input.acceptInput()).thenReturn("1").thenReturn("abc-defg").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("abc-defg", "qwerty")).thenReturn("customer");
        application.start(input);

        verify(messageView, times(1)).printMessage(Message.CustomerMainMenu);
    }

    @Test
    public void applicationCallsDispatcherToPerformAppropriateFunctionalityForCustomer() {
        Authenticator authenticator = mock(Authenticator.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        Input input = mock(Input.class);
        MessageView messageView = mock(MessageView.class);
        ArrayList<User> userList = new ArrayList<User>();

        Application application = new Application(authenticator, dispatcher, userList, messageView);


        when(input.acceptInput()).thenReturn("1").thenReturn("abc-defg").thenReturn("qwerty").thenReturn("6").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("abc-defg", "qwerty")).thenReturn("customer");
        application.start(input);

        verify(dispatcher).start("6", "abc-defg", userList);
    }
}
