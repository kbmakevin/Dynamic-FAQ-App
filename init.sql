#DDL
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

#DML
insert into `topics`  values 
	(10,'Javabean'),
    (20,'Servlet'),
    (30,'jsp');
    
insert into `faq` values
	(10,1,'What is a java bean?','A java bean is a component written in Java.'),
    (10,2,'Are Java beans portable?', 'Yes, they are Java components.'),
    (20,1,'What is a Java Servlet?','A Java Servlet is a server side Java class that runs on a Web server');