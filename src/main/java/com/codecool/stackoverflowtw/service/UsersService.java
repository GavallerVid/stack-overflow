package com.codecool.stackoverflowtw.service;
import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.controller.dto.newUserDTO;
import com.codecool.stackoverflowtw.dao.UsersDaoJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private UsersDaoJdbc usersDaoJdbc;
    @Autowired
    public UsersService(UsersDaoJdbc usersDaoJdbc) {
        this.usersDaoJdbc = usersDaoJdbc;
    }
    public List<UserDTO> getAllUsers() {
        // TODO
        return List.of(new UserDTO(1, "example user", "example pw"));
    }
    public UserDTO getUserById(int id) {
        // TODO

        return new UserDTO(id, "example user", "example pw");
    }
    public boolean deleteUsersById(int id) {
        // TODO
        return false;
    }
    public int addNewUser(int id, String user_name, String password) {
        usersDaoJdbc.addUser(new UserDTO(id, user_name, password));
        int createdId = id;
        return createdId;
    }
}
