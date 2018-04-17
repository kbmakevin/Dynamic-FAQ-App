CREATE SCHEMA FAQ_DB;

USE FAQ_DB;

CREATE TABLE `topics` (
    `topic_id` INT(5) NOT NULL,
    `topic_name` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`topic_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `faq` (
    `topic_id` INT(5) NOT NULL,
    `question_id` INT(3) NOT NULL,
    `question` VARCHAR(50) NOT NULL,
    `answer` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`topic_id` , `question_id`),
    CONSTRAINT `topic_fk` FOREIGN KEY (`topic_id`)
        REFERENCES `topics` (`topic_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;