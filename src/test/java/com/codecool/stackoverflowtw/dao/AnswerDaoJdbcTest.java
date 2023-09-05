package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.PSQLConnect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerDaoJdbcTest {

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void add() {
        PSQLConnect psqlConnect = new PSQLConnect();
        AnswerDaoJdbc answerDaoJdbc = new AnswerDaoJdbc(psqlConnect);
        AnswerDTO answerDTO = new AnswerDTO(1,"answer to random question", 4, 10);
        assertEquals(1, answerDaoJdbc.add(answerDTO));
    }
}