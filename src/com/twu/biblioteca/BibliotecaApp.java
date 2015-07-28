package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public void start(View view, ArrayList<String>[] books) {
        view.printWelcomeMessage();
        view.printBookList(books);
    }
}
