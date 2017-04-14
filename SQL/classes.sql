CREATE TABLE `classes` (
  `classes_id` int(11) NOT NULL AUTO_INCREMENT,
  `classesId` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `classesName` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`classes_id`),
  UNIQUE KEY `id_UNIQUE` (`classes_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `clazzId` (`classesId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

