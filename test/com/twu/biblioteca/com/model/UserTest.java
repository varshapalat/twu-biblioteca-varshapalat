package com.twu.biblioteca.com.model;

import com.twu.biblioteca.com.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void userShouldTellIfLoginIdAndPasswordMatch() {
        User user = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");

        assertEquals(true, user.hasUser("123-4567", "qwerty"));
    }

    @Test
    public void roleIsReturnedForEachUser() {
        User user = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");

        assertEquals("librarian", user.getRole());
    }

    @Test
    public void userCanReturnUserDetails()  {
        User user = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");

        assertEquals("123-4567\tRam\tram@gmail.com\t999999999", user.getUserDetails("123-4567"));
    }

    @Test
    public void userCanReturnUserName() {
        User user = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");

        assertEquals("Ram", user.getName());
    }

    @Test
    public void userCanReturnUserEmail() {
        User user = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");

        assertEquals("ram@gmail.com", user.getEmailId());
    }

    @Test
    public void userCanReturnUserLoginId() {
        User user = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");

        assertEquals("123-4567", user.getLoginId());
    }

    @Test
    public void userCanReturnUserPhoneNumber() {
        User user = new User("123-4567", "qwerty", "librarian", "Ram", "ram@gmail.com", "999999999");

        assertEquals("999999999", user.getPhoneNumber());
    }
}
