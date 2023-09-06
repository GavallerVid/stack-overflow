package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.controller.dto.newUserDTO;
import com.codecool.stackoverflowtw.dao.model.User;
import com.codecool.stackoverflowtw.service.PSQLConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoJdbc implements UsersDAO {
    private PSQLConnect psqlConnect;

    public UsersDaoJdbc(PSQLConnect psqlConnect) {
        this.psqlConnect = psqlConnect;
    }

    @Override
    public int addUser(newUserDTO newUserDTO) {
        String sql = "INSERT INTO users(user_name, password) VALUES(?,?)";
        Connection connection = psqlConnect.connect();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newUserDTO.username());
            preparedStatement.setString(2, newUserDTO.password());
            preparedStatement.executeUpdate();
            System.out.println("user added");
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users;";
        try {
            Connection connection = psqlConnect.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("conn!");

            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String user_name = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                users.add(new User(user_id, user_name, password));
                System.out.printf("QID: %d, Description: %s, UID: %s", user_id, user_name, password);

                System.out.println();
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }

    @Override
    public UserDTO getUserById(int id) {
        System.out.println(id + "IDD");
        String sql = "SELECT * FROM users WHERE user_id = ?";
        int user_id = 0;
        String username = "";
        String password = "";
        try {
            Connection connection = psqlConnect.connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user_id = rs.getInt("user_id");
                username = rs.getString("user_name");
                password = rs.getString("password");
            }
            connection.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return new UserDTO(user_id, username, password);
    }

    @Override
    public boolean deleteUsersById(int id) {
        return false;
    }
}
