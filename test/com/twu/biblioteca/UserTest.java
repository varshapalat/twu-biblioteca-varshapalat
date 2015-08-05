package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userShouldTellIfLoginIdAndPasswordMatch() {
        User user = new User("123-4567", "qwerty", "librarian");

        assertEquals(true, user.hasUser("123-4567", "qwerty"));
    }

    @Test
    public void roleIsReturnedForEachUser() {
        User user = new User("123-4567", "qwerty", "librarian");

        assertEquals("librarian", user.getRole());
    }

}
