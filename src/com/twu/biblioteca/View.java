package com.twu.biblioteca;

import java.util.Scanner;


public class View {

    public void printList(String list) {
        System.out.print(list);
    }

    public String acceptMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }

    public String acceptStringMenuInput() {
        return acceptMenuInput();
    }

    public void print(Message s) {
        System.out.print(s.getMessage());
    }
}

