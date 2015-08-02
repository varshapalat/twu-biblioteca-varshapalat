package com.twu.biblioteca;

public class Book implements LibraryItem{
    String title;
    String author;
    String yearPublished;

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
}
