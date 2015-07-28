package com.twu.biblioteca;


import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();

        application.start(view);

        verify(view).printWelcomeMessage();
    }
}
