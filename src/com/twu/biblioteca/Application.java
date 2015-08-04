package com.twu.biblioteca;

public class Application {
    ViewMessage nextView;
    public Application(ViewMessage firstView) {
        nextView = firstView;
    }
    public void start(ViewMessage viewWelcomeMessage, ViewMessage viewMainMenu) {
        nextView.instantiate(viewWelcomeMessage, viewMainMenu);
        nextView.render();
        nextView = viewWelcomeMessage.next();
    }
}
