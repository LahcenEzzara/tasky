CREATE DATABASE tasky_db;

USE tasky_db;

CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL
);

CREATE TABLE task (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      user_id INT,
                      FOREIGN KEY (user_id) REFERENCES user(id)
);
