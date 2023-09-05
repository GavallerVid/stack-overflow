package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.service.PSQLConnect;

public class UserDaoJdbc {
    private PSQLConnect psqlConnect;

    public UserDaoJdbc(PSQLConnect psqlConnect) {
        this.psqlConnect = psqlConnect;
    }
}
