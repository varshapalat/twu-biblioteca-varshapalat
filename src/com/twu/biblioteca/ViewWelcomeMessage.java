package com.twu.biblioteca;

public class ViewWelcomeMessage implements ViewMessage{
    String message = "****************Welcome!!**************** \n" +
            " ***********Biblioteca is now available***********\n";

    ViewMessage next;
    ViewMessage welcomeMessage;
    ViewMessage viewMainMenu;

    @Override
    public void instantiate(ViewMessage welcomeMessage, ViewMessage viewMainMenu) {
        this.welcomeMessage = welcomeMessage;
        this.viewMainMenu = viewMainMenu;
        this.next = viewMainMenu;
    }

    @Override
    public void render() {

    }

    @Override
    public ViewMessage next() {
        return null;
    }

}
