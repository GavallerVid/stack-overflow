package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.dao.AnswerDao;
import com.codecool.stackoverflowtw.dao.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    private AnswerDao answerDao;

    @Autowired
    public AnswerService(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public List<AnswerDTO> getAllAnswerByQuestionId(int questionId) {
        List<AnswerDTO> answerDTOS = new ArrayList<>();
        List<Answer> answers = answerDao.getAllAnswerByQuestionId(questionId);

        answers.forEach(answer -> answerDTOS.add(new AnswerDTO(answer.answer_id(), answer.description(), answer.question_id(), answer.user_id())));

        return answerDTOS;
    }

    public boolean deleteAnswerById(int answer_id) {
        try {
            answerDao.deleteById(answer_id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
