package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {

    public void start(View view, ArrayList<ArrayList<String>> books, Library library) {
        String choice = "0";
        view.printLine();
        view.printWelcomeMessage();
        view.printLine();

        while (!choice.equals("2")) {
            view.printMainMenu();
            choice = view.acceptMenuInput();
            if (choice.equals("1")) {
                view.printBookList(books);
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                String bookName = view.acceptStringMenuInput();
                if(library.checkout(bookName))
                    view.printSuccessfulCheckout();
                else
                    view.printUnsuccessfullCheckout();
            } else if (choice.equals("4")) {
                String bookName = view.acceptStringMenuInput();
                library.returnABook(bookName);
            } else {
                view.printInvalidMenuOption();
                view.printLine();
            }
        }
    }
}
