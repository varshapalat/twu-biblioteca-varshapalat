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
            choice = view.acceptInput();
            if (choice.equals("1")) {
                view.print(Message.BookList);
                view.printList(bookLibrary.listOfAvailableLibraryItems());
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                view.print(Message.NameBook);
                String bookName = view.acceptInput();
                if (bookLibrary.checkout(bookName)) {
                    view.print(Message.SuccesfulBookCheckout);
                }
                else {
                    view.print(Message.UnsuccesfulBookCheckout);
                }
            } else if (choice.equals("4")) {
                view.print(Message.NameBook);
                String bookName = view.acceptInput();
                if (bookLibrary.returnALibraryItem(bookName)) {
                    view.print(Message.SuccessfulBookReturn);
                }
                else {
                    view.print(Message.UnsuccesfulBookReturn);
                }
            } else if(choice.equals("5")) {
                view.print(Message.BookList);
                view.printList(bookLibrary.listOfCheckedOutLibraryItems());
            } else if(choice.equals("6")) {
                view.print(Message.MovieList);
                view.printList(movieLibrary.listOfAvailableLibraryItems());
            } else if(choice.equals("7")) {
                view.print(Message.MovieList);
                view.printList(movieLibrary.listOfCheckedOutLibraryItems());
            }
            else if(choice.equals("8")) {
                view.print(Message.NameMovie);
                String movieName = view.acceptInput();
                if(movieLibrary.checkout(movieName)) {
                    view.print(Message.SuccesfulMovieCheckout);
                }
                else {
                    view.print(Message.UnsuccesfulMovieCheckout);
                }
            }
            else if(choice.equals("9")) {
                view.print(Message.NameMovie);
                String movieName = view.acceptInput();
                if(movieLibrary.returnALibraryItem(movieName)) {
                    view.print(Message.SuccessfulMovieReturn);
                }
                else {
                    view.print(Message.UnsuccesfulMovieReturn);
                }
            }
            else {
                view.print(Message.InvaildMenuOption);
                view.print(Message.Line);
            }
        }
    }
}
