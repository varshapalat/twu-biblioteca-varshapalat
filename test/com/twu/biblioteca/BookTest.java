package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void bookTellsIfItHasTheTitle() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");
        assertEquals(true, book.hasTitle("The Alchemist"));
    }

    @Test
    public void printEachBookDetail() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");

        assertEquals("The Alchemist\tPaulo Coelho\t\t1988\n", book.toString());
    }

    @Test
    public void getBookTitle() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");

        assertEquals("The Alchemist", book.getTitle());
    }

    @Test
    public void getBookAuthor() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");

        assertEquals("Paulo Coelho", book.getAuthor());
    }
    @Test
    public void getBookPublishedYear() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");

        assertEquals("1988", book.getYearPublished());
    }
}
