package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        List<Question> questionsFromDB = questionsDAO.getAllQuestionsWithAnswerCount();

        questionsFromDB.forEach((question -> questionDTOS.add(new QuestionDTO(question.question_id(), question.title(), question.description(), LocalDateTime.now(), question.user_id(), question.answerCount()))));


        return questionDTOS;
    }

    public QuestionDTO getQuestionById(int id) {

        List<Question> questionsFromDB = questionsDAO.getAllQuestionsWithAnswerCount();
        for (Question question : questionsFromDB) {
            if (question.question_id() == id) {
                return new QuestionDTO(question.question_id(), "title", question.description(), LocalDateTime.now(), question.user_id(), question.answerCount());
            }
        }
        return null;
    }

    public boolean deleteQuestionById(int id) {
        int deletedRows = questionsDAO.deleteQuestionById(id);
        System.out.println(deletedRows);
        return deletedRows == 1;
    }

    public int addNewQuestion(NewQuestionDTO question) {
        return questionsDAO.addQuestion(question);
    }
}
