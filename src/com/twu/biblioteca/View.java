package com.twu.biblioteca;

import java.util.Scanner;


public class View {

    public void printWelcomeMessage() {

        System.out.print("Welcome!! \nBiblioteca is now available\n");
    }

    public void printBookList(String list) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("BOOKS AVAILABLE");
        System.out.println("TITLE               AUTHOR         YEAR PUBLISHED");
        System.out.print(list);
    }

    public void printMainMenu() {
        System.out.print("\n\n\nMAIN MENU\n1.List Books\n2.Quit\n3.Checkout\n4.Return A Book\nEnter your choice:\n");
    }

    public String acceptMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }

    public void printLine() {
        System.out.print("------------------------------------------------------------\n");
    }

    public void printInvalidMenuOption() {
        System.out.print("Select a valid Option!\n");
    }


    public String acceptStringMenuInput() {
        System.out.print("Enter book name:\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printSuccessfulCheckout() {
        System.out.print("Thank you! Enjoy the book\n");
    }

    public void printUnsuccessfullCheckout() {
        System.out.print("That book is not available.\n");
    }

    public void printSuccessfulReturn() {
        System.out.print("Thank you for returning the book.\n");
    }

    public void printUnsuccessfullReturn() {
        System.out.print("That is not a valid book to return.\n");
    }
}

