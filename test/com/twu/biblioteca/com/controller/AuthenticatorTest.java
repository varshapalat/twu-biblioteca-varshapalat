package com.twu.biblioteca.com.controller;

import com.twu.biblioteca.com.controller.Authenticator;
import com.twu.biblioteca.com.model.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {
    @Test
    public void authenticateALibrarian() {
        User userOne = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");
        User userTwo = new User("abc-defg", "qwerty", "customer", "Nancy", "nancy@gmail.com", "8888888888");
        User userThree = new User("var-shap", "qwerty", "customer", "Varsha", "varsha@gmail.com", "7777777777");

        ArrayList<User> UserList = new ArrayList<User>();
        UserList.add(userOne);
        UserList.add(userTwo);
        UserList.add(userThree);

        Authenticator authenticator = new Authenticator(UserList);

        assertEquals("librarian", authenticator.authenticate("123-4567", "qwerty"));
    }

    @Test
    public void authenticateACustomer() {
        User userOne = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");
        User userTwo = new User("abc-defg", "qwerty", "customer", "Nancy", "nancy@gmail.com", "8888888888");
        User userThree = new User("var-shap", "qwerty", "customer", "Varsha", "varsha@gmail.com", "7777777777");

        ArrayList<User> UserList = new ArrayList<User>();
        UserList.add(userOne);
        UserList.add(userTwo);
        UserList.add(userThree);

        Authenticator authenticator = new Authenticator(UserList);

        assertEquals("customer", authenticator.authenticate("abc-defg", "qwerty"));
    }

    @Test
    public void authenticateInvalidRoles() {
        User userOne = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");
        User userTwo = new User("abc-defg", "qwerty", "customer", "Nancy", "nancy@gmail.com", "8888888888");
        User userThree = new User("var-shap", "qwerty", "customer", "Varsha", "varsha@gmail.com", "7777777777");

        ArrayList<User> UserList = new ArrayList<User>();
        UserList.add(userOne);
        UserList.add(userTwo);
        UserList.add(userThree);

        Authenticator authenticator = new Authenticator(UserList);

        assertEquals("no role", authenticator.authenticate("111-defg", "qwerty"));
    }
}
