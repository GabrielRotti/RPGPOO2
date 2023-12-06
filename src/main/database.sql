CREATE DATABASE rpg;

CREATE TABLE users
(
    id       INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE races
(
    id       INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL
);

CREATE TABLE dnd_characters
(
    id             INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id        INTEGER      NOT NULL,
    race_id        INTEGER      NOT NULL,
    character_name VARCHAR(255) NOT NULL,
    title          VARCHAR(255) NOT NULL,
    lvl            INTEGER      NOT NULL,
    str            INTEGER      NOT NULL,
    dex            INTEGER      NOT NULL,
    con            INTEGER      NOT NULL,
    wis            INTEGER      NOT NULL,
    cha            INTEGER      NOT NULL,
    smt            INTEGER      NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (race_id) REFERENCES races (id)
);
