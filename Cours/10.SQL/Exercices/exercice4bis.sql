/*
Exercice 4 Bis :
- Creer une BDD avec le nom ventes
- Dans cette BDD cree une table ventes avec les champs suivant (tous les champs sont obligatoire):
	- id_vente
    - nom du produit
    - quantite
    - prix unitaire
    - date de vente

- Inserer au moins 6 enregistrment dans cette table

- Question 1 : Quel est le montant total des ventes pour chaque produit ?

- Question 2 : Quelle est la quantite totale vendue pour chaque produit  ?

- Question 3 : Quelle est la date de vente la plus recente pour chaque produit ?

- Question 4 : Calculer le montant total des ventes par produit, ainsi que la quantite total vendue pour chaque produit ?

*/
-- Création de la BDD
CREATE DATABASE ventes;
-- Utilisation de la BDD
USE ventes;

-- Création de la table ventes
CREATE TABLE ventes (
id_vente INT PRIMARY KEY AUTO_INCREMENT,
nom_produit VARCHAR(50),
quantite INT,
prix_unitaire DECIMAL(10,2), -- FLOAT
date_vente DATE
);

-- Insertion de données dans la table ventes
INSERT INTO ventes (nom_produit,quantite,prix_unitaire,date_vente)
VALUES
('Carambar',10,9.99,'2023-04-01'),
('TUC',5,19.99,'2023-04-02'),
('Carambar',3,9.99,'2023-04-03'),
('Malabar',8,14.99,'2023-04-04'),
('TUC',2,19.99,'2023-04-05'),
('Carambar',7,9.99,'2023-04-06');

SELECT * FROM ventes;

-- Question 1 : 
SELECT nom_produit, SUM(prix_unitaire*quantite) AS montant_total FROM ventes GROUP BY nom_produit;

-- Question 2 :
SELECT nom_produit,SUM(quantite) AS quantite_total FROM ventes GROUP BY nom_produit;

-- Question 3 :
SELECT nom_produit,MAX(date_vente) AS date_vente_recente FROM ventes GROUP BY nom_produit;

-- Question 4 :
SELECT nom_produit, SUM(quantite*prix_unitaire) AS montant_total, SUM(quantite) AS quantite_total FROM ventes GROUP BY nom_produit;

-- Bonus :
-- Question 5 : Quel est le prix unitaire moyen de chaque produit vendu ?
-- Question 6 : Combien de ventes ont été réalisées pour chaque produit ?
-- Question 7 : Quelle est la vente avec le montant total le plus élevé ?

-- Question 5 :
SELECT nom_produit, AVG(prix_unitaire) AS prix_unitaire_moyen FROM ventes GROUP BY nom_produit;

-- Question 6 :
SELECT nom_produit, COUNT(*) AS nombre_ventes FROM ventes GROUP BY nom_produit;

-- Question 7 :
SELECT *, quantite*prix_unitaire AS montant_total FROM ventes ORDER BY montant_total DESC LIMIT 1;





