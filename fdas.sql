/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.32 : Database - pdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pdb`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `detail` varchar(100) NOT NULL,
  `beginTime` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `departmentId` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `departmentId` (`departmentId`),
  CONSTRAINT `job_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Table structure for table `leaveinfo` */

DROP TABLE IF EXISTS `leaveinfo`;

CREATE TABLE `leaveinfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `staffId` int(20) NOT NULL,
  `quitTime` varchar(30) NOT NULL,
  `type` int(20) NOT NULL,
  `isResume` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `staffId` (`staffId`),
  CONSTRAINT `leaveInfo_ibfk_1` FOREIGN KEY (`staffId`) REFERENCES `staff` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `probinfo` */

DROP TABLE IF EXISTS `probinfo`;

CREATE TABLE `probinfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `staffId` int(20) NOT NULL,
  `probResult` int(20) DEFAULT NULL,
  `probBeginTime` varchar(30) NOT NULL,
  `probEndTime` varchar(30) NOT NULL,
  `executeTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `staffId` (`staffId`),
  CONSTRAINT `probInfo_ibfk_1` FOREIGN KEY (`staffId`) REFERENCES `staff` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `gender` int(20) NOT NULL,
  `identityId` varchar(30) NOT NULL,
  `departmentId` int(20) DEFAULT NULL,
  `jobId` int(20) DEFAULT NULL,
  `enterTime` varchar(30) DEFAULT NULL,
  `workType` int(20) DEFAULT NULL,
  `from` int(20) NOT NULL,
  `org` int(20) NOT NULL,
  `home` varchar(100) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `qualif1` int(20) NOT NULL,
  `qualif2` int(20) NOT NULL,
  `university` varchar(100) NOT NULL,
  `major` varchar(100) NOT NULL,
  `isEnter` int(20) NOT NULL,
  `isQuit` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `departmentId` (`departmentId`),
  KEY `jobId` (`jobId`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `staff_ibfk_2` FOREIGN KEY (`jobId`) REFERENCES `job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
