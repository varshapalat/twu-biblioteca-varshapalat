package com.twu.biblioteca;

import java.util.Scanner;


public class Input {

    public String acceptInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}

