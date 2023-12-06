CREATE DATABASE rpg;

CREATE TABLE rpg.users
(
    id       INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE rpg.races
(
    id   INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE rpg.dnd_characters
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

    FOREIGN KEY (user_id) REFERENCES rpg.users (id),
    FOREIGN KEY (race_id) REFERENCES rpg.races (id)
);

INSERT INTO `users`
VALUES (1, 'ansexy', '123123'),
       (2, 'ceo_cloudia', 'silence'),
       (3, 'rotero', 'senha');

INSERT INTO `races`
VALUES (1, 'Orc'),
       (2, 'Human'),
       (3, 'Dwarf');

INSERT INTO `dnd_characters`
VALUES (1, 1, 1, 'Strogo', 'The Orc', 7, 18, 17, 18, 8, 8, 7),
       (2, 2, 3, 'Bronson', 'The Warhammer', 7, 18, 15, 18, 8, 8, 8),
       (2, 2, 3, 'Bronson', 'The Warhammer', 7, 18, 15, 18, 8, 8, 8);
