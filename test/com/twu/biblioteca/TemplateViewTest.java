package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        ArrayList<Book> bookList = new ArrayList<Book>();
        Book bookOne = new Book("The Da Vinci Code", "Dan Brown", "2000");
        Book bookTwo = new Book("Kane and Abel", "Jeffrey Archer", "1979");
        Book bookThree = new Book("The Alchemist", "Paulo Coelho", "1988");
        bookList.add(bookOne);
        bookList.add(bookTwo);
        bookList.add(bookThree);
        TemplateView templateView = new TemplateView();

        templateView.printBookList(bookList);

        assertEquals("        The Da Vinci Code            Dan Brown       2000\n" +
                "            Kane and Abel       Jeffrey Archer       1979\n" +
                "            The Alchemist         Paulo Coelho       1988\n", outContent.toString());
    }
}
