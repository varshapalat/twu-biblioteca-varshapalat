package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        Application application = new Application();
        View view = mock(View.class);

        when(view.acceptInput()).thenReturn("1");
        application.start(view);

        verify(view).print(Message.Welcome);
    }

   @Test
    public void applicationCallsViewToAcceptChoiceInput() {
        View view = mock(View.class);
        Application application = new Application();

        when(view.acceptInput()).thenReturn("1");
        application.start(view);

        verify(view,times(3)).acceptInput();
    }
}
