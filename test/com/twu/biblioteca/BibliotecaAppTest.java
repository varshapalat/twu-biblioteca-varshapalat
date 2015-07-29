package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    @Test
    public void applicationCallsViewToPrintWelcomeMessage() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];
        when(view.acceptMenuInput()).thenReturn(2);

        application.start(view, books);

        verify(view).printWelcomeMessage();
    }

    @Test
    public void applicationCallsViewToPrintListOfBooksWithColumns() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];
        when(view.acceptMenuInput()).thenReturn(1).thenReturn(2);

        application.start(view, books);

        verify(view).printBookList(books);
    }

    @Test
    public void applicationCallsViewToPrintMainMenu() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];
        when(view.acceptMenuInput()).thenReturn(2);

        application.start(view, books);

        verify(view, atMost(2)).printMainMenu();
    }

    @Test
    public void applicationCallsViewToAcceptInputForMainMenuFromUser() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];
        when(view.acceptMenuInput()).thenReturn(2);

        application.start(view, books);

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToPrintLine() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];
        when(view.acceptMenuInput()).thenReturn(2);

        application.start(view, books);

        verify(view).acceptMenuInput();
    }

    @Test
    public void applicationCallsViewToPrintInvalidOption() {
        View view = mock(View.class);
        BibliotecaApp application = new BibliotecaApp();
        ArrayList<String>[] books = new ArrayList[10];
        when(view.acceptMenuInput()).thenReturn(3).thenReturn(2);

        application.start(view, books);

        verify(view).printInvalidMenuOption();
    }
}
