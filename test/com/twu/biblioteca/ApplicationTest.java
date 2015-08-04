package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        Authenticator authenticator = mock(Authenticator.class);
        Application application = new Application(authenticator);
        View view = mock(View.class);

        when(view.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("2");
        when(authenticator.authenticate("123-4567", "qwerty")).thenReturn("librarian");
        application.start(view);

        verify(view).print(Message.Welcome);
    }

   @Test
    public void applicationCallsViewToAcceptChoiceInput() {
        View view = mock(View.class);
        Authenticator authenticator = mock(Authenticator.class);
        Application application = new Application(authenticator);

        when(view.acceptInput()).thenReturn("1").thenReturn("2").thenReturn("2").thenReturn("2").thenReturn("2").thenReturn("2");
        when(authenticator.authenticate(anyString(), anyString())).thenReturn("librarian");
        application.start(view);

        verify(view,times(4)).acceptInput();
    }

    @Test
    public void applicationCallsAuthenticatorToAuthenticateUser() {
        View view = mock(View.class);
        Authenticator authenticator = mock(Authenticator.class);
        Application application = new Application(authenticator);


        when(view.acceptInput()).thenReturn("1").thenReturn("123-4567").thenReturn("qwerty").thenReturn("2");
        when(authenticator.authenticate(anyString(), anyString())).thenReturn("librarian");

        application.start(view);

        verify(authenticator).authenticate("123-4567", "qwerty");
    }
}
