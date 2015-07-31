package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    ArrayList<ArrayList<String>> listOfAllLibraryBooks;
    ArrayList<ArrayList<String>> listOfCheckedOutLibraryBooks = new ArrayList<ArrayList<String>>();

    public Library(ArrayList<ArrayList<String>> books) {
        listOfAllLibraryBooks = books;
    }

    public boolean checkout(String nameOfBookToCheckout) {
        for (ArrayList<String> book : listOfAllLibraryBooks) {
            if (book.get(0).equals(nameOfBookToCheckout)) {
                listOfAllLibraryBooks.remove(book);
                listOfCheckedOutLibraryBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnABook(String nameOfBookToReturn) {
        ArrayList<String> book = new ArrayList<String>();
        boolean checkin = false;
        for (int i = 0; i < listOfCheckedOutLibraryBooks.size(); i++) {
            if (nameOfBookToReturn.equals(listOfCheckedOutLibraryBooks.get(i).get(0))) {
                checkin = true;
                book = listOfCheckedOutLibraryBooks.get(i);
                listOfCheckedOutLibraryBooks.remove(book);
            }
        }
        if (checkin) listOfAllLibraryBooks.add(book);
        return checkin;
    }
}

