CREATE DATABASE transaction;

USE transaction;

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


-- Début de la transaction 
START TRANSACTION;

-- Insertion de données dans la table service
INSERT INTO 
	service 
    (libelle)
VALUES 
	('comptabilité'),
    ('développement');

-- valider la transaction
COMMIT;

-- Début de la transaction 
START TRANSACTION;

-- Insertion de données dans la table service
INSERT INTO service (libelle)
VALUES ('recheche');

SELECT * FROM service;

-- annuler la transaction
ROLLBACK;

-- Début de la transaction 
START TRANSACTION;

-- Insertion de données dans la table service
INSERT INTO service (libelle)
VALUES ('recherche123456');

SELECT * FROM service;

-- valider la transaction
COMMIT;
-- annuler la transaction
ROLLBACK;



START TRANSACTION;

-- Insertion de données dans la table service
INSERT INTO service (libelle) VALUES ('informaique');
INSERT INTO service (libelle)VALUES ('médical');

-- annuler la transaction
ROLLBACK;


SELECT * FROM service;


    
