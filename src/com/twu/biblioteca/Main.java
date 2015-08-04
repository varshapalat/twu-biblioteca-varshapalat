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
        Dispatcher dispatcher = new Dispatcher(view, bookLibrary, movieLibrary);

        User userOne = new User("123-4567", "qwerty");
        User userTwo = new User("abc-defg", "qwerty");
        User userThree = new User("var-shap", "qwerty");

        ArrayList<User> UserList = new ArrayList<User>();
        UserList.add(userOne);
        UserList.add(userTwo);
        UserList.add(userThree);

        Authenticator authenticator = new Authenticator(UserList);

        Application application = new Application();
        application.start(view);
    }
}
