package com.twu.biblioteca;

import java.util.ArrayList;


public class Main {

    public static void main(String [] args) {
        View view = new View();

        ArrayList<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutBooks = new ArrayList<LibraryItem>();

        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");

        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        availableBooks.add(bookThree);

        ArrayList<LibraryItem> availableMovies = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutMovies = new ArrayList<LibraryItem>();

        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        Movie movieTwo = new Movie("Gladiator", "Ridley Scott", "2000", "7.6");
        Movie movieThree = new Movie("Matrix", "The Wachowskis", "1999", "8.2");

        availableMovies.add(movieOne);
        availableMovies.add(movieTwo);
        availableMovies.add(movieThree);

        Library bookLibrary = new Library(availableBooks, checkedOutBooks);
        Library movieLibrary = new Library(availableMovies, checkedOutMovies);

        ViewWelcomeMessage viewWelcomeMessage = new ViewWelcomeMessage();
        ViewMainMenu viewMainMenu = new ViewMainMenu();
        Application app = new Application(viewWelcomeMessage);

        app.start(viewWelcomeMessage, viewMainMenu);
    }
}
