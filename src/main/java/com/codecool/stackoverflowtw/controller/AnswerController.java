package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answers")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }


    @PostMapping("/")
    public int addNewAnswer(@RequestBody NewAnswerDTO newAnswerDTO) {
        return 0;
    }

    @GetMapping("/{questionId}")
    public List<AnswerDTO> getAllAnswerByQuestionId(@PathVariable int questionId) {
        return answerService.getAllAnswerByQuestionId(questionId);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAnswerById(@PathVariable int id) {
        return answerService.deleteAnswerById(id);
    }
}
