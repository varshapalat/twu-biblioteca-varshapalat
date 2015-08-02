package com.twu.biblioteca;


public class BibliotecaApp {
    Library bookLibrary;
    Library movieLibrary;
    View view;

    public BibliotecaApp(View view, Library bookLibrary, Library movieLibrary) {
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
        this.view = view;
    }

    public void start() {
        String choice = "0";
        view.print(Message.Line);
        view.print(Message.Welcome);
        view.print(Message.Line);

        while (!choice.equals("2")) {
            view.print(Message.MainMenu);
            choice = view.acceptMenuInput();
            if (choice.equals("1")) {
                view.print(Message.BookList);
                view.printBookList(bookLibrary.listOfAvailableLibraryItems());
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                String bookName = view.acceptStringMenuInput();
                if (bookLibrary.checkout(bookName)) {
                    view.print(Message.SuccesfulCheckout);
                }
                else {
                    view.print(Message.UnsuccesfulCheckout);
                }
            } else if (choice.equals("4")) {
                String bookName = view.acceptStringMenuInput();
                if (bookLibrary.returnABook(bookName)) {
                    view.print(Message.SuccessfulReturn);
                }
                else {
                    view.print(Message.UnsuccesfulReturn);
                }
            } else if(choice.equals("5")) {
                view.printBookList(bookLibrary.listOfCheckedOutLibraryItems());
            } else if(choice.equals("6")) {
                view.print(Message.MovieList);
                view.printBookList(movieLibrary.listOfAvailableLibraryItems());
            }
            else {
                view.print(Message.InvaildMenuOption);
                view.print(Message.Line);
            }
        }
    }
}
