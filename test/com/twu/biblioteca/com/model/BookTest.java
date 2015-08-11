package com.twu.biblioteca.com.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void bookTellsIfItHasTheTitle() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");
        assertEquals(true, book.hasTitle("The Alchemist"));
    }

    @Test
    public void bookReturnsTitle() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");

        assertEquals("The Alchemist", book.getTitle());
    }

    @Test
    public void bookReturnsAuthor() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");

        assertEquals("Paulo Coelho", book.getAuthor());
    }

    @Test
    public void bookReturnsYearPublished() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");

        assertEquals("1988", book.getYearPublished());
    }
}
