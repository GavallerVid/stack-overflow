package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.PSQLConnect;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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
        QuestionsDaoJdbc questionsDaoJdbc = new QuestionsDaoJdbc(psqlConnect);
        // uncomment this to add question to your personal db. Also user with id 1 needs to be present in your own db.
        //QuestionDTO testQuestion = new QuestionDTO(1,"Test Question", "test description",
        //        LocalDateTime.now(), 2 );
        //questionsDaoJdbc.addQuestion(testQuestion);
        AnswerDTO answerDTO = new AnswerDTO(1,"answer to random question", 1, 1);
        assertEquals(1, answerDaoJdbc.add(answerDTO));
    }
}