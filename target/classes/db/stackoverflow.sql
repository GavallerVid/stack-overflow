DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS answers;

CREATE TABLE users
(
    user_id             serial primary key,
    user_name           character varying(15) NOT NULL,
    password           character varying(15) NOT NULL
);

CREATE TABLE questions
(
    question_id serial primary key,
    description text
    user_id int NOT NULL,
    foreign key (user_id)
        references users (user_id)
);

CREATE TABLE answers
(
    answer_id   serial primary key,
    description text,
    question_id int NOT NULL,
    foreign key (question_id)
        references questions (question_id)
);
