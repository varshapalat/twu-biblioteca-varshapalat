package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
        View book = new View();
        ArrayList<String> books = new ArrayList<String>();
        books.add("The Da Vinci Code");
        books.add("Kane And Abel");
        books.add("The Five People You Meet In Heaven");

        book.printBookList(books);

        assertEquals("The Da Vinci Code\nKane And Abel\nThe Five People You Meet In Heaven\n", outContent.toString());
    }
}
