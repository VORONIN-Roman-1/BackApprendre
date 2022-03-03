CREATE USER 'padawan'@'localhost' IDENTIFIED BY 'padawan';
GRANT ALL PRIVILEGES ON * . * TO 'padawan'@'localhost';
ALTER USER 'padawan'@'localhost' IDENTIFIED WITH
mysql_native_password BY 'padawan';