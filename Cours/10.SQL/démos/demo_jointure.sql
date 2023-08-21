CREATE DATABASE demo_jointure;

USE demo_jointure;

CREATE TABLE TableA (
id INT NOT NULL PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE TableB (
id INT NOT NULL PRIMARY KEY,
name VARCHAR(50)
);

INSERT INTO TableA (id,name) 
VALUES
(1,"Pirate"),
(2,"Monkey"),
(3,"Ninja"),
(4,"Spaghetti");

INSERT INTO TableB (id,name) 
VALUES
(1,"Rutabaga"),
(2,"Pirate"),
(3,"Darth Vader"),
(4,"Ninja");

SELECT * FROM TableA;
SELECT * FROM TableB;

-- INNER JOIN
SELECT * FROM TableA INNER JOIN TableB ON TableA.name = TableB.name;
SELECT * FROM TableA INNER JOIN TableB ON TableA.id = TableB.id;
SELECT TableA.id,TableB.name FROM TableA INNER JOIN TableB ON TableA.name = TableB.name;

-- FULL JOIN
-- MySQL ne supporte pas ce FULL JOIN on peut combiner un LEFT JOIN et un RIGHT JOIN avec UNION
-- SELECT * FROM TableA FULL JOIN TableB ON TableA.name = TableB.name;
SELECT * 
FROM TableA LEFT JOIN TableB ON TableA.id = TableB.id
UNION
SELECT * 
FROM TableA RIGHT JOIN TableB ON TableA.id = TableB.id;

-- LEFT JOIN 
SELECT * FROM TableA LEFT JOIN TableB ON TableA.name = TableB.name;
SELECT * FROM TableA LEFT JOIN TableB ON TableB.name = TableA.name;
SELECT * FROM TableA LEFT JOIN TableB ON TableB.name = TableA.name WHERE TableB.id IS NOT null;
SELECT * FROM TableA LEFT JOIN TableB ON TableB.name = TableA.name WHERE TableB.id IS null;

-- RIGHT JOIN
SELECT * FROM TableA RIGHT JOIN TableB ON TableA.name = TableB.name;
SELECT * FROM TableB RIGHT JOIN TableA ON TableA.name = TableB.name;
SELECT * FROM TableB RIGHT JOIN TableA ON TableA.name = TableB.name WHERE TableB.id IS NOT null;
SELECT * FROM TableB RIGHT JOIN TableA ON TableA.name = TableB.name WHERE TableB.id IS null;
