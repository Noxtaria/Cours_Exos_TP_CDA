-- Exercice 1
-- Partie 1
-- Créer la base de données
CREATE DATABASE correction_ex_1;

-- Utiliser la base de données 
USE correction_ex_1;

-- Question 1
CREATE TABLE personne (
personne_id INT NOT NULL AUTO_INCREMENT,
titre VARCHAR(3) NOT NULL,
prenom VARCHAR(150) NOT NULL,
nom VARCHAR(150) NOT NULL,
telephone VARCHAR(10),
email VARCHAR(150),
CONSTRAINT pk_personne_personne_id PRIMARY KEY(personne_id)
);

-- Question 2
CREATE TABLE adresse(
adress_id INT NOT NULL AUTO_INCREMENT,
rue VARCHAR(150) NOT NULL,
ville VARCHAR(150) NOT NULL,
code_postal INT NOT NULL,
personne_id INT NOT NULL,
CONSTRAINT pk_adresse_adress_id PRIMARY KEY(adresse_id),
CONSTRAINT fk_personne_adresse_personne_id FOREIGN KEY(personne_id) REFERENCES personne(personne_id)
);

-- Partie 2
INSERT INTO 
	personne
    (titre,prenom,nom,telephone,email)
VALUES
	('Mr.', 'Bob', 'Eponge', '0606060606', 'bob@eponge.fr'),
    ('Mr.', 'Patrick', 'Etoile', '0606060607', 'patrick@etoile.fr'),
    ('Mr.', 'Carlo', 'Tentacule', '0606060608', 'carlo@tentacule.fr'),
    ('Mme', 'Pearl', 'Krabs', '0606060609', 'pearl@krabs.fr'),
    ('Mme', 'Sandy', 'Ecurueil', '0606060610', 'Sandy@Ecurueil.fr'),
    ('Mr.', 'Gary', 'Escargot', '0606060611', 'gary@escargot.fr');
    
SELECT * FROM personne;

INSERT INTO 
	adresse 
    (rue, ville, code_postal, personne_id) 
    VALUES
	('17 rue Dufour', 'Lille', 59000, 1),
	('258 Boulevard Victor Hugo', 'Lille', 59000, 2),
	('23 rue de la république', 'Arras', 62000, 3),
	('12 rue de la Paix', 'Paris', 75001, 4),
	('124 rue de la Bourre', 'Paris', 75001, 5),
	('21 rue du Bourg', 'Paris', 75001, 6);
    
SELECT * FROM adresse;

INSERT INTO 
	adresse 
    (rue, ville, code_postal, personne_id) 
    VALUES
	('17 rue Dufour', 'Lille', 59000, 99);
    
-- Partie 3
-- Question 4
DELETE FROM adresse WHERE personne_id = 3;

-- Question 5
DELETE FROM personne WHERE prenom = 'Patrick';
-- Si on veut supprimmer Patrick
DELETE FROM adresse WHERE personne_id = 2;

-- Partie 4
-- Question 6
UPDATE personne SET telephone = '0101010195' WHERE telephone = '0101010199';

-- Partie 5
-- Question 7
SELECT * FROM personne ORDER BY nom DESC;

-- Question 8
SELECT * FROM personne ORDER BY titre ASC;

-- Question 9
SELECT * FROM personne WHERE email = 'gary@escargot.fr';
