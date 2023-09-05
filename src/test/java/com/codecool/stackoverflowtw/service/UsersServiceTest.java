package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.UsersDaoJdbc;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UsersServiceTest {
    @Test
    void addNewUser() {
        PSQLConnect connect = new PSQLConnect();
        UsersDaoJdbc usersDaoJdbc = new UsersDaoJdbc(connect);
        UsersService usersService = new UsersService(usersDaoJdbc);
        assertEquals(2, usersService.addNewUser(2,"Neo", "fsdf"));
    }

}