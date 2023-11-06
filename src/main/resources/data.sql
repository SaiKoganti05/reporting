CREATE TABLE `tbl_emp_band` (
 `band_id` int NOT NULL AUTO_INCREMENT,
 `band_name` varchar(8) NOT NULL,
 PRIMARY KEY (`band_id`)
);

INSERT INTO `tbl_emp_band` VALUES (10,'M1'),(11,'M2'),(12,'M3');


CREATE TABLE `tbl_leave_type` (
 `leave_id` int NOT NULL AUTO_INCREMENT,
 `leave_type` varchar(16) NOT NULL,
 PRIMARY KEY (`leave_id`)
);
INSERT INTO `tbl_leave_type` VALUES (1,'CL'),(2,'ML'),(3,'EL');




CREATE TABLE `tbl_leave_allocation` (
 `allocation_id` int NOT NULL AUTO_INCREMENT,
 `leave_id` int NOT NULL,
 `band_id` int NOT NULL,
 `total_leave` int NOT NULL,
 PRIMARY KEY (`allocation_id`),
foreign key (leave_id) references tbl_leave_type(leave_id),
foreign key (band_id) references tbl_emp_band(band_id)
);

INSERT INTO `tbl_leave_allocation` VALUES 
(1,1,10,15),(2,2,10,15),(3,3,10,12),(4,1,11,12),(5,2,11,12),(6,3,11,
10),(7,1,12,10),(8,2,12,10),(9,3,12,8);

CREATE TABLE `tbl_employee_dtls` (
 `emp_id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(45) NOT NULL,
 `address` varchar(450) NOT NULL,
 `mobile_no` varchar(12) NOT NULL,
 `email` varchar(45) NOT NULL,
 `designation` varchar(45) NOT NULL,
 `band_id` int DEFAULT NULL,
 PRIMARY KEY (`emp_id`),
 foreign key (band_id) references tbl_emp_band(band_id)
);

INSERT INTO `tbl_employee_dtls` VALUES (1001,'Amit Sahoo','old town, 
bbsr','9861116414','amit@gmail.com','PM',10),(1002,'Sunita 
Das','laxmi 
sagar,bbsr','9987676545','sunita@gmail.com','PM',10),(1003,'Anil 
Behera','vim 
tangi,bbsr','9876665654','anil@gmail.com','TL',11),(1004,'Suman 
Sharma','vvs 
nagar,bbsr','9456665454','suman@gmail.com','TL',11),(1005,'Kundan 
Patra','kaliga 
vihar,bbsr','9984543234','kundan@gmail','SSD',12),(1006,'Swagat 
Swain','acharaya 
bihar,bbsr','9962435467','swagat@gmail.com','SSD',12);


CREATE TABLE `tbl_leave_apply` (
 `leave_apply_id` int NOT NULL AUTO_INCREMENT,
 `emp_id` int NOT NULL,
 `leave_id` int NOT NULL,
 `applied_on` date DEFAULT NULL,
 `reason` varchar(108) DEFAULT NULL,
 `status` varchar(8) DEFAULT NULL,
 PRIMARY KEY (`leave_apply_id`),
foreign key (emp_id) references tbl_employee_dtls(emp_id),
foreign key (leave_id) references tbl_leave_type(leave_id)
);
INSERT INTO `tbl_leave_apply` VALUES (1,1001,1,'2022-01-05','household work','APPROVED'),(2,1002,2,'2022-01-06','health 
check-up','APPROVED'),(3,1003,2,'2022-02-02','eye 
checkup','APPROVED'),(4,1001,1,'2022-02-05','household 
work','REJECTED'),(5,1003,1,'2022-02-10','brothers 
marriage','APPROVED'),(6,1004,2,'2022-02-11','common 
cold','APPROVED'),(7,1005,2,'2022-02-13','common 
cold','APPROVED'),(8,1006,2,'2022-03-02','fever','APPROVED'),(9,1001,1,'2022-04-05','birthday,self','APPROVED'),(10,1001,2,'2022-04-25','fever','APPROVED'),(11,1001,2,'2022-05-03','cold','APPROVED'),(12,1002,2,'2022-05-07','fever','APPROVED');


