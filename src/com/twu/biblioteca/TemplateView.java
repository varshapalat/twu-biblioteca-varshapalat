package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class TemplateView {

    public void printBookList(ArrayList<LibraryItem> bookItems) {
        System.out.format("%40s", "BOOKS\n");
        System.out.format("---------------------------------------------------------------------\n");
        System.out.format("%20s\t| %17s\t| %20s\n", "TITLE","AUTHOR", "YEAR PUBLISHED");
        System.out.format("---------------------------------------------------------------------\n");
        for (LibraryItem eachBook : bookItems) {
            Book book = (Book) eachBook;
            System.out.format("%25s\t| %20s\t| %10s\n", book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
        System.out.format("---------------------------------------------------------------------\n");
    }

    public void printMovieList(ArrayList<LibraryItem> movieList) {
        System.out.format("%40s", "MOVIES\n");
        System.out.format("-------------------------------------------------------------------------------------------\n");
        System.out.format("%19s\t\t| %17s\t| %15s\t| %10s\n","MOVIE NAME", "DIRECTOR", "YEAR", "RATING");
        System.out.format("-------------------------------------------------------------------------------------------\n");
        for (LibraryItem eachMovie : movieList) {
            Movie movie = (Movie) eachMovie;
            System.out.format("%20s\t| %20s\t| %15s\t| %5s\n", movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
        }
        System.out.format("-------------------------------------------------------------------------------------------\n");
    }

    public void printCheckedOutBookList(HashMap<LibraryItem, String> checkedOutBookList) {
        String userId;
        System.out.format("%40s", "BOOKS\n");
        System.out.format("-------------------------------------------------------------------------------------------------\n");
        System.out.format("%20s\t| %17s\t| %20s\t| %10s\n", "TITLE","AUTHOR", "YEAR PUBLISHED", "USER");
        System.out.format("-------------------------------------------------------------------------------------------------\n");
        for(LibraryItem eachBook: checkedOutBookList.keySet()) {
            Book book = (Book) eachBook;
            userId = checkedOutBookList.get(eachBook);
            System.out.format("%25s\t| %15s\t| %10s\t\t| %10s\n",book.getTitle(), book.getAuthor(), book.getYearPublished(), userId);
        }
        System.out.format("-------------------------------------------------------------------------------------------\n");
    }

    public void printCheckedOutMovieList(HashMap<LibraryItem, String> checkedOutMovieList) {
        String userId;
        System.out.format("%50s", "MOVIES\n");
        System.out.format("------------------------------------------------------------------------------------------------------------\n");
        System.out.format("%19s\t\t| %17s\t| %15s\t| %10s\t| %10s\n","MOVIE NAME", "DIRECTOR", "YEAR", "RATING", "USER");
        System.out.format("-------------------------------------------------------------------------------------------------------------\n");
        for(LibraryItem eachMovie: checkedOutMovieList.keySet()) {
            Movie movie = (Movie) eachMovie;
            userId = checkedOutMovieList.get(eachMovie);
            System.out.format("%20s\t| %20s\t| %15s\t| %5s\t\t| %10s\n", movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating(), userId);
        }
        System.out.format("-------------------------------------------------------------------------------------------\n");
    }

    public void printUserDetails(ArrayList<User> userList, String loginId) {
        for (User user: userList) {
            if(loginId.equals(user.getLoginId())) {
                System.out.format("MY PROFILE:\n");
                System.out.format("----------------------------------------------\n");
                System.out.format("NAME: %10s\n", user.getName());
                System.out.format("LOGIN ID: %10s\n", user.getLoginId());
                System.out.format("E-MAIL ID: %10s\n", user.getEmailId());
                System.out.format("PHONE NO: %10s\n", user.getPhoneNumber());
            }
        }
    }
}