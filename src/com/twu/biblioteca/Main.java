package com.twu.biblioteca;

import java.util.ArrayList;


public class Main {

    public static void main(String [] args) {
        View view = new View();

        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");

        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        availableBooks.add(bookThree);

        ArrayList<Movie> availableMovies = new ArrayList<Movie>();

        Movie movieOne = new Movie("Troy", "Wolfgang Petersen", "2004", "8");
        Movie movieTwo = new Movie("Gladiator", "Ridley Scott", "2000", "7.6");
        Movie movieThree = new Movie("A Beautiful Mind", "Ron Howard", "2001", "8.2");

        availableMovies.add(movieOne);
        availableMovies.add(movieTwo);
        availableMovies.add(movieThree);

        Library library = new Library(availableBooks, checkedOutBooks);
        BibliotecaApp application = new BibliotecaApp(view, library);

        application.start();
    }
}
