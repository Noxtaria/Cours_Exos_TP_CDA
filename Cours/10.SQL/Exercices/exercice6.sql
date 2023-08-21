-- Exercice 6
CREATE DATABASE correction_ex_6;

USE correction_ex_6;
-- 1- Créer les tables en précisant les clés primaires et étrangères.
CREATE TABLE eleve(
id_eleve INT PRIMARY KEY,
nom VARCHAR(30),
prenom VARCHAR(50),
age INT
);

CREATE TABLE matiere(
code_matiere VARCHAR(50) PRIMARY KEY,
nom_matiere VARCHAR(50),
coef_matiere INT
);

CREATE TABLE controle(
id_eleve INT,
code_matiere VARCHAR(50),
date_controle DATE,
note FLOAT,
PRIMARY KEY(id_eleve,code_matiere,date_controle),
FOREIGN KEY (id_eleve) REFERENCES eleve(id_eleve),
FOREIGN KEY (code_matiere) REFERENCES matiere(code_matiere)
);

-- 2- Créer les contraintes qui imposent que l’âge de l’élève soit entre 17 et 23 et que la note du contrôle soit entre 0 et 20.

ALTER TABLE eleve ADD CONSTRAINT age_eleve CHECK(age BETWEEN 17 AND 23);
ALTER TABLE controle ADD CONSTRAINT note_eleve CHECK(note BETWEEN 0 AND 20);

-- 3-  Insérer des lignes dans les tables.
INSERT INTO eleve 
VALUES
(1,'Lecoeur','Alexandre',22),
(2,'Lalaux','Clément',20),
(3,'Truffin','Cassandre',19),
(4,'Buannec','Kevin',21),
(5,'Megri','Karim',18);

-- Verification CONSTRAINT question 2
INSERT INTO eleve 
VALUES
(1,'Lecoeur','Alexandre',35);

INSERT INTO matiere 
VALUES
('M1','HTML',2),
('M2','javascript',3),
('M3','REACT',4),
('M4','SQL',5),
('M5','JAVA',2);

INSERT INTO controle 
VALUES
(1,'M1','2023-04-20',15),
(1,'M2','2023-04-19',14),
(1,'M3','2023-04-18',13),
(1,'M4','2023-04-17',19),
(1,'M5','2023-04-16',18);

INSERT INTO controle 
VALUES
(2,'M1','2023-04-15',15),
(2,'M2','2023-04-14',14),
(2,'M3','2023-04-13',13),
(2,'M4','2023-04-12',19),
(3,'M5','2023-04-11',18),
(3,'M1','2023-04-10',15),
(3,'M2','2023-04-06',14),
(4,'M3','2023-04-05',13),
(4,'M4','2023-04-04',19),
(4,'M5','2023-04-03',18),
(4,'M1','2023-03-20',15),
(4,'M2','2023-03-19',14),
(1,'M3','2023-03-18',13),
(5,'M4','2023-03-17',19),
(5,'M5','2023-03-16',18),
(1,'M1','2023-02-20',15),
(5,'M2','2023-02-19',14),
(1,'M3','2023-02-18',13),
(5,'M4','2023-02-17',19),
(5,'M5','2023-02-16',18);

-- Verif CONSTRAINT note
INSERT INTO controle 
VALUES
(2,'M1','2023-04-15',25);

-- 4- Afficher le nombre de contrôles passés par élève en javascript.
SELECT eleve.nom, c.id_eleve,COUNT(*) AS "Nombre de controles"
FROM controle AS c INNER JOIN matiere AS m ON c.code_matiere = m.code_matiere
INNER JOIN eleve ON eleve.id_eleve = c.id_eleve
WHERE m.nom_matiere = "JAVA"
GROUP BY id_eleve;

-- 5 - Créer une vue V_Moyenne_Matière qui permet d’afficher la moyenne de chaque élève (Id,Nom,Prénom) Par matière (NomMat, Coef).
-- Création de la vue
create view V_Moyenne_Matiere as
select e.Id_Eleve,e.Nom,e.Prenom,m.Nom_Matiere,m.Coef_Matiere,SUM(c.Note)/COUNT(c.Note)  as "Moyenne_Matiere"
from Controle c inner join Eleve e on c.Id_Eleve=e.Id_Eleve inner join Matiere m on c.Code_Matiere=m.Code_Matiere
group by e.Id_Eleve,e.Nom,e.Prenom,m.Nom_Matiere,m.Coef_Matiere;

-- Utilisation de la vue
select * from V_Moyenne_Matiere;

-- 6 - Créer une vue V_Moyenne_Générale qui permet d’afficher la moyenne générale de chaque élève (Id,Nom,Prénom).
-- Création de la vue
create view V_Moyenne_Genrale as
select Id_Eleve,Nom,Prenom,SUM(Coef_Matiere*Moyenne_Matiere)/(select SUM(Coef_Matiere) from Matiere) as "Moyenne Générale"
from V_Moyenne_Matiere
group by Id_Eleve,Nom,Prenom;

-- Utilisation de la vue
select * from V_Moyenne_Genrale;

