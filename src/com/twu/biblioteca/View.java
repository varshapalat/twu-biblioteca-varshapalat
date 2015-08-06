package com.twu.biblioteca;

import java.util.Scanner;


public class  View {

    public void printList(String list) {
        System.out.print(list);
    }

    public String acceptInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public void print(Message s) {
        System.out.print(s.getMessage());
    }
}

