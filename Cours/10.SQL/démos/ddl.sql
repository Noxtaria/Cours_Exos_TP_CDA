/**********************************

MANIPULATION DES BASES DE DONNEES

**********************************/


-- Création d'une base de données si celle-ci n'existe pas
CREATE DATABASE IF NOT EXISTS entreprise_demo
	CHARACTER SET = 'utf8mb4'
	COLLATE = 'utf8mb4_general_ci';

-- Permet d'afficher toutes les bases de données
SHOW DATABASES;

-- Suppression de la base de données si celle-ci existe
DROP DATABASE IF EXISTS entreprise_demo;

-- Modification du commentaire d'une base de données
ALTER DATABASE entreprise_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER DATABASE entreprise_demo DEFAULT CHARACTER SET utf8mb4;
ALTER DATABASE entreprise_demo ENCRYPTION='Y';

-- Afficher les schémas des bases de données
-- Permet de visualiser le commentaire
SELECT * FROM information_schema.SCHEMATA;

-- Utiliser la base de données
USE entreprise_demo;


/**********************************

MANIPULATION DES TABLES

**********************************/

-- Création d'une seconde table service
CREATE TABLE IF NOT EXISTS service (
service_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
libelle VARCHAR(150) NOT NULL
);

-- Création d'une table si elle n'existe pas
CREATE TABLE IF NOT EXISTS salarie (
salarie_id INT NOT NULL AUTO_INCREMENT, -- Clé primaire qui s'auto-incrémente
prenom VARCHAR(50) NOT NULL, -- Obligation de saisir une valeur
nom VARCHAR(50) NOT NULL,
age INT NOT NULL CHECK(age > 18 AND age < 65), -- Contrainte pour vérifier l'âge saisi
salaire FLOAT NOT NULL DEFAULT 1500, -- Valeur par défaut
service_id INT NOT NULL, -- Ajout de la colonne pour la clé étrangère
PRIMARY KEY (salarie_id), -- Contrainte de clé primaire, à la fin des déclarations
CONSTRAINT fk_service_id FOREIGN KEY (service_id) REFERENCES service(service_id) -- Contrainte de clé étrangère
);

-- Suppression de la table si elle n'existe pas
DROP TABLE IF EXISTS salarie;

-- Affiche les tables de la base de données
SHOW TABLES;

-- Affiche le détail des colonnes de la base de données
SHOW COLUMNS FROM salarie;
SHOW COLUMNS FROM service;

-- Ajout de la contrainte après création de la table
ALTER TABLE service
	ADD CONSTRAINT fk_service_id FOREIGN KEY(service_id) REFERENCES service(service_id);

-- Ajouter une colonne date-heure
ALTER TABLE service
	ADD COLUMN date_modification DATETIME;

-- Modifier la colonne en type DATE
ALTER TABLE service
	MODIFY COLUMN date_modification DATE;