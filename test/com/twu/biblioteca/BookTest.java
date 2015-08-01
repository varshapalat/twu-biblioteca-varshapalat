package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void bookTellsIfItHasTheTitle() {
        Book book = new Book("The Alchemist", "Paulo Coelho", "1988");
        assertEquals(true, book.hasTitle("The Alchemist"));
    }
}
