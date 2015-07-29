package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {

    public void start(View view, ArrayList<String>[] books) {
        view.printWelcomeMessage();
        view.printMainMenu();
        int choice = view.acceptMenuInput();
        if(choice == 1)
        {
            view.printBookList(books);
        }
    }
}
