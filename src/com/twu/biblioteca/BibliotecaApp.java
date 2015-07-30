package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {

    public void start(View view, ArrayList<ArrayList<String>> books) {
        int choice = 0;
        view.printLine();
        view.printWelcomeMessage();
        view.printLine();

        while(choice != 2) {
            view.printMainMenu();
            choice = view.acceptMenuInput();
            switch (choice) {
                case 1:
                    view.printBookList(books);
                    break;
                case 2:
                    break;
                default:
                    view.printInvalidMenuOption();
                    view.printLine();
                    break;
            }
        }
    }
}
