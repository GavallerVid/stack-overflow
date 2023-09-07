package com.codecool.stackoverflowtw.service;
import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.controller.dto.newUserDTO;
import com.codecool.stackoverflowtw.dao.UsersDaoJdbc;
import com.codecool.stackoverflowtw.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    private UsersDaoJdbc usersDaoJdbc;
    @Autowired
    public UsersService(UsersDaoJdbc usersDaoJdbc) {
        this.usersDaoJdbc = usersDaoJdbc;
    }
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: usersDaoJdbc.getAllUsers()) {
            int id = user.user_id();
            String username = user.user_name();
            String pw = user.password();
            userDTOS.add(new UserDTO(id, username,pw));
        }
        return userDTOS;
    }
    public UserDTO getUserByName(String user_name) {
        UserDTO user = usersDaoJdbc.getUserByName(user_name);

        return user;
    }
    public boolean deleteUsersById(int id) {
        // TODO
        return false;
    }
    public int addNewUser(String user_name, String password) {
        newUserDTO user = new newUserDTO(user_name, password);
        return usersDaoJdbc.addUser(user);
        //return user.id();
    }
}
