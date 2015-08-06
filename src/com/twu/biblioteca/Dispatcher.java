package com.twu.biblioteca;



public class Dispatcher {
    private Library bookLibrary;
    private Library movieLibrary;
    private View view;
    private MessageView messageView;
    private TemplateView templateView;

    public Dispatcher(View view, MessageView messageView, TemplateView templateView, Library bookLibrary, Library movieLibrary) {
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
        this.messageView = messageView;
        this.templateView = templateView;
        this.view = view;
    }

    public void start(String choice, String loginId, UserDetails userDetails) {

            if (choice.equals("1")) {
                messageView.printMessage(Message.BookList);
                templateView.printBookList(bookLibrary.getAvailableLibraryItems());
            } else if (choice.equals("2")) {
                messageView.printMessage(Message.MovieList);
                templateView.printMovieList(movieLibrary.getAvailableLibraryItems());
            } else if (choice.equals("3")) {
                messageView.printMessage(Message.NameBook);
                String bookName = view.acceptInput();
                if (bookLibrary.checkout(bookName, loginId)) {
                    messageView.printMessage(Message.SuccesfulBookCheckout);
                }
                else {
                    messageView.printMessage(Message.UnsuccesfulBookCheckout);
                }
            } else if (choice.equals("4")) {
                messageView.printMessage(Message.NameMovie);
                String movieName = view.acceptInput();
                if(movieLibrary.checkout(movieName, loginId)) {
                    messageView.printMessage(Message.SuccesfulMovieCheckout);
                }
                else {
                    messageView.printMessage(Message.UnsuccesfulMovieCheckout);
                }
            } else if(choice.equals("5")) {
                messageView.printMessage(Message.NameBook);
                String bookName = view.acceptInput();
                if(bookLibrary.returnALibraryItem(bookName, loginId)) {
                    messageView.printMessage(Message.SuccessfulBookReturn);
                }
                else {
                    messageView.printMessage(Message.UnsuccesfulBookReturn);
                }
            } else if(choice.equals("6")) {
                messageView.printMessage(Message.NameMovie);
                String movieName = view.acceptInput();
                if(movieLibrary.returnALibraryItem(movieName, loginId)) {
                    messageView.printMessage(Message.SuccessfulMovieReturn);
                }
                else {
                    messageView.printMessage(Message.UnsuccesfulMovieReturn);
                }
            } else if(choice.equals("7")) {

            }
            else if(choice.equals("8")) {
                messageView.printMessage(Message.BookList);
                templateView.printCheckedOutBookList(bookLibrary.getCheckedOutLibraryItems());
            }
            else if(choice.equals("9")) {
                messageView.printMessage(Message.MovieList);
                templateView.printCheckedOutMovieList(movieLibrary.getCheckedOutLibraryItems());
            }
            else if(choice.equals("10")) {
                messageView.printMessage(Message.UserDetailsList);
                view.printList(userDetails.getDetailsOf(loginId));
            }
            else {
                messageView.printMessage(Message.InvaildMenuOption);
                messageView.printMessage(Message.Line);
            }
        }
    }

