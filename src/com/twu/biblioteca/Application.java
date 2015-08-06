package com.twu.biblioteca;


public class Application {
    private Authenticator authenticator;
    private Dispatcher dispatcher;
    private UserDetails userDetails;

    public Application(Authenticator authenticator, Dispatcher dispatcher, UserDetails userDetails) {
        this.authenticator = authenticator;
        this.dispatcher = dispatcher;
        this.userDetails = userDetails;
    }

    public void start(MessageView messageView, View view) {
        messageView.printMessage(Message.Line);
        messageView.printMessage(Message.Welcome);
        messageView.printMessage(Message.Line);
        String choice;
        String option;
        do {
            messageView.printMessage(Message.Initial);
            choice = view.acceptInput();
            if (choice.equals("1")) {
                messageView.printMessage(Message.Login);
                String loginId = view.acceptInput();
                messageView.printMessage(Message.EnterPassword);
                String password = view.acceptInput();
                if (authenticator.authenticate(loginId, password).equals("librarian")) {
                    do {
                        messageView.printMessage(Message.LibrarianMainMenu);
                        option = view.acceptInput();
                        dispatcher.start(option, loginId, userDetails);
                    }while (!option.equals("7"));
                    messageView.printMessage(Message.SuccessfulLogout);
                } else if (authenticator.authenticate(loginId, password).equals("customer")) {
                    do {
                        messageView.printMessage(Message.CustomerMainMenu);
                        option = view.acceptInput();
                        if(!(option.equals("8") || option.equals("9")))
                           dispatcher.start(option, loginId, userDetails);
                        else if(option.equals("8"))
                            dispatcher.start("10",loginId, userDetails);
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
