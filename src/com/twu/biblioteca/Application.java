package com.twu.biblioteca;

public class Application {

    public void start(View view) {
        view.print(Message.Line);
        view.print(Message.Welcome);
        view.print(Message.Line);
        view.print(Message.Initial);
        String choice = view.acceptInput();
        if (choice.equals("1")) {

        }
        else {
        }
    }
}
