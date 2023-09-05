package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.service.PSQLConnect;
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

}