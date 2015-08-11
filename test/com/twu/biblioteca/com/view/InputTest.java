package com.twu.biblioteca.com.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class InputTest {

    InputStream originalIn;


    @Before
    public void setUpStreams() {
        originalIn = System.in;
    }

    @After
    public void cleanUpStreams() {
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