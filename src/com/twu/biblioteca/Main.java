package com.twu.biblioteca;


import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {
        BibliotecaApp application = new BibliotecaApp();
        View view = new View();

        ArrayList<String>[] books = new ArrayList[10];
        ArrayList<String> bookOne = new ArrayList<String>();
        bookOne.add("The Da Vinci Code");
        bookOne.add("Dan Brown");
        bookOne.add("2000");
        ArrayList<String> bookTwo = new ArrayList<String>();
        bookTwo.add("Kane and Abel");
        bookTwo.add("Jeffrey Archer");
        bookTwo.add("1979");
        ArrayList<String> bookThree = new ArrayList<String>();
        bookThree.add("The Alchemist");
        bookThree.add("Paulo Coelho");
        bookThree.add("1988");
        books[0] = bookOne;
        books[1] = bookTwo;
        books[2] = bookThree;

        application.start(view, books);
    }
}
