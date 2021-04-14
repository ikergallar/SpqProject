CREATE DATABASE database;
USE database;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON database.* TO 'spq'@'localhost';