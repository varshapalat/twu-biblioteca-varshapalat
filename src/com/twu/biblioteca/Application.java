package com.twu.biblioteca;

public class Application {
    private Authenticator authenticator;
    private Dispatcher dispatcher;

    public Application(Authenticator authenticator, Dispatcher dispatcher) {
        this.authenticator = authenticator;
        this.dispatcher = dispatcher;
    }

    public void start(View view) {
        view.print(Message.Line);
        view.print(Message.Welcome);
        view.print(Message.Line);
        String choice;
        String option;
        do {
            view.print(Message.Initial);
            choice = view.acceptInput();
            if (choice.equals("1")) {
                view.print(Message.Login);
                String loginId = view.acceptInput();
                view.print(Message.EnterPassword);
                String password = view.acceptInput();
                if (authenticator.authenticate(loginId, password).equals("librarian")) {
                    do {
                        view.print(Message.LibrarianMainMenu);
                        option = view.acceptInput();
                        dispatcher.start(option);
                    }while (!option.equals("7"));
                    view.print(Message.SuccessfulLogout);
                } else if (authenticator.authenticate(loginId, password).equals("customer")) {
                    view.print(Message.CustomerMainMenu);
                } else {
                    view.print(Message.InvalidLogin);
                }
            } else {
            }
        } while (!choice.equals("2"));
    }
}
