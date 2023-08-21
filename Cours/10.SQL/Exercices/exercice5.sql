-- Exercice 5 
-- Création de la base
CREATE DATABASE correction_ex_5;

-- Utlisation de la base
USE correction_ex_5;

-- Utilisation des scripts departement.sql et villes_france_free.sql

-- Question 1 :
SELECT * FROM villes_france_free ORDER BY ville_population_2012 DESC LIMIT 10;

-- Question 2 :
SELECT * FROM villes_france_free ORDER BY ville_surface LIMIT 50;

-- Question 3 :
SELECT * FROM departement WHERE departement_code LIKE '97%';

-- Question 4 :
SELECT v.ville_nom, d.departement_nom FROM villes_france_free AS v INNER JOIN departement AS d 
ON v.ville_departement = d.departement_code ORDER BY v.ville_population_2012 DESC LIMIT 10;

-- Question 5 :
SELECT departement_nom, ville_departement , COUNT(*) AS compte_commune FROM villes_france_free 
INNER JOIN departement ON departement_code = ville_departement 
GROUP BY departement_nom, ville_departement
ORDER BY compte_commune DESC;

-- Question 6 :
SELECT departement_nom, SUM(villes_france_free.ville_surface) AS surface FROM   departement
INNER JOIN villes_france_free ON villes_france_free.ville_departement = departement.departement_code
GROUP BY departement_nom
ORDER BY surface DESC
LIMIT 10;

SELECT SUM(ROUND(v.ville_surface)) AS surface, d.departement_nom, d.departement_code FROM villes_france_free AS v
INNER JOIN departement AS d ON v.ville_departement = d.departement_code
GROUP BY d.departement_code, d.departement_nom
ORDER BY surface DESC
LIMIT 10;

-- Question 7 :
SELECT COUNT(ville_nom) FROM villes_france_free WHERE ville_nom LIKE "Saint%"; 
SELECT COUNT(*) AS ville_saint FROM villes_france_free AS v WHERE v.ville_nom LIKE "Saint%"; 

-- Question 8 :
SELECT * FROM (SELECT ville_nom,COUNT(*) AS nombre_ville FROM villes_france_free GROUP BY ville_nom ORDER BY nombre_ville DESC)
AS v WHERE nombre_ville > 1;

SELECT ville_nom , COUNT(ville_id) FROM villes_france_free AS v GROUP BY v.ville_nom
HAVING COUNT(ville_id) > 1 ORDER BY COUNT(ville_id) DESC;

-- Question 9 :
SELECT * FROM villes_france_free WHERE ville_surface > (SELECT AVG(ville_surface) FROM villes_france_free)
ORDER BY ville_surface DESC;

-- Question 10 :
SELECT ville_departement, SUM(ville_population_2012) AS nbr_population_2012 FROM villes_france_free
GROUP BY ville_departement HAVING nbr_population_2012 > 2000000
ORDER BY nbr_population_2012 DESC;

SELECT * FROM
(SELECT SUM(v.ville_population_2012) as populations, d.departement_code, d.departement_nom
FROM villes_france_free AS v INNER JOIN departement AS d ON v.ville_departement = d.departement_code
GROUP BY d.departement_code,d.departement_nom) AS table_population WHERE populations > 2000000;

-- Question 11 :
UPDATE villes_france_free SET ville_nom = REPLACE(ville_nom,'-',' ') WHERE ville_nom LIKE 'SAINT-%';



