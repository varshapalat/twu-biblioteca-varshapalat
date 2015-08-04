package com.twu.biblioteca;

public interface ViewMessage {
    //ViewMessage run(ViewMessage view);
    void render();
    ViewMessage next();
    void instantiate(ViewMessage welcomeMessage, ViewMessage viewMainMenu);
}
