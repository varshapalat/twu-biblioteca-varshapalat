package com.twu.biblioteca;


enum Message {
    Welcome("Welcome!! \n Biblioteca is now available\n"),
    MainMenu("\n\n\n MAIN MENU\n1.List Available Books\n2.Quit\n3.Checkout Book\n4.Return A Book\n" +
            "5.List Checked out Books\n6.List Available Movies\n7.List Checked out Movies\n8.Checkout Movie\nEnter your choice:\n"),
    Line("------------------------------------------------------------\n"),
    InvaildMenuOption("Select a valid Option!\n"),
    SuccesfulBookCheckout("Thank you! Enjoy the book\n"),
    UnsuccesfulBookCheckout("That book is not available.\n"),
    SuccessfulReturn("Thank you for returning the book.\n"),
    BookList("BOOKS\nTITLE\t\tAUTHOR\t\tYEAR PUBLISHED\n"),
    UnsuccesfulReturn("That is not a valid book to return.\n"),
    MovieList("MOVIES\nMOVIE NAME\tDIRECTOR\tYEAR\tRATING\n"),
    NameBook("Enter Book Name:\n"),
    NameMovie("Enter Movie Name:\n"),
    SuccesfulMovieCheckout("Thank you! Enjoy the book\n"),
    UnsuccesfulMovieCheckout("That movie is not available");
    private String value;

    Message(String s) {
        value = s;
    }

    String getMessage() {
        return value;
    }
}
