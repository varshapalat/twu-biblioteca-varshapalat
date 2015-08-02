package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    ArrayList<LibraryItem> availableLibraryItems;
    ArrayList<LibraryItem> checkedOutLibraryItems;

    public Library(ArrayList<LibraryItem> availableLibraryItems, ArrayList<LibraryItem> checkedOutLibraryItems) {
        this.availableLibraryItems = availableLibraryItems;
        this.checkedOutLibraryItems = checkedOutLibraryItems;
    }

    public boolean checkout(String nameOfBookToCheckout) {
        for (LibraryItem book : availableLibraryItems) {
            if (book.hasTitle(nameOfBookToCheckout)) {
                availableLibraryItems.remove(book);
                checkedOutLibraryItems.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnABook(String nameOfBookToReturn) {
        for (LibraryItem book : checkedOutLibraryItems) {
            if (book.hasTitle(nameOfBookToReturn)) {
                checkedOutLibraryItems.remove(book);
                availableLibraryItems.add(book);
                return true;
            }
        }
        return false;
    }

    public String listOfAvailableLibraryItems() {
        String list = "";
        for (int i = 0; i < availableLibraryItems.size(); i++) {
            list += String.format("%s ", availableLibraryItems.get(i));
        }
        return list;
    }

    public String listOfCheckedOutLibraryItems() {
        String list = "";
        for (int i = 0; i < checkedOutLibraryItems.size(); i++) {
            list += String.format("%s ", checkedOutLibraryItems.get(i));
        }
        return list;
    }
}

