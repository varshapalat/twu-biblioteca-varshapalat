package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String [] args) {
        MessageView messageView = new MessageView();
        Input input = new Input();
        TemplateView templateView = new TemplateView();

        ArrayList<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        HashMap<LibraryItem, String> checkedOutBooks = new HashMap<LibraryItem, String>();

        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");

        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        availableBooks.add(bookThree);

        ArrayList<LibraryItem> availableMovies = new ArrayList<LibraryItem>();
        HashMap<LibraryItem, String> checkedOutMovies = new HashMap<LibraryItem, String>();

        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        Movie movieTwo = new Movie("Gladiator", "Ridley Scott", "2000", "7.6");
        Movie movieThree = new Movie("Matrix", "The Wachowskis", "1999", "8.2");

        availableMovies.add(movieOne);
        availableMovies.add(movieTwo);
        availableMovies.add(movieThree);

        Library bookLibrary = new Library(availableBooks, checkedOutBooks);
        Library movieLibrary = new Library(availableMovies, checkedOutMovies);
        Dispatcher dispatcher = new Dispatcher(input, messageView, templateView, bookLibrary, movieLibrary);

        User userOne = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");
        User userTwo = new User("abc-defg", "qwerty", "customer", "Nancy", "nancy@gmail.com", "8888888888");
        User userThree = new User("var-shap", "qwerty", "customer", "Varsha", "varsha@gmail.com", "7777777777");

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(userOne);
        userList.add(userTwo);
        userList.add(userThree);

        Authenticator authenticator = new Authenticator(userList);

        Application application = new Application(authenticator, dispatcher, userList);
        application.start(messageView, input);
    }
}
