package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    public ArrayList<LibraryItem> availableLibraryItems;
    private HashMap<LibraryItem, String> checkedOutLibraryItems;

    public Library(ArrayList<LibraryItem> availableLibraryItems, HashMap<LibraryItem, String> checkedOutLibraryItems) {
        this.availableLibraryItems = availableLibraryItems;
        this.checkedOutLibraryItems = checkedOutLibraryItems;
    }

    public boolean checkout(String nameOfBookToCheckout, String user) {
        for (LibraryItem item : availableLibraryItems) {
            if (item.hasTitle(nameOfBookToCheckout)) {
                availableLibraryItems.remove(item);
                checkedOutLibraryItems.put(item, user);
                return true;
            }
        }
        return false;
    }

    public boolean returnALibraryItem(String nameOfBookToReturn, String user) {
        for (LibraryItem item : checkedOutLibraryItems.keySet()) {
            if (item.hasTitle(nameOfBookToReturn) && user.equals(checkedOutLibraryItems.get(item))) {
                checkedOutLibraryItems.remove(item);
                availableLibraryItems.add(item);
                return true;
            }
        }
        return false;
    }

    public String listOfAvailableLibraryItems() {
        String list = "";
        for (LibraryItem availableLibraryItem : availableLibraryItems) {
            list += String.format("%s ", availableLibraryItem);
        }
        return list;
    }

    public String listOfCheckedOutLibraryItems() {
        String list = "";
        String userId;
        for(LibraryItem key: checkedOutLibraryItems.keySet()) {
            userId = checkedOutLibraryItems.get(key);
            list += key + userId + "\n";
        }
        return list;
    }

    public ArrayList<LibraryItem> getAvailableLibraryItems() {
        return availableLibraryItems;
    }

    public HashMap<LibraryItem, String> getCheckedOutLibraryItems() {
        return checkedOutLibraryItems;
    }
}

