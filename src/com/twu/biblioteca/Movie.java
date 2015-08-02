package com.twu.biblioteca;

public class Movie implements LibraryItem{
    String name;
    String year;
    String director;
    String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + "\t" + year + "\t" + director + "\t" + rating;
    }
}
