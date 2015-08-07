package com.twu.biblioteca;


import java.util.ArrayList;

public class Application {
    private Authenticator authenticator;
    private Dispatcher dispatcher;
    private ArrayList<User> userList;

    public Application(Authenticator authenticator, Dispatcher dispatcher, ArrayList<User> userList) {
        this.authenticator = authenticator;
        this.dispatcher = dispatcher;
        this.userList = userList;
    }

    public void start(MessageView messageView, Input input) {
        messageView.printMessage(Message.Line);
        messageView.printMessage(Message.Welcome);
        messageView.printMessage(Message.Line);
        String choice;
        String option;
        do {
            messageView.printMessage(Message.Initial);
            choice = input.acceptInput();
            if (choice.equals("1")) {
                messageView.printMessage(Message.Login);
                String loginId = input.acceptInput();
                messageView.printMessage(Message.EnterPassword);
                String password = input.acceptInput();
                if (authenticator.authenticate(loginId, password).equals("librarian")) {
                    do {
                        messageView.printMessage(Message.LibrarianMainMenu);
                        option = input.acceptInput();
                        dispatcher.start(option, loginId, userList);
                    }while (!option.equals("7"));
                    messageView.printMessage(Message.SuccessfulLogout);
                } else if (authenticator.authenticate(loginId, password).equals("customer")) {
                    do {
                        messageView.printMessage(Message.CustomerMainMenu);
                        option = input.acceptInput();
                        if(!(option.equals("8") || option.equals("9") || option.equals("11")))
                           dispatcher.start(option, loginId, userList);
                        else if(option.equals("8"))
                            dispatcher.start("10",loginId, userList);
                    }while (!option.equals("7"));
                    messageView.printMessage(Message.SuccessfulLogout);
                } else {
                    messageView.printMessage(Message.InvalidLogin);
                }
            } else {
            }
        } while (!choice.equals("2"));
    }
}
