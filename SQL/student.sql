CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL,
  `studentName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `classes_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `studentId` (`studentId`),
  KEY `classes_id_idx` (`classes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
