package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void printEachMovieDetail() {
        Movie movie = new Movie("Troy", "2004", "Wolfgang Petersen", "5");

        assertEquals("Troy\t2004\tWolfgang Petersen\t5\n", movie.toString());
    }

    @Test
    public void movieTellsIfItHasTheTitle() {
        Movie movie = new Movie("Matrix", "The Wachowskis", "1999", "8.2");

        assertEquals(true, movie.hasTitle("Matrix"));
    }
}
