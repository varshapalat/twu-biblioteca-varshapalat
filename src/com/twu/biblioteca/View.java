package com.twu.biblioteca;


import java.util.ArrayList;

public class View {

    String welcomeMessage = "Welcome!! \nBiblioteca is now available";

    public void printWelcomeMessage() {
        System.out.print(welcomeMessage);
    }

    public void printBookList(ArrayList<String> books) {
        for(int i = 0; i < books.size(); i++)
        {
            System.out.println(books.get(i));
        }
    }
}
