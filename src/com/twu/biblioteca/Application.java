package com.twu.biblioteca;

public class Application {
    Authenticator authenticator;

    public Application(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public void start(View view) {
        view.print(Message.Line);
        view.print(Message.Welcome);
        view.print(Message.Line);
        String choice;
        do {
            view.print(Message.Initial);
            choice = view.acceptInput();
            if (choice.equals("1")) {
                view.print(Message.Login);
                String loginId = view.acceptInput();
                view.print(Message.EnterPassword);
                String password = view.acceptInput();
                if (authenticator.authenticate(loginId, password).equals("librarian")) {

                } else if (authenticator.authenticate(loginId, password).equals("customer")) {

                } else {
                    view.print(Message.InvalidLogin);
                }
            } else {
            }
        } while (!choice.equals("2"));
    }
}
