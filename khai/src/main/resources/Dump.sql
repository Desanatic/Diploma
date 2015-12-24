-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.10-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.3.0.5026
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных trkhai
DROP DATABASE IF EXISTS `trkhai`;
CREATE DATABASE IF NOT EXISTS `trkhai` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `trkhai`;


-- Дамп структуры для таблица trkhai.group
DROP TABLE IF EXISTS `group`;
CREATE TABLE IF NOT EXISTS `group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы trkhai.group: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` (`id`, `name`) VALUES
	(0, 'aw');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;


-- Дамп структуры для таблица trkhai.homework
DROP TABLE IF EXISTS `homework`;
CREATE TABLE IF NOT EXISTS `homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `training_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `date_of_delivery` date DEFAULT NULL,
  KEY `id` (`id`),
  KEY `FK_homework_training` (`training_id`),
  CONSTRAINT `FK_homework_training` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы trkhai.homework: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
INSERT INTO `homework` (`id`, `training_id`, `name`, `date_of_delivery`) VALUES
	(0, 1, 'firsHomework', '2015-11-01'),
	(2, 1, 'adawawd', '2015-12-20');
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;


-- Дамп структуры для таблица trkhai.homework_task
DROP TABLE IF EXISTS `homework_task`;
CREATE TABLE IF NOT EXISTS `homework_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `homework_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `task` text,
  `chart` text,
  `state` enum('DONE','CLOSE','IN_PROGRESS','OVERDUE','NEW') DEFAULT NULL,
  KEY `id` (`id`),
  KEY `FK_homework_task_homework` (`homework_id`),
  KEY `FK_homework_task_user` (`user_id`),
  CONSTRAINT `FK_homework_task_homework` FOREIGN KEY (`homework_id`) REFERENCES `homework` (`id`),
  CONSTRAINT `FK_homework_task_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы trkhai.homework_task: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `homework_task` DISABLE KEYS */;
INSERT INTO `homework_task` (`id`, `homework_id`, `user_id`, `task`, `chart`, `state`) VALUES
	(1, 0, 0, 'С одной стороны улицы подряд стоят пять домов, каждый — своего цвета. В каждом живёт человек, все пять — разных национальностей. Каждый человек предпочитает уникальную марку сигарет, напиток и домашнее животное. Кроме того:', '{labels: [\'Mon\', \'Tue\', \'Wed\', \'Thu\', \'Fri\'],', 'NEW'),
	(2, 2, 0, 'awdawdawdawd', 'awdadawddawd', 'DONE');
/*!40000 ALTER TABLE `homework_task` ENABLE KEYS */;


-- Дамп структуры для таблица trkhai.proverb
DROP TABLE IF EXISTS `proverb`;
CREATE TABLE IF NOT EXISTS `proverb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proverb` varchar(100) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы trkhai.proverb: ~10 rows (приблизительно)
/*!40000 ALTER TABLE `proverb` DISABLE KEYS */;
INSERT INTO `proverb` (`id`, `proverb`) VALUES
	(1, 'Не учись до старости, а учись до смерти.'),
	(2, 'Без терпенья нет ученья.'),
	(3, 'Перо пишет, а ум водит.'),
	(4, 'Не бойся, когда не знаешь: страшно, когда знать не хочется.'),
	(5, 'Человек без знаний – все - равно, что гриб: хотя на взгляд и крепкий, а за землю плохо держится.'),
	(6, 'Мир освещается солнцем, а человек — знанием.'),
	(7, 'Неграмотный — что слепой. '),
	(8, 'Много ученых, мало смышленных.'),
	(9, 'Наука в лес не ведет, а из лесу выводит.'),
	(10, 'Мудрым ни кто не родился, а научился.');
/*!40000 ALTER TABLE `proverb` ENABLE KEYS */;


-- Дамп структуры для таблица trkhai.solution
DROP TABLE IF EXISTS `solution`;
CREATE TABLE IF NOT EXISTS `solution` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `homework_id` int(11) DEFAULT NULL,
  `decision` text,
  `chart` text,
  `assessment` int(11) DEFAULT NULL,
  KEY `id` (`id`),
  KEY `FK_solution_user` (`user_id`),
  KEY `FK_solution_homework` (`homework_id`),
  CONSTRAINT `FK_solution_homework` FOREIGN KEY (`homework_id`) REFERENCES `homework` (`id`),
  CONSTRAINT `FK_solution_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы trkhai.solution: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `solution` DISABLE KEYS */;
/*!40000 ALTER TABLE `solution` ENABLE KEYS */;


-- Дамп структуры для таблица trkhai.training
DROP TABLE IF EXISTS `training`;
CREATE TABLE IF NOT EXISTS `training` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы trkhai.training: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` (`id`, `name`) VALUES
	(1, 'testTraining');
/*!40000 ALTER TABLE `training` ENABLE KEYS */;


-- Дамп структуры для таблица trkhai.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  KEY `id` (`id`),
  KEY `FK_user_group` (`group_id`),
  CONSTRAINT `FK_user_group` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы trkhai.user: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `group_id`, `name`, `surname`, `middle_name`, `role`, `password`) VALUES
	(0, 0, 'Vladyslav', 'Dubinin', 'Artemovich', 'student', '123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры для таблица trkhai.user_home_work
DROP TABLE IF EXISTS `user_home_work`;
CREATE TABLE IF NOT EXISTS `user_home_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `home_work_id` int(11) DEFAULT NULL,
  `home_work_task_id` int(11) DEFAULT NULL,
  `training_id` int(11) DEFAULT NULL,
  KEY `id` (`id`),
  KEY `FK_user_home_work_user` (`user_id`),
  KEY `FK_user_home_work_homework` (`home_work_id`),
  KEY `FK_user_home_work_training` (`training_id`),
  KEY `FK_user_home_work_homework_task` (`home_work_task_id`),
  CONSTRAINT `FK_user_home_work_homework` FOREIGN KEY (`home_work_id`) REFERENCES `homework` (`id`),
  CONSTRAINT `FK_user_home_work_homework_task` FOREIGN KEY (`home_work_task_id`) REFERENCES `homework_task` (`id`),
  CONSTRAINT `FK_user_home_work_training` FOREIGN KEY (`training_id`) REFERENCES `training` (`id`),
  CONSTRAINT `FK_user_home_work_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы trkhai.user_home_work: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `user_home_work` DISABLE KEYS */;
INSERT INTO `user_home_work` (`id`, `user_id`, `home_work_id`, `home_work_task_id`, `training_id`) VALUES
	(1, 0, 0, 1, 1),
	(3, 0, 0, 2, 1);
/*!40000 ALTER TABLE `user_home_work` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
