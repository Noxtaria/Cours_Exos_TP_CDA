-- SQL -vue

CREATE DATABASE demovue;

USE demovue;

CREATE TABLE annuaire (
id INT PRIMARY KEY AUTO_INCREMENT,
nom VARCHAR(50) NOT NULL,
prenom VARCHAR(50),
numero VARCHAR(50)
);

INSERT INTO annuaire (nom, prenom, numero)
VALUES
('Rébecca', 'Armand', '0123456789'),
('Aimée', 'Hebert', '9876543210'),
('Marielle', 'Ribeiro', '1234509876'),
('Hilaire', 'Savary', '0987612345');

SELECT * FROM annuaire;

SELECT * FROM annuaire WHERE nom = 'Marielle';

/* Syntaxe vue SQL :
CREATE VIEW view_name AS
SELECT column1,column2, ...
FROM table_name
WHERE condition;
*/

CREATE VIEW all_marielle AS 
SELECT * FROM annuaire WHERE nom = 'Marielle';

SELECT * FROM all_marielle;


INSERT INTO annuaire (nom,prenom,numero)
VALUES ('Marielle','Hebert','1234567899');

SELECT prenom FROM all_marielle;

INSERT INTO all_marielle (nom,prenom,numero)
VALUES ('toto','titi','1234567899');

DELETE FROM all_marielle WHERE id =3;