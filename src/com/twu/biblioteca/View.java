package com.twu.biblioteca;

import java.util.Scanner;


public class View {

    public void printBookList(String list) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("BOOKS AVAILABLE");
        System.out.println("TITLE               AUTHOR         YEAR PUBLISHED");
        System.out.print(list);
    }

    public String acceptMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }

    public String acceptStringMenuInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book name:\n");
        return scanner.nextLine();
    }

    public void print(Message s) {
        System.out.print(s.getMessage());
    }
}

