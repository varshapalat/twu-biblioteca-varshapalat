package com.twu.biblioteca.com.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MessageViewTest {

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
    public void messageViewCanPrintAnyMessagePassedToIt() {
        MessageView view = new MessageView();

        view.printMessage(Message.Welcome);

        assertEquals("-----------------------------------------------------------------\n" +
                "****************Welcome!!**************** \n" +
                " ***********Biblioteca is now available***********\n" +
                "-----------------------------------------------------------------\n", outContent.toString());
    }
}
