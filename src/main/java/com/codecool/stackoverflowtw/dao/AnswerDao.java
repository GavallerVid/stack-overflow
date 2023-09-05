package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;

import java.util.List;

public interface AnswerDao {

    List<Answer> getAll(int questionId);
    Answer getById(int id);
    int deleteById(int id);
    int add(Answer answer);
}
