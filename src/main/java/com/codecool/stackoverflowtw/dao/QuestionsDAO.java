package com.codecool.stackoverflowtw.dao;


import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;

import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {
    void sayHi();
    List<Question> getAllQuestions();

    int addQuestion(NewQuestionDTO newQuestionDTO);

    int deleteQuestionById(int id);


}
