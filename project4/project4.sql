/*
SQLyog Job Agent Version 9.02 Copyright(c) Webyog Softworks Pvt. Ltd. All Rights Reserved.


MySQL - 5.0.24-community-nt : Database - project_4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`project_4` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `project_4`;

/*Table structure for table `st_college` */

DROP TABLE IF EXISTS `st_college`;

CREATE TABLE `st_college` (
  `ID` int(50) NOT NULL,
  `NAME` varchar(50) default NULL,
  `ADDRESS` varchar(50) default NULL,
  `STATE` varchar(50) default NULL,
  `CITY` varchar(50) default NULL,
  `PHONE_NO` varchar(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` varchar(50) default NULL,
  `MODIFIED_DATE_TIME` varchar(50) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_college` */

insert  into `st_college` values (1,'NIT','vijay nagar','MADHYA PRADESH','INDORE','9876789876','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:27:28','2020-11-24 21:27:28'),(2,'Gujrati','141,Dheeraj nagar`','MADHYA PRADESH','INDORE','9876789876','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:27:53','2020-11-24 21:27:53'),(3,'Acropolish','vijay nagar','MP','INDORE','9989998985','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:29:05','2020-11-24 21:29:05'),(4,'SOFTVISION','vijay nagar','MP','INDORE','9989998985','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:29:05','2020-11-24 21:29:26'),(5,'Prestige','141,Dheeraj nagar near yadav shree showroom','MADHYA PRADESH','INDORE','9989998987','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:29:59','2020-11-24 21:29:59'),(6,'davv','shajapur','MADHYA PRADESH','INDORE','9989998987',NULL,NULL,NULL,NULL),(7,'Davv','141,Dheeraj nagar near yadav shree showroom','MADHYA PRADESH','INDORE','9989998987','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:29:59','2020-11-24 21:30:31'),(8,'Holkar','141,Dheeraj nagar near yadav shree showroom','MADHYA PRADESH','INDORE','9989998987','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-22 01:38:42','2021-12-22 01:38:42'),(9,'SGSITS','141,Dheeraj nagar near yadav shree showroom','MADHYA PRADESH','INDORE','9989998987','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:29:59','2020-11-24 21:31:23'),(10,'Medicaps','141,Dheeraj nagar near yadav shree showroom','MADHYA PRADESH','INDORE','9989998987','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:29:59','2020-11-24 21:31:52'),(11,'aurbindo','141,Dheeraj nagar near yadav shree showroom','MADHYA PRADESH','INDORE','9989998987','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:29:59','2020-11-24 21:32:21'),(12,'sanskar','khardone','mp','indore','7806085877','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-10 21:59:42','2021-12-10 21:59:42'),(13,'ips','khardone','MADHYA PRADESH','indore','9898767888','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-11 11:07:42','2021-12-11 11:07:42');

/*Table structure for table `st_course` */

DROP TABLE IF EXISTS `st_course`;

CREATE TABLE `st_course` (
  `ID` bigint(50) NOT NULL,
  `COURSE_NAME` varchar(50) default NULL,
  `DESCRIPTION` varchar(50) default NULL,
  `DURATION` varchar(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` timestamp NULL default CURRENT_TIMESTAMP,
  `MODIFIED_DATE_TIME` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_course` */

insert  into `st_course` values (1,'CA','good','4Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-19 16:53:00','2020-11-19 16:53:00'),(2,'B.tech','zz','4Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:35:08','2020-11-24 21:35:08'),(3,'BSC','zz','3Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:35:08','2020-11-24 21:35:18'),(4,'BCA','zz','3Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:35:08','2020-11-24 21:35:25'),(5,'MCA','zz','2Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:35:08','2020-11-24 21:35:39'),(6,'BBA','aa','3Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:36:05','2020-11-24 21:36:09'),(7,'B.pharma','aa','4Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:36:05','2020-11-24 21:36:33'),(8,'M.pharma','aa','2Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:36:05','2020-11-24 21:36:43'),(9,'M.tech','aa','2Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:36:05','2020-11-24 21:36:51'),(10,'MBA','aa','2Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:36:05','2020-11-24 21:37:13'),(11,'MMPSC','aa','2Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:36:05','2020-11-24 21:37:17'),(12,'PHD','aa','2Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:36:05','2020-11-24 21:37:07'),(15,'Mcom','hjhhhj','2Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-20 12:36:40','2020-12-20 12:36:40'),(16,'LKG','jkjkjkj','1Year','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-20 12:37:01','2020-12-20 12:37:01'),(17,'MPPSC','phhhhh','3Year','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-10 18:38:28','2021-12-10 18:38:28'),(18,'MPPSC','phhhhh','3Year','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-10 18:40:05','2021-12-10 18:40:05'),(19,'MSC','hhhhjk','3Year','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-10 18:41:46','2021-12-10 18:41:46'),(20,'MCA','hdbrsbxtgs','3Year','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-10 18:49:50','2021-12-10 18:49:50'),(21,'PPT','index','3Year','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-26 01:17:29','2021-12-26 01:17:29'),(22,'MA','defret4','2Year','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-26 01:17:52','2021-12-26 01:17:52');

/*Table structure for table `st_faculty` */

DROP TABLE IF EXISTS `st_faculty`;

CREATE TABLE `st_faculty` (
  `ID` int(50) NOT NULL,
  `FIRST_NAME` varchar(50) default NULL,
  `LAST_NAME` varchar(50) default NULL,
  `GENDER` varchar(50) default NULL,
  `JOINING_DATE` date default NULL,
  `QUALIFICATION` varchar(50) default NULL,
  `EMAIL_ID` varchar(50) default NULL,
  `MOBILE_NO` varchar(50) default NULL,
  `COLLEGE_ID` varchar(50) default NULL,
  `COLLEGE_NAME` varchar(50) default NULL,
  `COURSE_ID` bigint(50) default NULL,
  `COURSE_NAME` varchar(50) default NULL,
  `SUBJECT_ID` bigint(50) default NULL,
  `SUBJECT_NAME` varchar(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` timestamp NULL default NULL,
  `MODIFIED_DATE_TIME` timestamp NULL default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_faculty` */

insert  into `st_faculty` values (1,'Ajay','singh','Male','2017-05-11','Graduate','Ankit@gmail.com','9898989897','7','ajay',3,'CA',8,'hindi','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:41:37','2020-11-24 21:41:37'),(2,'Priya','jain','Male','2017-05-11','Graduate','Ankit@gmail.com','9898989897','7','Aurbindo',3,'CA',8,'hindi','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:41:46','2020-11-24 21:41:46'),(4,'Aryan','jain','Male','2017-05-11','Graduate','Ankit@gmail.com','9898989897','7','Aurbindo',3,'CA',8,'hindi','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:41:57','2020-11-24 21:41:57'),(5,'Shyam','jain','Male','2017-05-11','Graduate','Ankit@gmail.com','9898989897','7','Aurbindo',3,'CA',8,'hindi','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:42:03','2020-11-24 21:42:03'),(6,'Neelam','jain','Male','2017-05-11','Graduate','Ankit@gmail.com','9898989897','7','Aurbindo',3,'CA',8,'hindi','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:42:12','2020-11-24 21:42:12'),(7,'Sandhya','jain','Male','2017-05-11','Graduate','Ankit@gmail.com','9898989897','7','Aurbindo',3,'CA',8,'hindi','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:42:19','2020-11-24 21:42:19'),(8,'neeraj','jain','Male','2017-05-11','Graduate','Ankit@gmail.com','9898989897','7','Aurbindo',3,'CA',8,'hindi','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:42:25','2020-11-24 21:42:25'),(9,'vipin','mishra','Male','2021-05-12','Graduate','ajju@gmail.com','9565656543','11','SGSITS',2,'BE',6,'Tocs','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:03:45','2020-12-19 01:03:45'),(10,'cdcdscsd','sharmaassa','Female','2021-04-12','Graduate','wdwcdct@gmail.com','9898989897','1','NIT',13,'MBA',6,'Tocs','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:04:53','2020-12-19 01:04:53'),(11,'ffdff','sharmwdw','Female','2021-04-12','Graduate','wdwcdct@gmail.com','9898989856','1','NIT',11,'M.tech',6,'Tocs','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:05:20','2020-12-19 01:05:20'),(12,'Ankitsa','sharma','Male','2022-12-12','Graduate','akas3e3h@gmail.com','9399502158','6','Prestige',14,'MA',4,'Networking','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:06:29','2020-12-19 01:06:29'),(13,'Ankitsad','sharma','Male','2022-12-12','Graduate','akas3e3h@gmail.com','9399502158','6','Prestige',14,'MA',4,'Networking','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:06:35','2020-12-19 01:06:35'),(14,'kali','sharma','Male','2022-12-12','Graduate','akas3e3h@gmail.com','9399502159','6','Prestige',14,'MA',4,'Networking','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:07:06','2020-12-19 01:07:06'),(15,'kajal','sharma','Male','2022-12-12','Graduate','akas3e3h@gmail.com','9399502159','6','Prestige',14,'MA',4,'Networking','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:07:17','2020-12-19 01:07:17'),(16,'ashish','patidar','Male','2020-02-03','BE','jay@gmail.com','7806085877','14','davv',12,'PHD',6,'Tocs','jay@gmail.com','jay@gmail.com','2021-11-30 23:16:18','2021-11-30 23:16:18'),(17,'palak','patidar','Male','2021-01-12','BE','pavanpatidar12@gmail.com','7806085877','6','Prestige',10,'M.pharma',4,'Networking','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-11 11:02:30','2021-12-11 11:02:30'),(18,'bhupendra','patidar','Male','2001-01-01','MA','pavanpatidar580@gmail.com','7806085877','6','Prestige',5,'BSC',24,'English','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-13 15:27:08','2021-12-13 15:27:08');

/*Table structure for table `st_marksheet` */

DROP TABLE IF EXISTS `st_marksheet`;

CREATE TABLE `st_marksheet` (
  `ID` bigint(50) default NULL,
  `ROLL_NO` varchar(50) default NULL,
  `STUDENT_ID` bigint(50) default NULL,
  `NAME` varchar(50) default NULL,
  `PHYSICS` int(50) default NULL,
  `CHEMISTRY` int(50) default NULL,
  `MATHS` int(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` varchar(50) default NULL,
  `MODIFIED_DATE_TIME` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_marksheet` */

insert  into `st_marksheet` values (1,'IT3041',1,'krishnapal',98,65,66,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-04 14:09:22','2020-11-04 14:10:28'),(2,'IT3049',2,'AnkitSingh',65,90,54,'mayankmishra661@gmail.com','bhupendra2000.bp@gmail.com','2021-12-22 01:43:12','2021-12-22 01:43:12'),(3,'IT3046',2,'AnkitSingh',98,65,66,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-04 23:19:25','2020-11-04 23:19:38'),(4,'IT3047',7,'parasmishra',98,98,98,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:15:33','2020-12-19 01:15:33'),(5,'IT3045',4,'ajaymishra',98,98,98,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:15:33','2020-12-19 01:15:47'),(6,'IT3044',13,'Sonamjain',98,98,98,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:15:33','2020-12-19 01:15:54'),(7,'IT3043',12,'Sonamjain',34,56,76,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:15:33','2020-12-19 01:16:13'),(8,'IT3041',11,'Sonamjain',34,65,76,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:15:33','2020-12-19 01:16:26'),(9,'IT3087',9,'ArpitDubey',65,56,77,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:17:21','2020-12-19 01:17:21'),(10,'IT3079',8,'ShivamDubey',65,56,77,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:17:21','2020-12-19 01:17:30'),(11,'IT2445',8,'ShivamDubey',56,54,77,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:17:21','2020-12-19 01:17:53'),(12,'IT2464',6,'Shyams',56,54,77,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:17:21','2020-12-19 01:18:05'),(13,'IT3076',2,'AnkitSingh',45,23,45,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:18:32','2020-12-19 01:18:32'),(14,'IT3078',2,'AnkitSingh',45,23,45,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:18:32','2020-12-19 01:18:36'),(15,'IT3064',2,'AnkitSingh',45,23,45,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:18:32','2020-12-19 01:18:42'),(16,'IT1001',16,'AjaySingh',78,89,54,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-22 01:22:18','2021-12-22 01:22:18'),(17,'IT7001',6,'Shyams',78,88,-78,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-22 01:23:12','2021-12-22 01:23:12'),(18,'IT3002',7,'parasmishra',99,98,99,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-22 01:42:16','2021-12-22 01:42:16'),(19,'IT4002',2,'AnkitSingh',99,99,99,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-22 12:44:36','2021-12-22 12:44:36'),(20,'IT3022',17,'sachinpatidar',78,98,99,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-01-20 14:41:41','2022-01-20 14:41:41');

/*Table structure for table `st_role` */

DROP TABLE IF EXISTS `st_role`;

CREATE TABLE `st_role` (
  `ID` bigint(50) NOT NULL,
  `NAME` varchar(50) default NULL,
  `DESCRIPTION` varchar(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `MODIFIED_DATE_TIME` timestamp NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_role` */

insert  into `st_role` values (1,'Admin','Admin','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:58:32','2020-10-29 14:10:18'),(2,'Student','Stuent','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:58:34','2020-10-30 15:19:24'),(3,'faculty','faculty','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:58:37','2020-10-30 15:18:53'),(4,'online','Online','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:58:25','2021-12-21 15:55:23'),(5,'shubham','patidar','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-01-05 13:09:10','2022-01-05 13:09:10'),(6,'Ajay','sadf','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:58:43','2022-02-22 23:36:38'),(7,'shubham','fafa','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:21:27','2022-03-09 15:21:27');

/*Table structure for table `st_student` */

DROP TABLE IF EXISTS `st_student`;

CREATE TABLE `st_student` (
  `ID` bigint(50) NOT NULL,
  `COLLEGE_ID` bigint(50) default NULL,
  `COLLEGE_NAME` varchar(50) default NULL,
  `FIRST_NAME` varchar(50) default NULL,
  `LAST_NAME` varchar(50) default NULL,
  `DATE_OF_BIRTH` date default NULL,
  `MOBILE_NO` varchar(50) default NULL,
  `EMAIL` varchar(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` timestamp NULL default CURRENT_TIMESTAMP,
  `MODIFIED_DATE_TIME` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_student` */

insert  into `st_student` values (2,1,'gwalior','Ankit','Singh','2000-01-01','9087654567','ankit@gmail.com','admin','admin','2020-10-31 18:18:58','2020-10-31 18:18:58'),(3,1,'NIT','ramesh','Singh','2000-01-01','9087654567','ankit@gmail.com','admin','bhupendra2000.bp@gmail.com','2022-02-18 15:47:12','2022-02-18 15:47:12'),(4,2,'Gujrati','ajay','mishra','1990-11-19','9898989890','mayankmishra661@gmail.com','mayankmishra661@gmail.com','bhupendra2000.bp@gmail.com','2022-01-04 00:39:34','2022-01-04 00:39:34'),(5,5,'Prestige','Shyam','parmar','2001-11-02','9989898989','mayankmishra666@gmail.com','mayankmishra666@gmail.com','bhupendra2000.bp@gmail.com','2021-12-25 02:06:04','2021-12-25 02:06:04'),(6,2,'Gujrati','paras','mishra','1994-11-09','9898989899','Paras@gmail.com','mayankmishra661@gmail.com','bhupendra2000.bp@gmail.com','2022-03-28 15:56:26','2022-03-28 15:56:26'),(7,2,'Gujrati','Shivam','Dubey','1994-11-09','9898989899','Shivam@gmail.com','mayankmishra661@gmail.com','bhupendra2000.bp@gmail.com','2022-02-28 10:39:05','2022-02-28 10:39:05'),(8,1,'NIT','Arpit','Dubey','1994-11-09','9898989899','Arpit@gmail.com','mayankmishra661@gmail.com','bhupendra2000.bp@gmail.com','2022-03-21 17:24:41','2022-03-21 17:24:41'),(9,2,'Gujrati','Shri','Dubey','1994-11-09','9898989899','Shri@gmail.com','mayankmishra661@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:57:08','2022-03-09 15:57:08'),(10,5,'Prestige','Sonam','jain','1989-11-08','9898989899','deechavhan.098@gmail.com','mayankmishra661@gmail.com','bhupendra2000.bp@gmail.com','2022-02-28 11:27:19','2022-02-28 11:27:19'),(11,5,'Softvision','Sonam','jain','1989-11-08','9898989899','sonam@gmail.com','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 22:51:50','2020-11-24 22:52:16'),(12,5,'Softvision','Sonam','jain','1989-11-08','9898989899','sonam123@gmail.com','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 22:51:50','2020-11-24 22:52:21'),(13,4,'Softvision','madhvi','patidar','1996-01-01','9070305256','ajay@gmail.com','admin','admin','2021-11-09 15:31:31','2021-11-09 15:31:31'),(14,2,'Gujrati','Ajay','Singh','2000-01-01','9087654567','ajay@gmail.com','admin','bhupendra2000.bp@gmail.com','2022-01-09 19:28:18','2022-01-09 19:28:18'),(15,2,'Gujrati','Ajay','Singh','2000-01-01','9087654567','pavan@gmail.com','admin','admin','2021-11-16 10:59:35','2021-11-16 10:59:35'),(16,4,'davv 1','kanu','patidar','1997-01-14','7806085877','abhhi@gmail.com','jay@gmail.com','jay@gmail.com','2021-11-27 10:48:38','2021-11-27 10:48:38'),(17,13,'XYZ','sachin','patidar','1998-01-01','7806085877','raj@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-11 00:30:10','2021-12-11 00:30:10'),(18,1,'NIT','devendra','jaat','2000-01-01','7806085877','devendra@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-11 11:05:31','2021-12-11 11:05:31'),(19,7,'Holkar','dheeraj','kumar','1999-01-01','9179954666','dheeraj@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-12 02:15:26','2021-12-12 02:15:26'),(20,11,'SGSITS','arjit','nema','1999-01-05','7806085877','arjit@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2021-12-13 15:21:31','2021-12-13 15:21:31'),(21,5,'aurbindo','ajju','rathore','2000-01-01','7806085877','ajju@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-01-31 15:32:56','2022-01-31 15:32:56'),(22,11,'aurbindo','naveen','patidar','2000-01-01','7806085877','naveen@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-03 16:22:54','2022-03-03 16:22:54'),(23,10,'Medicaps','vikas','patidar','2000-01-01','7806085877','vikas@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-08 17:35:03','2022-03-08 17:35:03'),(24,10,'Medicaps','sarthak','patidar','2000-01-01','7806085877','sarthak@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-08 17:36:33','2022-03-08 17:36:33'),(25,12,'sanskar','Ritik','kushwah','1995-01-01','7806085877','ritik@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 14:44:21','2022-03-09 14:44:21'),(26,4,'Softvision','ashish','jaat','1995-01-01','7806085877','ashish@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 14:45:13','2022-03-09 14:45:13'),(27,1,'NIT','puspendra','jaat','1998-01-01','7806085877','push@gmail.com','bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:33:03','2022-03-09 15:33:03');

/*Table structure for table `st_subject` */

DROP TABLE IF EXISTS `st_subject`;

CREATE TABLE `st_subject` (
  `ID` bigint(50) NOT NULL,
  `SUBJECT_NAME` varchar(50) default NULL,
  `DESCRIPTION` varchar(50) default NULL,
  `COURSE_NAME` varchar(50) default NULL,
  `COURSE_ID` bigint(50) default NULL,
  `SUBJECT_ID` bigint(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` timestamp NULL default CURRENT_TIMESTAMP,
  `MODIFIED_DATE_TIME` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_subject` */

insert  into `st_subject` values (2,'Chemistry','sas','B.tech',4,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:37:58','2020-11-24 21:38:04'),(4,'Networking','sasffe','B.tech',4,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:37:58','2020-11-27 15:53:04'),(5,'CSO','sas','BCA',4,0,'mayankmishra661@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:36:08','2022-03-31 19:36:08'),(6,'Tocs','sas','B.tech',4,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:37:58','2020-11-24 21:39:00'),(7,'English','sas','BBA',8,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:37:58','2020-11-24 21:39:09'),(8,'hindi','sas','B.pharma',9,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:37:58','2020-11-24 21:39:15'),(9,'nursing','sas','B.pharma',9,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:37:58','2020-11-24 21:39:20'),(10,'maths','sas','B.pharma',9,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:37:58','2020-11-24 21:39:24'),(11,'sanskrit','sas','B.pharma',9,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:37:58','2020-11-24 21:39:31'),(12,'urdu','dwqd','PHD',12,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:39:53','2020-11-24 21:39:55'),(13,'c','dcdcdc','B.tech',4,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:13:48','2020-12-19 01:13:48'),(14,'c#','dcdcdc','B.tech',4,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:13:48','2020-12-19 01:13:54'),(15,'Python','dcdcdc','B.tech',4,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:13:48','2020-12-19 01:14:10'),(16,'iot','dcdcdc','B.tech',4,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:13:48','2020-12-19 01:14:34'),(17,'cs0','jhjhjhjh','PHD',12,0,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-20 12:37:52','2020-12-20 12:37:52'),(18,'chemistry','bachelor','CA',3,103,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2021-11-12 15:37:31','2021-11-12 15:37:31'),(19,'EVS','read','BBA',6,0,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:33:45','2022-03-31 19:33:45'),(20,'JAVA','Write','MCA',5,0,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:34:03','2022-03-31 19:34:03'),(21,'Python','hoooo','BCA',4,0,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:34:29','2022-03-31 19:34:29'),(22,'Spring','btech','B.tech',2,0,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:34:45','2022-03-31 19:34:45'),(23,'Angular','hhhhh','BBA',6,0,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:35:00','2022-03-31 19:35:00'),(24,'Advance','read','M.tech',9,0,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:35:48','2022-03-31 19:35:48'),(25,'React','djnjkcnjf','BSC',3,0,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:38:33','2022-03-31 19:38:33'),(26,'English','king','MBA',10,0,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-31 19:39:01','2022-03-31 19:39:01');

/*Table structure for table `st_timetable` */

DROP TABLE IF EXISTS `st_timetable`;

CREATE TABLE `st_timetable` (
  `ID` bigint(50) NOT NULL,
  `SUB_ID` bigint(50) default NULL,
  `SUB_NAME` varchar(50) default NULL,
  `COURSE_ID` bigint(50) default NULL,
  `COURSE_NAME` varchar(50) default NULL,
  `SEMESTER` varchar(50) default NULL,
  `EXAM_DATE` date default NULL,
  `EXAM_TIME` varchar(50) default NULL,
  `DESCRIPTION` varchar(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` timestamp NULL default CURRENT_TIMESTAMP,
  `MODIFIED_DATE_TIME` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_timetable` */

insert  into `st_timetable` values (1,1,'Complier',1,'B.com','4','2022-02-11','08:00 AM to 11:00 AM','gyuy','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:43:15','2020-11-24 21:43:15'),(2,2,'Maths2',8,'MSC9','5','2022-01-11','3:00PM to 6:00PM','xx','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:43:43','2020-11-24 21:43:43'),(6,5,'CSO',9,'B.pharma','3','2022-05-12','08:00 AM to 11:00 AM','fvdvdf','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 00:59:47','2020-12-19 00:59:47'),(7,4,'Networking',9,'B.pharma','2','2021-12-12','3:00PM to 6:00PM','fvvfvfv','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:00:48','2020-12-19 01:00:48'),(8,7,'English',4,'B.tech','5','2021-10-12','3:00PM to 6:00PM','fvfvfv','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:01:06','2020-12-19 01:01:06'),(9,3,'DBMS',6,'BCA','7','2022-02-12','12:00PM to 3:00PM','fvfvfvdedede','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:01:29','2020-12-19 01:01:29'),(10,2,'Micro',5,'BSC','6','2022-04-12','08:00 AM to 11:00 AM','eewedwedw','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:01:47','2020-12-19 01:01:47'),(11,8,'hindi',4,'B.tech','2','2022-05-12','12:00PM to 3:00PM','eded323e','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 01:02:08','2020-12-19 01:02:08'),(12,16,'iot',4,'B.tech','2','2021-11-12','08:00 AM to 11:00 AM','cscsc','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 11:53:27','2020-12-19 11:53:27'),(13,13,'c',3,'CA','6','2021-12-12','12:00PM to 3:00PM','dcsdcdsc','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 11:54:47','2020-12-19 11:54:47'),(14,11,'sanskrit',2,'BE','7','2021-10-12','3:00PM to 6:00PM','ergergrger','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 11:55:40','2020-12-19 11:55:40'),(15,12,'urdu',13,'MBA','8','2021-11-12','3:00PM to 6:00PM','mmmmm','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 21:39:59','2020-12-19 21:39:59'),(16,9,'nursing',13,'MBA','9','2022-01-12','3:00PM to 6:00PM','jhjhjhj','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 21:40:20','2020-12-19 21:40:20'),(17,10,'Maths',2,'MSC','6','2021-12-12','08:00 AM to 11:00 AM','iuiuiu','mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-19 21:42:08','2020-12-19 21:42:08');

/*Table structure for table `st_user` */

DROP TABLE IF EXISTS `st_user`;

CREATE TABLE `st_user` (
  `ID` bigint(50) NOT NULL,
  `FIRST_NAME` varchar(50) default NULL,
  `LAST_NAME` varchar(50) default NULL,
  `LOGIN` varchar(50) default NULL,
  `PASSWORD` varchar(50) default NULL,
  `DOB` date default NULL,
  `MOBILE_NO` varchar(50) default NULL,
  `ROLE_ID` bigint(50) default NULL,
  `UNSUCCESSFULL_LOGIN` int(50) default NULL,
  `GENDER` varchar(50) default NULL,
  `LAST_LOGIN` timestamp NULL default CURRENT_TIMESTAMP,
  `USER_LOCK` varchar(50) default NULL,
  `REGISTERED_IP` varchar(50) default NULL,
  `LAST_LOGIN_IP` varchar(50) default NULL,
  `CREATED_BY` varchar(50) default NULL,
  `MODIFIED_BY` varchar(50) default NULL,
  `CREATED_DATE_TIME` timestamp NULL default '0000-00-00 00:00:00',
  `MODIFIED_DATE_TIME` timestamp NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `st_user` */

insert  into `st_user` values (1,'bhupendra','patidar','bhupendra2000.bp@gmail.com','8989','1998-01-08','7806085877',1,0,'Male',NULL,NULL,NULL,NULL,'root','root','2020-11-03 13:00:25','2020-11-03 13:00:25'),(2,'Ajay','singh','Ajaysingh@gmail.com','Ajay@12345','1998-11-08','9898989898',3,0,'Male',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 21:22:16','2020-11-24 21:22:16'),(3,'Vipin','sharma','vipin@gmail.com','Vip@12345','1994-11-22','9565656543',1,0,'Male',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-27 16:12:22','2020-11-27 16:12:22'),(4,'Shyam','jain','Shyam@gmail.com','Shyam@12345','1999-11-09','9565656543',2,0,'Female',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-01 12:09:13','2020-12-01 12:09:13'),(5,'neeraj','sharma','EWFEWAF@gmail.com','aKASH@12345','1998-11-25','9898989894',1,0,'Female',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 22:54:28','2020-11-24 22:54:28'),(6,'fi','la','login','aKASH@12345','1998-11-25','9898989894',1,0,'Female',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 22:54:33','2020-11-24 22:54:33'),(7,'neeraj','sharma','FWEFEF@gmail.com','aKASH@12345','1998-11-25','9898989894',2,0,'Female',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-24 22:54:40','2020-11-24 22:54:40'),(8,'ewfwe','mishra','mayankmishra666@gmail.com','May@1234','1998-11-25','9399502149',3,0,'Male',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-25 14:34:30','2020-11-25 14:34:30'),(9,'ergger','mishra','mayankmishra65@gmail.com','May@1234','1998-11-25','9399502149',1,0,'Male',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-25 14:34:44','2020-11-25 14:34:44'),(10,'wqewqe','mishra','mayankmishra665@gmail.com','May@1234','1998-11-25','9399502149',4,0,'Male',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-11-25 14:34:36','2020-11-25 14:34:36'),(11,'ajjayaa','aa','akash21@gmail.com','Ajay@123','1992-04-11','9399502147',1,0,'Male',NULL,NULL,NULL,NULL,'root','root','2020-11-30 12:47:37','2020-11-30 12:47:37'),(12,'aa','aaa','akash24@gmail.com','May@1234','1985-01-11','9399502147',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2020-11-30 13:06:01','2020-11-30 13:06:01'),(13,'kajal','shrivastava','sharmaneeraj41970@gmail.com','Kajal@12345','1992-03-12','9399502149',1,0,'Female',NULL,NULL,NULL,NULL,'root','root','2020-12-02 14:09:26','2020-12-02 14:09:26'),(14,'mayankm','dfgfd','mayankmishra668@gmail.com','May@12345','1986-12-15','9898989898',1,0,'Male',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-15 15:37:37','2020-12-15 15:37:37'),(15,'pawan','patidar','pavanpatidar8080@gmail.com','Pawan@123','1999-01-01','8719954385',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:44:28','2022-01-08 14:44:28'),(16,'pawan','patidar','pavanpatidar8080@gmail.com','Pawan@123','1999-01-01','8719954385',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:44:30','2022-01-08 14:44:30'),(17,'pawan','patidar','pavanpatidar8080@gmail.com','Pawan@123','1999-01-01','8719954385',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:44:45','2022-01-08 14:44:45'),(18,'pawan','patidar','pavanpatidar8080@gmail.com','Pawan@123','1999-01-01','8719954385',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:45:08','2022-01-08 14:45:08'),(19,'mayankm','dfgfd','mayankmishra669@gmail.com','May@12345','1986-12-15','9898989898',4,0,'Male',NULL,NULL,NULL,NULL,'mayankmishra661@gmail.com','mayankmishra661@gmail.com','2020-12-15 15:37:30','2020-12-15 15:37:30'),(20,'pawan','patidar','pavanpatidar8080@gmail.com','Pawan@123','1999-01-01','8719954385',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:46:31','2022-01-08 14:46:31'),(21,'pawan','patidar','pavanpatidar8080@gmail.com','Pawan@123','1999-01-01','8719954385',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:48:34','2022-01-08 14:48:34'),(22,'pawan','patidar','pavanpatidar8080@gmail.com','Pawan@123','1999-01-01','8719954385',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:48:48','2022-01-08 14:48:48'),(23,'pawan','patidar','pavanpatidar8080@gmail.com','Pass@123','1998-01-01','7806085877',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:50:57','2022-01-08 14:50:57'),(29,'pawan','patidar','pavanpatidar8080@gmail.com','Pass@123','1998-01-01','7806085877',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:49:55','2022-01-08 14:49:55'),(31,'bhupendra','jaat','pavanpatidar80@gmail.com','Pass@123','1999-12-01','7806085877',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:53:41','2022-01-08 14:53:41'),(32,'krishna','patidar','bhupendra2000.bp@gmail.com','Pawan@1234','2003-03-01','7806085877',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 14:59:34','2022-01-08 14:59:34'),(33,'ashish','patidar','ashish@78gmail.com','Ashish@12','2000-01-01','7806085877',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-08 15:13:00','2022-01-08 15:13:00'),(34,'harsh','updahy','harsh@gmail.com','Harsh@12','1999-01-01','7806085877',1,0,'male',NULL,NULL,NULL,NULL,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-01-20 16:15:28','2022-01-20 16:15:28'),(35,'ritesh','patidar','ritesh@gmail.com','Ritesh@123','1999-01-01','7806085877',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-01-23 23:42:46','2022-01-23 23:42:46'),(36,'alkesh','patidar','alkesh@gmail.com','Pass@1234','2000-02-02','8719954385',2,0,'Male',NULL,NULL,NULL,NULL,'root','root','2022-02-18 16:20:34','2022-02-18 16:20:34'),(37,'arpit','parmar','arpit@gmail.com','Arpit@1234','1997-01-01','7806085877',1,0,'Female',NULL,NULL,NULL,NULL,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-09 15:22:31','2022-03-09 15:22:31'),(38,'deny','jaat','deny@gmail.com','Deny@1234','1998-03-01','7806085877',1,0,'male',NULL,NULL,NULL,NULL,'bhupendra2000.bp@gmail.com','bhupendra2000.bp@gmail.com','2022-03-12 14:44:48','2022-03-12 14:44:48');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
