-- Exercice 3
CREATE DATABASE IF NOT EXISTS correction_ex_3;

USE correction_ex_3;

-- Question 1
CREATE TABLE IF NOT EXISTS professeur (
professeur_id INT NOT NULL AUTO_INCREMENT,
prenom VARCHAR(50) NOT NULL,
nom VARCHAR(50) NOT NULL,
numero_classe INT,
numero_departement INT,
email VARCHAR(50) NOT NULL,
telephone VARCHAR(10) NOT NULL,
PRIMARY KEY(professeur_id)
);

-- Question 2
CREATE TABLE IF NOT EXISTS etudiant (
etudiant_id INT NOT NULL AUTO_INCREMENT,
prenom VARCHAR(50) NOT NULL,
nom VARCHAR(50) NOT NULL,
telephone VARCHAR(10),
numero_classe INT,
date_diplome DATE,
PRIMARY KEY(etudiant_id)
);

-- Question 3
CREATE TABLE IF NOT EXISTS professeur_etudiant (
prof_etudiant_id INT NOT NULL AUTO_INCREMENT,
professeur_id INT NOT NULL,
etudiant_id INT NOT NULL,
PRIMARY KEY(prof_etudiant_id),
FOREIGN KEY (professeur_id) REFERENCES professeur(professeur_id),
FOREIGN KEY (etudiant_id) REFERENCES etudiant(etudiant_id)
);

-- Question 4
ALTER TABLE etudiant 
MODIFY telephone VARCHAR(10) NOT NULL;

ALTER TABLE etudiant
ADD CONSTRAINT UC_telphone UNIQUE (telephone);

ALTER TABLE professeur
ADD CONSTRAINT UC_telphone UNIQUE (telephone);

ALTER TABLE professeur
ADD CONSTRAINT UC_email UNIQUE (email);


-- Question 5
INSERT INTO etudiant(prenom,nom,telephone) VALUES ('jean','dupont','0601010101');
SELECT * FROM etudiant;
-- test clé unique
-- Erreur sur la clé unique du télephone
INSERT INTO etudiant(prenom,nom,telephone) VALUES ('jeanne','dupont','0601010101');
-- test valeur non nulle
-- Erreur 
INSERT INTO etudiant(prenom,nom) VALUES ('jeanne','dupont');