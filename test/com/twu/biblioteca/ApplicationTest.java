package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        Authenticator authenticator = mock(Authenticator.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        Application application = new Application(authenticator, dispatcher);
        View view = mock(View.class);

        when(view.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(view);

        verify(view).print(Message.Welcome);
    }

   @Test
    public void applicationCallsViewToAcceptChoiceInput() {
        View view = mock(View.class);
       Dispatcher dispatcher = mock(Dispatcher.class);
        Authenticator authenticator = mock(Authenticator.class);
        Application application = new Application(authenticator, dispatcher);

        when(view.acceptInput()).thenReturn("1").thenReturn("2").thenReturn("2").thenReturn("7").thenReturn("2").thenReturn("2");
        when(authenticator.authenticate(anyString(), anyString())).thenReturn("librarian");
        application.start(view);

        verify(view,times(5)).acceptInput();
    }

    @Test
    public void applicationCallsAuthenticatorToAuthenticateUser() {
        View view = mock(View.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        Authenticator authenticator = mock(Authenticator.class);
        Application application = new Application(authenticator, dispatcher);


        when(view.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate(anyString(), anyString())).thenReturn("librarian");

        application.start(view);

        verify(authenticator).authenticate("123-4567", "qwerty");
    }

    @Test
    public void applicationCallsDispatcherToPerformAppropriateFunctionality() {
        Authenticator authenticator = mock(Authenticator.class);
        Dispatcher dispatcher = mock(Dispatcher.class);
        View view = mock(View.class);
        Application application = new Application(authenticator, dispatcher);

        when(view.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("6").thenReturn("7").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(view);

        verify(dispatcher, times(2)).start(anyString(), anyString());
    }
}
