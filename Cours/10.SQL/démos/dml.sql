-------------------------------------------------------------
-- INSERT INTO
-------------------------------------------------------------

USE entreprise_demo;

-- Méthode 1 :
-- Sans préciser le nom des colonnes 
INSERT INTO 
	service 
VALUES 
	(NULL, 'RH');
    
-- Méthode 2 :
-- En précisant les colonnes
INSERT INTO 
	service 
    (libelle)
VALUES 
	('comptabilité'),
    ('développement');

SELECT * FROM service;

-- Méthode 3 :
-- Via requete imbrique
INSERT INTO 
	service 
    (libelle)
SELECT 
	'recherche' as libelle;
    
-------------------------------------------------------------
-- DELETE FROM
-------------------------------------------------------------

-- Supprime tous les enregistrements de la table
DELETE FROM service;

-- Suppression avec condition sur l'ID
DELETE FROM service WHERE service_id = 2;

-- Suppression avec condition sur la colonne libelle
DELETE FROM service WHERE libelle = 'recherche';

-------------------------------------------------------------
-- UPDATE
-------------------------------------------------------------

-- Mise à jour de l'enregistrement
UPDATE service SET libelle = 'Recherche et développement' WHERE service_id = 3;

-------------------------------------------------------------
-- SELECT
-------------------------------------------------------------

-- Sélectionner toutes les colonnes d'une table
SELECT * FROM service;

-- Selectionner une colonne d'une table
SELECT libelle FROM service;

-- Selectionner plusieurs colonnes d'une table
SELECT libelle, service_id FROM service;

-- Préfixer les colonnes du nom de la table
SELECT service.libelle, service.service_id FROM service;

-- Selection sur plusieurs tables
SELECT * FROM salarie,service;

INSERT INTO salarie(prenom, nom, age, salaire, service_id)
VALUES('jeanne', 'dupond', 35, 1500, 3),
('jacques', 'chirac', 62, 3500, 3),
('michelle', 'obama', 54, 1200, 3),
('roberta', 'patinsona', 31, 5000, 3),
('michael', 'patate', 36, 2500, 3),
('robert', 'patinson', 32, 5000, 3),
('robert', 'patinson', 32, 5000, 3);

-- instruction WHERE
SELECT prenom,nom FROM salarie WHERE salaire > 1500;

SELECT prenom,nom FROM salarie WHERE age > 25 AND salaire < 3000;

SELECT salarie_id,prenom,nom,age FROM salarie WHERE age BETWEEN 25 AND 45;

-- DISTINCT : élemine les doublons
SELECT
	DISTINCT salaire,age
FROM salarie;

-- LIMIT : spécifie le nombre de résultat à retourner
SELECT * FROM salarie LIMIT 2;

-- ORDER BY : retourne le résultat dans un ordre défini
SELECT * FROM service ORDER BY libelle; -- ASC implicite

SELECT * FROM service ORDER BY libelle DESC;

SELECT * FROM salarie ORDER BY nom,age,salarie_id DESC;

-- Requêtes imbriquées 
SELECT nom,prenom FROM (SELECT * FROM salarie WHERE prenom LIKE 'r%') AS nom_en_r WHERE age > 31; 

-- SELECT * FROM salarie WHERE prenom LIKE 'r%';

SELECT COUNT(service_id) AS nombre_service FROM salarie GROUP BY service_id;

-- Utilisation du HAVING
SELECT service_id,AVG(salaire) FROM salarie GROUP BY service_id HAVING AVG(salaire) > 2000;

-- Jointures
SELECT s.nom, s.prenom, service.libelle FROM salarie AS s LEFT JOIN service ON s.service_id = service.service_id;

