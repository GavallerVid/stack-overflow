package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.dao.model.User;

import java.util.List;

public interface UsersDAO {
    public boolean addUser(UserDTO userDTO);
    public List<User> getAllUsers();

    public UserDTO getUserById(int id);
    public boolean deleteUsersById(int id);
}
