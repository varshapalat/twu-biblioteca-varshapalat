package com.twu.biblioteca;

import java.util.ArrayList;

public class TemplateView {

    public void printBookList(ArrayList<Book> bookItems) {
        for (Book book:bookItems) {
            System.out.format("%25s %20s %10s\n", book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
    }
}
