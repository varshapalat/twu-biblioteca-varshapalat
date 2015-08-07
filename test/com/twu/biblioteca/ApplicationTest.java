package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        Authenticator authenticator = mock(Authenticator.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        ArrayList<User> userList = new ArrayList<User>();
        Application application = new Application(authenticator, dispatcher, userList);
        Input input = mock(Input.class);
        MessageView messageView = mock(MessageView.class);

        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(messageView, input);

        verify(messageView).printMessage(Message.Welcome);
    }

   @Test
    public void applicationCallsViewToAcceptChoiceInput() {
        Input input = mock(Input.class);
       Dispatcher dispatcher = mock(Dispatcher.class);
        Authenticator authenticator = mock(Authenticator.class);
       ArrayList<User> userList = new ArrayList<User>();

        Application application = new Application(authenticator, dispatcher, userList);
       MessageView messageView = mock(MessageView.class);


       when(input.acceptInput()).thenReturn("1").thenReturn("2").thenReturn("2").thenReturn("7").thenReturn("2").thenReturn("2");
        when(authenticator.authenticate(anyString(), anyString())).thenReturn("librarian");
        application.start(messageView, input);

        verify(input,times(5)).acceptInput();
    }

    @Test
    public void applicationCallsAuthenticatorToAuthenticateUser() {
        Input input = mock(Input.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        Authenticator authenticator = mock(Authenticator.class);
        ArrayList<User> userList = new ArrayList<User>();

        Application application = new Application(authenticator, dispatcher, userList);
        MessageView messageView = mock(MessageView.class);



        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate(anyString(), anyString())).thenReturn("librarian");

        application.start(messageView, input);

        verify(authenticator).authenticate("123-4567", "qwerty");
    }

    @Test
    public void applicationCallsDispatcherToPerformAppropriateFunctionality() {
        Authenticator authenticator = mock(Authenticator.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        Input input = mock(Input.class);
        UserDetails userDetails = mock(UserDetails.class);
        ArrayList<User> userList = new ArrayList<User>();

        Application application = new Application(authenticator, dispatcher, userList);
        MessageView messageView = mock(MessageView.class);


        when(input.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("6").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(messageView, input);

        verify(dispatcher).start("6", "123-4567", userList);
    }
}
