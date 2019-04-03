CREATE DATABASE  IF NOT EXISTS `student_course_tracker`; 
USE `student_course_tracker`;
DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `course`;


CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `instructor` varchar(128) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
  );

  


