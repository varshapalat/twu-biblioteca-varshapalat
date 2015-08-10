package com.twu.biblioteca.com.view;

import java.util.Scanner;


public class Input {

    public String acceptInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}

