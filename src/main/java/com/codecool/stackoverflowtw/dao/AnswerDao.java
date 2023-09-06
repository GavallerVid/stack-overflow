package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.dao.model.Answer;

import java.util.List;

public interface AnswerDao {

    List<Answer> getAllAnswerByQuestionId(int questionId);
    Answer getById(int id);
    int deleteById(int id);
    int add(AnswerDTO answer);
}
