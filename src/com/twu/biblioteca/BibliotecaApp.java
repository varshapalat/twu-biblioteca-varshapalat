package com.twu.biblioteca;


public class BibliotecaApp {

    public void start(View view, Library library) {
        String choice = "0";
        view.print(Message.Line);
        view.print(Message.Welcome);
        view.print(Message.Line);

        while (!choice.equals("2")) {
            view.print(Message.MainMenu);
            choice = view.acceptMenuInput();
            if (choice.equals("1")) {
                view.printBookList(library.toPrintListOfAvailableBook());
            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {
                String bookName = view.acceptStringMenuInput();
                if (library.checkout(bookName)) {
                    view.print(Message.SuccesfulCheckout);
                }
                else {
                    view.print(Message.UnsuccesfulCheckout);
                }
            } else if (choice.equals("4")) {
                String bookName = view.acceptStringMenuInput();
                if (library.returnABook(bookName)) {
                    view.print(Message.SuccessfulReturn);
                }
                else {
                    view.print(Message.UnsuccesfulReturn);
                }
            } else if(choice.equals("5")) {
                view.printBookList(library.toPrintListOfCheckedOutBook());
            } else {
                view.print(Message.InvaildMenuOption);
                view.print(Message.Line);
            }
        }
    }
}
