package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userCanValidateBasedOnLoginIdAndPassword() {
    User user = new User("123-4567", "qwerty", "librarian");

    assertEquals(true, user.validate("123-4567", "qwerty"));
    }
}
