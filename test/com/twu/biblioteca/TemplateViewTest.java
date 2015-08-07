package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TemplateViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream original;

    @Before
    public void setUpStreams() {
        original = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }

    @Test
    public void printListOfBooks() {
        ArrayList<LibraryItem> bookList = new ArrayList<LibraryItem>();
        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        bookList.add(bookOne);
        bookList.add(bookTwo);
        bookList.add(bookThree);
        TemplateView templateView = new TemplateView();

        templateView.printBookList(bookList);

        assertEquals("                                  BOOKS\n" +
                "---------------------------------------------------------------------\n" +
                "               TITLE\t|            AUTHOR\t|       YEAR PUBLISHED\n" +
                "---------------------------------------------------------------------\n" +
                "        The Da Vinci Code\t|            Dan Brown\t|       2000\n" +
                "            Kane and Abel\t|       Jeffrey Archer\t|       1979\n" +
                "            The Alchemist\t|         Paulo Coelho\t|       1988\n" +
                "---------------------------------------------------------------------\n", outContent.toString());
    }

    @Test
    public void printListOfMovies() {
        ArrayList<LibraryItem> movieList = new ArrayList<LibraryItem>();
        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        Movie movieTwo = new Movie("Gladiator", "Ridley Scott", "2000", "7.6");
        Movie movieThree = new Movie("Matrix", "The Wachowskis", "1999", "8.2");
        movieList.add(movieOne);
        movieList.add(movieTwo);
        movieList.add(movieThree);
        TemplateView templateView = new TemplateView();

        templateView.printMovieList(movieList);

        assertEquals("                                 MOVIES\n" +
                "-------------------------------------------------------------------------------------------\n" +
                "         MOVIE NAME\t\t|          DIRECTOR\t|            YEAR\t|     RATING\n" +
                "-------------------------------------------------------------------------------------------\n" +
                "           Gone Girl\t|        David Fincher\t|            2014\t|     8\n" +
                "           Gladiator\t|         Ridley Scott\t|            2000\t|   7.6\n" +
                "              Matrix\t|       The Wachowskis\t|            1999\t|   8.2\n" +
                "-------------------------------------------------------------------------------------------\n", outContent.toString());
    }

    @Test
    public void printListOfCheckedOutBooks() {
        TemplateView templateView = new TemplateView();
        HashMap<LibraryItem, String> bookList = new HashMap<LibraryItem, String>();
        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        bookList.put(bookOne, "123-4567");
        templateView.printCheckedOutBookList(bookList);

        assertEquals("                                  BOOKS\n" +
                "-------------------------------------------------------------------------------------------------\n" +
                "               TITLE\t|            AUTHOR\t|       YEAR PUBLISHED\t|       USER\n" +
                "-------------------------------------------------------------------------------------------------\n" +
                "        The Da Vinci Code\t|       Dan Brown\t|       2000\t\t|   123-4567\n" +
                "-------------------------------------------------------------------------------------------\n", outContent.toString());
    }

    @Test
    public void printListOfCheckedOutMovies() {
        TemplateView templateView = new TemplateView();
        HashMap<LibraryItem, String> movieList = new HashMap<LibraryItem, String>();
        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        movieList.put(movieOne, "123-4567");
        templateView.printCheckedOutMovieList(movieList);

        assertEquals("                                           MOVIES\n" +
                "------------------------------------------------------------------------------------------------------------\n" +
                "         MOVIE NAME\t\t|          DIRECTOR\t|            YEAR\t|     RATING\t|       USER\n" +
                "-------------------------------------------------------------------------------------------------------------\n" +
                "           Gone Girl\t|        David Fincher\t|            2014\t|     8\t\t|   123-4567\n" +
                "-------------------------------------------------------------------------------------------\n", outContent.toString());
    }

    @Test
    public void printUserProfileInformation() {
        TemplateView templateView = new TemplateView();
        HashMap<LibraryItem, String> movieList = new HashMap<LibraryItem, String>();
        Movie movieOne = new Movie("Gone Girl", "David Fincher", "2014", "8");
        movieList.put(movieOne, "123-4567");
        templateView.printCheckedOutMovieList(movieList);

        assertEquals("                                           MOVIES\n" +
                "------------------------------------------------------------------------------------------------------------\n" +
                "         MOVIE NAME\t\t|          DIRECTOR\t|            YEAR\t|     RATING\t|       USER\n" +
                "-------------------------------------------------------------------------------------------------------------\n" +
                "           Gone Girl\t|        David Fincher\t|            2014\t|     8\t\t|   123-4567\n" +
                "-------------------------------------------------------------------------------------------\n", outContent.toString());
    }
}
