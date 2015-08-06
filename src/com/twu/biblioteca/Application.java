package com.twu.biblioteca;

import java.util.ArrayList;

public class Application {
    private Authenticator authenticator;
    private Dispatcher dispatcher;
    private UserDetails userDetails;

    public Application(Authenticator authenticator, Dispatcher dispatcher, UserDetails userDetails) {
        this.authenticator = authenticator;
        this.dispatcher = dispatcher;
        this.userDetails = userDetails;
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
                        dispatcher.start(option, loginId, userDetails);
                    }while (!option.equals("7"));
                    view.print(Message.SuccessfulLogout);
                } else if (authenticator.authenticate(loginId, password).equals("customer")) {
                    do {
                        view.print(Message.CustomerMainMenu);
                        option = view.acceptInput();
                        if(!(option.equals("8") || option.equals("9")))
                           dispatcher.start(option, loginId, userDetails);
                        else if(option.equals("8"))
                            dispatcher.start("10",loginId, userDetails);
                    }while (!option.equals("7"));
                    view.print(Message.SuccessfulLogout);
                } else {
                    view.print(Message.InvalidLogin);
                }
            } else {
            }
        } while (!choice.equals("2"));
    }
}
