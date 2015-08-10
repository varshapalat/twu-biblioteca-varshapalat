package com.twu.biblioteca.com.model;

import com.twu.biblioteca.com.model.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void movieTellsIfItHasTheTitle() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowskis", "8.2");

        assertEquals(true, movie.hasTitle("Matrix"));
    }

    @Test
    public void movieReturnsMovieName() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowskis", "8.2");

        assertEquals("Matrix", movie.getName());
    }

    @Test
    public void movieReturnsMovieDirector() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowskis", "8.2");

        assertEquals("The Wachowskis", movie.getDirector());
    }

    @Test
    public void movieReturnsMovieRating() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowskis", "8.2");

        assertEquals("8.2", movie.getRating());
    }

    @Test
    public void movieReturnsMovieYear() {
        Movie movie = new Movie("Matrix", "1999", "The Wachowskis", "8.2");

        assertEquals("1999", movie.getYear());
    }

}
