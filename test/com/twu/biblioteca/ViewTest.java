package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class ViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream original;
    InputStream originalIn;


    @Before
    public void setUpStreams() {
        original = System.out;
        originalIn = System.in;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
        System.setIn(originalIn);
    }

    @Test
    public void viewCanPrintWelcomeMessage() {
        View view = new View();

        view.print(Message.Welcome);

        assertEquals("****************Welcome!!**************** \n" +
                " ***********Biblioteca is now available***********\n", outContent.toString());
    }

    @Test
    public void viewCanPrintListOfBooks() {
        View view = new View();
        ArrayList<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checkedOutBooks = new ArrayList<LibraryItem>();

        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        availableBooks.add(bookOne);
        availableBooks.add(bookTwo);
        availableBooks.add(bookThree);
        Library library = new Library(availableBooks, checkedOutBooks);
        String list = library.listOfAvailableLibraryItems();
        view.printList(list);

        assertEquals("The Da Vinci Code\tDan Brown\t\t2000\n" +
                        " Kane and Abel\tJeffrey Archer\t\t1979\n" +
                        " The Alchemist\tPaulo Coelho\t\t1988\n" +
                        " ",
                outContent.toString());
    }

    @Test
    public void viewCanPrintMainMenu() {
        View view = new View();

        view.print(Message.MainMenu);

        assertEquals("\n" +
                "\n" +
                "\n" +
                " MAIN MENU\n" +
                "1.List Available Books\n" +
                "2.List Available Movies\n" +
                "3.Check Out Book\n" +
                "4.Check Out Movie\n" +
                "5.Return A Book\n" +
                "6.Return A Movie\n" +
                "7.Quit\n" +
                "8.List Checked Out Books\n" +
                "9.List Checked Out Movies\n" +
                "\n" +
                "Enter your choice:\n", outContent.toString());
    }

    @Test
    public void viewShouldTakeUserInput() {
        View view = new View();

        System.setIn(new ByteArrayInputStream("1".getBytes()));

        assertEquals("1", view.acceptInput());
    }

    @Test
    public void viewCanPrintLine() {
        View view = new View();

        view.print(Message.Line);

        assertEquals("------------------------------------------------------------\n", outContent.toString());
    }

    @Test
    public void viewCanPrintInvalidMenuOption() {
        View view = new View();

        view.print(Message.InvaildMenuOption);

        assertEquals("Select a valid Option!\n", outContent.toString());
    }

    @Test
    public void viewShouldTakeStringUserInputToCheckout() {
        View view = new View();

        System.setIn(new ByteArrayInputStream("The Alchemist".getBytes()));

        assertEquals("The Alchemist", view.acceptInput());
    }

    @Test
    public void viewCanPrintIfSuccessfulCheckout() {
        View view = new View();

        view.print(Message.SuccesfulBookCheckout);

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void viewCanPrintIfUnsuccessfulCheckout() {
        View view = new View();

        view.print(Message.UnsuccesfulBookCheckout);;

        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void viewCanPrintIfSuccessfulCheckIn() {
        View view = new View();

        view.print(Message.SuccessfulBookReturn);

        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void viewCanPrintIfUnsuccessfulCheckIn() {
        View view = new View();

        view.print(Message.UnsuccesfulBookReturn);

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @Test
    public void viewCanPrintHeaderOfBookList() {
        View view = new View();

        view.print(Message.BookList);

        assertEquals("BOOKS\n" +
                "-------------------------------------------------------\n" +
                "TITLE\t\tAUTHOR\t\tYEAR PUBLISHED\n", outContent.toString());
    }

    @Test
    public void viewCanPrintHeaderOfMovieList() {
        View view = new View();

        view.print(Message.MovieList);

        assertEquals("MOVIES\n" +
                "----------------------------------------------------\n" +
                "MOVIE NAME\tDIRECTOR\tYEAR\tRATING\n", outContent.toString());
    }

    @Test
    public void viewCanPrintIfSuccessfulMovieCheckout() {
        View view = new View();

        view.print(Message.SuccesfulMovieCheckout);

        assertEquals("Thank you! Enjoy the movie\n", outContent.toString());
    }

    @Test
    public void viewCanPrintIfUnsuccessfulMovieCheckout() {
        View view = new View();

        view.print(Message.UnsuccesfulMovieCheckout);

        assertEquals("That movie is not available", outContent.toString());
    }


    @Test
    public void viewCanPrintIfSuccessfulMovieReturn() {
        View view = new View();

        view.print(Message.SuccessfulMovieReturn);

        assertEquals("Thank you for returning the movie.\n", outContent.toString());
    }

    @Test
    public void viewCanPrintIfUnsuccessfulMovieReturn() {
        View view = new View();

        view.print(Message.UnsuccesfulMovieReturn);

        assertEquals("That is not a valid movie to return.\n", outContent.toString());
    }
}