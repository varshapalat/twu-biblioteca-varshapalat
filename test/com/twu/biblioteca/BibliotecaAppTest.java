package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];

        application.start(view, books);

        verify(view).printWelcomeMessage();
    }

    @Test
    public void applicationCallsViewToPrintListOfBooksWithColumns() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];
        when(view.acceptMenuInput()).thenReturn(1);

        application.start(view, books);

        verify(view).printBookList(books);
    }

    @Test
    public void applicationCallsViewToPrintMainMenu() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];

        application.start(view, books);

        verify(view).printMainMenu();
    }

    @Test
    public void applicationCallsViewToAcceptInputForMainMenuFromUser() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];

        application.start(view, books);

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToPrintLine() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];

        application.start(view, books);

        verify(view).acceptMenuInput();
    }
}
