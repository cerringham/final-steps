DROP TABLE IF EXISTS city;

CREATE TABLE city (
id INT AUTO_INCREMENT  PRIMARY KEY,
city_name VARCHAR(50) NOT NULL,
city_pincode INT NOT NULL
);