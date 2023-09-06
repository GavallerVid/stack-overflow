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

    private QuestionsDAO questionsDAO;

    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        List<Question> questionsFromDB = questionsDAO.getAllQuestions();

        for (Question question : questionsFromDB) {
            int id = question.question_id();
            String description = question.description();
            int user_id = question.user_id();
            questionDTOS.add(new QuestionDTO(id, "title", description, LocalDateTime.now(), user_id));
        }

        return questionDTOS;
    }

    public QuestionDTO getQuestionById(int id) {

        // TODO
        questionsDAO.sayHi();
        return new QuestionDTO(id, "example title", "example desc", LocalDateTime.now(), 1);

        List<Question> questionsFromDB = questionsDAO.getAllQuestions();
        for (Question question : questionsFromDB) {
            if (question.question_id() == id) {
                return new QuestionDTO(question.question_id(), "title", question.description(), LocalDateTime.now());
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
        // TODO
        int createdId = 0;
        return createdId;
    }
}
