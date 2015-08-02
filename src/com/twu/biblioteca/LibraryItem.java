package com.twu.biblioteca;

public interface LibraryItem {
    public String toString();

    boolean hasTitle(String nameOfLibraryItemToCheckout);
}
