package com.twu.biblioteca;

import java.util.ArrayList;


public class Main {

    public static void main(String [] args) {
        BibliotecaApp application = new BibliotecaApp();
        View view = new View();

        ArrayList<Book> books = new ArrayList<Book>();

        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        Library library = new Library(books);

        application.start(view, library);
    }
}
