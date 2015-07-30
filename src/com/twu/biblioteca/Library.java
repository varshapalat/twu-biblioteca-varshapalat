package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    ArrayList<ArrayList<String>> listOfAllLibraryBooks;
    ArrayList<ArrayList<String>> listOfCheckedOutLibraryBooks = new ArrayList<ArrayList<String>>();

    public Library(ArrayList<ArrayList<String>> books) {
        listOfAllLibraryBooks = books;
    }

    public boolean checkout(String nameOfBookToCheckout) {
        boolean checkout = false;
        ArrayList<String> book = new ArrayList<String>();

        for (int i = 0; i < listOfAllLibraryBooks.size(); i++) {
            if (nameOfBookToCheckout.equals(listOfAllLibraryBooks.get(i).get(0))) {
                checkout = true;
                for (int j = 0; j < listOfAllLibraryBooks.get(0).size(); j++) {
                    book.add(listOfAllLibraryBooks.get(i).get(j));
                }
                listOfCheckedOutLibraryBooks.add(book);
            }
        }
        listOfAllLibraryBooks.remove(book);
        return checkout;
    }

    public void returnABook(String nameOfBookToReturn) {
        ArrayList<String> book = new ArrayList<String>();

        for (int i = 0; i < listOfCheckedOutLibraryBooks.size(); i++) {
            if(nameOfBookToReturn.equals(listOfCheckedOutLibraryBooks.get(i).get(0))) {
                book = listOfCheckedOutLibraryBooks.get(i);
                listOfCheckedOutLibraryBooks.remove(book);
            }
        }
        listOfAllLibraryBooks.add(book);
    }
}
