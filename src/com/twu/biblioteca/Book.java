package com.twu.biblioteca;

public class Book {
    String title;
    String author;
    String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public boolean hasTitle(String s) {
        if(s.equals(title))
        return true;
        return false;
    }

    @Override
    public String toString() {
        return title +"\t"+ author +"\t\t" + yearPublished + "\n";
    }
}
