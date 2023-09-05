package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.service.PSQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDaoJdbc implements UsersDAO {
    private PSQLConnect psqlConnect;

    public UsersDaoJdbc(PSQLConnect psqlConnect) {
        this.psqlConnect = psqlConnect;
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        String sql = "INSERT INTO users(user_name, password) VALUES(?,?)";
        Connection connection = psqlConnect.connect();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userDTO.user_name());
            preparedStatement.setString(2, userDTO.password());
            preparedStatement.executeUpdate();
            System.out.println("user added");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
