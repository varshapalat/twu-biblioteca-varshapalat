package com.twu.biblioteca.com.controller;


import com.twu.biblioteca.com.model.User;
import com.twu.biblioteca.com.view.Input;
import com.twu.biblioteca.com.view.Message;
import com.twu.biblioteca.com.view.MessageView;

import java.util.ArrayList;

public class Application {
    private Authenticator authenticator;
    private Dispatcher dispatcher;
    private ArrayList<User> userList;
    private MessageView messageView;

    public Application(Authenticator authenticator, Dispatcher dispatcher, ArrayList<User> userList, MessageView messageView) {
        this.authenticator = authenticator;
        this.dispatcher = dispatcher;
        this.userList = userList;
        this.messageView = messageView;
    }

    public void start(Input input) {
        messageView.printMessage(Message.Welcome);
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
                    } while (!option.equals("7"));
                    messageView.printMessage(Message.SuccessfulLogout);
                } else if (authenticator.authenticate(loginId, password).equals("customer")) {
                    do {
                        messageView.printMessage(Message.CustomerMainMenu);
                        option = input.acceptInput();
                        if (!(option.equals("8") || option.equals("9") || option.equals("11")))
                            dispatcher.start(option, loginId, userList);
                        else if (option.equals("8"))
                            dispatcher.start("10", loginId, userList);
                    } while (!option.equals("7"));
                    messageView.printMessage(Message.SuccessfulLogout);
                } else {
                    messageView.printMessage(Message.InvalidLogin);
                }
            }
        } while (!choice.equals("2"));
    }
}
