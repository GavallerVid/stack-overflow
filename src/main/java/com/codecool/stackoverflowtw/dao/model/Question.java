package com.codecool.stackoverflowtw.dao.model;

public record Question (int question_id, String title, String description, int user_id, int answerCount) {
}
