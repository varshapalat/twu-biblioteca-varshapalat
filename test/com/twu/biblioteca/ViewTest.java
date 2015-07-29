package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ViewTest {

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
    public void viewCanPrintWelcomeMessage() {
        View welcomeMessage = new View();

        welcomeMessage.printWelcomeMessage();

        assertEquals("Welcome!! \n" + "Biblioteca is now available", outContent.toString());
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

        assertEquals("\n\n\nBOOKS AVAILABLE\n" +
                        "TITLE               AUTHOR         YEAR PUBLISHED\n" +
                        "The Da Vinci Code   Dan Brown      2000\n" +
                        "Kane and Abel       Jeffrey Archer 1979\n" +
                        "The Alchemist       Paulo Coelho   1988\n",
                outContent.toString());
    }

    @Test
    public void viewCanPrintMainMenu() {
        View view = new View();

        view.printMainMenu();

        assertEquals("\n\n\nMAIN MENU\n1.List Books\n\nEnter your choice:", outContent.toString());
    }

    @Test
    public void viewShouldTakeUserInput() {
        View view = new View();

        System.setIn(new ByteArrayInputStream("1".getBytes()));

        assertEquals(1, view.acceptMenuInput());
        System.setIn(System.in);
    }
}
