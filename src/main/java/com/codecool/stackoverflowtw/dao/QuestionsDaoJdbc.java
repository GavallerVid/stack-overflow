package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.PSQLConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {
    private PSQLConnect psqlConnect;

    public QuestionsDaoJdbc(PSQLConnect psqlConnect) {
        this.psqlConnect = psqlConnect;
    }

    @Override
    public void sayHi() {
        System.out.println("Hi DAO!");
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions";
        Connection conn = null;
        Statement statement = null;
        try {
            conn = psqlConnect.connect();
            System.out.println("Connected...");

            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                int question_id = rs.getInt("question_id");
                String description = rs.getString("description");
                int user_id = rs.getInt("user_id");

                questions.add(new Question(question_id, description, user_id));

                System.out.printf("QID: %d, Description: %s, UID: %d", question_id, description, user_id);

                System.out.println();
            }

            rs.close();
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return questions;
    }

    @Override
    public boolean addQuestion(QuestionDTO questionDTO) {
        String sql = "INSERT INTO questions(description ,user_id) VALUES (?,?)";
        Connection connection = psqlConnect.connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, questionDTO.description());
            preparedStatement.setInt(2, questionDTO.user_id());
            preparedStatement.executeUpdate();
            System.out.println("question added");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
