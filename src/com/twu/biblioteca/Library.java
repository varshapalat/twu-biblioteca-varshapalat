package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    ArrayList<Book> listOfAvailableLibraryBooks;
    ArrayList<Book> listOfCheckedOutLibraryBooks;

    public Library(ArrayList<Book> listOfAvailableBooks, ArrayList<Book> listOfCheckedOutBooks) {
        listOfAvailableLibraryBooks = listOfAvailableBooks;
        listOfCheckedOutLibraryBooks = listOfCheckedOutBooks;
    }

    public boolean checkout(String nameOfBookToCheckout) {
        for (Book book : listOfAvailableLibraryBooks) {
            if (book.hasTitle(nameOfBookToCheckout)) {
                listOfAvailableLibraryBooks.remove(book);
                listOfCheckedOutLibraryBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnABook(String nameOfBookToReturn) {
        for (Book book : listOfCheckedOutLibraryBooks) {
            if (book.hasTitle(nameOfBookToReturn)) {
                listOfCheckedOutLibraryBooks.remove(book);
                listOfAvailableLibraryBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public String toPrintListOfAvailableBook() {
        String list = "";
        for (int i = 0; i < listOfAvailableLibraryBooks.size(); i++) {
            list += String.format("%s ", listOfAvailableLibraryBooks.get(i));
        }
        return list;
    }

    public String toPrintListOfCheckedOutBook() {
        String list = "";
        for (int i = 0; i < listOfCheckedOutLibraryBooks.size(); i++) {
            list += String.format("%s ", listOfCheckedOutLibraryBooks.get(i));
        }
        return list;
    }
}

