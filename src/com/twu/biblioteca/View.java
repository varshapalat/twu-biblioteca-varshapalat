package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

    String welcomeMessage = "Welcome!! \nBiblioteca is now available";

    public void printWelcomeMessage() {

        System.out.print(welcomeMessage);
    }

    public void printBookList(ArrayList<String>[] books) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("BOOKS AVAILABLE");
        System.out.println("TITLE               AUTHOR         YEAR PUBLISHED");
        System.out.println("The Da Vinci Code   Dan Brown      2000");
        System.out.println("Kane and Abel       Jeffrey Archer 1979");
        System.out.println("The Alchemist       Paulo Coelho   1988");
    }

    public void printMainMenu() {
        System.out.print("\n\n\nMAIN MENU\n1.List Books\n");
        System.out.print("\nEnter your choice:");
    }

    public int acceptMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.next());
        return choice;
    }
}

