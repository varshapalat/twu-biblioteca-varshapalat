package com.twu.biblioteca;

public class Book implements LibraryItem{
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

    @Override
    public String toString() {
        return title +"\t"+ author +"\t\t" + yearPublished + "\n";
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
