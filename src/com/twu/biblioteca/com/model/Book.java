package com.twu.biblioteca.com.model;

public class Book implements LibraryItem {
    private String title;
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public boolean hasTitle(String givenTitle) {
        return givenTitle.equals(title);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }
}
