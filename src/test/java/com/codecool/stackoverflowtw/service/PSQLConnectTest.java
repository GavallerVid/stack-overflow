package com.codecool.stackoverflowtw.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PSQLConnectTest {

    PSQLConnect psqlConnect = new PSQLConnect();
    @Test
    void connect () {
        psqlConnect.connect();
    }
}