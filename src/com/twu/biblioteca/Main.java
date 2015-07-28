package com.twu.biblioteca;


import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {
        BibliotecaApp application = new BibliotecaApp();
        View view = new View();
        application.start(view);

        ArrayList<String> books = new ArrayList<String>();
        books.add("The Da Vinci Code");
        books.add("Kane And Abel");
        books.add("The Five People You Meet In Heaven");
        view.printBookList(books);
    }
}
