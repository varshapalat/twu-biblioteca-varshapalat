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
        view.print(Message.Initial);
        String choice = view.acceptInput();
        if (choice.equals("1")) {
            view.print(Message.Login);
            String loginId = view.acceptInput();
            view.print(Message.EnterPassword);
            String password = view.acceptInput();
           if(authenticator.authenticate(loginId, password))
                System.out.print("this works!!");
            else
                System.out.print("not!!");
        }
        else {
        }
    }
}
