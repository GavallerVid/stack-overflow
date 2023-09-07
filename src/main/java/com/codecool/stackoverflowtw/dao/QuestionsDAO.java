package com.codecool.stackoverflowtw.dao;


import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;

import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {

    List<Question> getAllQuestionsWithAnswerCount();

    int addQuestion(NewQuestionDTO newQuestionDTO);

    int deleteQuestionById(int id);


}
