--Участники
CREATE TABLE PARTICIPANT
(
    ID             BIGINT GENERATED BY DEFAULT AS IDENTITY,
    NAME           TEXT NOT NULL,
    AGE            BIGINT NOT NULL,
    CITY           TEXT NOT NULL,
    PRIMARY KEY (ID)
);

--Победители
CREATE TABLE WINNER
(
    ID             BIGINT GENERATED BY DEFAULT AS IDENTITY,
    NAME           TEXT NOT NULL,
    AGE            BIGINT NOT NULL,
    CITY           TEXT NOT NULL,
    WINNING_AMOUNT BIGINT NOT NULL,
    PRIMARY KEY (ID)
);
