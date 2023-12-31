package com.codecool.stackoverflowtw.dao;


import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;

import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.service.PSQLConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {
    private final PSQLConnect psqlConnect;

    public QuestionsDaoJdbc(PSQLConnect psqlConnect) {
        this.psqlConnect = psqlConnect;
    }

    @Override
    public List<Question> getAllQuestionsWithAnswerCount() {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT *, COUNT(a.answer_id) FROM questions q " +
        "LEFT JOIN answers a ON a.question_id = q.question_id " +
        "GROUP BY q.question_id, a.answer_id";

        try {
            Connection conn = psqlConnect.connect();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                int question_id = rs.getInt("question_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int user_id = rs.getInt("user_id");
                int answerCount = rs.getInt("count");

                questions.add(new Question(question_id, title, description, user_id, answerCount));

                System.out.printf("QID: %d, Title: %s, Description: %s, UID: %d, answers: %d", question_id, title, description, user_id, answerCount);

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
    public int addQuestion(NewQuestionDTO newQuestionDTO) {
        String sql = "INSERT INTO questions(title, description ,user_id) VALUES (?,?,?)";
        Connection connection = psqlConnect.connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newQuestionDTO.title());
            preparedStatement.setString(2, newQuestionDTO.description());
            preparedStatement.setInt(3, newQuestionDTO.user_id());
            preparedStatement.executeUpdate();
            System.out.println("question added");
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }


    public int deleteQuestionById(int id) {

        String SQL = "DELETE FROM questions WHERE question_id = ?";

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


}
