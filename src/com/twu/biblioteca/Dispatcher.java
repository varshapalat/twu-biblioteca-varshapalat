package com.twu.biblioteca;


import java.util.ArrayList;

public class Dispatcher {
    private Library bookLibrary;
    private Library movieLibrary;
    private Input input;
    private MessageView messageView;
    private TemplateView templateView;

    public Dispatcher(Input input, MessageView messageView, TemplateView templateView, Library bookLibrary, Library movieLibrary) {
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
        this.messageView = messageView;
        this.templateView = templateView;
        this.input = input;
    }

    public void start(String choice, String loginId, ArrayList<User> userList) {

            if (choice.equals("1")) {
                templateView.printBookList(bookLibrary.getAvailableLibraryItems());
            } else if (choice.equals("2")) {
                templateView.printMovieList(movieLibrary.getAvailableLibraryItems());
            } else if (choice.equals("3")) {
                messageView.printMessage(Message.NameBook);
                String bookName = input.acceptInput();
                if (bookLibrary.checkout(bookName, loginId)) {
                    messageView.printMessage(Message.SuccesfulBookCheckout);
                }
                else {
                    messageView.printMessage(Message.UnsuccesfulBookCheckout);
                }
            } else if (choice.equals("4")) {
                messageView.printMessage(Message.NameMovie);
                String movieName = input.acceptInput();
                if(movieLibrary.checkout(movieName, loginId)) {
                    messageView.printMessage(Message.SuccesfulMovieCheckout);
                }
                else {
                    messageView.printMessage(Message.UnsuccesfulMovieCheckout);
                }
            } else if(choice.equals("5")) {
                messageView.printMessage(Message.NameBook);
                String bookName = input.acceptInput();
                if(bookLibrary.returnALibraryItem(bookName, loginId)) {
                    messageView.printMessage(Message.SuccessfulBookReturn);
                }
                else {
                    messageView.printMessage(Message.UnsuccesfulBookReturn);
                }
            } else if(choice.equals("6")) {
                messageView.printMessage(Message.NameMovie);
                String movieName = input.acceptInput();
                if(movieLibrary.returnALibraryItem(movieName, loginId)) {
                    messageView.printMessage(Message.SuccessfulMovieReturn);
                }
                else {
                    messageView.printMessage(Message.UnsuccesfulMovieReturn);
                }
            } else if(choice.equals("7")) {

            }
            else if(choice.equals("8")) {
                templateView.printCheckedOutBookList(bookLibrary.getCheckedOutLibraryItems());
            }
            else if(choice.equals("9")) {
                templateView.printCheckedOutMovieList(movieLibrary.getCheckedOutLibraryItems());
            }
            else if(choice.equals("10")) {
                templateView.printUserDetails(userList, loginId);
            }
            else {
                messageView.printMessage(Message.InvaildMenuOption);
                messageView.printMessage(Message.Line);
            }
        }
    }

