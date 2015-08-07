package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    public void viewShouldTakeUserInput() {
        Input input = new Input();

        System.setIn(new ByteArrayInputStream("1".getBytes()));

        assertEquals("1", input.acceptInput());
    }


    @Test
    public void viewShouldTakeStringUserInputToCheckout() {
        Input input = new Input();

        System.setIn(new ByteArrayInputStream("The Alchemist".getBytes()));

        assertEquals("The Alchemist", input.acceptInput());
    }
}