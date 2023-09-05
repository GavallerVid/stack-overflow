package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.AnswerDTO;
import com.codecool.stackoverflowtw.dao.model.Answer;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.PSQLConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class AnswerDaoJdbc implements AnswerDao{

    private PSQLConnect psqlConnect;

    public AnswerDaoJdbc(PSQLConnect psqlConnect) {
        this.psqlConnect = psqlConnect;
    }

    @Override
    public List<Answer> getAll(int questionId) {
        String SQL = "SELECT answer_id, description FROM answers";
        List<Answer> answers = new ArrayList<>();

        try (Connection conn = psqlConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Integer answer_id = rs.getInt("answer_id");
                String description = rs.getString("description");
                Integer question_id = rs.getInt("question_id");
                Integer user_id = rs.getInt("user_id");
                answers.add(new Answer(answer_id, description,question_id,user_id));
            }

        } catch (SQLException e) {
            System.out.println("An SQL exception occurred: " + e);
        }

        return answers;

    }

    @Override
    public Answer getById(int id) {
        String SQL = "SELECT * FROM answers WHERE answer_id = ?";
        Answer answer = null;

        try (Connection conn = psqlConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Integer answer_id = rs.getInt("answer_id");
                String description = rs.getString("description");
                Integer question_id = rs.getInt("question_id");
                Integer user_id = rs.getInt("user_id");
                answer = new Answer(answer_id, description,question_id,user_id);
            }

        } catch (SQLException e) {
            System.out.println("An SQL exception occurred: " + e);
        }

        return answer;    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM answers WHERE answer_id = ?";

        int affectedrows = 0;

        try (Connection conn = psqlConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, id);

            affectedrows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedrows;
    }

    @Override
    public int add(AnswerDTO answer) {
        String sql = "INSERT INTO answers(description, question_id, user_id) VALUES (?,?,?)";
        Connection connection = psqlConnect.connect();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, answer.description());
            preparedStatement.setInt(2,answer.question_id());
            preparedStatement.setInt(3,answer.user_id());
            preparedStatement.executeUpdate();
            System.out.println("answer added");
            return answer.id();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }
}
