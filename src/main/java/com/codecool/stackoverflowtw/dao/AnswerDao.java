package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface AnswerDao {

    List<Answer> getAll(int questionId);
    Answer getById(int id);
    int deleteById(int id);
    int add(AnswerDTO answer);
}
