package com.codecool.stackoverflowtw.service;
import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.controller.dto.newUserDTO;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private QuestionsDAO questionsDAO;
    @Autowired
    public UsersService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }
    public List<UserDTO> getAllUsers() {
        // TODO
        return List.of(new UserDTO(1, "example user", "example pw"));
    }
    public UserDTO getUserById(int id) {
        // TODO
        questionsDAO.sayHi();
        return new UserDTO(id, "example user", "example pw");
    }
    public boolean deleteUsersById(int id) {
        // TODO
        return false;
    }
    public int addNewUser(newUserDTO user) {
        // TODO
        int createdId = 0;
        return createdId;
    }
}
