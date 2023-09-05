package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.service.PSQLConnect;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersDaoJdbcTest {

    @Test
    void adduser() {
        PSQLConnect psqlConnect = new PSQLConnect();
        UsersDaoJdbc usersDaoJdbc = new UsersDaoJdbc(psqlConnect);
        UserDTO user = new UserDTO(1, "Bob", "333");
        assertTrue(usersDaoJdbc.addUser(user));
    }

    @Test
    void getAllUser(){
        UsersDaoJdbc usersDaoJdbc = new UsersDaoJdbc(new PSQLConnect());
        assertFalse(usersDaoJdbc.getAllUsers().isEmpty());
        UserDTO bob = new UserDTO(2,"Bob", "333");
        assertEquals("Bob", usersDaoJdbc.getAllUsers().get(usersDaoJdbc.getAllUsers().size() - 1).user_name());
    }

}