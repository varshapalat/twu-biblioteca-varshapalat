package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<LibraryItem> availableLibraryItems;
    private ArrayList<LibraryItem> checkedOutLibraryItems;

    public Library(ArrayList<LibraryItem> availableLibraryItems, ArrayList<LibraryItem> checkedOutLibraryItems) {
        this.availableLibraryItems = availableLibraryItems;
        this.checkedOutLibraryItems = checkedOutLibraryItems;
    }

    public boolean checkout(String nameOfBookToCheckout) {
        for (LibraryItem item : availableLibraryItems) {
            if (item.hasTitle(nameOfBookToCheckout)) {
                availableLibraryItems.remove(item);
                checkedOutLibraryItems.add(item);
                return true;
            }
        }
        return false;
    }

    public boolean returnALibraryItem(String nameOfBookToReturn) {
        for (LibraryItem item : checkedOutLibraryItems) {
            if (item.hasTitle(nameOfBookToReturn)) {
                checkedOutLibraryItems.remove(item);
                availableLibraryItems.add(item);
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

