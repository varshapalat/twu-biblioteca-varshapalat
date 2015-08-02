package com.twu.biblioteca;


enum Message {
    Welcome("****************Welcome!!**************** \n ***********Biblioteca is now available***********\n"),
    MainMenu("\n\n\n MAIN MENU\n1.List Available Books\n2.List Available Movies\n3.List Checked Out Books\n4.List Checked Out Movies\n" +
            "5.Check Out Book\n6.Check Out Movie\n7.Return A Book\n8.Return A Movie\n9.Quit\nEnter your choice:\n"),
    Line("------------------------------------------------------------\n"),
    InvaildMenuOption("Select a valid Option!\n"),
    SuccesfulBookCheckout("Thank you! Enjoy the book\n"),
    UnsuccesfulBookCheckout("That book is not available.\n"),
    SuccessfulBookReturn("Thank you for returning the book.\n"),
    BookList("BOOKS\n-------------------------------------------------------\nTITLE\t\tAUTHOR\t\tYEAR PUBLISHED\n"),
    UnsuccesfulBookReturn("That is not a valid book to return.\n"),
    MovieList("MOVIES\n----------------------------------------------------\nMOVIE NAME\tDIRECTOR\tYEAR\tRATING\n"),
    NameBook("Enter Book Name:\n"),
    NameMovie("Enter Movie Name:\n"),
    SuccesfulMovieCheckout("Thank you! Enjoy the movie\n"),
    UnsuccesfulMovieCheckout("That movie is not available"),
    SuccessfulMovieReturn("Thank you for returning the movie.\n"),
    UnsuccesfulMovieReturn("That is not a valid movie to return.\n");
    private String value;

    Message(String s) {
        value = s;
    }

    String getMessage() {
        return value;
    }
}
