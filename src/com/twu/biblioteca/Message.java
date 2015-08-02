package com.twu.biblioteca;


enum Message {
    Welcome("Welcome!! \n Biblioteca is now available\n"), MainMenu("\n\n\n MAIN MENU\n1.List Available Books\n2.Quit\n3.Checkout\n4.Return A Book\n" +
            "5.List Checked out Books\n6.List Available Movies\nEnter your choice:\n"), Line("------------------------------------------------------------\n"), InvaildMenuOption("Select a valid Option!\n"),
    SuccesfulCheckout("Thank you! Enjoy the book\n"), UnsuccesfulCheckout("That book is not available.\n"), SuccessfulReturn("Thank you for returning the book.\n"), BookList("AVAILABLE BOOKS\nTITLE\t\tAUTHOR\t\tYEAR PUBLISHED\n"),
    UnsuccesfulReturn("That is not a valid book to return.\n"), MovieList("AVAILABLE MOVIES\nMOVIE NAME\tDIRECTOR\tYEAR\tRATING\n") ;
    private String value;

    Message(String s) {
        value = s;
    }

    String getMessage() {
        return value;
    }
}
