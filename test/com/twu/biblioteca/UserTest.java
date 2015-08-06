package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userShouldTellIfLoginIdAndPasswordMatch() {
        User user = new User("123-4567", "qwerty", "librarian", "123-4567", "qwerty", "librarian");

        assertEquals(true, user.hasUser("123-4567", "qwerty"));
    }

    @Test
    public void roleIsReturnedForEachUser() {
        User user = new User("123-4567", "qwerty", "librarian", "123-4567", "qwerty", "librarian");

        assertEquals("librarian", user.getRole());
    }

    @Test
    public void userCanReturnUserDetails()  {
        User user = new User("123-4567", "qwerty", "librarian", "Varsha", "qwerty", "librarian");

        assertEquals("123-4567\tVarsha\tqwerty\tlibrarian", user.getUserDetails("123-4567"));
    }
}
