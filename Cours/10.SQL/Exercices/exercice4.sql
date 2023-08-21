-- Exercice 4
-- Création d'une database
CREATE DATABASE IF NOT EXISTS correction_ex_4;

USE correction_ex_4;

-- Question 1 :
CREATE TABLE IF NOT EXISTS livre (
id INT NOT NULL AUTO_INCREMENT,
titre VARCHAR(150),
auteur VARCHAR(50),
editeur VARCHAR(50),
date_publication DATE,
isbn_10 VARCHAR(10),
isbn_13 VARCHAR(15),
PRIMARY KEY(id)
);

-- Ajout du script ajout_livre.sql
-- Verification de l'ajout des livres
SELECT * FROM livre;