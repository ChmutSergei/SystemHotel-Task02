CREATE DATABASE HotelSystem2  CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
USE HotelSystem2;
CREATE TABLE Contacts(id INT PRIMARY KEY AUTO_INCREMENT, email CHAR(20), telephone CHAR(20), country CHAR(20),
city CHAR(20), address CHAR(120), zip CHAR (10));
CREATE TABLE Users(id INT PRIMARY KEY AUTO_INCREMENT, login CHAR(20), password CHAR(30), name CHAR(20),lastname CHAR(20),
role CHAR (15),contact_id INT, FOREIGN KEY (contact_id) REFERENCES Contacts(id) ON DELETE  CASCADE  ON UPDATE CASCADE);
CREATE TABLE Rooms(id INT PRIMARY KEY AUTO_INCREMENT, roomNumber INT,type CHAR(15),bedType INT,
                   price DOUBLE, checkIn DATE,checkOut DATE, description TEXT);
CREATE TABLE Reservation (id INT PRIMARY KEY AUTO_INCREMENT, user_id INT, room_id INT, date DATE,
  FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE  CASCADE  ON UPDATE CASCADE,
  FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE  CASCADE  ON UPDATE CASCADE);
INSERT INTO Users (login, password , name , lastname, role) VALUES ("admin", "1111","Valeriy", "Manager", "admin");
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (1,'Супер Люкс',3,128.9,'2018-05-05','2018-05-07',
        'Приятный и уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (2,'Люкс',2,58.9,'2018-06-05','2018-06-10',
        'Уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (3,'Супер Люкс',2,115.9,'2018-07-05','2018-07-08',
        'Приятный и уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (4,'Люкс',3,109.9,'2018-06-28','2018-06-30',
        'Уютный номер распологается на втором этаже с видом во двор.');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (5,'Люкс',1,89.9,'2018-06-30','2018-07-05',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (6,'Люкс',1,79.9,'2018-06-25','2018-06-28',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (7,'Люкс',1,82.9,'2018-06-25','2018-06-28',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (8,'СуперЛюкс',1,89.9,'2018-06-20','2018-06-22',
        'Приятный и уютный номер распологается на первом этаже с видом на паркинг');
INSERT INTO Rooms(roomNumber, type, bedType, price, checkIn, checkOut, description)
VALUES (9,'СуперЛюкс',4,189.5,'2018-07-20','2018-07-22',
        'Приятный и уютный номер распологается на первом этаже с видом на город');
