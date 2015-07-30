package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class View {

    String welcomeMessage = "Welcome!! \nBiblioteca is now available\n";

    public void printWelcomeMessage() {

        System.out.print(welcomeMessage);
    }

    public void printBookList(ArrayList<ArrayList<String>> books) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("BOOKS AVAILABLE");
        System.out.println("TITLE               AUTHOR         YEAR PUBLISHED");
        for(int i = 0; i < books.size(); i++) {
            System.out.printf("%-20s %-15s %-5s\n", books.get(i).get(0), books.get(i).get(1), books.get(i).get(2));
        }
    }

    public void printMainMenu() {
        System.out.print("\n\n\nMAIN MENU\n1.List Books\n2.Quit\n3.Checkout\nEnter your choice:\n");
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

    public void successfulCheckout() {
    }
}

