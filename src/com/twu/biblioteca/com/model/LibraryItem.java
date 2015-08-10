package com.twu.biblioteca.com.model;

public interface LibraryItem {
    String toString();

    boolean hasTitle(String nameOfLibraryItemToCheckout);
}
