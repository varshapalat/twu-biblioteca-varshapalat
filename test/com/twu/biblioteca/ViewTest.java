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
        View welcomeMessage = new View();

        welcomeMessage.printWelcomeMessage();

        assertEquals("Welcome!! \n" + "Biblioteca is now available\n", outContent.toString());
    }

    @Test
    public void viewCanPrintListOfBooks() {
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

        view.printBookList(books);

        assertEquals("\n" +
                        "\n" +
                        "\n" +
                        "BOOKS AVAILABLE\n" +
                        "TITLE               AUTHOR         YEAR PUBLISHED\n" +
                        "The Da Vinci Code    Dan Brown       2000 \n" +
                        "Kane and Abel        Jeffrey Archer  1979 \n" +
                        "The Alchemist        Paulo Coelho    1988 \n",
                outContent.toString());
    }

    @Test
    public void viewCanPrintMainMenu() {
        View view = new View();

        view.printMainMenu();

        assertEquals("\n\n\nMAIN MENU\n1.List Books\nEnter your choice:\n", outContent.toString());
    }

    @Test
    public void viewShouldTakeUserInput() {
        View view = new View();

        System.setIn(new ByteArrayInputStream("1".getBytes()));

        assertEquals(1, view.acceptMenuInput());
    }

    @Test
    public void viewCanPrintLine() {
        View view = new View();

        view.printLine();

        assertEquals("------------------------------------------------------------\n", outContent.toString());
    }

    @Test
    public void viewCanPrintInvalidMenuOption() {
        View view = new View();

        view.printInvalidMenuOption();

        assertEquals("Select a valid Option!\n", outContent.toString());
    }
}

