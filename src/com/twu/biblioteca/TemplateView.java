package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class TemplateView {

    public void printBookList(ArrayList<LibraryItem> bookItems) {
        for (LibraryItem eachBook : bookItems) {
            Book book = (Book) eachBook;
            System.out.format("%25s %20s %10s\n", book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
    }

    public void printMovieList(ArrayList<LibraryItem> movieList) {
        for (LibraryItem eachMovie : movieList) {
            Movie movie = (Movie) eachMovie;
            System.out.format("%20s %20s %15s %5s\n", movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
        }
    }

    public void printCheckedOutBookList(HashMap<LibraryItem, String> checkedOutBookList) {
        String userId;
        for(LibraryItem eachBook: checkedOutBookList.keySet()) {
            Book book = (Book) eachBook;
            userId = checkedOutBookList.get(eachBook);
            System.out.format("%25s %15s %10s %10s\n",book.getTitle(), book.getAuthor(), book.getYearPublished(), userId);
        }
    }

}