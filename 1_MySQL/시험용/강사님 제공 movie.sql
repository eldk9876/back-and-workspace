Drop TABLE movie;
CREATE TABLE movie(

id INT AUTO_INCREMENT PRIMARY KEY,

title VARCHAR(20),

genre VARCHAR(20),

actor VARCHAR(50)

);

SELECT * FROM movie;

DELETE FROM movie WHERE title ;