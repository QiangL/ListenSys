CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `studentName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `teacher_id` int(11) NOT NULL,
  `classes_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `classes_id_idx` (`classes_id`),
  KEY `teacher_id_idx` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
