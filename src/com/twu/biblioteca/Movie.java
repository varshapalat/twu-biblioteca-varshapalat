package com.twu.biblioteca;

public class Movie implements LibraryItem{
    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public boolean hasTitle(String givenTitle) {
        return givenTitle.equals(name);
    }

    @Override
    public String toString() {
        return name + "\t" + year + "\t" + director + "\t" + rating + "\n";
    }
}
