package com.twu.biblioteca;

public interface LibraryItem {
    String toString();

    boolean hasTitle(String nameOfLibraryItemToCheckout);
}
