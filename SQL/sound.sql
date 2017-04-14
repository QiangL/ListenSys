CREATE TABLE `sound` (
  `sound_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `folder_id` int(11) NOT NULL,
  `points` int(11) DEFAULT '0',
  `comment` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `marked` int(11) DEFAULT '0',
  `path` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`sound_id`),
  KEY `student_id` (`student_id`),
  KEY `folder_id` (`folder_id`),
  KEY `student_and_folder` (`student_id`,`folder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
