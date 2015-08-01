package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    ArrayList<Book> listOfAvailableLibraryBooks;
    ArrayList<Book> listOfCheckedOutLibraryBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> books) {
        listOfAvailableLibraryBooks = books;
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
}

