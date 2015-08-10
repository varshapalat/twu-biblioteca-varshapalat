package com.twu.biblioteca.com.model;

import com.twu.biblioteca.com.model.LibraryItem;

public class Movie implements LibraryItem {
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

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }
}
