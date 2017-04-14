CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `teacherName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 NOT NULL,
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  UNIQUE KEY `teacherId` (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
