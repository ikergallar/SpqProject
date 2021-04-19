CREATE DATABASE databasespq;
USE databasespq;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON databasespq.* TO 'spq'@'localhost';