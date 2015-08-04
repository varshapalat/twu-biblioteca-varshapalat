package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {
    @Test
    public void ApplicationCallsInstantiateMethodOfViewMessage() {
        ViewMessage firstView = mock(ViewWelcomeMessage.class);
        ViewMessage welcomeMessage = mock(ViewWelcomeMessage.class);
        ViewMessage mainMenu = mock(ViewMainMenu.class);
        Application application = new Application(firstView);

        application.start(welcomeMessage, mainMenu);

        verify(firstView).instantiate(welcomeMessage, mainMenu);
    }
}
