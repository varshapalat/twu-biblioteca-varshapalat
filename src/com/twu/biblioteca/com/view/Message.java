package com.twu.biblioteca.com.view;


public enum Message {
    Welcome("-----------------------------------------------------------------\n"+
            "****************Welcome!!**************** \n ***********Biblioteca is now available***********\n" +
            "-----------------------------------------------------------------\n"),
    LibrarianMainMenu("\n\n\nMAIN MENU\n" +
            "1.List Available Books\n2.List Available Movies\n3.Check Out Book\n4.Check Out Movie\n5.Return A Book\n" +
            "6.Return A Movie\n7.Logout\n8.List Checked Out Books\n9.List Checked Out Movies\n" +
            "10.My UserInformation\n11.Customer Contact Details\n" +
            "Enter your choice:\n"),
    CustomerMainMenu("\n\n\n" +
            "MAIN MENU\n1.List Available Books\n2.List Available Movies\n3.Check Out Book\n4.Check Out Movie" +
            "\n5.Return A Book\n6.Return A Movie\n7.Logout\n8.My User Information\nEnter your choice:\n"),

    InvaildMenuOption("Select a valid Option!\n"),
    SuccesfulBookCheckout("Thank you! Enjoy the book\n"),
    UnsuccesfulBookCheckout("That book is not available.\n"),
    SuccessfulBookReturn("Thank you for returning the book.\n"),
    UnsuccesfulBookReturn("That is not a valid book to return.\n"),
    NameBook("Enter Book Name:\n"),
    NameMovie("Enter Movie Name:\n"),
    SuccesfulMovieCheckout("Thank you! Enjoy the movie\n"),
    UnsuccesfulMovieCheckout("That movie is not available"),
    SuccessfulMovieReturn("Thank you for returning the movie.\n"),
    UnsuccesfulMovieReturn("That is not a valid movie to return.\n"),
    Initial("1.Login\n2.Quit\n"),
    EnterPassword("Enter the password:\n"),
    InvalidLogin("Sorry! You entered the wrong login id and password\n"),
    Login("Login\nEnter library number(xxx-xxxx):\n"),
    SuccessfulLogout("You have successfully logged out!\n");
    private String value;

    Message(String message) {
        value = message;
    }

    String getMessage() {
        return value;
    }
}
