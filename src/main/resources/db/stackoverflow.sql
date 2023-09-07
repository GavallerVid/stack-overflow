DROP TABLE IF EXISTS questions CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS answers CASCADE;

CREATE TABLE users
(
    user_id             serial primary key,
    user_name           character varying(35) UNIQUE NOT NULL,
    password           character varying(45) NOT NULL
);

CREATE TABLE questions
(
    question_id serial primary key,
    title text,
    description text,
    user_id serial NOT NULL,
    foreign key (user_id)
        references users (user_id)
);

CREATE TABLE answers
(
    answer_id   serial primary key,
    description text,
    question_id serial NOT NULL,
    foreign key (question_id)
        references questions (question_id) ON DELETE CASCADE,
    user_id serial NOT NULL,
    foreign key (user_id)
        references users (user_id)
);

