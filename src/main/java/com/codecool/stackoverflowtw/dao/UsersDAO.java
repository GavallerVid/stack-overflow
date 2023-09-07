package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.controller.dto.newUserDTO;
import com.codecool.stackoverflowtw.dao.model.User;

import java.util.List;

public interface UsersDAO {
    public int addUser(newUserDTO newUserDTO);
    public List<User> getAllUsers();

    public UserDTO getUserByName(String user_name,String password);
    public boolean deleteUsersById(int id);
}
