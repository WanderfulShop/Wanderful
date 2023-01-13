CREATE DATABASE IF NOT EXISTS wanderful_db;

USE wanderful_db;

CREATE TABLE users (
    user_password VARCHAR(100) NOT NULL,
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    school VARCHAR(100),
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE wands (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    wand_name VARCHAR(50) NOT NULL,
    core_material VARCHAR(80) NOT NULL,
    wood_type VARCHAR(80) NOT NULL,
    use_category VARCHAR(80) NOT NULL,
    age INT NOT NULL,
    image VARCHAR(100),
    user_id int UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    creation_date DATE NOT NULL,
    ad_title VARCHAR(80) NOT NULL,
    ad_description VARCHAR(200) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE wand_ads (
    wand_id INT UNSIGNED NOT NULL,
    ad_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (wand_id) REFERENCES wands(id),
    FOREIGN KEY (ad_id) REFERENCES ads(id)
);
INSERT INTO users (user_password, user_name, first_name, last_name, school, email)
VALUES ('password','PotionMaster95','Brittney','Brinson','Hogwarts','magic8@gmail.com');







