package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    ArrayList<ArrayList<String>> listOfAllLibraryBooks;

    public Library(ArrayList<ArrayList<String>> books) {
        listOfAllLibraryBooks = books;
    }

    public ArrayList<ArrayList<String>> checkout(String s) {
        ArrayList<String> book = new ArrayList<String>();

        for (int i = 0; i < listOfAllLibraryBooks.size(); i++) {
            if (s.equals(listOfAllLibraryBooks.get(i).get(0))) {
                for (int j = 0; j < listOfAllLibraryBooks.get(0).size(); j++) {
                    book.add(listOfAllLibraryBooks.get(i).get(j));
                }
            }
        }
        listOfAllLibraryBooks.remove(book);
        return listOfAllLibraryBooks;
    }
}
