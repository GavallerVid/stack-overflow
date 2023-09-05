package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
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

            while (rs.next()) {
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

    @Override
    public int addNewQuestion (NewQuestionDTO newQuestionDTO) {
//        String SQL = "INSERT INTO questions(first_name,last_name) "
//                + "VALUES(?,?)";
//
        int id = 0;
//
//        try (Connection conn = connect();
//             PreparedStatement pstmt = conn.prepareStatement(SQL,
//                     Statement.RETURN_GENERATED_KEYS)) {
//
//            pstmt.setString(1, actor.getFirstName());
//            pstmt.setString(2, actor.getLastName());
//
//            int affectedRows = pstmt.executeUpdate();
//            // check the affected rows
//            if (affectedRows > 0) {
//                // get the ID back
//                try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                    if (rs.next()) {
//                        id = rs.getLong(1);
//                    }
//                } catch (SQLException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
        return id;
    }
}
