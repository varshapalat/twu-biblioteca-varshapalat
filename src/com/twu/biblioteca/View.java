package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class View {

    String welcomeMessage = "Welcome!! \nBiblioteca is now available\n";

    public void printWelcomeMessage() {

        System.out.print(welcomeMessage);
    }

    public void printBookList(ArrayList<String>[] books) {
        int counter = 0;
        for (int i = 0; i < books.length; i ++) {
            if (books[i] != null)
                counter++;
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("BOOKS AVAILABLE");
        System.out.println("TITLE               AUTHOR         YEAR PUBLISHED");
        for(int i = 0; i < counter; i++) {
            System.out.printf("%-20s %-15s %-5s\n", books[i].get(0), books[i].get(1), books[i].get(2));
        }
    }

    public void printMainMenu() {
        System.out.print("\n\n\nMAIN MENU\n1.List Books\nEnter your choice:\n");
    }

    public int acceptMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.next());
        return choice;
    }

    public void printLine() {
        System.out.print("------------------------------------------------------------\n");
    }
}

