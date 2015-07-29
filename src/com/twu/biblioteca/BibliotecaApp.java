package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {

    public void start(View view, ArrayList<String>[] books) {
        int choice;
        view.printLine();
        view.printWelcomeMessage();
        view.printLine();
        view.printMainMenu();
        choice = view.acceptMenuInput();
        if(choice == 1) {
            view.printLine();
            view.printBookList(books);
        }
        else {
            view.printInvalidMenuOption();
        }
        view.printLine();
    }
}
